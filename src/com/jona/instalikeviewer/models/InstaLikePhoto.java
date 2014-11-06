package com.jona.instalikeviewer.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InstaLikePhoto {
	public String username;
	public String userProfileImgUrl;
	public String caption;
	public String imgUrl;
	public int imgHeight;
	public int imgWidth;
	public int likesCount;
	public long timeCreated;
	public List<String> comments = new ArrayList<String>();
	
	public static ArrayList<InstaLikePhoto> fromJson(JSONArray jsonObjects) {
		ArrayList<InstaLikePhoto> photos = new ArrayList<InstaLikePhoto>();
		
		for (int i =0 ; i < jsonObjects.length(); i++){
			try {
				JSONObject photoJson =  jsonObjects.getJSONObject(i);
				InstaLikePhoto photo = new InstaLikePhoto();
				
				photo.username = photoJson.getJSONObject("user").getString("username");
				photo.userProfileImgUrl = photoJson.getJSONObject("user").getString("profile_picture");
				if(photoJson.getJSONObject("caption") != null){
					photo.caption = photoJson.getJSONObject("caption").getString("text");
				}
				
				photo.timeCreated = photoJson.getJSONObject("caption").getLong("created_time");
				photo.imgUrl = photoJson.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
				photo.imgHeight= photoJson.getJSONObject("images").getJSONObject("standard_resolution").getInt("height");
				photo.imgWidth= photoJson.getJSONObject("images").getJSONObject("standard_resolution").getInt("width");
				photo.likesCount = photoJson.getJSONObject("likes").getInt("count");
				JSONArray commentsArray = photoJson.getJSONObject("comments").getJSONArray("data");
				for (int k = 0; k < commentsArray.length(); k++) {
					//no need to check for timestamp - the api returns it in chronological order
					String comment = commentsArray.getJSONObject(k).getString("text");
					photo.comments.add(comment);
				}
				photos.add(photo);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return photos;	
	}
}
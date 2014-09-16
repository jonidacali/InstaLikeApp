package com.jona.instalikeviewer;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class PhotosActivity extends Activity {
	public static final String CLIENT_ID = "0d026667178745719dd60676ed3d065a";
	private ArrayList<InstaLikePhoto> photos;
	private InstaLikePhotosAdaptor aPhotos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photos);
		fetchPopularPhotos();
	}

	private void fetchPopularPhotos() {
		photos = new ArrayList<InstaLikePhoto>();
		aPhotos = new InstaLikePhotosAdaptor(this, photos);
		ListView lvPhotos = (ListView) findViewById(R.id.lvPhotos);
		lvPhotos.setAdapter(aPhotos);
		
		//Setup endpoint URL
		String popularUrl = "https://api.instagram.com/v1/media/popular?client_id=" + CLIENT_ID;		
		//Create net client
		AsyncHttpClient client = new AsyncHttpClient();
		//Trigger net request
		client.get(popularUrl, new JsonHttpResponseHandler(){
			//define success and failure
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				JSONArray photosJson = null;
				try{
					photos.clear();
					photosJson = response.getJSONArray("data");
					for (int i =0 ; i < photosJson.length(); i++){
						JSONObject photoJson =  photosJson.getJSONObject(i);
						InstaLikePhoto photo = new InstaLikePhoto();
						
						photo.username = photoJson.getJSONObject("user").getString("username");
						if(photoJson.getJSONObject("caption") != null){
							photo.caption = photoJson.getJSONObject("caption").getString("text");
						}
						photo.imgUrl = photoJson.getJSONObject("images").getJSONObject("standard_resolution").getString("url");
						photo.imgHeight= photoJson.getJSONObject("images").getJSONObject("standard_resolution").getInt("height");
						photo.imgWidth= photoJson.getJSONObject("images").getJSONObject("standard_resolution").getInt("width");
						photo.likesCount = photoJson.getJSONObject("likes").getInt("count");
						
						photos.add(photo);
					}
					aPhotos.notifyDataSetChanged();
				} catch (JSONException e){
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void onFailure(int statusCode, Header[] headers,
					String responseString, Throwable throwable) {
				super.onFailure(statusCode, headers, responseString, throwable);
			}
		});
		
		//
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photos, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
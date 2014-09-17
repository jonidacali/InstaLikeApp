package com.jona.instalikeviewer;

import java.util.List;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InstaLikePhotosAdaptor extends ArrayAdapter<InstaLikePhoto> {
	public InstaLikePhotosAdaptor(Context context, List<InstaLikePhoto> photos) {
		super(context, android.R.layout.simple_list_item_1, photos);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		InstaLikePhoto photo = getItem(position);
		
		//Check if using a recycled view
		if(convertView == null){
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
		}
		
		TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
		ImageView imgPhoto = (ImageView) convertView.findViewById(R.id.imgPhoto);
		ImageView imgUserProfPhoto = (ImageView) convertView.findViewById(R.id.imgProfile);
		TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
		
		tvCaption.setText(Html.fromHtml("<b>" + photo.username + "</b> -- " + photo.caption));
		tvLikes.setText(getContext().getResources().getString(R.string.label_likes) + Integer.toString(photo.likesCount));

		float imgRatio = photo.imgWidth/photo.imgHeight;

		DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();		
		float scWidth = metrics.widthPixels;
		
		//Set imageView width to 250
		imgPhoto.getLayoutParams().width =  (int) 250;
		imgPhoto.getLayoutParams().height = (int) (250*imgRatio);

		//Clear images that existed in the recycled view
		imgPhoto.setImageResource(0);		
		
		Picasso.with(getContext()).load(photo.imgUrl).into(imgPhoto);
		Picasso.with(getContext()).load(photo.userProfileImgUrl).into(imgUserProfPhoto);
		return convertView;	
	}
	
	
}

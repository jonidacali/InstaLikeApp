package com.jona.instalikeviewer;

import java.sql.Date;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class InstaLikePhotosAdaptor extends ArrayAdapter<InstaLikePhoto> {
	
	private static class ViewHolder {
        ImageView ivPhoto;
        ImageView civProfilePhoto;
        TextView tvCaption;
        TextView tvUserName;
        TextView tvComments;
        TextView tvTimeCreated;
        TextView tvLikes;
    }
	
	public InstaLikePhotosAdaptor(Context context, List<InstaLikePhoto> photos) {
		super(context, android.R.layout.simple_list_item_1, photos);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Date now = new Date(System.currentTimeMillis());
		
		InstaLikePhoto photo = getItem(position);
		
		ViewHolder viewHolder;
		
		//Check if using a recycled view
		if(convertView == null){
			viewHolder = new ViewHolder();	
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
			viewHolder.ivPhoto = (ImageView) convertView.findViewById(R.id.imgPhoto);
			viewHolder.civProfilePhoto = (ImageView) convertView.findViewById(R.id.imgProfile);
	        viewHolder.tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
	        viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tvUsername);
	        viewHolder.tvComments = (TextView) convertView.findViewById(R.id.tVComments);
	        viewHolder.tvTimeCreated = (TextView) convertView.findViewById(R.id.tvTimeCreated);
	        viewHolder.tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
	        convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
				
		viewHolder.tvUserName.setText(photo.username);
		viewHolder.tvCaption.setText(photo.caption);
		viewHolder.tvLikes.setText(Html.fromHtml("&#9825; " + Integer.toString(photo.likesCount)));
		
		CharSequence relativeTime = DateUtils.getRelativeTimeSpanString(photo.timeCreated*1000, now.getTime(), DateUtils.MINUTE_IN_MILLIS);
		viewHolder.tvTimeCreated.setText(relativeTime);
		
		String comments = "";
		int commentsNum = photo.comments.size();
		
		if(commentsNum>0){
			for (int i=0; i<2; i++){
				comments+= photo.comments.get(i) +"<br/>";
			}
			viewHolder.tvComments.setText(Html.fromHtml(comments));
		} else {
			viewHolder.tvComments.setVisibility(View.GONE);
		}		
		
		float imgRatio = photo.imgWidth/photo.imgHeight;
		DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();		
		int scWidth = metrics.widthPixels;

		//Set imageView width to 250
		viewHolder.ivPhoto.getLayoutParams().width = scWidth;
		viewHolder.ivPhoto.getLayoutParams().height = (int) (250*imgRatio);

		//Clear images that existed in the recycled view
		viewHolder.ivPhoto.setImageResource(0);		
		
		Picasso.with(getContext()).load(photo.imgUrl).into(viewHolder.ivPhoto);
		Picasso.with(getContext()).load(photo.userProfileImgUrl).into(viewHolder.civProfilePhoto);
				
		return convertView;	
	}
	
	
}

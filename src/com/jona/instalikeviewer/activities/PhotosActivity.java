package com.jona.instalikeviewer.activities;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jona.instalikeviewer.R;
import com.jona.instalikeviewer.adaptors.InstaLikePhotosAdaptor;
import com.jona.instalikeviewer.models.InstaLikePhoto;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class PhotosActivity extends Activity {
	public static final String CLIENT_ID = "0d026667178745719dd60676ed3d065a";
	private ArrayList<InstaLikePhoto> photos;
	private InstaLikePhotosAdaptor aPhotos;
	private SwipeRefreshLayout swipeContainer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photos);
		swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
		
		
		swipeContainer.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
            	fetchPopularPhotos();
            } 
        });
		fetchPopularPhotos();

		swipeContainer.setColorSchemeResources(
				android.R.color.holo_blue_bright, 
				android.R.color.holo_green_light, 
				android.R.color.holo_orange_light, 
				android.R.color.holo_red_light);	
	}

	private void fetchPopularPhotos() {
		photos = new ArrayList<InstaLikePhoto>();
		aPhotos = new InstaLikePhotosAdaptor(this, photos);
		ListView lvPhotos = (ListView) findViewById(R.id.lvPhotos);
		lvPhotos.setAdapter(aPhotos);
		
		String popularUrl = "https://api.instagram.com/v1/media/popular?client_id=" + CLIENT_ID;		
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(popularUrl, new JsonHttpResponseHandler(){
			//define success and failure
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				JSONArray photosJson = null;
				
				//swipeContainer.setRefreshing(false);
				try{
					photos.clear();
					photosJson = response.getJSONArray("data");
					ArrayList<InstaLikePhoto> newPhotos = InstaLikePhoto.fromJson(photosJson);
					photos.addAll(newPhotos);
					aPhotos.notifyDataSetChanged();
					swipeContainer.setRefreshing(false);
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

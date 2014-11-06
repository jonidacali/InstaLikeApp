package com.jona.instalikeviewer.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.format.DateUtils;

public class Utility {

	public static CharSequence getTimePostedShort(long createdAt) throws ParseException {
		Date now = new Date(System.currentTimeMillis());		
		String abrevRelTime = "";
		String relativeDate = DateUtils.getRelativeTimeSpanString(createdAt*1000, now.getTime(), DateUtils.SECOND_IN_MILLIS).toString();
		String[] time;
		time = relativeDate.split(" ");
		
		if(time.length==3){
			abrevRelTime = time[0]+time[1].substring(0,1);
		} 
		return abrevRelTime;
	}
	
}

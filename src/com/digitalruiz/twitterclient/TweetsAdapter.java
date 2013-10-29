package com.digitalruiz.twitterclient;

import java.util.List;


import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.digitalruiz.twitterclient.models.Tweet;
import com.digitalruiz.twitterclient.Item_Test;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




public class TweetsAdapter extends ArrayAdapter<Tweet> {
	 private Context context;
	 
	
	
	public static Item_Test getRandom() {
		return new Select().from(Item_Test.class).orderBy("RANDOM()").executeSingle();
		}
	
	

	

	public static List<Item_Test> getAll() {
		return new Select()
			.from(Item_Test.class)
			.execute();
	}


	

	
	
	public TweetsAdapter(Context context, List<Tweet> tweets) {
		
	//	this.context = context;
	//	List<Tweet> = 0;
		
		super(context, 0, tweets);
		this.context = context;
	
	
	}
	

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.tweet_item, null);
		}
		
		final Tweet tweet = getItem(position);
		
		
		ImageView imageView = (ImageView) view.findViewById(R.id.ivProfile);
		ImageLoader.getInstance().displayImage(tweet.getUser().getProfileImageUrl(), imageView);
		
		TextView nameView = (TextView) view.findViewById(R.id.tvName);
		String formattedName = "<b>" + tweet.getUser().getName() + "</b>" + "<small><font color='#77777777'>@" + 
				tweet.getUser().getScreenName() + "</font></small>";
		
		nameView.setText(Html.fromHtml(formattedName));
		
		TextView bodyView = (TextView) view.findViewById(R.id.tvBody);
		bodyView.setText(Html.fromHtml(tweet.getBody()));
		
		Log.d("DEBUG", tweet.toString());
		Log.d("DEBUG", tweet.getUser().getName());
		Log.d("DEBUG", tweet.getUser().getScreenName());
		Log.d("DEBUG", tweet.getBody());
		Log.d("DEBUG", tweet.getUser().getProfileImageUrl());
		
		
		new Delete().from(Item_Test.class).where("Id = ?", 1).execute();
		Item_Test item_test = new Item_Test();
		item_test.name = tweet.getUser().getName();
		item_test.save();
		
		
		view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	String un = tweet.getUser().getScreenName().toString();
            	Log.d("DEBUG", un);
            	Intent i = new Intent(context, ProfileActivity.class);
            	i.putExtra("user",un);
        	//	startActivity(i);
            	view.getContext().startActivity(i);
        	//	context.startActivity(ProfileActivity.class);
            }
        });
	
		
		
	
		
		return view;
	}

}

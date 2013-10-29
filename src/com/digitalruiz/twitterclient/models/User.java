package com.digitalruiz.twitterclient.models;

import org.json.JSONObject;



public class User extends BaseModel {

                public String getName(){
                        return getString("name");
                }
                public String getScreenName() {
                        return getString("screen_name");
                }
                
                public String getProfileImageUrl(){
                        return getString("profile_image_url");
                }
                
                public String getProfileBackgroundImageUrl(){
                        return getString("profile_background_image_url");
                }
                
                public int getNumTweets(){
                        return getInt("statuses_count");
                }
                
                public int getFollowersCount(){
                        return getInt("followers_count");
                }
                
                public int getFriendsCount(){
                        return getInt("friends_count");
                }
                
                public static User fromJson(JSONObject json){
                        User u = new User();
                        
                        try {
                                u.jsonObject = json;
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                        
                        return u;
                }
                
                public String getTagline(){
                        return getString("description");
                }
}
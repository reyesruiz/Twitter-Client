package com.digitalruiz.twitterclient;

import java.util.List;

import android.content.ClipData.Item;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

@Table(name = "Items")
public class Item_Test extends Model {
	@Column(name = "Name")
	public String name;
	

        public Item_Test(){
                super();
        }
        
        public Item_Test(String name){
                super();
                this.name = name;
                
        }
        
    //	public static Item_Test getRandom() {
    //		return new Select().from(Item_Test.class).orderBy("RANDOM()").executeSingle();
    	//	}
    	
    	
}

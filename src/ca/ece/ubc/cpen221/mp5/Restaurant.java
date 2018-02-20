package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;

public class Restaurant {
	
	private boolean isOpen;
	private String url;
	private double longitude;
	private int latitude;
	private ArrayList<String> neighbourhoods;
	private String business_id;
	private String name;
	private ArrayList<String> categories;
	private String state;
	private String type;
	private double stars;
	private String city;
	private String full_address;
	private int review_count;
	private String photo_url;
	private ArrayList<String> schools;
	private int price;
	
	
	public Restaurant(boolean isOpen, String url, double longitude, ArrayList<String> neighbourhoods, String business_id, String name, ArrayList<String> categories,
			String state, String type, double stars, String city, String full_address, int review_count, String photo_url, ArrayList<String> schools, 
			double latitude, int price){
		
		this.isOpen = isOpen;
		this.url = url;
		this.longitude = longitude;
		this.neighbourhoods = neighbourhoods;
		this.business_id = business_id;
		this.name = name;
		this.categories = categories;
		this.state = state;
		this.type = type;
		this.stars = stars;
		this.city = city;
		this.full_address = full_address;
		this.review_count = review_count;
		this.photo_url = photo_url;
		this.schools = schools;
	}
	
	public boolean getIsOpen(){
		return isOpen;
	}
	
	public String getUrl(){
		return url;
	}
	public double getLongitude(){
		return longitude;
	}
	
	public double getLatitude(){
		return latitude;
	}
	
	public ArrayList<String> getNeighbourhoods(){
		return neighbourhoods;
	}
	
	public String getBusiness_id(){
		return business_id;
	}
	
	public String getName(){
		return name;
	}
	
	
	public ArrayList<String> getCategories(){
		return categories;
	}
	
	public String getState(){
		return state;
	}
	
	public String getType(){
		return type;
	}
	public double getStars(){
		return stars;
	}
	
	public String getCity(){
		return city;
	}
	public String getFull_address(){
		return full_address;
	}
	public int getRevew_coutn(){
		return review_count;
	}
	public String photo_url(){
		return photo_url;
	}
	public ArrayList<String> getSchools(){
		return schools;
	}
	public int getPrice(){
		return price;
	}	
}
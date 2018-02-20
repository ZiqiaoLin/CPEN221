package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


// TODO: This class represents the Restaurant Database.
// Define the internal representation and
// state the rep invariant and the abstraction function.

public class RestaurantDB {

	
	ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>();
	ArrayList <Review> reviews = new ArrayList <Review>();
	ArrayList <Users> users = new ArrayList <Users>();
	
	private boolean open;
	private String url;
	private double longitude;
	private ArrayList <String> neighbourhoods = new ArrayList<String>();
	private String business_id;
	private String name;
	private ArrayList <String> categories = new ArrayList<String>();
	private String state;
	private String type;
	private double stars;
	private String city;
	private String full_address;
	private int review_count;
	private String photo_url;
	private ArrayList <String> schools = new ArrayList<String>();
	private double latitude;
	private int price;
	private int coolvotes;
	private int usefulvotes;
	private int funnyvotes;
	private String review_id;
	private String text;
	private String user_id;
	private String date;
	private int reviewstars;
	
	private long average_stars;
	
	
	/**
	 * Create a database from the Yelp dataset given the names of three files:
	 * <ul>
	 * <li>One that contains data about the restaurants;</li>
	 * <li>One that contains reviews of the restaurants;</li>
	 * <li>One that contains information about the users that submitted reviews.
	 * </li>
	 * </ul>
	 * The files contain data in JSON format.
	 *
	 * @param restaurantJSONfilename
	 *            the filename for the restaurant data
	 * @param reviewsJSONfilename
	 *            the filename for the reviews
	 * @param usersJSONfilename
	 *            the filename for the users
	 */
	public RestaurantDB(String restaurantJSONfilename, String reviewsJSONfilename, String usersJSONfilename) {
		// TODO: Implement this method
		JSONParser parser = new JSONParser();
		
		try{
			BufferedReader readRestaurant = new BufferedReader (new FileReader(restaurantJSONfilename));
			String restaurantLine;
			
			while((restaurantLine = readRestaurant.readLine())!=null){
				JSONObject jsonRestaurant = (JSONObject) parser.parse(restaurantLine);
				
				open = (boolean) jsonRestaurant.get("open");
				url = (String) jsonRestaurant.get("url");
				longitude = (double) jsonRestaurant.get("longitude");
				neighbourhoods = (ArrayList<String>) jsonRestaurant.get("neighbourhoods");
				business_id = (String) jsonRestaurant.get("Business_id");
				name = (String) jsonRestaurant.get("name");
				categories = (ArrayList<String>) jsonRestaurant.get("categorires");
				state=(String) jsonRestaurant.get("state");
				type=(String) jsonRestaurant.get("type");
				stars =(double) jsonRestaurant.get("stars");
				city =(String) jsonRestaurant.get("city");
				full_address =(String) jsonRestaurant.get("full_address");
				review_count = (int) jsonRestaurant.get("review_count");
				photo_url = (String) jsonRestaurant.get("photo_url");
				schools = (ArrayList<String>) jsonRestaurant.get("schools");
				latitude = (double) jsonRestaurant.get("latitude");
				price = (int) jsonRestaurant.get("price");
				
				
			    Restaurant rest = new Restaurant(open, url, longitude, neighbourhoods, business_id, name, categories,
					state, type, stars, city, full_address, review_count, photo_url, schools, latitude, price);
				
				restaurants.add(rest);
				
				BufferedReader read = new BufferedReader (new FileReader(reviewsJSONfilename));
				String reviewLine;
				
				while((reviewLine = read.readLine()) != null){
					JSONObject jsonReview = (JSONObject) parser.parse(reviewLine);
					
					type = (String) jsonReview.get("type");
					business_id = (String) jsonReview.get("business_id");
					usefulvotes = (int) ((HashMap) jsonReview.get("votes")).get("cool");
					funnyvotes = (int) ((HashMap) jsonReview.get("votes")).get("funny");
					usefulvotes = (int) ((HashMap) jsonReview.get("votes")).get("useful");
					review_id = (String) jsonReview.get("review_id");
					text = (String) jsonReview.get("text");
					user_id = (String) jsonReview.get("user_id");
					reviewstars = (int) jsonReview.get("stars");
					date = (String) jsonReview.get("date");
					
					
					Review rev = new Review(type, business_id, coolvotes, usefulvotes, funnyvotes, review_id, text, reviewstars, user_id);
					reviews.add(rev);
					
					BufferedReader readUsers = new BufferedReader (new FileReader(usersJSONfilename));
					String userLine;
					
					while((userLine = readUsers.readLine())!=null){
						JSONObject jsonUser = (JSONObject) parser.parse(userLine);
						
						coolvotes = (int) ( (HashMap) jsonUser.get("votes")).get("cool");
						funnyvotes = (int) ((HashMap) jsonUser.get("votes")).get("funny");
						usefulvotes = (int) ((HashMap) jsonUser.get("votes")).get("useful");
						review_count = (int) jsonUser.get("review_count");
						type = (String)jsonUser.get("type");
						user_id = (String) jsonUser.get("user_id");
						name = (String) jsonUser.get("name");
						average_stars = (long) jsonUser.get("average_stars");
						url = (String) jsonUser.get("url");
						
						Users use = new Users(url, funnyvotes, usefulvotes, coolvotes, review_count, type, user_id, name, average_stars);
						
						users.add(use);
			}	
			
		
		}
		
		
      }
   }
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<Review>getReview(){
		return reviews;
	}
	public ArrayList<Restaurant>getRestaurant(){
		return restaurants;
	}
	public ArrayList<Users>getUsers(){
		return users;
	}
		}

		

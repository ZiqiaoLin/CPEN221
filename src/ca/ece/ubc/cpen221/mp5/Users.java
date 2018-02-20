package ca.ece.ubc.cpen221.mp5;

public class Users {
	
	private String url;
	private int funnyvotes;
	private int usefulvotes;
	private int coolvotes;
	private int review_count;
	private String type;
	private String user_id;
	private String review_id;
	private String name;
	private double average_stars;
	
	
	public  Users( String url, int funnyvotes, int usefulvotes, int coolvotes, int review_count, String type,
	 String user_id, String review_id, double average_stars){
		
		this.url = url;
		this.funnyvotes = funnyvotes;
		this.usefulvotes = usefulvotes;
		this.coolvotes = coolvotes;
		this.review_count = review_count;
		this.type = type;
		this.user_id = user_id;
		this.review_id = review_id;
		this.name = name;
		this.average_stars = average_stars;
	}
	
	public String getUrl(){
		return url;
	}
	
	public int getFunnyvotes(){
		return funnyvotes;
	}
	
	public int getUsefulvotes(){
		return usefulvotes;
	}
	
	public int getCoolvotes(){
		return coolvotes;
	}
	
	public int getReview_count(){
		return review_count;
	}
	
	public String getType(){
		return type;
	}
	
	public String getUser_id(){
		return user_id;
	}
	
	public String getReview_id(){
		return review_id;
	}
	
	public String getName(){
		return name;
	}
	
	public double getAverage_stars(){
		return average_stars;
	}
}
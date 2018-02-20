package ca.ece.ubc.cpen221.mp5;

public class Review {
	
	private String type;
	private String business_id;
	private int coolVotes;
	private int usefulVotes;
	private int funnyVotes;
	private String review_id;
	private String text;
	private int stars;
	private String user_id;
	private String date;
	
	public   Review( String type, String business_id, int coolVotes, int usefulVotes,
	 int funnyVotes, String review_id, String text, int stars, String user_id){
		
		this.type = type;
		this.business_id = business_id;
		this.coolVotes = coolVotes;
		this.usefulVotes = usefulVotes;
		this.funnyVotes = funnyVotes;
		this.review_id = review_id;
		this.text = text;
		this.stars = stars;
		this.user_id = user_id;
	}
	
	public String getType(){
		return type;
	}
	
	public String getBusiness_id(){
		return business_id;
	}
	
	public int getCoolVotes(){
		return coolVotes;
	}
	
	public int getUsefulVotes(){
		return usefulVotes;
	}
	
	public int getFunnyVotes(){
		return funnyVotes;
	}
	
	public String getReview_id(){
		return review_id;
	}
	
	public String getText(){
		return text;
	}
	
	public int getStars(){
		return stars;
	}
	
	public String getUser_id(){
		return user_id;
	}
	
	public String getDate(){
		return date;
	}
}
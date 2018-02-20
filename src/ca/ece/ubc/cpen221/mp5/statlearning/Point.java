package ca.ece.ubc.cpen221.mp5.statlearning;

public class Point {

	private final double longitude;
	private final double latitude;
	
	public Point(double x, double y){
		this.longitude = x;
		this.latitude = y;
	}
	
	public double getX(){
		return longitude;
	}
	
	public double getY(){
		return latitude;
	}
	
	public boolean equals(Object obj){
		Point p = new Point(0, 0);
		
		if(obj instanceof Point){
			p = (Point) obj;
		}else{
			return false;
		}
		
		return (p.getX() == this.longitude && p.getY() == this.latitude);
	}
	
	public double getDistance(Point p1, Point p2){
		double distance = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + 
									Math.pow(p1.getY() - p2.getY(), 2));
		
		return distance;
	}
}
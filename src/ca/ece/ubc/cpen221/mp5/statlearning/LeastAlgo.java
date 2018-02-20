package ca.ece.ubc.cpen221.mp5.statlearning;


import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class LeastAlgo implements LeastSquaresRegression{

	double c;
	double a;
	double r_squared;
	FeatureFunction feature;
	
	
	//Using format ax + b for linear equation
	public LeastAlgo(double a, double b, double rr, FeatureFunction featureFunction) {
		this.c = a;
		this.a = b;
		this.r_squared = r_squared;
		this.feature = feature;
	}


	
	
	
	public double getA(){
		return a;
	}
	public double getC(){
		return c;
	}
	public double getRsquared(){
		return r_squared;
	}


	@Override
	public double lsrf(RestaurantDB db, String user_id, String restaurant_id) {
		// TODO Auto-generated method stub
		return a*feature.getFeature(db, restaurant_id) + c;	
	}




}







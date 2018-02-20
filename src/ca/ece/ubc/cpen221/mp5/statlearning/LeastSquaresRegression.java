package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public interface LeastSquaresRegression {

	/**
	 * Compute a feature function given a restaurant
	 *
	 * @param yelpRestaurant
	 * @return the value of the feature function
	 */
	public double lsrf(RestaurantDB db, String user_id, String restaurant_id);
	public double getRsquared();
}

//Implement the getPredictor method, which takes a user and a feature function (as well as the RestaurantDB), 
//and returns a function that predicts the users ratings.

//Also implement the getBestPredictor method that takes a user and a list of feature functions and returns 
//the best predictor function (the one that results in the highest R2 value).

//In this machine problem, we will use a functional interface to pass and return functions 
//but we could have also considered using lambdas that Java 8 supports.
package ca.ece.ubc.cpen221.mp5.statlearning;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import ca.ece.ubc.cpen221.mp5.*;

public class Algorithms {

	/**
	 * Use k-means clustering to compute k clusters for the restaurants in the
	 * database.
	 *
	 * @param db
	 * @return
	 */
	public static List<Set<Restaurant>> kMeansClustering(int k, RestaurantDB db) {
		List<Point> centers = initializeCenters(k, db);
		List<Set<Restaurant>> clusters = assignToClusters(centers, db);
		
		boolean complete = false;
		do{
			List<Point> newCenters = computeNewCenters(clusters);
			clusters = assignToClusters(newCenters, db);
			if(!(new HashSet(centers).equals(new HashSet(newCenters)))){
				centers = newCenters;
			}
			else{
				complete = true;
			}
		
		//As long as the process is not complete, keep doing it;
		}while(complete == false);
		
		return clusters;
	}
	
	private static List<Point> initializeCenters(int k, RestaurantDB db){
		List<Point> initCenters = new ArrayList<Point>();
		List<Restaurant> restaurants = new ArrayList<Restaurant>(db.getRestaurant());
		
		//Get the locations of k restaurants as the initial k centers
		for(int i = 0; i < k; i++){
			double latitude = restaurants.get(i).getLatitude();
			double longitude = restaurants.get(i).getLongitude();
			initCenters.add(new Point(longitude, latitude));
		}
		
		return initCenters;
	}
	
	private static List<Point> computeNewCenters(List<Set<Restaurant>> previousCenters){
		List<Point> newCenters = new ArrayList<Point>();
		for(Set<Restaurant> restaurants : previousCenters){
			double longitudeSum = 0;
			double latitudeSum = 0;
			for(Restaurant res : restaurants){
				longitudeSum += res.getLongitude();
				latitudeSum += res.getLatitude();
			}
			double avgLongitude = longitudeSum / restaurants.size();
			double avgLatitude = latitudeSum / restaurants.size();
			
			newCenters.add(new Point(avgLongitude, avgLatitude));
		}
		return newCenters;
	}
	
	private static List<Set<Restaurant>> assignToClusters(List<Point> centers, RestaurantDB db){
						
		
		
		Map<Restaurant, Point> resToLoc = new HashMap<Restaurant, Point>();
		Map<Restaurant, Point> resToCenter = new HashMap<Restaurant, Point>();
		
		for(Restaurant res : db.getRestaurant()){
			Map<Double ,Point> disToCenter = new HashMap<Double, Point>();
			Point center = new Point(1,1);
			int minD = 6;
			
			for(Point cen : centers){
				double distance = getDistance(cen, new Point(res.getLongitude(), res.getLatitude()));
				disToCenter.put(distance, cen);
				minD = (int) Math.min(distance, minD);	
			}
			
			for(Entry<Double, Point> a : disToCenter.entrySet()){
				if(a.getKey() == minD){
					resToCenter.put(res, a.getValue());
				}
				break;
			}
		}
		
		Map<Point, Set<Restaurant>> clusterMap = new HashMap<Point, Set<Restaurant>>();
		//Create a set corresponding to each center
		for(Point center : centers){
			Set<Restaurant> resSet = new HashSet<Restaurant>();
			clusterMap.put(center, resSet);
		}
		
		//Compare the center of a restaurant to a center
		//If they equal, put the restaurant to the corresponding set
		for( Entry<Restaurant, Point> e : resToCenter.entrySet()){
			for(Point center : centers){
				if(center.equals(e.getValue())){
					clusterMap.get(center).add(e.getKey());
				}
			}
		}
		
		//return a list of sets of restaurants
		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();
		for(Entry<Point, Set<Restaurant>> e : clusterMap.entrySet()){
			clusterList.add(e.getValue());
		}
		
		return clusterList;
	}
	
	public static double getDistance(Point p1, Point p2){
		double distance = Math.sqrt((p1.getX() - p2.getX())*(p1.getX() - p2.getX()) + 
									(p1.getY() - p2.getY())*(p2.getY() - p2.getY()));
		
		return distance;
	}

	public static String convertClustersToJSON(List<Set<Restaurant>> clusters) {
		// TODO: Implement this method
		return null;
	}
	// This method was done alongside the partners Artem and Vitor after discussing the best approach to solve the problem
	public static LeastSquaresRegression getPredictor(String user_id, RestaurantDB db, FeatureFunction featureFunction) {
		
		
		ArrayList <Review> reviews = new ArrayList<Review>();
		ArrayList<Double>featurefunctions = new ArrayList<Double>();
		ArrayList<Integer>stars = new ArrayList<Integer>();
		
		
		double featureAvg = 0;
		double ratingAvg = 0;
		double squarexx = 0;
		double squareyy = 0;
		double squarexy = 0;
		double rr;
		double b;
		double a;
		
		
		//1
		for(Review rev:db.getReview()){
			if(rev.getUser_id().equals(user_id)){
				double feature = featureFunction.getFeature(db, rev.getBusiness_id());
				featurefunctions.add(feature);
				stars.add(rev.getStars());
			}
		}
		//Get the current 
		for(Double d:featurefunctions){
			double sum = 0;
			sum += d;
			featureAvg = sum/(featurefunctions.size());
		}
		//3
		for(Integer i:stars){
			double sum = 0;
			sum+=i;
			ratingAvg = sum/(stars.size());
		}
		//4
		for(Double d:featurefunctions){
			squarexx = squarexx + (d-featureAvg)*(d-featureAvg);
		}
		//5
		for(Integer i :stars){
			squareyy = squareyy + (i-ratingAvg)*(i-ratingAvg);
		}
		//6
		for(int i = 0; i<featurefunctions.size(); i++){
			
			squarexy = squarexy + (featurefunctions.get(i)-featureAvg)*(stars.get(i)-ratingAvg);
		}
		
		
		b = squarexy/squarexx;
        a = ratingAvg - b*featureAvg;
		rr = squarexy/(squarexx*squareyy);
		
		LeastAlgo obj = new LeastAlgo(a,b,rr,featureFunction);
		
		
		return obj;   
	}

	/**
	 * Returns the best predictor for a user's rating
	 * 
	 * @param user_id
	 *            the user id for the user we are interested in
	 * @param db
	 *            the database object that represents the yelp dataset
	 * @param featureFunctionList
	 *            is a list of feature functions from which the best is selected
	 * @return the best prediction function
	 */
	public static LeastSquaresRegression getBestPredictor(String user_id, RestaurantDB db,List<FeatureFunction> featureFunctionList) {
	    LeastSquaresRegression best = null;
		double max = 0;
		for(FeatureFunction temp: featureFunctionList){
		LeastSquaresRegression obj = getPredictor(user_id, db, temp);
		     if(obj.getRsquared()>max)
		    	 max = obj.getRsquared();
		         best = obj;
		}
		
		return best;
	}
}
	

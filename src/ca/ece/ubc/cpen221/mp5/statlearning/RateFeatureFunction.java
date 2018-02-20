package ca.ece.ubc.cpen221.mp5.statlearning;

import java.util.ArrayList;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class RateFeatureFunction implements FeatureFunction {

	
	
	
	public double getFeature(RestaurantDB rdb, String restaurant_id) {
		// TODO Auto-generated method stub
		{
			ArrayList<Restaurant> rest = new ArrayList<Restaurant>();
			
			for(Restaurant r:rest){
				if (r.getBusiness_id().equals(restaurant_id))
					return r.getPrice();
			}
			
			return 0;
		}

	}

}
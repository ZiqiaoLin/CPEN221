package ca.ubc.ece.cpen221.mp4.commands;

import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.World;
import vehicles.Vehicle;

public class BrakeCommand implements Command {

		Vehicle vehicle;
		Location targetLocation;
		int coolDown;
		
		public BrakeCommand(Vehicle vehicle, Location targetLocation) {
			this.vehicle = vehicle;
			this.targetLocation = targetLocation;
			
			for(int i = 1; i < Integer.MAX_VALUE; i++){
				vehicle.setCOOLDOWN(vehicle.getCoolDownPeriod() + 1);
			}	
		}

	@Override
	public void execute(World world) throws InvalidCommandException {
		// TODO Auto-generated method stub
		
	}
}

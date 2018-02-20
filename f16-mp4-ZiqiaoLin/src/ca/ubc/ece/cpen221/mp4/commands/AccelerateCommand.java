package ca.ubc.ece.cpen221.mp4.commands;

import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.items.MoveableItem;
import ca.ubc.ece.cpen221.mp4.items.MoveableMachine;
import vehicles.Vehicle;

public final class AccelerateCommand implements Command{

	Vehicle vehicle;
	Location targetLocation;
	int coolDown;
	
	public AccelerateCommand(Vehicle vehicle, Location targetLocation) {
		this.vehicle = vehicle;
		this.targetLocation = targetLocation;
		
		vehicle.setCOOLDOWN(vehicle.getCoolDownPeriod() - 1);
		new MoveCommand(vehicle, targetLocation);
	}
	@Override
	public void execute(World world) throws InvalidCommandException {
		// TODO Auto-generated method stub
		
	}
	
}

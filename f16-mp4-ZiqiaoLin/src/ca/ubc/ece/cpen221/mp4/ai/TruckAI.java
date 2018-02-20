package ca.ubc.ece.cpen221.mp4.ai;

import java.util.Iterator;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.ArenaWorld;
import ca.ubc.ece.cpen221.mp4.Direction;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.commands.BumpCommand;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.MoveCommand;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.MoveableMachine;

public class TruckAI extends VehicleAI{
	
	public TruckAI() {
	}
	
	public Command getNextAction(World world, MoveableMachine machine) {
		Direction dir = Util.getRandomDirection();
		Location targetLocation = new Location(machine.getLocation(), dir);
		Set<Item> possibleBumps = world.searchSurroundings(machine.getLocation(), 1);
		Location current = machine.getLocation();
		Iterator<Item> it = possibleBumps.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			if ((item.getName().equals("Gnat") || item.getName().equals("Rabbit"))
					&& (current.getDistance(item.getLocation()) == 1)) {
				return new BumpCommand(machine, item); // arena machines eat gnats
														// and rabbits
			}
		}
		if (Util.isValidLocation(world, targetLocation) && this.isLocationEmpty(world, targetLocation)) {
			return new MoveCommand(machine, targetLocation);
		}
		return new WaitCommand();
	}
}

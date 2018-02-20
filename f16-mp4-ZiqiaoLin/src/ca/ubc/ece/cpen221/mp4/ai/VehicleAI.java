package ca.ubc.ece.cpen221.mp4.ai;

import ca.ubc.ece.cpen221.mp4.ArenaWorld;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;
import ca.ubc.ece.cpen221.mp4.items.MoveableMachine;
import ca.ubc.ece.cpen221.mp4.items.animals.ArenaAnimal;

public class VehicleAI extends MoveableMachineAI{
	
	public Command getNextAction(ArenaWorld world, MoveableMachine machine) {
		return new WaitCommand();
	}
}

package ca.ubc.ece.cpen221.mp4.commands;

import ca.ubc.ece.cpen221.mp4.Food;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.LivingItem;
import ca.ubc.ece.cpen221.mp4.items.MoveableMachine;

/**
 * An EatCommand is a {@link Command} which represents a {@link LivingItem}
 * eating a {@link Food}.
 */
public final class BumpCommand implements Command {

	private final Item potentialVictim;
	private final MoveableMachine MoveableMachine;

	/**
	 * Construct a {@link EatCommand}, where <code> item </code> is the eater
	 * and <code> food </code> is the food. Remember that the food must be
	 * adjacent to the eater, and the eater must have greater strength than the
	 * food.
	 *
	 * @param Vehicle
	 *            the eater
	 * @param food
	 *            : the food
	 */
	public BumpCommand(MoveableMachine moveableMachine, Item potentialVictim) {
		this.MoveableMachine = moveableMachine;
		this.potentialVictim = potentialVictim;
	}


	@Override
	public void execute(World w) throws InvalidCommandException {
		if (MoveableMachine.getStrength() <= potentialVictim.getStrength())
			throw new InvalidCommandException("Invalid BumpCommand: Food possesses too much strength");
		if ( potentialVictim.getLocation().getDistance(MoveableMachine.getLocation()) != 1)
			throw new InvalidCommandException("Invalid EatCommand: Food is not adjacent");

		MoveableMachine.Crash(potentialVictim);
		potentialVictim.loseEnergy(Integer.MAX_VALUE);
	}

}

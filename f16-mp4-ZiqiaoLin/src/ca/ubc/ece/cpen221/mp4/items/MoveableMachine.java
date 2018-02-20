package ca.ubc.ece.cpen221.mp4.items;

import ca.ubc.ece.cpen221.mp4.Actor;

public interface MoveableMachine extends MoveableItem, Actor {
	
	/**
	 * Returns the current energy of this living thing. A {@link LivingItem}
	 * gains energy by eating and loses energy by performing actions. If its
	 * energy level drops below or equal to 0, it dies.
	 *
	 * @return current energy level
	 */
	int getEnergy();
	
	/**+
	 * Crash the items that has a lower strength
	 */
	void Crash(Item item);
	
	boolean isDestroyed();
}

package ca.ubc.ece.cpen221.mp4.items.vehicles;


import javax.swing.ImageIcon;

import ca.ubc.ece.cpen221.mp4.Food;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.ai.AI;
import ca.ubc.ece.cpen221.mp4.ai.VehicleAI;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.items.Item;
import ca.ubc.ece.cpen221.mp4.items.LivingItem;
import ca.ubc.ece.cpen221.mp4.items.MoveableMachine;

public abstract class Vehicle implements MoveableMachine {
	private int INITIAL_ENERGY;
	private int MAX_ENERGY;
	private int STRENGTH;
	private int VIEW_RANGE;
	private int COOLDOWN;
	private ImageIcon image;
	private boolean isDestroyed;

	private VehicleAI ai;

	private Location location;
	private int energy = INITIAL_ENERGY;
	
	@Override
	public void Crash(Item item) {
		if(item.getStrength() >= STRENGTH){
			energy = 0;
			isDestroyed = true;
		}else{
			item.loseEnergy(Integer.MAX_VALUE);
		}
	}

	protected void setINITIAL_ENERGY(int i) {
		this.INITIAL_ENERGY = i;
	}

	protected void setEnergy(int i) {
		this.energy = i;
	}

	protected void setMAX_ENERGY(int i) {
		this.MAX_ENERGY = i;
	}

	protected void setSTRENGTH(int i) {
		this.STRENGTH = i;
	}

	protected void setVIEW_RANGE(int i) {
		this.VIEW_RANGE = i;
	}

	public void setCOOLDOWN(int i) {
		this.COOLDOWN = i;
	}

	protected void setLocation(Location l) {
		this.location = l;
	}

	@Override
	public int getCoolDownPeriod() {
		return COOLDOWN;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public ImageIcon getImage() {
		return image;
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	public int getMaxEnergy() {
		return MAX_ENERGY;
	}

	@Override
	public int getMeatCalories() {
		return energy;
	}

	@Override
	public int getMovingRange() {
		return 1; // Can only move to adjacent locations.
	}

	@Override
	public abstract String getName();

	@Override
	public Command getNextAction(World world) {
		Command nextAction = ai.getNextAction(world, this);
		this.energy--; // Loses 1 energy regardless of action.
		return nextAction;
	}

	@Override
	public int getPlantCalories() { // arena animals dont eat plants
		return 0;
	}

	@Override
	public int getStrength() {
		return STRENGTH;
	}
	
	public int getViewRange() {
		return VIEW_RANGE;
	}

	@Override
	public boolean isDead() {
		return this.energy <= 0;
	}

	@Override
	public void loseEnergy(int energyLoss) {
		this.energy = this.energy - energyLoss;
	}

	@Override
	public void moveTo(Location targetLocation) {
		location = targetLocation;
	}
}

import java.util.Random;

public class Creature {

	public int rank;
	private int food;
	private int foodTendency;
	private int energy;

	
	public Creature(int rank, int foodTendency) {

		Random r = new Random();

		this.rank = rank;
		this.foodTendency = foodTendency;
		energy = r.nextInt(9) + 1;
		food = 0;

	}

	public int getFood() {
		return food;
	}

	public int getRank() {
		return rank;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int n) {
		energy = energy + n;
	}

	public void energyDec() {
		energy -= 1;
	}

	public void energyInc() {
		energy++;
	}

	public void foodInc() {
		food++;
	}

	public void foodReset() {
		food = 0;
	}

	public int getTendency() {
		return foodTendency;
	}

	public String toString() {

		String s = "(Rank: " + rank + ", " + " Food: " + Integer.toString(food) + ", " + "Energy: " + Integer.toString(energy) + ")";
		return s;

	}



}
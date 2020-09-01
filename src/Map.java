import java.util.*;

public class Map {
	
	private int food;
	private int foodEaten;
	private Population p;
	private int cycle;
	private int deaths;

	public Map(int food, int cycle, Population p) {

		this.food = food;
		foodEaten = 0;
		this.p = p;
		this.cycle = cycle;

	}

	public void getsFood() {

		Random r = new Random();

		for (int j = 0; j < cycle; j++) {

			for (int i = 0; i < p.size(); i++) {

				if (food > 0) {

					if (p.get(i).getTendency() >= 89) {

					p.get(i).foodInc();
					food--;

				} else if (p.get(i).getTendency() >= 49 && p.get(i).getTendency() <= 88) {

					if (r.nextInt(1) == 1) {

						p.get(i).foodInc();
						food--;

					}

				} else {

					if (r.nextInt(3) == 3) {

						p.get(i).foodInc();
						food--;

						}

					}


				}

			}

		}
	}

	public void survival() {

		Random r = new Random();
		int n;
		deaths = 0;


		for (int i = 0; i < p.size(); i++) {

			n = r.nextInt(100) + 1;

			if (p.get(i).getEnergy() == 0 && n <= 50) {

				p.remove(i);
				deaths++;

			} else if (p.get(i).getEnergy() == 1) {

				p.get(i).energyDec();

			}

		}

		foodRestore();
		p.energyCalc();
		p.populate();

	}

	public void foodRestore() {

		Double temp = p.size()/0.9;
		food = temp.intValue();

	}

	public int food() {
		return food;
	}

	public int getDeaths() {
		return deaths;
	}

}
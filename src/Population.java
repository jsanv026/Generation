import java.lang.*;
import java.util.*;

public class Population {

	private ArrayList<Creature> array;
	private int birth;

	public Population(int size) {

		array = new ArrayList<>();
		Random r = new Random();

		for (int i = 0; i < size; i++) {

			Integer n = r.nextInt(99);
			Creature c = new Creature(i,n);
			array.add(c);

		}

	}

	public void remove(int index) {
		array.remove(index);
	}

	public Creature get(int index) {
		return array.get(index);
	}

	public void add(Creature c) {
		array.add(c);
	}

	public int size() {
		return array.size();
	}

	public int getBirths(){
		return birth;
	}

	public int topTen() {

		int creatures = 0;

		for (int i = 0; i < size(); i++) {

			if (get(i).getTendency() >= 89) {
				creatures++;
			}

		}

		return creatures;

	}

	public void populate() {

		int tmp = size();
		birth = 0;
		//System.out.println(toString());



		for (int i = 0; i < tmp; i++) {

			if (get(i).getEnergy() > 1) {

				get(i).energyDec();
				Creature c = get(i);
				c.energyDec();
				add(c);
				birth++;

			}

		}

	}

	public void energyCalc() {

		//System.out.println(toString());

		for (int i = 0; i < size(); i++) {

			get(i).setEnergy(get(i).getFood());
			get(i).foodReset();

		}

	}

	public int energyGreater() {

		int en = 0;

		for (int i = 0; i < size(); i++) {

			if (get(i).getEnergy() > 0) {

				en++;

			}

		}
		return en;
	}

	public String toString() {

		String s = "[";

		for (int i = 0; i < size(); i++) {

			if (i == size() - 1) {

				s += get(i);

			} else {

				s += get(i) + ", ";

			}
			

		}

		return s + "]";

	}


}
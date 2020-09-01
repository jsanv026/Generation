public class Test {
	
	public Test(int size, int gen, int food, int cycle) {

		Population p = new Population(size);
		Map m = new Map(food, cycle, p);

		for (int i = 0; i < gen; i++) {

			if (p.size() == 1) {
				System.out.println("\nCreature of rank " + p.get(0).getRank() + " is the last alive with");
				System.out.println("food tendency rating of " + (p.get(0).getTendency()+1));
				break;

			} else if(p.size() == 0) {
				System.out.println("\nEveryone died before simulation could complete");
				break;
				
			}

			System.out.println("\n<---------[Generation: " + (i+1) + "]--------->");
			System.out.println("\nPopulation Size: " + p.size());
			System.out.println("Births: " + p.getBirths());
			System.out.println("Deaths: " + m.getDeaths());
			System.out.println("Net: " + (p.getBirths() - m.getDeaths()));

			System.out.println("\nCreatures with rating 90+: " + p.topTen());
			System.out.println("How much food in the map?: " + m.food());
			System.out.println("How much creature with energy?: " + p.energyGreater());
			
			m.getsFood();
			m.survival();

		}
		
	}

}
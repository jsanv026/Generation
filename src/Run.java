import java.util.Scanner;

public class Run {
	
	public static void main(String[] args) {

		int size;
		int gen;
		int food;
		int cycle;
		String response;

		Scanner input = new Scanner(System.in);

		System.out.println("+-------------------------+");
		System.out.println(" Generation Simulator v0.1");
		System.out.println("+-------------------------+");

		System.out.println("How many creatures? ");
		size = input.nextInt();

		System.out.println("\nHow many generations? ");
		gen = input.nextInt();

		System.out.println("\nHow much food? ");
		food = input.nextInt();

		System.out.println("\nHow cycles per generation? ");
		cycle = input.nextInt();

		System.out.println("Console or GUI?");
		response = input.next();

		if (response.equals("console")) {
			Test test = new Test(size,gen,food,cycle);
		} else if (response.equals("gui")) {
			Graphic gui = new Graphic(size, gen, food, cycle);
		}
	}

}
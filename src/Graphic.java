import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Graphic extends JFrame {

	private int size;
	private int gen;
	private int food;
	private int cycle;
	private JFrame frame;
	private TextArea area;
	
	public Graphic(int size, int gen, int food, int cycle) {

		this.size = size;
		this.gen = gen;
		this.food = food;
		this.cycle = cycle;

		frame = new JFrame("Generation Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,800);

		JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("PH");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Options");
        JMenuItem m12 = new JMenuItem("Close");
        m1.add(m11);
        m1.add(m12);

        JLabel labelTitle = new JLabel("Generation Simulator v1.0 ");
        labelTitle.setFont(new Font("Serif", Font.PLAIN, 24));

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        JLabel labelNumCreatures = new JLabel("Starting Creatures: ");
        JTextField tfCreatures = new JTextField(Integer.toString(size), 10);
        JLabel labelGenerations = new JLabel("Generations: ");
        JTextField tfGen = new JTextField(Integer.toString(gen), 10);
        JLabel labelFood = new JLabel("Food availability: ");
        JTextField tfFood = new JTextField(Integer.toString(food), 10);
        JLabel labelCycles = new JLabel("Number of Cycles: ");
        JTextField tfCycles = new JTextField(Integer.toString(cycle), 10);
        JButton start = new JButton("Generate");
        panelRight.add(labelNumCreatures);
        panelRight.add(tfCreatures);
        panelRight.add(labelGenerations);
        panelRight.add(tfGen);
        panelRight.add(labelFood);
        panelRight.add(tfFood);
        panelRight.add(labelCycles);
        panelRight.add(tfCycles);
        panelRight.add(start);
        start.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {

        		size(Integer.parseInt(tfCreatures.getText()));
        		gen(Integer.parseInt(tfGen.getText()));
        		food(Integer.parseInt(tfFood.getText()));
        		cycle(Integer.parseInt(tfCycles.getText()));
        		run();

        	}
        });

        area = new TextArea(300,300);


        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.NORTH, labelTitle);
        frame.getContentPane().add(BorderLayout.EAST, panelRight);
        frame.getContentPane().add(BorderLayout.CENTER, area);
		frame.setVisible(true);

	}

	public void run() {

		Population p = new Population(size);
		Map m = new Map(food, cycle, p);
		area.setText(null);

		for (int i = 0; i < gen; i++) {

			if (p.size() == 1) {
				area.append("\nCreature of rank " + p.get(0).getRank() + " is the last alive with");
				area.append("food tendency rating of " + (p.get(0).getTendency()+1));
				break;

			} else if(p.size() == 0) {
				area.append("\nEveryone died before simulation could complete");
				break;
				
			}

			area.append("\n\n<---------------[Generation: " + (i+1) + "]--------------->");
			area.append("\nPopulation Size: " + p.size());
			area.append("\nBirths: " + p.getBirths());
			area.append("\nDeaths: " + m.getDeaths());
			area.append("\nNet: " + (p.getBirths() - m.getDeaths()));

			area.append("\n\nCreatures with rating 90+: " + p.topTen());
			area.append("\nHow much food in the map?: " + m.food());
			area.append("\nHow much creature with energy?: " + p.energyGreater());
			
			m.getsFood();
			m.survival();

		}

	}

	public void size(int n) {
		size = n;
	}

	public void gen(int n) {
		gen = n;
	}

	public void food(int n) {
		food = n;
	}

	public void cycle(int n) {
		cycle = n;
	}

}
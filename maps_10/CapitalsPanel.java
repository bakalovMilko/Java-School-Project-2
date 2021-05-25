package maps_10;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CapitalsPanel extends JPanel{
	private JTextField questionField = new JTextField();
	private JTextField answearField = new JTextField();
	private JTextField pointsField = new JTextField();
	private Map<String, String> capitals = new HashMap<String, String>();
	private String currentKey;
	private int points = 0;
	
	public CapitalsPanel() throws Exception {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//Add the fields
		add(questionField);
		add(answearField);
		add(pointsField);
		
		//set fields' editability
		questionField.setEditable(false);
		answearField.setEditable(true);
		pointsField.setEditable(false);
		
		//add the entries to the map
		File file = new File("C:/Users/User/Documents/workspace 2/Module 2/src/capitals.txt");
		Scanner sc = new Scanner (file);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String country = line.split(", ")[0];
			String capital = line.split(", ")[1];
			capitals.put(country, capital);
		}
		sc.close();
		
		currentKey = randomKey(capitals);
		questionField.setText("What is the capital of " + currentKey + "?");
		
		answearField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String answear = answearField.getText();
					answearField.setText("");
					if(answear.equals(capitals.get(currentKey))) {
						points+= 50;
						pointsField.setText("Points: " + points);
						currentKey = randomKey(capitals);
						questionField.setText("Correct! Now, what is the capital of " + currentKey + "?");
					}
					else {
						points -= 100;
						pointsField.setText("Points: " + points);
						currentKey = randomKey(capitals);
						questionField.setText("Incorrect! What is the capital of " + currentKey + "?");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}
	public static String randomKey(Map<String, String> map){
		int randomIndex = (int)(map.size() * Math.random());
		int currentIndex = 0;
		for(String iterator : map.keySet()) {
			if(currentIndex == randomIndex) {
				return iterator;
			}
			else {
				currentIndex++;
			}
		}
		return "";
	}
}

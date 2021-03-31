package collections_7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.*;

public class numbersPanel extends JPanel{
	JPanel buttonPanel = new JPanel();
	JTextField inputField = new JTextField();
	JTextArea outputArea = new JTextArea();
	JButton reverseButton = new JButton("Reverse");
	JButton sortButton = new JButton("Sort");
	JButton shuffleButton = new JButton("Shuffle");
	
	LinkedList<Integer> list = new LinkedList<Integer>();
	
	numbersPanel(){
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(reverseButton);
		buttonPanel.add(sortButton);
		buttonPanel.add(shuffleButton);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(inputField);
		this.add(outputArea);
		this.add(buttonPanel);
		
		outputArea.setEditable(false);
		
		reverseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				java.util.Collections.reverse(list);
				printList();
			}
		});
		sortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				java.util.Collections.sort(list);
				printList();
			}
		});
		shuffleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				java.util.Collections.shuffle(list);
				printList();
			}
		});
		inputField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
		        {
					if(!isStringAnInteger(inputField.getText())) {
						inputField.setText("Incorrect input!");
						return;
					} else if(!isNew(Integer.parseInt(inputField.getText()))) {
						inputField.setText("This number exists in the list already.");
					} else {
						list.addLast(Integer.parseInt(inputField.getText()));
						printList();
						inputField.setText("");
					}
		        }
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void printList() {
		outputArea.setText("");
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext();) {
			outputArea.setText(outputArea.getText() + itr.next() + " ");
		}
	}
	public static boolean isStringAnInteger (String a) {
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)<'0' || a.charAt(i)>'9') {
				return false;
			}
		}
		return true;
	}
	public boolean isNew (int newInt) {
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext();) {
			if(itr.next() == newInt) {
				return false;
			}
		}
		return true;
	}
	
}

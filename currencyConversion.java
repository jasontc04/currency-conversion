package currencyConversion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.lang.Exception;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class currencyConversion {
	//Create the frame that holds everything inside
	private JFrame frame;

	//main method to launch the GUI
	public static void main(String[] args) {
		//essentially runs the GUI so that it opens
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//creates currency Conversion object
					currencyConversion window = new currencyConversion();
					//lets us see the frame/GUI
					window.frame.setVisible(true);
				//general exception to ensure GUI can run
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//initialization method
	public currencyConversion() {
		initialize();
	}

	//initialize the stuff that will be seen inside the frame + how it will run
	private void initialize() {
		//create a JFrame: a container
		frame = new JFrame();
		//set sizing-- I made it small
		frame.setBounds(100, 100, 300, 150);
		//terminate GUI statement
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make 2 different sections using a tabbed pane and add panels on each
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		//set sizes of panels
		panel1.setPreferredSize(new Dimension(640, 480));
		panel2.setPreferredSize(new Dimension(640, 480));
		//The tabbed pane allows us to switch back and forth between converting to and from
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        //Give names on each tab and add the panels to each
		tabbedPane.addTab("Convert from USD", panel1);
        tabbedPane.addTab("Convert to USD", panel2);
        //add the tabbed pane to the frame as a whole
        frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		//Create comboboxes for different conversions
		String[] types = {"Choose a currency to convert to!", "Pesos", "Euros", "Yen"};
		final JComboBox<Object> typesOfMoney = new JComboBox<Object>(types);
		//Combo box takes in a list of strings with the different conversions I offer
		//add to panel1
		panel1.add(typesOfMoney, BorderLayout.EAST);
		
		//create text field that will take in the USD amount
		JTextField enterAmount = new JTextField("Enter amount (USD)");
		//add to panel1
		panel1.add(enterAmount, BorderLayout.WEST);
		
		//create arrow just using a label
		JLabel arrow = new JLabel("-->");
		//add to panel1
		panel1.add(arrow, BorderLayout.CENTER);
		
		
		//create conversion button
		JButton convert = new JButton("Convert!");
		//add ActionListener so that it has functionality when pressed
		convert.addActionListener(new ActionListener() {
			//define the action that happens inside this method
			public void actionPerformed(ActionEvent e) {
				//initialize important variables
				double usdAmount;
				double convertedAmount;
				//if statements to determine what type of currency the user selected
				//Take the value from the typesOfMoney JTextField and see if it equals pesos
				if (String.valueOf(typesOfMoney.getSelectedItem()).equals("Pesos")) {
					//take number from the enterAmount text field and convert from string to double
					usdAmount = Double.valueOf(enterAmount.getText());
					//conversion
					convertedAmount = usdAmount*19.92;
					//Print to console
					System.out.println(usdAmount + " in USD is " + convertedAmount + " in pesos.");
				}
				//Take the value from the typesOfMoney JTextField and see if it equals euros
				if (String.valueOf(typesOfMoney.getSelectedItem()).equals("Euros")) {
					//take number from the enterAmount text field and convert from string to double
					usdAmount = Double.valueOf(enterAmount.getText());
					//conversion
					convertedAmount = usdAmount*0.83;
					//Print to console
					System.out.println(usdAmount + " in USD is " + convertedAmount + " in euros.");
				}
				//Take the value from the typesOfMoney JTextField and see if it equals yen
				if (String.valueOf(typesOfMoney.getSelectedItem()).equals("Yen")) {
					//take number from the enterAmount text field and convert from string to double
					usdAmount = Double.valueOf(enterAmount.getText());
					//conversion
					convertedAmount = usdAmount*110.03;
					//Print to console
					System.out.println(usdAmount + " in USD is " + convertedAmount + " in yen.");
				}
			}
		
		});
		//add convert button to panel1
		panel1.add(convert, BorderLayout.SOUTH);
		
		
		//PANEL 2
		//Create list of options of currency
		String[] types2 = {"Choose a currency to convert from!", "Pesos", "Euros", "Yen"};
		//create combobox that takes types2 (a list) in
		final JComboBox<Object> typesOfMoney2 = new JComboBox<Object>(types2);
		//add combobox to panel2
		panel2.add(typesOfMoney2, BorderLayout.EAST);
		
		//Textfield that prompts user to enter an amount
		JTextField enterAmount2 = new JTextField("Enter amount");
		//add to panel2 on the left side
		panel2.add(enterAmount2, BorderLayout.WEST);
		
		//Create a button to convert
		JButton convert2 = new JButton("Convert!");
		//add actionListener to allow for usage
		convert2.addActionListener(new ActionListener() {
			
			//method that defines what will happen when pressed
			public void actionPerformed(ActionEvent e) {
				//usdAmount variable name is misleading (it was a copy-paste from above).
				//It should actually be the unknown currency amount
				double usdAmount;
				//converted amount is the USD amount
				double convertedAmount;
				//See if the amount given in textfield is pesos
				if (String.valueOf(typesOfMoney2.getSelectedItem()).equals("Pesos")) {
					//find pesos amount from text field and convert to double
					usdAmount = Double.valueOf(enterAmount2.getText());
					//conversion
					convertedAmount = usdAmount/19.92;
					//print to console
					System.out.println(usdAmount + " in pesos is " + convertedAmount + " in USD.");
				}
				//See if the amount given in textfield is euros
				if (String.valueOf(typesOfMoney2.getSelectedItem()).equals("Euros")) {
					//find euro amount from text field and convert to double
					usdAmount = Double.valueOf(enterAmount2.getText());
					//conversion
					convertedAmount = usdAmount/0.83;
					//print to console
					System.out.println(usdAmount + " in euros is " + convertedAmount + " in USD.");
				}
				//See if the amount given in textfield is yen
				if (String.valueOf(typesOfMoney2.getSelectedItem()).equals("Yen")) {
					//find yen amount from text field and convert to double
					usdAmount = Double.valueOf(enterAmount2.getText());
					//conversion
					convertedAmount = usdAmount/110.03;
					//print to console
					System.out.println(usdAmount + " in yen is " + convertedAmount + " in USD.");
				}
			}
		
		});
		//add button to panel2
		panel2.add(convert2, BorderLayout.SOUTH);
	}

}

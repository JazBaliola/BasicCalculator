/**
 * 
 */
package jazcodeit.sc.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Simple Calculator Application
 * 
 * @author Jaz Baliola
 * @version 8/30/2022
 *
 */
public class Calculator extends JFrame {

	// Global Fields

	/**
	 * Initialize JTextFields
	 */
	private JTextField output, calculationPreview;

	/**
	 * Initialize JButtons
	 */
	private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAC,
			buttonEqual, buttonAddition, buttonSubtract, buttonMultiply, buttonDivide;

	/**
	 * Initialize Fields for inputs and calculation
	 */
	private int num1 = 0, num2 = 0, calculation = 0;

	/**
	 * Field for calculation preview text field
	 */
	private String preview = "";

	/**
	 * Field for what operator needed for calculation
	 */
	private char operator;

	/**
	 * ArrayList for storing all numeric buttons
	 */
	private ArrayList<JButton> numericButtons = new ArrayList<JButton>();

	/**
	 * ArrayList for storing all operator buttons
	 */
	private ArrayList<JButton> operatorButtons = new ArrayList<JButton>();

	/**
	 * Boolean Field to know if the next input is number
	 */
	boolean numberInput;

	/**
	 * Initialize Calculator Constructor
	 */
	public Calculator() {

		// Change Name from Super Class
		super("Jaz Simple Calculator");

		System.out.println("Application Started!");

		// Disable User to Resize Frame
		this.setResizable(false);

		// Set Size of the Frame
		this.setSize(410, 625);

		// Close Application when X is clicked
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Panels
		JPanel topPanel = createTopPanel();
		JPanel keypadPanel = createKeypadPanel();

		// Add Panel to Frame
		this.add(topPanel, BorderLayout.NORTH);
		this.add(keypadPanel, BorderLayout.CENTER);

	}

	/**
	 * Create Top Panel for output text field and calculation text field
	 * 
	 * @return JPanel - Return JPanel for Top section of the application
	 */
	public JPanel createTopPanel() {

		// Initialize new Panel
		JPanel panel = new JPanel(new BorderLayout());

		// Initialize Text Field
		output = new JTextField();
		output.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		output.setPreferredSize(new Dimension(390, 40));
		output.setFont(new Font("Verdana", Font.PLAIN, 40));
		output.setHorizontalAlignment(JTextField.RIGHT);
		output.setEditable(false);

		calculationPreview = new JTextField();
		calculationPreview.setPreferredSize(new Dimension(390, 20));
		calculationPreview.setFont(new Font("Verdana", Font.PLAIN, 20));
		calculationPreview.setEditable(false);

		// Add to Panel
		panel.add(output, BorderLayout.NORTH);
		panel.add(calculationPreview, BorderLayout.CENTER);

		// Return Panel
		return panel;
	}

	/**
	 * Create Panel for Keypad section
	 * 
	 * @return JPanel - Return JPanel for Keypad section of the application
	 */
	public JPanel createKeypadPanel() {
		JPanel panel = new JPanel(new GridLayout(4, 4));

		// Initialize Buttons
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonAC = new JButton("AC");
		buttonEqual = new JButton("=");
		buttonAddition = new JButton("+");
		buttonSubtract = new JButton("-");
		buttonMultiply = new JButton("x");
		buttonDivide = new JButton("÷");

		// Add buttons to array
		numericButtons.add(button0);
		numericButtons.add(button1);
		numericButtons.add(button2);
		numericButtons.add(button3);
		numericButtons.add(button4);
		numericButtons.add(button5);
		numericButtons.add(button6);
		numericButtons.add(button7);
		numericButtons.add(button8);
		numericButtons.add(button9);

		operatorButtons.add(buttonAC);
		operatorButtons.add(buttonEqual);
		operatorButtons.add(buttonAddition);
		operatorButtons.add(buttonSubtract);
		operatorButtons.add(buttonMultiply);
		operatorButtons.add(buttonDivide);

		// Add Event Listener to Buttons
		for (int i = 0; i < numericButtons.size(); i++) {
			numericButtons.get(i).addActionListener(buttonListener);
			numericButtons.get(i).setFont(new Font("Arial", Font.BOLD, 25));
			numericButtons.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		for (int i = 0; i < operatorButtons.size(); i++) {
			operatorButtons.get(i).addActionListener(buttonListener);
			operatorButtons.get(i).setFont(new Font("Arial", Font.BOLD, 25));
			operatorButtons.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		// Add Buttons to Panel

		// First Row
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(buttonDivide);

		// Second Row
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(buttonMultiply);

		// Third Row
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(buttonSubtract);

		// Fourth Row
		panel.add(button0);
		panel.add(buttonAC);
		panel.add(buttonEqual);
		panel.add(buttonAddition);

		// Return Panel
		return panel;
	}

	/**
	 * Action Listener for all buttons
	 */
	public ActionListener buttonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				// Numeric
				for (int i = 0; i < numericButtons.size(); i++) {

					if (e.getSource() == numericButtons.get(i)) {

						// If the input is second number then clear current value on the output text
						// field
						if (!numberInput) {
							output.setText("");
							numberInput = true;
						}

						output.setText(output.getText().concat(String.valueOf(i)));

						preview += String.valueOf(i);
					}

				}

				// Operators
				if (e.getSource() == buttonAddition) {

					numberInput = false;
					num1 = Integer.parseInt(output.getText());
					operator = '+';
					output.setText("+");
					preview += output.getText();

				} else if (e.getSource() == buttonSubtract) {

					numberInput = false;
					num1 = Integer.parseInt(output.getText());
					operator = '-';
					output.setText("-");
					preview += output.getText();

				} else if (e.getSource() == buttonMultiply) {

					numberInput = false;
					num1 = Integer.parseInt(output.getText());
					operator = '*';
					output.setText("x");
					preview += output.getText();

				} else if (e.getSource() == buttonDivide) {

					numberInput = false;
					num1 = Integer.parseInt(output.getText());
					operator = '/';
					output.setText("÷");
					preview += output.getText();
				}

				// Equals/Calculation
				if (e.getSource() == buttonEqual) {

					num2 = Integer.parseInt(output.getText());

					switch (operator) {
					case '+':
						calculation = num1 + num2;
						break;
					case '-':
						calculation = num1 - num2;
						break;
					case '*':
						calculation = num1 * num2;
						break;
					case '/':
						calculation = num1 / num2;
						break;
					default:
						break;
					}

					// show the result of calculation
					output.setText(String.valueOf(calculation));
					preview += "=" + output.getText();

				}

				// Clear Text Fields
				if (e.getSource() == buttonAC) {
					// Set all fields to null
					output.setText("");
					num1 = 0;
					num2 = 0;
					preview = "";
				}

				// Update calculation preview on text field
				calculationPreview.setText(preview);

			} catch (ArithmeticException | NumberFormatException err) {
				output.setText("Error!");
			}

		}

	};

}

package automovel;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAltera extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public TelaAltera() {
		setLayout(new MigLayout("", "[grow][31.00,grow][grow][grow][grow][grow][grow]", "[][][][][68.00][54.00,grow][][][][grow][]"));
		
		JLabel lblNewLabel = new JLabel("ALTERAR AUTOMOVEL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblNewLabel, "cell 1 0 5 1,alignx center");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 1 2 5 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		add(lblNewLabel_1, "cell 1 4,alignx right,aligny bottom");
		
		textField = new JTextField();
		add(textField, "cell 2 4 4 1,growx,aligny bottom");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("MODELO:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel_1_1, "cell 1 5,alignx trailing,aligny bottom");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 2 5 4 1,growx,aligny bottom");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("MARCA:");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel_1_1_1, "cell 1 6,alignx right,aligny bottom");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 2 6 4 1,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("ANO:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel_1_2, "cell 1 7,alignx trailing,aligny bottom");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 2 7 4 1,growx");
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, "cell 1 9 2 1,growx");
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1, "cell 4 9 2 1,growx");

	}

}

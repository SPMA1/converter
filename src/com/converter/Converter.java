package com.converter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JTextPane;

import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.SpringLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TrayIcon.MessageType;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTree;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

import java.awt.Panel;

import javax.swing.JEditorPane;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Converter extends JFrame {
	
	final Integer calculateur= new Integer(0);
	
	protected JTextComponent resultLabel;
	private JTextField textField;
	
	private JPanel panel;

	private JComboBox comboBox;

	private JLabel lblNewLabel;

	private JLabel lblNewLabel_1;

	private JComboBox comboBox_1;

	private JButton btnConvert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Converter frame = new Converter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Converter() {
		setSize(new Dimension(640, 480));
		initGUI();
		initActionGUI();
	}

//	private void copierTFtoLBL() {
//		Integer i=null;
//		try {
//			i= Integer.parseInt(textField.getText());	
//		} catch (Exception e2) {
//		}
//		if(i==null){
//			JOptionPane.showMessageDialog(null, "pas de valeur numérique");
//		}
//		else{
//			lblNewLabel_1.setText(String.valueOf(i));	
//		}				
//	}
//	
	private void initActionGUI() {
		btnConvert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//copier la valeur du textfield dans le label
				//copierTFtoLBL();

				lblNewLabel_1.setText(textField.getText());
				
				String combo1 = (String) comboBox.getSelectedItem();
				switch (combo1) {
				case "km":
					scdSwitchKm();
					break;
				case "m":
					scdSwitchM();
					break;
				default:
					break;
				}
			}

			private void scdSwitchM() {
				String combo2 = (String) comboBox_1.getSelectedItem();
				String s;
				Double unitConvert;
				int i;
				double d = 0;
				switch (combo2) {
				case "km":
					d= Integer.parseInt(textField.getText());
					s = "0.001";
					unitConvert = Double.parseDouble(s);
					d = d * unitConvert;
					lblNewLabel_1.setText(String.valueOf(d));
					break;
				case "mm":
					i= Integer.parseInt(textField.getText());
					i = i * 1000;
					lblNewLabel_1.setText(String.valueOf(i));
					break;
				case "miles":
					i= Integer.parseInt(textField.getText());
					i = i * 620;
					lblNewLabel_1.setText(String.valueOf(i));
					break;
				case "yards":
					i= Integer.parseInt(textField.getText());
					i = i * 109360;
					lblNewLabel_1.setText(String.valueOf(i));
					break;
				case "feet":
					i= Integer.parseInt(textField.getText());
					i = i * 3280800;
					lblNewLabel_1.setText(String.valueOf(i));
					break;
				default:
					break;
				}
			}

			private void scdSwitchKm() {
				String combo2 = (String) comboBox_1.getSelectedItem();
				String s;
				Double unitConvert;
				int i;
				double d;
				switch (combo2) {
				case "m":
					i= Integer.parseInt(textField.getText());
					i = i * 1000;
					lblNewLabel_1.setText(String.valueOf(i));
					break;
				case "mm":
					i= Integer.parseInt(textField.getText());
					i = i * 100000;
					lblNewLabel_1.setText(String.valueOf(i));
					break;
				case "miles":
					d= Integer.parseInt(textField.getText());
					s = "0.62";
					unitConvert = Double.parseDouble(s);
					d = d * unitConvert;
					lblNewLabel_1.setText(String.valueOf(d));
					break;
				case "yards":
					d= Integer.parseInt(textField.getText());
					s = "1093.6";
					unitConvert = Double.parseDouble(s);
					d = d * unitConvert;
					break;
				case "feet":
					d= Integer.parseInt(textField.getText());
					s = "3280.8";
					unitConvert = Double.parseDouble(s);
					d = d * unitConvert;
					break;
				default:
					break;
				}
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"km", "m", "mm", "miles", "yards", "feet"}));
				comboBox_1.removeItem(comboBox.getSelectedItem());
			}
		});
		
	}

	private void initGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {200, 0};
		gridBagLayout.rowHeights = new int[]{170, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textField = new JTextField();
		textField.setSize(new Dimension(100, 0));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel.add(comboBox, gbc_comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"km", "m", "mm", "miles", "yards", "feet"}));
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\_DEV\\WPEclipse\\Converter\\src\\com\\converter\\arrow.png"));
		
		lblNewLabel_1 = new JLabel("Résultat");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 0;
		panel.add(comboBox_1, gbc_comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"km", "m", "mm", "miles", "yards", "feet"}));
		
		btnConvert = new JButton("Convert");
		GridBagConstraints gbc_btnConvert = new GridBagConstraints();
		gbc_btnConvert.insets = new Insets(0, 0, 0, 5);
		gbc_btnConvert.gridx = 4;
		gbc_btnConvert.gridy = 2;
		panel.add(btnConvert, gbc_btnConvert);
	}
}

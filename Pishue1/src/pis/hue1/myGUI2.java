package pis.hue1;
import javax.swing.*;

import javafx.scene.control.Alert;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myGUI2 extends JFrame implements ActionListener{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		myGUI2 a = new myGUI2();
		a.show();

	}
	 private Container c;
	    private JLabel label1, label2, label3;
	    private JButton button1, button2;
	    private JTextField textfield1, textfield2;
	    private JTextArea area1, area2;
	    private JRadioButton radio1, radio2;

	    private myGUI2() {
	        c = getContentPane();
	        c.setLayout(null);
	        this.setSize(500, 350);

	        label1 =  new JLabel("Klartext: ");
	        label2 = new JLabel("Geheimtext: ");
	        label3 = new JLabel("Lösungsworter: ");
	        button1 = new JButton("kodiere");
	        button2 = new JButton("dekodiere");
	        area1 = new JTextArea();
	        area2 = new JTextArea();
	        textfield1 = new JTextField();
	        textfield2 = new JTextField();
	        radio1 = new JRadioButton("Würfel");
	        radio2 = new JRadioButton("Caeser");

	        label1.setBounds(60, 30, 180, 30);
	        textfield1.setBounds(60, 60, 130, 30);
	        label2.setBounds(260, 30, 180, 30);
	        textfield2.setBounds(260, 60, 130, 30);
	        label3.setBounds(60, 100, 180, 30);
	        area1.setBounds(60, 140, 150, 15);
	        area2.setBounds(260, 140, 150, 15);
	        radio1.setBounds(60, 180, 100, 30);
	        radio2.setBounds(200, 180, 100, 30);
	        button1.setBounds(60, 210, 120, 30);
	        button2.setBounds(260, 210 , 120, 30);

	        radio1.setSelected(true);
	        ButtonGroup gruppe = new ButtonGroup();
	        gruppe.add(radio1);
	        gruppe.add(radio2);
	        
	        c.add(area1);
	        c.add(area2);
	        c.add(textfield1);
	        c.add(textfield2);
	        c.add(button1);
	        c.add(button2);
			button1.addActionListener(this);
	        button2.addActionListener(this);
	        c.add(label1);
	        c.add(label2);
	        c.add(label3);
	        c.add(radio1);
	        c.add(radio2);

	        this.setVisible(true);
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

}

		@Override
		public void actionPerformed(ActionEvent a) {
		try {
			 if(a.getSource() == this.button1){
				 if(radio1.isSelected() && textfield1.getText() != null) {
					 textfield2.setText(mynewCodecGui.buttonkodiere(textfield1.getText(), area1.getText(), area2.getText()));
				 }else {
					 textfield2.setText(mynewCodecGui.buttonkodiere(textfield1.getText(), area1.getText())); 
				 }
		        }
		        else if(a.getSource() == this.button2){
		        	if(radio1.isSelected() && textfield2.getText() != null) {
		        		textfield1.setText(mynewCodecGui.buttondekodiere(textfield2.getText(), area1.getText(), area2.getText())); 
		        	}else {
		        		textfield1.setText(mynewCodecGui.buttondekodiere(textfield2.getText(), area1.getText())); 
		        	}
		        }else {
		        	throw new IllegalArgumentException("Da ist eine leere Eingabe");
		        }
		} catch (IllegalArgumentException e) {
//			error(e.getMessage());
		}
		
	}
		private void error(String message) {
			Alert alerterror = new Alert(Alert.AlertType.INFORMATION);
	        alerterror.setTitle("Ein Fehler ist aufgetreten");
	        alerterror.setHeaderText(message);
	        alerterror.showAndWait();
		}
		
}
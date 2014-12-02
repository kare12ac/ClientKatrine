package GUI;

import GUI.Calendar;

import java.util.ArrayList;

import com.google.gson.*;

import javax.swing.*;

import Logic.ServerConnection;
import JsonClasses.CreateCalender;
import JsonClasses.AuthUser;

import java.awt.Color;
import java.awt.Font;
import java.awt.color.*;
import java.awt.font.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddCalendar extends JFrame {

	String msg = "";
	JPanel panel = new JPanel();
	JButton btnCreate = new JButton("Create Calendar");
	JButton btnCancel = new JButton("Cancel");
	JTextField txtUser = new JTextField(30);
	JTextField txtAuthor = new JTextField(30);
	JTextField txtCalName = new JTextField(30);
	JTextField txtpubPriv= new JTextField(30);
	JButton addU = new JButton("Add User");
	JButton addA = new JButton ("Add Author(s)");
	JTextArea TextAreaUsers = new JTextArea();
	JTextArea TextAreaAuthors = new JTextArea();
	JLabel PP = new JLabel("Press 1 for private, and 0 for public ");
	JLabel AC = new JLabel("Add Calendar");
	JLabel N = new JLabel ("Calendar Name:");
	JLabel prpu= new JLabel("Is it Private or public");
	JLabel UC = new JLabel ("Add username for users connected to this calendar");
	JLabel UE = new JLabel(" Add username for users allowed to edit");
	
	public AddCalendar(){
	super("Create Calendar");
	setSize(550,550);
	setLocation(500,280);
	panel.setLayout(null);
	
	txtUser.setBounds(35,346,150,20);
	txtAuthor.setBounds(35,183,150,20);
	txtCalName.setBounds(187,80,150,20);
	txtpubPriv.setBounds(187,112,150,20);
	btnCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	btnCreate.setBounds(286,488,140,29);
	btnCancel.setBounds(219, 488, 67, 29);
	addU.setBounds(66, 398, 106, 29);
	addA.setBounds(47, 229, 125, 29);
	TextAreaUsers.setBounds(308, 348, 150, 117);
	TextAreaAuthors.setBounds(308, 185, 150, 117);
	PP.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
	PP.setBounds(342, 115, 198, 16);
	AC.setFont(new Font("Arial", Font.BOLD, 30));
	AC.setForeground(new Color(0, 0, 128));
	AC.setBounds(187, 6, 198, 74);
	N.setBounds(35, 75, 115, 30);
	prpu.setBounds(35, 117, 150, 15);
	UC.setBounds(35, 311, 423, 30);
	UE.setBounds(35, 156, 412, 15);
	
	panel.add(txtUser);
	panel.add(txtAuthor);
	panel.add(txtCalName);
	panel.add(txtpubPriv);
	panel.add(btnCreate);
	panel.add(btnCancel);
	panel.add(addU);
	panel.add(addA);
	panel.add(TextAreaUsers);
	panel.add(TextAreaAuthors);
	panel.add(PP);
	panel.add(AC);
	panel.add(N);
	panel.add(prpu);
	panel.add(UC);
	panel.add(UE);
	
	
	
	}	
}


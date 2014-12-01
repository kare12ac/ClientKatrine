package GUI;

import GUI.Calendar;
import java.util.ArrayList;

import com.google.gson.*;
import com.google.gson.JsonSyntaxException;

import javax.swing.*;

import Logic.ServerConnection;
import JsonClasses.CreateCalender;
import JsonClasses.AuthUser;

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
	setSize(500,500);
	setLocation(500,280);
	panel.setLayout(null);
	
	txtUser.setBounds(120,60,70,150);
	txtCalName.setBounds(130,70,80,160);
	txtpubPriv.setBounds(140, 80, 90, 170);
	btnCreate.setBounds(180, 50, 30, 190);
	btnCancel.setBounds(10, 30, 70, 10);
	addU.setBounds(30, 90, 80, 40);
	addA.setBounds(40,100,90,30);
	TextAreaUsers.setBounds(100, 50, 60, 110);
	TextAreaAuthors.setBounds(130, 60, 70, 120);
	PP.setBounds(63, 10, 83, 15);
	AC.setBounds(100, 60, 70, 110);
	N.setBounds(90, 40, 30, 100);
	prpu.setBounds(160, 50, 150, 70);
	UC.setBounds(170,40,30,160);
	UE.setBounds(130,90,70,120);
	
	panel.add(txtUser);
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


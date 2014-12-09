package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;


	public class Calendar extends JFrame {
	    
	    public Calendar() {
	        
	        setTitle("Calendar");
	        setSize(500, 500);
	        
	        // Creates a menubar for a JFrame
	        JMenuBar menuBar = new JMenuBar();
	        
	        // Add the menubar to the frame
	        setJMenuBar(menuBar);
	        
	        // Define and add two drop down menu to the menubar
	        JMenu addMenu = new JMenu("Add");
	        JMenu deleteMenu = new JMenu("Delete");
	        JMenu othersMenu = new JMenu("Others");
	        menuBar.add(addMenu);
	        menuBar.add(deleteMenu);
	        menuBar.add(othersMenu);
	        
	        
	        // Create and add simple menu item to one of the drop down menu
	        JMenuItem newcalAction = new JMenuItem("New Calendar");
	        JMenuItem newevAction = new JMenuItem("New Event");
	        JMenuItem newnoteAction = new JMenuItem("New Note");
	        JMenuItem delcalAction = new JMenuItem("Delete Calendar");
	        JMenuItem delevAction = new JMenuItem("Delete Event");
	        JMenuItem delnAction = new JMenuItem("Delete Note");
	        JMenuItem weatherAction = new JMenuItem("Weather Forecast");
	        JMenuItem quoteAction = new JMenuItem("Random quote");
	        JMenuItem importcalAction = new JMenuItem("Import Calendar");
	        JMenuItem importevAction = new JMenuItem("Import Event");
	        
	     
	        // Create a ButtonGroup and add both radio Button to it. Only one radio
	        // button in a ButtonGroup can be selected at a time.
	       
	        addMenu.add(newcalAction);
	        addMenu.add(newevAction);
	        addMenu.add(newnoteAction);
	        addMenu.addSeparator();
	        deleteMenu.add(delcalAction);
	        deleteMenu.add(delevAction);
	        deleteMenu.add(delnAction);
	        deleteMenu.addSeparator();
	        othersMenu.add(quoteAction);
	        othersMenu.add(weatherAction);
	        othersMenu.add(importcalAction);
	        othersMenu.add(importevAction);
	        othersMenu.addSeparator();	
	    
	   
	      
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	 
	//btnPreview.addActionListener(new btnPreview_Action());
	//btnNext.addActionListener(new btnNext_Action());
	newcalAction.addActionListener(new Cal_Action());
	newevAction.addActionListener(new event_Action());
	newnoteAction.addActionListener(new note_Action());
	delcalAction.addActionListener(new delCal_Action());
	delevAction.addActionListener(new delEvent_Action());
	delnAction.addActionListener(new delNote_Action());
	quoteAction.addActionListener(new quote_Action());
	}
	
	public class Cal_Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
				AddCalendar addCalendar = new AddCalendar();
				addCalendar.setVisible(true);
		}}
	 public class event_Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
				AddEvent addEvent = new AddEvent();
				addEvent.setVisible(true);
		}}
	 public class note_Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
				AddNote addNote = new AddNote();
				addNote.setVisible(true);
		}}
	
	 public class delCal_Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
				RemoveCalendar removeCalendar = new RemoveCalendar();
				removeCalendar.setVisible(true);
		}
	}
				
	 public class delEvent_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
				RemoveEvents removeEvent = new RemoveEvents();
				removeEvent.setVisible(true);
			}
		}
				
		 public class delNote_Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			RemoveNote removeNote = new RemoveNote();
			removeNote.setVisible(true);
		
			
			}
		}
		
		 public class	 quote_Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Quote quote = new Quote();
			quote.setVisible(true);
		}
			}
			
		public class imp_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){				
			ImportEvents impevev = new ImportEvents();
			impevev.setVisible(true);
			}
		}
						
		public class impCal_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
				ImportCalendar impcalcal = new ImportCalendar();
				impcalcal.setVisible(true);
				
	
			}
		}
	}


//
//package GUI;
//import javax.swing.*;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//
//import java.util.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.GregorianCalendar;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JCheckBoxMenuItem;
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JRadioButtonMenuItem;
//
//import JsonClasses.CreateCalender;
//import JsonClasses.getCalendar;
//
////import JsonClasses.testing;
//
//	
//		 public class Calendar extends JFrame{
//		 	public Calendar() {
//		 	}
//								
//		/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
////		static JLabel lblDay,lblWeek; 
////		static JButton btnPreview, btnNext;
////		static JTable tblCalendar;
//		static JFrame frmMain;
//		//static Container pane;
////		static DefaultTableModel mtblCalendar; //table model
////		static JScrollPane stblCalendar; // the scrollpane
//		static JPanel pnlCalendar; // the panel 
////		static int realDay, realWeek, currentDay,currentWeek;
//		static JMenuBar menuBar;
//		static JMenu addMenu,deleteMenu,othersMenu;
//		static JMenuItem newCalendar, newEvent, newNote, deleteCalendar,deleteEvent,deleteNote,weather,quote,impCalendar,impEvent;
//		
//		
//				
//		public static void main(String args[] ){
//		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
//		catch(ClassNotFoundException e){}
//		catch(InstantiationException e){}	
//		catch(IllegalAccessException e ){}
//		catch (UnsupportedLookAndFeelException e){}
//		
//		
//		//Create controls 
//		frmMain = new JFrame("Calendar application");
//
//		JMenuBar menuBar = new JMenuBar();
//		JMenu addMenu = new JMenu("Add");
//		JMenu deleteMenu = new JMenu("Delete");
//		JMenu othersMenu = new JMenu ("Others");
//		JMenuItem newCalendar = new JMenuItem("Add Calendar");
//		JMenuItem newEvent = new JMenuItem ("Add Event");
//		JMenuItem newNote = new JMenuItem("New Note");
//		JMenuItem delCalendar = new JMenuItem("Delete Calendar");
//		JMenuItem delEvent = new JMenuItem("Delete Event");
//		JMenuItem delNote = new JMenuItem("Delete Note");
//		JMenuItem weather = new JMenuItem("Weather Forecast");
//		JMenuItem quote = new JMenuItem("Random Quote");
//		JMenuItem impEvents = new JMenuItem("Import Events");
//		JMenuItem impCalendar = new JMenuItem("Import Calender");
//		
//		
//		//prepare frame
//				frmMain = new JFrame ("CBS Calendar"); // create frame
//				frmMain.setSize(800,500);
//				//pane = frmMain.getContentPane();//get contentpane
//				//pane.setLayout(null);//apply null layout 
//				frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frmMain.setJMenuBar(menuBar);
//				
//		//set border
//		//pnlCalendar.setBorder(BorderFactory.createTitledBorder("calendar"));
//		
//		
//		//register action listeners 
//		
//		//btnPreview.addActionListener(new btnPreview_Action());
//		//btnNext.addActionListener(new btnNext_Action());
//		newCalendar.addActionListener(new Cal_Action());
//		newEvent.addActionListener(new event_Action());
//		newNote.addActionListener(new note_Action());
//		delCalendar.addActionListener(new delCal_Action());
//		//delEvent.addActionListener(new delEvent_Action());
//		delNote.addActionListener(new delNote_Action());
//		weather.addActionListener(new weather_Action());
//		quote.addActionListener(new quote_Action());
//
//		//pane.add(pnlCalendar);
//		menuBar.add(addMenu);
//		menuBar.add(deleteMenu);
//		menuBar.add(othersMenu);
//		
//		addMenu.add(newCalendar);
//		addMenu.add(newEvent);
//		addMenu.add(newNote);
//		addMenu.addSeparator();
//		deleteMenu.add(delCalendar);
//		deleteMenu.add(delEvent);
//		deleteMenu.add(delNote);
//		deleteMenu.addSeparator();
//		othersMenu.add(weather);
//		othersMenu.add(quote);
//		othersMenu.add(impEvents);
//		othersMenu.add(impCalendar);
//		othersMenu.addSeparator();
//		
//
//		
//		//make frame visible 
//		frmMain.setResizable(false);
//		frmMain.setVisible(true);
//		
//		}
//
//		static class Cal_Action implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//					AddCalendar addCalendar = new AddCalendar();
//					addCalendar.setVisible(true);
//			}}
//		static class event_Action implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//					AddEvent addEvent = new AddEvent();
//					addEvent.setVisible(true);
//			}}
//		static class note_Action implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//					AddNote addNote = new AddNote();
//					addNote.setVisible(true);
//			}}
//		
//		static class delCal_Action implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//					RemoveCalendar removeCalendar = new RemoveCalendar();
//					removeCalendar.setVisible(true);
//			}
//		}
//					
//			static class delEvent_Action implements ActionListener{
//				public void actionPerformed(ActionEvent e){
//					RemoveEvents removeEvent = new RemoveEvents();
//					removeEvent.setVisible(true);
//				}
//			}
//					
//			static class delNote_Action implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//				RemoveNote removeNote = new RemoveNote();
//				removeNote.setVisible(true);
//				
//			}
//		}
//			
//			static class weather_Action implements ActionListener{
//				public void actionPerformed(ActionEvent e){
//				WeatherForcast weatherForcast = new WeatherForcast();
//				weatherForcast.setVisible(true);
//				}
//			}
//			
//				static class quote_Action implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//				Quote quote = new Quote();
//				quote.setVisible(true);
//			}
//				}
//				
//			static class imp_Action implements ActionListener{
//				public void actionPerformed(ActionEvent e){				
//				ImportEvents impevev = new ImportEvents();
//				impevev.setVisible(true);
//				}
//			}
//							
//			static class impCal_Action implements ActionListener{
//				public void actionPerformed(ActionEvent e){
//					ImportCalendar impcalcal = new ImportCalendar();
//					impcalcal.setVisible(true);
//					
//				}				
//				
//			}
//
//		 } 
//		 
//		 
//		 
//		 
//	
//


package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import JsonClasses.CreateCalender;

//import JsonClasses.testing;

	
		 public class Calendartest extends JFrame{
		 	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;


			public Calendartest() {
		 	}
								
		static JLabel lblDay,lblWeek; 
		static JButton btnPreview, btnNext;
		static JTable tblCalendar;
		static JFrame frmMain;
		static Container pane;
		static DefaultTableModel mtblCalendar; //table model
		static JScrollPane stblCalendar; // the scrollpane
		static JPanel pnlCalendar; // the panel 
		static int realDay, realWeek, currentDay,currentWeek;
		static JMenuBar menuBar;
		static JMenu addMenu,deleteMenu,othersMenu;
		static JMenuItem newCalendar, newEvent, newNote, deleteCalendar,deleteEvent,deleteNote,weather,quote,impCalendar,impEvent;
		
				
		public static void main(String args[] ){
		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(ClassNotFoundException e){}
		catch(InstantiationException e){}
		catch(IllegalAccessException e ){}
		catch (UnsupportedLookAndFeelException e){}
		
		
		//Create controls 
		frmMain = new JFrame("Calendar application");
		lblDay = new JLabel("Monday");
		lblWeek = new JLabel("1");
		btnPreview = new JButton("<<");
		btnNext = new JButton(">>");
		mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar); // the scrollpane of the above table
		pnlCalendar = new JPanel(null);//Create the "panel" to place components
		JMenuBar menuBar = new JMenuBar();
		JMenu addMenu = new JMenu("Add");
		JMenu deleteMenu = new JMenu("Delete");
		JMenu othersMenu = new JMenu ("Others");
		JMenuItem newCalendar = new JMenuItem("Add Calendar");
		JMenuItem newEvent = new JMenuItem ("Add Event");
		JMenuItem newNote = new JMenuItem("New Note");
		JMenuItem delCalendar = new JMenuItem("Delete Calendar");
		JMenuItem delEvent = new JMenuItem("Delete Event");
		JMenuItem delNote = new JMenuItem("Delete Note");
		JMenuItem weather = new JMenuItem("Weather Forecast");
		JMenuItem quote = new JMenuItem("Random Quote");
		JMenuItem impEvents = new JMenuItem("Import Events");
		JMenuItem impCalendar = new JMenuItem("Import Calender");
		
		
		//prepare frame
				frmMain = new JFrame ("CBS Calendar"); // create frame
				frmMain.setSize(800,500);
				pane = frmMain.getContentPane();//get contentpane
				pane.setLayout(null);//apply null layout 
				frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmMain.setJMenuBar(menuBar);
				
		//set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("calendar"));
		
		
		//register action listeners 
		
		btnPreview.addActionListener(new btnPreview_Action());
		btnNext.addActionListener(new btnNext_Action());
		newCalendar.addActionListener(new Cal_Action());
		newEvent.addActionListener(new event_Action());
		newNote.addActionListener(new note_Action());
		delCalendar.addActionListener(new delCal_Action());
		//delEvent.addActionListener(new delEvent_Action());
		delNote.addActionListener(new delNote_Action());
		weather.addActionListener(new weather_Action());
		quote.addActionListener(new quote_Action());
//		impEvent.addActionListener(new impEvent_Action());
//		impCalendar.addActionListner(new impCalendar_Action());
		
		
		
		
		
		
		
		
		//add controls to pane
		pane.add(pnlCalendar);
	//	pnlCalendar.add(lblDay);
		pnlCalendar.add(lblWeek);
		pnlCalendar.add(btnPreview);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);
		menuBar.add(addMenu);
		menuBar.add(deleteMenu);
		menuBar.add(othersMenu);
		
		addMenu.add(newCalendar);
		addMenu.add(newEvent);
		addMenu.add(newNote);
		addMenu.addSeparator();
		deleteMenu.add(delCalendar);
		deleteMenu.add(delEvent);
		deleteMenu.add(delNote);
		deleteMenu.addSeparator();
		othersMenu.add(weather);
		othersMenu.add(quote);
		othersMenu.add(impEvents);
		othersMenu.add(impCalendar);
		othersMenu.addSeparator();
		
		// set bounds 
		pnlCalendar.setBounds(151, 93, 480, 379);
		lblWeek.setBounds(382,24,100,25);
		lblDay.setBounds(6, 330, 80, 20);
		btnPreview.setBounds(10,25,50,25);
		btnNext.setBounds(260, 25, 50, 25);
		stblCalendar.setBounds(6, 68, 468, 250);

		
		//make frame visible 
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		//get real month/year
		
		GregorianCalendar cal = new GregorianCalendar();// Create calendar 
		realDay = cal.get(GregorianCalendar.DAY_OF_WEEK);//get day
		realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		currentDay = realDay;
		currentWeek = realWeek;
		
		
		// add headers 
		String[] headersM = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};// all headers 
		for(int i = 0; i<7; i++){
			mtblCalendar.addColumn(headersM[i]);
		}

		
			//set background
		
		tblCalendar.getParent().setBackground(tblCalendar.getBackground());
		
		
		
		
		// no resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);
		
		
		
		//single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		// set row/column count 
		tblCalendar.setRowHeight(38);
		mtblCalendar.setColumnCount(7);
		//mtblCalendar.setRowCount(6);
		
		
			//refresh calendar 
		refreshCalendar( realDay, realWeek);
		}
		public static void refreshCalendar(int day, int week){
			//variables
			//String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			//String[] days = {"Monday","Tuesday","Wednesday","Thursday", "Friday","Saturday","Sunday"};
			//String[] weeks = {"1","2","3","4","5"};
			int nod,som;//number of days, start of month
		
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
		
		// prepare buttons
		btnPreview.setEnabled(true); //enable buttons at first
		btnNext.setEnabled(true);
//		if(week ==0&& day <= realDay-10){btnPreview.setEnabled(false);}//too early
//		if(week ==11&& day>= realDay+100){btnNext.setEnabled(false);}//too late 
//		lblWeek.setText(weeks[week]);//refresh the month label(at the top)
//		lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2,25,180,25);// re-allign label with calendar)
//		
		//clear table
		for(int i=0; i<6; i++){
			for(int j = 0; j<7; j++){
				mtblCalendar.setValueAt(null,i,j);
			}
		}
			

		GregorianCalendar cal = new GregorianCalendar(day,week,1);
		nod = cal.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		// draw calendar 
				for(int i =1; i<=nod; i++){
					int row = new Integer((i+som-2)/7);
					int column = (i+som-2)%7;
					mtblCalendar.setValueAt(i,row,column);
				}		
			
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
		}
		static class tblCalendarRenderer extends DefaultTableCellRenderer{
			public Component getTableCellRendererComponent(JTable table, Object value, boolean selected,
				boolean focused, int row,int column	
					){
				super.getTableCellRendererComponent(table,value,selected,focused,row,column);
				if(column ==0|| column == 6){//week-end
					setBackground(new Color(225,255,255));
				}
				else{//week
					setBackground(new Color(225,255,255));
				}
				if(value != null){
					if(Integer.parseInt(value.toString()) == realDay &&currentWeek == realWeek &&currentDay ==realDay ){//today
						setBackground(new Color(220,220,255));
					}
					
				}	
				setBorder(null);
				setForeground(Color.black);
				return this;
		
			
			}
		}
		
		static class btnPreview_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(currentWeek == 0){//back one year
					currentWeek = 11;
					currentWeek -= 1; 
				}
				else{//back one month 
					currentWeek -=1;
				}
				refreshCalendar(currentWeek,currentDay);
				
				}
			}
		
		

		static class btnNext_Action implements ActionListener{
			public void actionPerformed (ActionEvent e){
				if(currentWeek ==11){//forward one week
					currentWeek = 0; 
					currentDay +=1;
				}
				else{//forward one week
					currentWeek +=1;
				}
				refreshCalendar(currentWeek,currentDay);
			
			}
			}
		
		static class Cal_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
					AddCalendar addCalendar = new AddCalendar();
					addCalendar.setVisible(true);
			}}
		static class event_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
					AddEvent addEvent = new AddEvent();
					addEvent.setVisible(true);
			}}
		static class note_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
					AddNote addNote = new AddNote();
					addNote.setVisible(true);
			}}
		
		static class delCal_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
					RemoveCalendar removeCalendar = new RemoveCalendar();
					removeCalendar.setVisible(true);
			}
		}
					
//			static class delEvent_Action implements ActionListener{
//				public void actionPerformed(ActionEvent e){
//					RemoveEvents removeEvent = new RemoveEvents();
//					removeEvent.setVisible(true);
//				}
//			}
					
			static class delNote_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
				RemoveNote removeNote = new RemoveNote();
				removeNote.setVisible(true);
				
			}
		}
			
			static class weather_Action implements ActionListener{
				public void actionPerformed(ActionEvent e){
				WeatherForcast weatherForcast = new WeatherForcast();
				weatherForcast.setVisible(true);
				}
			}
			
				static class quote_Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
				Quote quote = new Quote();
				quote.setVisible(true);
			}
				}
//				
//			static class imp_Action implements ActionListener{
//				public void actionPerformed(ActionEvent e){
//				getEvents getevents = new getEvents();
//				getevents.setVisible(true);
//				}
//			}
//							
//			static class impCal_Action implements ActionListener{
//				public void actionPerformed(ActionEvent e){
//					getCalendar getcalendar = new getCalendar();
//					getcalendar.setVisible(true);
//					
//				
				}
			

		 
		 
		 

	


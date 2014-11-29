package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;


public class Calendar {
	//public Calendar() {
//	}
		//Calendar frameTabel = new Calendar();
	
		
		
		static JLabel lblDay,lblWeek, lblMonth, lblYear;
		static JButton btnPreview, btnNext;
		static JTable tblCalendar;
		static JComboBox cmbYear;
		static JFrame frmMain;
		static Container pane;
		static DefaultTableModel mtblCalendar; //table model
		static JScrollPane stblCalendar; // the scrollpane
		static JPanel pnlCalendar; // the panel 
		static int realDay, realWeek,realMonth, realYear, currentDay,currentWeek,currentMonth,currentYear;
		JLabel welcome = new JLabel("Welcome to CBS Calendar");
		JPanel panel = new JPanel();
		JButton addCalendar = new JButton("Add Calendar");
		JButton addEvent = new JButton("Add Event");
		JButton addNote = new JButton("Add Note");
		JButton share = new JButton("Share...");
		
		
		
		
		public static void main(String args[] ){
		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(ClassNotFoundException e){}
		catch(InstantiationException e){}
		catch(IllegalAccessException e ){}
		catch (UnsupportedLookAndFeelException e){}
		
		//prepare frame
		frmMain = new JFrame ("CBS Calendar"); // create frame
		frmMain.setSize(800,500);
		pane = frmMain.getContentPane();//get contentpane
		pane.setLayout(null);//apply null layout 
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Create controls 
		//frmMain = new JFrame("Calendar application");
		lblDay = new JLabel("Monday");
		lblWeek = new JLabel("1");
		lblMonth = new JLabel ("January");
		lblYear = new JLabel ("change year");
		cmbYear = new JComboBox();
		btnPreview = new JButton("<<");
		btnNext = new JButton(">>");
		mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar); // the scrollpane of the above table
		pnlCalendar = new JPanel(null);//Create the "panel" to place components
		
		//set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("calendar"));
		
		//register action listeners 
		
		btnPreview.addActionListener(new btnPreview_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
		
		
		//add controls to pane
		pane.add(pnlCalendar);
		pnlCalendar.add(lblDay);
		pnlCalendar.add(lblWeek);
		pnlCalendar.add(lblMonth);
		pnlCalendar.add(lblYear);
		pnlCalendar.add(cmbYear);
		pnlCalendar.add(btnPreview);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);
		
		// set bounds 
		pnlCalendar.setBounds(151, 93, 480, 379);
		lblMonth.setBounds(382,24,100,25);
		lblYear.setBounds(6, 330, 80, 20);
		cmbYear.setBounds(233,331,106,20);
		btnPreview.setBounds(10,25,50,25);
		btnNext.setBounds(260, 25, 50, 25);
		stblCalendar.setBounds(6, 68, 468, 250);

		//make frame visible 
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		//get real month/year
		
		GregorianCalendar cal = new GregorianCalendar();// Create calendar 
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);//get day
		realMonth = cal.get(GregorianCalendar.MONTH);//get month
		realYear = cal.get(GregorianCalendar.YEAR);//get year
		currentMonth = realMonth; //Match month and year 
		currentYear = realYear;
		
		
		// add headers 
		String[] headers = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};// all headers 
		for(int i = 0; i<7; i++){
			mtblCalendar.addColumn(headers[i]);
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
		mtblCalendar.setRowCount(6);
		
		
		
		//populate table
		for(int i = realYear-100; i<=realYear+100;i++){
			cmbYear.addItem(String.valueOf(i));
		}
		
			//refresh calendar 
		refreshCalendar(realMonth,realYear);
		}
		public static void refreshCalendar(int month,int year){
			//variables
			String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		int nod,som;//number of days, start of month
		
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
		
		// prepare buttons
		btnPreview.setEnabled(true); //emble buttons at first
		btnNext.setEnabled(true);
		if(month ==0&& year <= realYear-10){btnPreview.setEnabled(false);}//too early
		if(month ==11&& year>= realYear+100){btnNext.setEnabled(false);}//too late 
		lblMonth.setText(months[month]);//refresh the month label(at the top)
		lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2,25,180,25);// re-allign label with calendar)
		cmbYear.setSelectedItem(String.valueOf(year));// select the correct year in the combo box
		//get number of days and star of month
		
		
		
		
		//clear table
		for(int i=0; i<6; i++){
			for(int j = 0; j<7; j++){
				mtblCalendar.setValueAt(null,i,j);
			}
		}
			
//<<<<<<< Updated upstream
//			addCalendar.setBounds(25, 140, 105, 39);
//			panel.add(addCalendar);
//			
//			addEvent.setBounds(25, 200, 105, 39);
//			panel.add(addEvent);
//			
//			
//			addNote.setBounds(25, 260, 105, 39);
//			panel.add(addNote);
//			
//			share.setBounds(25, 320, 105, 39);
//			panel.add(share);

		
		GregorianCalendar cal = new GregorianCalendar(year,month,1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
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
					setBackground(new Color(225,220,220));
				}
				else{//week
					setBackground(new Color(225,255,255));
				}
				if(value != null){
					if(Integer.parseInt(value.toString()) == realDay &&currentMonth == realMonth &&currentYear ==realYear ){//today
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
				if(currentMonth == 0){//back one year
					currentMonth = 11;
					currentYear -= 1; 
				}
				else{//back one month 
					currentMonth -=1;
				}
				refreshCalendar(currentMonth,currentYear);
				
				}
			}
		
		
	



		static class btnNext_Action implements ActionListener{
			public void actionPerformed (ActionEvent e){
				if(currentMonth ==11){//forward one year
					currentMonth = 0; 
					currentYear +=1;
				}
				else{//forward one month
					currentMonth +=1;
				}
				refreshCalendar(currentMonth,currentYear);
			
			}
			}
		static class cmbYear_Action implements ActionListener{
			public void actionPerformed (ActionEvent e){
				if(cmbYear.getSelectedItem() != null){
					String b = cmbYear.getSelectedItem().toString();
					currentYear = Integer.parseInt(b);//Get the numeric value
					refreshCalendar(currentMonth,currentYear);//Refresh
				}
			}
		}
}

//>>>>>>> Stashed changes
//			
//			
//<<<<<<< Updated upstream
//			actionCalendar action = new actionCalendar();
//			addCalendar.addActionListener(action);
//			addEvent.addActionListener(action);
//			addNote.addActionListener(action);
//			share.addActionListener(action);
			
//		}
//	
//		public void actionPerformed(ActionEvent event){
//			addCalendar.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent event){
//			JOptionPane.showMessageDialog(null, "Wrong Password or Username");
//					}
//			});
//		}
//		public void setVisible(boolean b) {
			// TODO Auto-generated method stub





			
		
		
		
		
		
		
		
		
		
//		
//		Calendar(){
//			super("CBS Calendar");
//			setSize(1000,1000);
//			setLocation(500,280);
//			getContentPane().setLayout(null);
//			panel.setBounds(0, 0, 1000, 978);
//			panel.setLayout(null);
//			welcome.setForeground(SystemColor.textHighlight);
//			welcome.setFont(new Font("Apple Braille", Font.PLAIN, 28));
//			
//			welcome.setBounds(310,-3,392,160);
//			panel.add(welcome);
//			
//			addCalendar.setBounds(25, 142, 105, 47);
//			panel.add(addCalendar);
//			
//			addEvent.setBounds(25, 201, 105, 39);
//			panel.add(addEvent);
//			addNote.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//				}
//			});
//			
//			addNote.setBounds(25, 252, 105, 39);
//			panel.add(addNote);
//			
//			share.setBounds(25, 303, 105, 39);
//			panel.add(share);
//			
//			getContentPane().add(panel);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			setVisible(true);
//			
//
//			
//		}
//	
//	
//}
//>>>>>>> Stashed changes

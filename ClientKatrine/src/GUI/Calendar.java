package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;


public class Calendar {
	//public Calendar() {
//	}
		//Calendar frameTabel = new Calendar();
	
		
		
		static JLabel lblDay,lblWeek ;
		static JButton btnPreview, btnNext;
		static JTable tblCalendar;
		static JFrame frmMain;
		static Container pane;
		static DefaultTableModel mtblCalendar; //table model
		//static DefaultTableModel wtblCalendar;
		//static DefaultTableModel dtblCalendar;
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
		btnPreview = new JButton("<<");
		btnNext = new JButton(">>");
		mtblCalendar = new DefaultTableModel(){/**
			 * 
			 */
		private static final long serialVersionUID = 8128849326616629044L;

		public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		//tblWeek = new JTable(wtblCalendar);
		//tblDay = new JTable(dtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar); // the scrollpane of the above table
		pnlCalendar = new JPanel(null);//Create the "panel" to place components
		
		//set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("calendar"));
		
		//register action listeners 
		
		btnPreview.addActionListener(new btnPreview_Action());
		btnNext.addActionListener(new btnNext_Action());
		
		
		//add controls to pane
		pane.add(pnlCalendar);
		pnlCalendar.add(lblDay);
		pnlCalendar.add(lblWeek);
		pnlCalendar.add(btnPreview);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);
		
		// set bounds 
		pnlCalendar.setBounds(151, 93, 480, 379);
		btnPreview.setBounds(10,25,50,25);
		btnNext.setBounds(260, 25, 50, 25);
		stblCalendar.setBounds(6, 68, 468, 250);

		//make frame visible 
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		//get real month/year
		
		GregorianCalendar cal = new GregorianCalendar();// Create calendar 
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);//get day
		realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		currentDay = realDay;
		currentWeek = realWeek;
		//currentMonth = realMonth; //Match month and year 
		//currentYear = realYear;
		
		
		// add headers 
		String[] headersM = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};// all headers 
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
		mtblCalendar.setRowCount(6);
		
		
		
		//populate table
		
			
	//	for (int y = realWeek-52; y<=realWeek+52;y++){
		//	cmbWeek.addItem(String.valueOf(y));
	//	}

		
			//refresh calendar 
		refreshCalendar(realDay, realWeek);
		}
		public static void refreshCalendar(int day, int week){
			//variables
			
			String[] days = {"Week 1","Week 2","week 3","week 4", "week 5","week 6","week 7"};
		
			int nod,som;//number of days, start of month
		
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
		
		
		// prepare buttons
		btnPreview.setEnabled(true); //enable buttons at first
		btnNext.setEnabled(true);
		if(day ==0&& week <= realWeek-10){btnPreview.setEnabled(false);}//too early
		if(day==11&& week>= realWeek+52){btnNext.setEnabled(false);}//too late 
		lblDay.setText(days[day]);//refresh the month label(at the top)
		lblDay.setBounds(160-lblDay.getPreferredSize().width/2,25,180,25);// re-allign label with calendar)
		//cmbWeek.setSelectedItem(String.valueOf(week));// select the correct year in the combo box
		//get number of days and star of month
		
		
		
		
		//clear table
		for(int i=0; i<6; i++){
			for(int j = 0; j<7; j++){
				mtblCalendar.setValueAt(null,i,j);
			}
		}
			


		
		GregorianCalendar cal = new GregorianCalendar(week,day,1);
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
			/**
			 * 
			 */
			private static final long serialVersionUID = 8701195806506032914L;

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
					if(Integer.parseInt(value.toString()) == realDay &&currentDay == realDay &&currentWeek ==realWeek ){//today
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
				if(currentDay == 0){//back one year
					currentDay = 6;
					currentWeek -= 1; 
				}
				else{//back one month 
					currentMonth -=1;
				}
				refreshCalendar(currentDay,currentWeek);
				
				}
			}
		
		
	



		static class btnNext_Action implements ActionListener{
			public void actionPerformed (ActionEvent e){
				if(currentDay ==6){//forward one year
					currentDay = 0; 
					currentWeek +=1;
				}
				else{//forward one month
					currentDay+=1;
				}
				refreshCalendar(currentDay,currentMonth);
			
			}
			}
		//static class cmbWeek_Action implements ActionListener{
			//public void actionPerformed (ActionEvent e){
				//if(cmbWeek.getSelectedItem() != null){
			//		String b = cmbWeek.getSelectedItem().toString();
			//		currentWeek = Integer.parseInt(b);//Get the numeric value
				//	refreshCalendar(currentDay,currentWeek);//Refresh
			//	}
			//}
		//}
}




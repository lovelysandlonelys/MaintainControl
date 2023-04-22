////////////////////////////////////////
//Program Name: monthlyScreen.java
//Program Purpose: create a jFrame for the monthly screen of Maintain Control
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.*; 
import java.awt.event.*; 

//Start of monthlyScreen Class
public class monthlyScreen extends JFrame
{

    //Objects 
    private Calendar cal;
    private int dayOfWeek; 
    private YearMonth monthandyear;  
    private JLabel monthandyearTitle;
    private Color colorful; 
    private String num; 
    private JButton dayButton;
    private JPanel monthlyGrid; 
    private JButton addEvent;
    private JButton deleteEvent; 
    private JPanel eventGrid; 
    private JTextArea events;   

    //Constructor
    public monthlyScreen()
    {
        super("Maintain Control: Monthly View"); 
        setLayout(new FlowLayout());

        //Setting up Title Area
        monthandyear = YearMonth.now(); 
        //Setting Month and Year from system
        monthandyearTitle = new JLabel(monthandyear.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " " + monthandyear.getYear()); 
        //Setting Font
        monthandyearTitle.setFont(new Font("Serif", Font.BOLD, 70 ));
        //Setting color 
        colorful = new Color(255, 153, 255);
        monthandyearTitle.setForeground(colorful);
        //Adding to Frame
        add(monthandyearTitle); 

        //NOTE TO SAVANANH, WOULD LIKE TO MAKE THE DAYS OF THE WEEK BUTTONS INTO AN ARRAY SO 
        //THAT WE CAN CLICK ON EACH MONTHLY VIEW BUTTON

        //Setting up Monthly Grid
        colorful = new Color(255, 204, 255);
        monthlyGrid = new JPanel(); 
        //Getting the number of days to offset the calandar by
        cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        //Filling the grid with days of week 
        for (int i = 1; i <= monthandyear.lengthOfMonth(); i++)
        {
            int count = 0; 
            if (i%2 == 0)
            {
                colorful = new Color(229, 204, 255); 
            }
            else 
            {
                colorful = new Color(255, 204, 255);
            }

            if (i < dayOfWeek)
            { 
                num = "X"; 
                dayButton = new JButton(num);  
                dayButton.setBackground(colorful); 
                monthlyGrid.add(dayButton);
                count++; 

            }
            else
            {
                int day = i - count; 
                num = "" + day; 
                dayButton = new JButton(num); 
                dayButton.setBackground(colorful);
                monthlyGrid.add(dayButton); 
            }

        }//end of for loop
        monthlyGrid.setLayout(new GridLayout(0, 7));
        add(monthlyGrid); 

        //event grid set up
        eventGrid = new JPanel(); 
        eventGrid.setLayout(new GridLayout(0, 1));

        //adding remove event button
        deleteEvent = new JButton("Delete Events");  
        deleteEvent.setPreferredSize(new Dimension(200, 40));;
        colorful = new Color(255, 204, 255);
        deleteEvent.setBackground(colorful); 
        eventGrid.add(deleteEvent);

        //Adding add event button
        addEvent = new JButton("Add Events");  
        addEvent.setPreferredSize(new Dimension(200, 40));;
        colorful = new Color(255, 204, 255);
        addEvent.setBackground(colorful); 
        eventGrid.add(addEvent); 

        //adding event grid to layout
        add(eventGrid); 

        //add text area for events that month
        events = new JTextArea("", 600, 100 );  //use a function here to return a list of events for the text area 
        add(events);

        //setting up button handeler
        ButtonHandler click = new ButtonHandler(); 
        dayButton.addActionListener(click);
        addEvent.addActionListener(click);
        deleteEvent.addActionListener(click);

        

    }//End of monthlyScreen Constructor

    //Inner Class For Event Handeling
    private class ButtonHandler implements ActionListener
    {
        //Handle button event
		@Override
		public void actionPerformed(ActionEvent event)
		{
            if (event.getSource() == dayButton)
            {
                //Pop-Up Window For Daily View
                dailyScreen dailyPopUp = new dailyScreen(); 
                dailyPopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dailyPopUp.setSize(600, 300);
                dailyPopUp.setVisible(true);

            }
            else if (event.getSource() == addEvent)
            {
               //weeklyScreen weeklyPopUp = new weeklyScreen(); 
                //weeklyPopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //weeklyPopUp.setSize(600, 300);
                //weeklyPopUp.setVisible(true);

            }
            else if (event.getSource() == deleteEvent)
            {
                //
                
            }
            else if (event.getSource() == toDoListView)
            {
                toDoListScreen toDoListPopUp = new toDoListScreen(); 
                toDoListPopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                toDoListPopUp.setSize(600, 300);
                toDoListPopUp.setVisible(true);
                
            }//end of else if statements   

        }//end of override of function

    }//End of ButtonHandler Class
    
}//End of monthlyScreen Class
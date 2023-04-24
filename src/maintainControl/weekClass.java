////////////////////////////////////////
//Program Name: weekClass.java
//Program Purpose: class to make using week as a timeframe easier
//Last Updated: 04/23/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports
import java.util.*;
import java.text.*; 

//Start of week class
public class weekClass
{
    //Objects
    private Calendar given;  
    private int numOfWeekGiven; 
    private String fullDateGiven;
    private String dateGiven;
    private int numDateGiven;  
    private String dateStartWeek;
    private String dateEndWeek;

    //Constructor
    public weekClass(Calendar date)
    {
        given = date; 
        
        Date representation = date.getTime();
        DateFormat repFormat = new SimpleDateFormat("MM-dd-YYYY"); 
        fullDateGiven =  repFormat.format(representation); 

        dateGiven = fullDateGiven.substring(3, 5);

        numDateGiven = Integer.parseInt(dateGiven);

        numOfWeekGiven = given.get(Calendar.DAY_OF_WEEK);
         
        if (numOfWeekGiven == 1)
        {
            dateStartWeek = Integer.toString(numDateGiven);  
            dateEndWeek = Integer.toString(numDateGiven + 6); 
        }
        else if(numOfWeekGiven == 2)
        {
            dateStartWeek = Integer.toString(numDateGiven - 1);  
            dateEndWeek = Integer.toString(numDateGiven + 5); 
        }
        else if(numOfWeekGiven == 3)
        {
            dateStartWeek = Integer.toString(numDateGiven - 2);  
            dateEndWeek = Integer.toString(numDateGiven + 4); 
        }
        else if(numOfWeekGiven == 4)
        {
            dateStartWeek = Integer.toString(numDateGiven - 3);  
            dateEndWeek = Integer.toString(numDateGiven + 3); 
        }
        else if(numOfWeekGiven == 5)
        {
            dateStartWeek = Integer.toString(numDateGiven -4);  
            dateEndWeek = Integer.toString(numDateGiven + 2); 
        }
        else if(numOfWeekGiven == 6)
        {
            dateStartWeek = Integer.toString(numDateGiven - 5);  
            dateEndWeek = Integer.toString(numDateGiven + 1);
        }
        else if(numOfWeekGiven == 7)
        {
            dateStartWeek = Integer.toString(numDateGiven - 6);  
            dateEndWeek = Integer.toString(numDateGiven); 
        }
        
    }//End of constructor

    //Functions
    public Calendar getGiven()
    {
        return given; 
        
    }//end of getGiven Function

    public int getNumOfWeekGiven()
    {
        return numOfWeekGiven; 
        
    }//end of getNumOfWeekGiven Function

   public String getFullDateGiven()
   {
        return fullDateGiven; 
   }

   public String getDateGiven()
   {
        return dateGiven; 
   }

   public int getNumDateGiven()
   {
        return numDateGiven;
   }

   public String getDateStartWeek()
   {
        return dateStartWeek; 
   }


   public String getDateEndWeek()
   {
        return dateEndWeek; 
   }


    
}//end of WeekClass class
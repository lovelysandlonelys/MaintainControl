/////////////////////////////////////////
//Program Name: 
//Program Purpose: 
//Last Updated: 04/21/2023
//Last Updated By: Savannah Stephenson
/////////////////////////////////////////

//Package
package maintainControl;

//Imports 
import javax.swing.*; 

//Start of MaintainControDriver Class
public class MaintainControlDriver
{
	//Main
	public static void main(String args[])
	{
		homeScreen maintainControl = new homeScreen(); 
		maintainControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maintainControl.setSize(800, 250);
		maintainControl.setVisible(true); 

	}//End of main

}//End of MaintainControlDriver class
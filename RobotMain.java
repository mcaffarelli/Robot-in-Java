package projectWithoutGUI;

import static projectWithoutGUI.Robot.grid;
import static projectWithoutGUI.Robot.clear;
import static projectWithoutGUI.Robot.print2D;

public class RobotMain {
	public static void main(String[] args) 
  {
    System.out.println("\n\nA-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

    //grid is a static variable in robot implementation code
    //Initialize all the elements of the 2D array to blank.
    clear();
    
    //place 'B' and 'C' on grid  Use print2D() to print the grid
    grid[10][8] = 'B';
    grid[22][4] = 'C';
    print2D(grid);
    
    System.out.println("\n\nB-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    
    //Create two robots R1 and R2 using the two constructors.
    Robot R1 = new Robot();//default constructor
    Robot R2 = new Robot(0,0,' ');// 3 parameter constructor (x, y, payload)
    
    //Print the location of the robots.
    System.out.println("Robot 1 is at: ");
    R1.print();
    System.out.println("Robot 2 is at: ");
    R2.print();
    
    System.out.println("\n\nC-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    
    //Use “moveTo()” method to place R1 at location (23, 24) and R2  at location (15, 3). Print the location of the robots
    R1.moveTo(23, 24);
    R2.moveTo(15,3);
    
    //Print the location of the robots.
    System.out.println("Robot 1 is at: ");
    R1.print();
    System.out.println("Robot 2 is at: ");
    R2.print();
    
    
    System.out.println("\n\nD-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    //Direct R1 to pick up ‘B’ at location (10, 8) 
    R1.moveTo(10, 8);
    R1.pickUp(10, 8);
    
    //and place it at location (20,20). 
    R1.moveTo(20, 20);
    R1.dropOff(20, 20);
    
    //Print the location of the robot. 
    System.out.println("Robot 1 is at: ");
    R1.print();
    
    //Print the grid.
    print2D(grid);

    System.out.println("\n\nE-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    
    //Direct R2 to pick up ‘C’ at location (22, 4) 
    R2.moveTo(22, 4);
    R2.pickUp(22, 4);
    
    //and place it at location (0, 0). 
    R2.moveTo(0, 0);
    R2.dropOff(0, 0);
    
    //Print the location of the robot. 
    System.out.println("Robot 2 is at: ");
    R2.print();
    
    //Print the grid.
    print2D(grid);
  }
}

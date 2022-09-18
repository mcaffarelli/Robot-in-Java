package projectWithoutGUI;

public class Robot {
  //Robot class has private data members x, y , and payload
  private int x;
  private int y;
  private char payload;
  
  //Grid Size declared as constants 25x25
  static final int COLUMNS=25;
  static final int ROWS=25;  
  static public char [][] grid = new char[ROWS][COLUMNS];
  
  //Default constructor initializes robot object to (0,0) with an empty load
  public Robot(){
  	x = 0;
  	y = 0;
  	payload = ' ';
  }

  //Constructor that recieves 3 parameters
  public Robot(int x, int y, char payload) {
  	this.x = x;
  	this.y = y;
  	this.payload = payload;
  }

  //Set and get functions for each private data member
  public void setPayload(char payload) {this.payload = payload;}

  public char getPayload() {return payload;}

  public void setX(int x) 
  {
		//checks if input is within the grid
  	if (x>=0 && x<ROWS) {
  		this.x = x;
  	}
  }

  public int getX() {return x;}

  public void setY(int y) 
  {
  	//checks if input is within the grid
    if (y>=0 && y<COLUMNS) {
      this.y = y;
    }
  }

  public int getY() {return y;}


  //member print function, returns location of the robot and its load
  public void print() 
  {
  	System.out.printf("Location: (%d, %d) Payload: %c \n\n", x, y, payload);
  }

  public boolean pickUp(int lx, int ly)
  {
    if (lx!=this.x&&ly!=this.y) 
    {
    	System.out.printf("Not at Location: (%d, %d)", lx, ly);
    	return false;
    }
    
    else if (grid[lx][ly] == ' ') 
    {
    	System.out.print("No Load at this Location");
    	return false;
    }
    
    else if (payload == ' ')
    {
    	payload = (char) grid[lx][ly];
    	grid[lx][ly]= ' ';
    	return true;
    }
    
    else {
    	return false;
    }
  }

  public boolean dropOff(int lx, int ly) 
  {
  	if (lx!=this.x&&ly!=this.y)
  	{
  		System.out.printf("Not at Location: (%d, %d)", lx, ly);
  		return false;
  	}
  	
  	else if (payload != ' ')
  	{
  		grid[lx][ly] = payload;
  		payload= ' ';
  		return true;
    }
  	
    else {
    	return false; 
    }
  }

  public void moveRight() 
  {
    if((y+1)< COLUMNS)//Checks if movement will still be in the grid
      y++;
    else
      System.out.println("Unable to move there");
    if(y==COLUMNS-1)//Checks if boundary has been reached
      System.out.println("Right boundary reached");
  }

  public void moveLeft() 
  {
    if((y-1)>= 0)//Checks if movement will still be in the grid
      y--;
    else
      System.out.println("Unable to move there");
    if(y==0)//Checks if boundary has been reached
      System.out.println("Left boundary reached");
  }

  public void moveUp() 
  {
    if((x-1)>= 0)//Checks if movement will still be in the grid
      x--;
    else
      System.out.println("Unable to move there");
    if (x==0)//Checks if boundary has been reached
      System.out.println("Top boundary reached");
  }

  public void moveDown() 
  {
    if((x+1)< ROWS)//Checks if movement will still be in the grid
      x++;
    else
      System.out.println("Unable to move there");
    if(x==ROWS-1)//Checks if boundary has been reached
      System.out.println("Bottom boundary reached");
  }

  public boolean moveTo(int lx, int ly)
  {
    if (lx < 0 || lx >= ROWS || ly < 0 || ly >= COLUMNS)
      return false;
    else 
    {
      while (this.x<lx)
        moveDown();
      while (this.x>lx)
        moveUp();
      while (this.y<ly)
        moveRight();
      while (this.y>ly)
        moveLeft();
      return true;
    }
  }
  
static public void print2D(char[][] a)
  {
    System.out.println("\nDisplaying Grid \n");
    System.out.print ("   |");
    
    for(int i=0; i<COLUMNS ; i++)
        System.out.printf (" %4d |", i);//add +1 to i for 1-25 display
    
      System.out.println();
      
      for (int x = 0; x < ROWS; x++)
      {
        int count = 0;
        System.out.println ("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(" %2d| ", x);//add +1 to X for 1-25 display
        for (int y = 0; y < COLUMNS; y++)
        {
          System.out.printf("%4c | ", a[x][y]);
          count++;
          if (count == COLUMNS)
            System.out.println();
        }
      }
      
  }
  static public void clear()//empty the grid
  {
  	for(int i=0; i<ROWS;i++) 
      for(int j=0; j<COLUMNS; j++)
        grid[i][j]=' ';
               
  }
}

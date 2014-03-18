import java.util.*;
import java.io.*;

public class Solution
{
	//members:
	//need an array to hold the array of coords for solution
	//array of holding line segs
	private Coord[] coords;
	private LineSegment[] lines; 
	//do we need a boolean to tell us if line needs to be redone?

	//we are going to create a path that is going to start from a certain set of coords and going to end at set of coords
	private Coord start;
	private Coord finish;
	private Reader reader;
	private Random gen = new Random();
	private boolean done;

	public Solution(Scanner user) throws FileNotFoundException
	{
		done = false;
		start = new Coord(0, 0);
		finish = new Coord(10, 10);
		//read in the file that we will use as problem
		reader = new Reader(user);

		//create the random set coords
		//we can have shapes test for us and just keep the results
		coords = new Coord[6];
		coords[0] = start;
		coords[5] = finish;

		lines  = new LineSegment[6];


	}
	//prints out solution coordinate array in the proper answer format
	public String toString()
	{
		String display = "";
		display += 6 + "\n";
		for(int i = 0; i < coords.length; i++)
		{
			display += coords[i].toString() + "\n";
		}
		return display;
	}


	public void getSolution()
	{
		//done could be a local variable
		
		//we need to make sure that there is a min and max rand num
		double minx = start.get_x();
		double miny = start.get_y();
		double maxx = finish.get_x();
		double maxy = finish.get_y();

		while(!done)
		{
			//coordinates between start and finish
			for(int i = 1; i < 5; i++)
			{
				double numx = Math.abs((gen.nextDouble() * 100) %(maxx - minx) + minx);
				double numy = Math.abs((gen.nextDouble() * 100) %(maxy - miny) + miny);

				coords[i] = new Coord(numx, numy);
				//System.out.println(coords[i].toString());
			}
			//makes lines from random coords
			connectLines();
			//tests to see if those lines work
			//will run through loop until done returns true
			done = test_file();
		}

	}
//helper method to test lines
	//set to public for testing
	private boolean test_file()
	{
		for(int i = 0; i < 5; i++)
		{
			//we need to compare each line to check every line in other shapes

			//I think my boolean logic is screwy
			if( reader.compare_file(lines[i]) == false)
			{
				//System.out.println("returned false on line " + i);//for testing
				return false;
			}
		}
		return true;
	}

//helper method to make lineSegments from random points
	private void connectLines()
	{

		for(int i = 0; i < 5 ;i++)
		{
			lines[i] = new LineSegment(coords[i], coords[i+1]);
		}
	}


}//end class
import java.util.*;
import java.io.*;

public class Solution
{
	//members:
	//need an array to hold the array of coords for solution
	//array of holding line segs
	private Coord[] coords;
	private LineSegment[] lines; 


	private Coord start; //start of path solution
	private Coord finish;//end of path solution
	private Reader reader; //will read the coords of problem from file
	private int num_shapes, num_solns;
	private Random gen = new Random(); //for generating random path solutions


//constructor for command line args

	public Solution(Scanner file, double p1, double p2, double p3, double p4 ) throws FileNotFoundException
	{
		//start = new Coord(0, 0);
		start = new Coord(p1, p2);
		finish = new Coord(p3, p4);
		//read in the file that we will use as problem
		reader = new Reader(file, 0);

		num_shapes = reader.get_num_shapes();
		num_solns = num_shapes + 1; //solutions should have at least one more line than shape

		coords = new Coord[num_solns]; 
		coords[0] = start;
		coords[num_solns - 1] = finish; //-1 because array index begins at 0

		lines  = new LineSegment[num_solns];


	}

//constructor used if we would like to ask the user for a file
	public Solution(Scanner user) throws FileNotFoundException
	{

		//ask for points

		System.out.println("Enter 4 doubles for start and end coords" + "\n");
		System.out.println("Enter point 1, double 1: ");
		double point1 = user.nextDouble();

		System.out.println("Enter point 1, double 2: ");
		double point2 = user.nextDouble();

		System.out.println("Enter point 2, double 1: ");
		double point3 = user.nextDouble();

		System.out.println("Enter point 2, double 2: ");
		double point4 = user.nextDouble();

		//clear the buffer
		user.nextLine();

		start = new Coord(point1, point2);
		finish = new Coord(point3, point4);
		//read in the file that we will use as problem
		reader = new Reader(user);

		num_shapes = reader.get_num_shapes();

		num_solns = num_shapes + 1; //solutions should have at least one more line than shape

		coords = new Coord[num_solns];
		coords[0] = start;
		coords[num_solns - 1] = finish; //-1 because array index begins at 0

		lines  = new LineSegment[num_solns];


	}
	//prints out solution coordinate array in the proper answer format
	public String toString()
	{
		String display = "";
		display += num_solns + "\n";
		for(int i = 0; i < coords.length; i++)
		{
			display += coords[i].toString() + "\n";
		}
		return display;
	}


	public void getSolution()
	{
		boolean done = false;

		//we need to make sure that there is a min and max rand num
		double minx = start.get_x();
		double miny = start.get_y();
		double maxx = finish.get_x();
		double maxy = finish.get_y();

		while(!done)
		{
			//create random solutions
			//coordinates between start and finish
			for(int i = 1; i < num_solns - 1; i++)
			{
				double numx = Math.abs((gen.nextDouble() * 100) %(maxx - minx) + minx);
				double numy = Math.abs((gen.nextDouble() * 100) %(maxy - miny) + miny);

				coords[i] = new Coord(numx, numy);
				//System.out.println(coords[i].toString()); //for testing
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
		for(int i = 0; i < num_solns - 1; i++)
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

		for(int i = 0; i < num_solns - 1 ;i++)
		{
			lines[i] = new LineSegment(coords[i], coords[i+1]);
		}
	}


}//end class
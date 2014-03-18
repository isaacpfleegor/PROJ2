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
		//System.out.println(reader.toString());

		//create the random set coords
		//we can have shapes test for us and just keep the results
		coords = new Coord[6];
		coords[0] = start;
		coords[5] = finish;

		lines  = new LineSegment[6];


	}
	//for testing to see if we can get correct solution
	/*public Solution(Scanner user, int num) throws FileNotFoundException
	{

		reader = new Reader(user);

		done = false;
		start = new Coord(0, 0);
		finish = new Coord(10, 10);

		coords = new Coord[6];
		coords[0] = start;
		coords[1] = new Coord(8.94957222245666,0.010806297164279721);
		coords[2] = new Coord(9.456728233436403,5.773122235432969);
		coords[3] = new Coord(5.094417227596423,3.3073044090658743);
		coords[4] = new Coord(4.276545968130401,9.910344840500013);
		coords[5] = finish;

		lines  = new LineSegment[5];

	}*/
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

	/*public String toString()
	{
		//prints out solution
		return "" + Arrays.toString(coords);
	}*/
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
			done = testLines();
		}

	}
//helper method to test lines
	//set to public for testing
	private boolean testLines()
	{
	//we have 6 lines and 7 coords
		//connectLines();

		/*{
			reader.intersect(lines[i]);
		}*/
		for(int i = 0; i < 5; i++)
		{
			//we need to compare each line to check every line in other shapes

			//I think my boolean logic is screwy
			if( reader.intersect(lines[i]) == false)
			{
				System.out.println("returned false on line " + i);
				return false;
			}
		}
		return true;
	}
//helper method to make lineSegments from random points
	private void connectLines()
	{
		//we need to stop at coord6--remember i + 1
		for(int i = 0; i < 5 ;i++)
		{//System.out.println("i is "+ i + " in connectLines");
			//System.out.println("i is " + i);
	lines[i] = new LineSegment(coords[i], coords[i+1]);
			//System.out.println(lines[i]);

}
}


}//end class
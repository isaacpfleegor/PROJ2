import java.util.*;
import java.io.*;

public class Shape
{
//members
	private int num_coords;
	private int num_lines;
	private Coord[] coords;
	private LineSegment[] lines;

	public Shape(Scanner file, int num)
	{
		double num1, num2;
		coords = new Coord[num];//allocate pointers for Coord array
		num_lines = num_coords = num;
		//here create 5 coords
		for(int i = 0; i < num ; i++)
		{
			num1 = file.nextDouble();
			num2 = file.nextDouble();

			coords[i] = new Coord(num1, num2);//for each
			//System.out.println(coords[i]);
		}
		//here create 5 line segments

		lines = new LineSegment[num];
		//creates a linesegment for every 2 points
		for(int i = 0; i < num; i++)
		{
			if(i < num - 1)
			{
				lines[i] = new LineSegment(coords[i], coords[i+1]);
			}
			else //connects the last and first point
			lines[i] = new LineSegment(coords[i], coords[0]);
		}
	}

	public int get_num_lines(){return num_lines;}
	public int get_num_coords(){return num_coords;}
//should return true if intersects
	public boolean compare(LineSegment line)
	{
	//will compare this line with every lineSeg in this shape
		for(int i = 0; i < lines.length; i++)
		{
			if( lines[i].intersect(line) == true)
			{
				System.out.println("this was line " + i + " in shapes obj");
				return false;
			}
		}
		return true;
	}

	public String toString()
	{
		String display = "";
		for (int i = 0; i < num_coords; i++)
		{
			display += "" + coords[i].toString() + '\n';
		}
		return display;
	}
}
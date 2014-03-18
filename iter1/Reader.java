import java.util.*;
import java.io.*;

public class Reader
{
	//members:
	private Shape[] shapes;
	public Scanner file;
	private int num_shapes;

	//methods:
	public Reader(Scanner user) throws FileNotFoundException
	{
		System.out.println("Enter the name of the infile:");
		String filename = user.nextLine();
		file = new Scanner(new FileReader (filename));

	num_shapes = file.nextInt(); //reads out num_shapes

	shapes = new Shape[num_shapes];


	for(int i = 0; i < num_shapes; i++)
	{
		int num_coords = file.nextInt(); //so, shape knows how many coords to read

		shapes[i] = new Shape(file, num_coords); //creates new shape object for each element

	}

	file.close();

}
//returns true if the file is successfully compared and path is found
public boolean compare_file(LineSegment line)
{
	//for each shape
	for(int i = 0; i < num_shapes; i++)
	{
		if( shapes[i].compare_shapes(line) == false)
		{
			//System.out.println("returned false on i "+ i); //for testing
			return false;
		}
	}
	//System.out.println("returned true"); //for testing
	return true;
}

public String toString()
{
	String display = "";
	for(int i = 0; i< num_shapes; i++)
	{
		display += "Shape " + i + ":" + '\n';
		display += shapes[i].toString();
		display += '\n';
	}
	return display;
}
}
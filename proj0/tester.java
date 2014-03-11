import java.util.*;
import java.io.*;

public class tester
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner user = new Scanner(System.in);
		Random gen = new Random();

		Coord start = new Coord(0, 0);
		Coord finish = new Coord(10, 10);

		Coord [] coords = new Coord[7];
		coords[0] = start;
		coords[6] = finish;

		double minx = start.get_x();
		double miny = start.get_y();
		double maxx = finish.get_x();
		double maxy = finish.get_y();

		for(int i = 1; i < 6; i++)
		{
			double numx = Math.abs((gen.nextDouble() * 100) %(maxx - minx) + minx);
			double numy = Math.abs((gen.nextDouble() * 100) %(maxy - miny) + miny);

			coords[i] = new Coord(numx, numy);
			System.out.println(coords[i]);
			
		}

		
	}
}
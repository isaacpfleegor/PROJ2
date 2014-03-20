import java.util.*;
import java.io.*;

public class appdriver
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//for command line args
		if (args.length > 0)
		{
			try
			{
				int pt1 = Integer.parseInt(args[2]);
				int pt2 = Integer.parseInt(args[3]);

				PrintWriter out = new PrintWriter( args[0]);//outfile
				
				Scanner file = new Scanner(new FileReader (args[1]));//file to read from
				
				Solution sol = new Solution(file, pt1, pt2);//get solution
				sol.getSolution();

				out.print(sol.toString());
				out.close();
			}
			catch (Exception e)
			{
				//let the user know the format for the CL Args
				System.out.println("Format should be java apptester filetowrite(string) filetoread(string) coord_end_point1(int) coord_end_point(int)");
			}
		}
		else
		{

			Scanner user = new Scanner(System.in);
			System.out.print("What file would you like to write to?   ");
			String fileout = user.nextLine();
			PrintWriter out = new PrintWriter( fileout);
			Solution sol = new Solution(user);
			sol.getSolution();

			out.print(sol.toString());
			out.close();
		}

	}
}
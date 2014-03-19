import java.util.*;
import java.io.*;

public class apptester
{
	public static void main(String[] args) throws FileNotFoundException
	{
//for command line args
		String arg0, arg1;
		if (args.length > 0)
		{
			try
			{
				PrintWriter out = new PrintWriter( args[0]);//outfile
				
				Scanner file = new Scanner(new FileReader (args[1]));//file to read from
				
				Solution sol = new Solution(file, 0);//get solution
				sol.getSolution();

				out.print(sol.toString());
				out.close();
			}
			catch (Exception e)
			{
				System.err.println("Argument '" + args[0] +"' should be a file to write to");
				System.err.println("Argument '" + args[1] +"' should be a file to read");
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
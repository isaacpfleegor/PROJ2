import java.util.*;
import java.io.*;

public class apptester
{
	public static void main(String[] args) throws FileNotFoundException
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
import java.util.*;
import java.io.*;

public class apptester
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner user = new Scanner(System.in);
		Solution sol = new Solution(user);
		sol.getSolution();


		System.out.println(sol.toString());

	
	}
}
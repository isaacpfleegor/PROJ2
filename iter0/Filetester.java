import java.util.*;
import java.io.*;

public class Filetester
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file;
		Scanner user = new Scanner(System.in);
		System.out.println("Enter the name of the infile:");

		String filename = user.nextLine();
		file = new Scanner( new FileReader(filename));		//read from file
		
		int num1 = file.nextInt();
		System.out.println(num1);
		//file.next();
		int num2 = file.nextInt();
		System.out.println(num2);

		double [][] coords = new double[num2][2];

		for(int count = 0; count < num1; count++)
		{
			
			for(int i = 0; i < num2 ; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					coords[i][j] = file.nextDouble();
					System.out.println(coords[i][j]);
				}
			}
			if (num2 < num1)
			{
				num2 = file.nextInt();
				System.out.println("There are " + num2 + " sets of coords");
			}
		}
		//System.out.println(Arrays.toString(coords));
		file.close();
	}
}
import java.util.*;

public class ladder
{
	private static Scanner in = new Scanner(System.in);
	public static void main (String [] args)
	{
		//Ask the user to input number of steps and checks if valid
		String msg = "How many steps(more than 1)";
		int steps = setValue(msg);

		if(steps <= 0 )
		{
			System.out.println("The number is invalid for a ladder!!");
			System.out.println("This function has been executed!");
			return;

		}
		if(steps == 1)
		{
			System.out.println("You need more than 1 step!!");
			System.out.println("This function has been executed!");
			return;

		}

		System.out.print("Enter the locations: ");
		int [] locations = new int [steps];

		//Ask the user to input the different locations of these steps
		String message = "Please enter location of step 1";
		locations[0] = setValue(message);

		if(locations[0] < 0)
		{
			System.out.print("Locations have to be positive!!\n");
			return;
		}

		for(int i = 1; i < steps; i++)
		{
			message = "Please enter location of step " + (i + 1);
			locations[i] = setValue(message);
			if(locations[i] <= locations[i-1] || locations[i] < 0)
			{

				System.out.print("Locations have to be in ascending order and positive!!\n");
				break;
			}
		}
		//Print out the largest gap between two consecutive steps

			System.out.println("The largest Gap is: " + largestGap(locations, steps) + ".");
	}

	static int largestGap(int [] input, int num)
	{
		//Find gap between one number and the next and so on
		int maxGap = 0;
		for(int i =0; i < num -1; i++)
		{
			if ((input[i+1] - input[i]) >= maxGap)
			{
				maxGap = input[i+1] - input[i];
			}
		}
		//return the greatest gap
		return maxGap;
	}
	private static int setValue(String message)
	{
		boolean success = false;

		int retVar = 0;

		while (!success)
		{
			try
			{
				System.out.printf("\n%s: ", message);
				retVar = in.nextInt();
				success = true;
			}
			catch (InputMismatchException e)
			{
				in.next();
				System.out.println("Not a correct INT. Please try again!");
			}
		}
			return retVar;
	}
}

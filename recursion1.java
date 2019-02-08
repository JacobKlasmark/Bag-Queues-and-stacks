/***
 * A program that takes an input string and reverses it with the help of recursion
 * 
 * 
 * 
 * @author Jacob Klasmark
 *
 */
public class recursion1 {
	public static void main (String[] args) 
	{
		java.util.Scanner in = new java.util.Scanner (System.in);
		String s = in.nextLine() + '\n';
		
		reverse(s, 0);
	}
	
	
	//Takes a String and a starting character as an int
	//Prints the inputed string in reversed order with the help of recursion
	public static void reverse (String str, int i)
	{
		char c = str.charAt(i);											
		if (c != '\n')
		{
			i++;
			reverse (str, i);
		}
		System.out.print(c);
	}
}

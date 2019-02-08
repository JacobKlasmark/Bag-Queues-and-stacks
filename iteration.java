/***
 * A program that takes an input string and reveses it
 * 
 * 
 * @author Jacob Klasmark
 *
 */




public class iteration 
{
	
	
	//Prints the reversed string
	public static void reverse(String str, int i)
	{
		char[] ch = new char[100];
		char c = 'a';
		String s = "";
		while (c != '\n')						//Loads every character in the sting into an array
		{
			c = str.charAt(i);
			ch[i] = c;
			i++;
		}
		while (i >= 0)							//Reads from the array in reverse and builds a string that is printed
		{
			s = s + ch[i];
			i--;
		}
		System.out.print(s);
	}
	
	
	public static void main (String[] args) 
	{
		java.util.Scanner in = new java.util.Scanner (System.in);
		String s = in.nextLine() + '\n';
		
		reverse(s, 0);
			
	}
}

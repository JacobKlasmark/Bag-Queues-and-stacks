/***********************************************************
 *A program that creates a FIFO-queue that gives you the option to
 *enqueue and dequeue items.
 * 
 * API public class fifi_queue<Item>
 * 			fifo_queue()			create an empty fifo-queue
 * void		enqueue(Item item)		add an item at the end of the queue	
 * Item		dequeue()				removes the item first in the queue
 * boolean	isEmpty()				is the queue empty?
 * int 		size()					number of items in the queue
 * void 	content()				prints out the items in the queue
 * 
 * @author Jacob Klasmark
 * 
 */




import java.util.Iterator;

public class fifo_queue<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N;
	
	//Create Nodes with Item, next, previous
	private class Node
	{
		Item item;
		Node next;
		Node previous;
	}
	
	//Returns null if queue is empty
	public boolean isEmpty() { return first == null; }
	
	// Returns the size of the queue
	public int size()		 { return N; }
	
	
	//Adds an Item at the end of the queue
	public void enqueue(Item item)
	{
		Node oldlast = last;									
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) 
		{
			first = last;
			last.previous = null;
		}
		else		   
		{
			oldlast.next = last;
			last.previous = oldlast;
		}
		N++;
	}
	
	//Removes and returns the first item in the queue
	public Item dequeue()
	{
		if (isEmpty()) 
		{ return null; }
			
		else {
			Item item = first.item;
			first = first.next;
			first.previous = null;
			if (isEmpty()) 
				last = null;
			N--;
			return item;
			}
	}
	
	public Iterator<Item> iterator()
	{ return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		
		public boolean hasNext()
		{ return current != null; }
		
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	// Takes the double linked list and prints out its content
	public void content(fifo_queue<Item> l1)
	{
		Iterator it = l1.iterator();
		String s;
		if (l1.size() == 1) 
		{
			s = "[" + it.next() + "]";
			System.out.println(s);
		}
		else
		{
			s = "[" + it.next() + "],";
			for (int i = 1; i < l1.size() - 1; i++)
				s = s + "[" + it.next() + "],";	
			s = s + "[" + it.next() + "]";
			System.out.println(s);
		}
		
	}
	
	public static void main(String[] args)
	{
		fifo_queue<Character> l1 = new fifo_queue<Character>();
		
		int size = l1.size();
		System.out.println(size);
		l1.dequeue();
		l1.enqueue('h');
		l1.enqueue('e');
		l1.enqueue('j');
		l1.content(l1);
		l1.enqueue('s');
		l1.enqueue('a');
		l1.enqueue('n');
		l1.content(l1);
		l1.dequeue();
		l1.content(l1);
		size = l1.size();
		System.out.println(size);
		char c = l1.dequeue();
		System.out.println(c);
		l1.content(l1);
		size = l1.size();
		System.out.println(size);
		l1.enqueue('5');
		c = l1.dequeue();
		System.out.println(c);
		l1.content(l1);
		
		
		
		
		
		
	}
}

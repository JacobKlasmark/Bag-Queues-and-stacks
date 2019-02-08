/*****************************************
 * The program creates a doubly circular linked list. 
 * You can add and remove items at the front and back of the queue.
 * Can print the content of the queue aswell.
 * 
 * API	public class queue_circular<Item> 
 * 			queue_circular()						creates an empty queue
 * void		enqueue_last(Item item)					adds an Item last in the queue
 * void		enqueue_first(Item item)				adds an Item first in the queue
 * Item		dequeue_first()							removes the item first in the queue
 * Item 	dequeue_last()							removes the item last in the queue
 * boolean	isEmpty()								is the queue empty?
 * int 		size()									number of items in the queue
 * void		content(queue_circular<Item> item)		prints the items in the queue
 * 
 * 
 * @author Jacob Klasmark
 *
 */

import java.util.Iterator;

public class queue_circular<Item> implements Iterable<Item>
{

	private Node first;
	private Node last;
	private int N;
	
	//Create Nodes with Item, next
	private class Node
	{
		Item item;
		Node next;
		Node previous;
	}
	
	
	//Returns null if queue is empty
	public boolean isEmpty() { return N == 0; }
	
	// Returns the size of the queue
	public int size()		 { return N; }	
	
	//Takes an Item and adds it at the start of the queu
	public void enqueue_first(Item item)
	{
		
		Node oldfirst = first;									
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (isEmpty()) 
		{
			last = first;
			first.previous = last;
		}
		else		   
		{
			last.next = first;
			first.previous = last;
		}
		N++;
	}
	
	//Takes an Item and ads it at the end of the queue
	public void enqueue_last(Item item)
	{
		Node oldlast = last;									
		last = new Node();
		last.item = item;
		last.next = first;
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
	
	//Removes the first Item from the queue and returns it
	public Item dequeue_first()
	{
		if (isEmpty()) 
		{ return null; }
			
		else {
			Item item = first.item;
			first = first.next;
			last.next = first;	
			first.previous = last;
			if (isEmpty()) 
				last = null;
			N--;
			return item;
			}		
	}
	
	//Removes the last Item from the queue and returns it
	public Item dequeue_last()
	{
		if (isEmpty()) 
		{ return null; }
			
		else {
			Item item = last.item;
			//first = first.next;
			last.previous.next = first;
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
	public void content(queue_circular<Item> l1)
	{
		Iterator<Item> it = l1.iterator();
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
	
	public static void main (String[] args)
	{
		queue_circular<Character> l1 = new queue_circular<Character>();
		
		int size = l1.size();
		System.out.println(size);
		l1.dequeue_first();
		l1.enqueue_first('h');
		l1.enqueue_first('e');
		l1.enqueue_last('j');
		l1.content(l1);
		l1.enqueue_last('s');
		l1.enqueue_last('a');
		l1.enqueue_last('n');
		l1.content(l1);
		size = l1.size();
		System.out.println(size);
		char c = l1.dequeue_first();
		System.out.println(c);
		l1.content(l1);
		size = l1.size();
		System.out.println(size);
		l1.enqueue_last('5');
		l1.content(l1);
		c = l1.dequeue_last();
		System.out.println(c);
		l1.content(l1);
	}
	
	
	
}

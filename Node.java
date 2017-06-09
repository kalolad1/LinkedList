/*
Programmar: Darshan Kalola, Summer of 2017

This class represents a Node that will be primarily implemented within a LinkedList.
The class may be extended to work within Binary Trees and other data structures some time
in the future. Generics has not been implemented, and the Node will only contain one
4-byte integer as its data value. 
*/

public class Node {
	
	/* Instance data - both have been given the public modifier for easier access
	within the LinkedList class, though proper implementation would include the modifier
	private to control getting and setting access. */
	// Contains the 4-byte integer that will be the only data source for the Node
	public int data;
	
	// Contains a pointer to the Next in sequence - will be set as null if there is none
	public Node next;
	
	/* Constructors */
	// Takes no parameters and assigns the data value to be 0, and the next node to be null
	public Node() {
		this.data = 0;
		this.next = null;
	}
	
	// Takes as the only parameter the integer value of the data
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	// Takes in two parameters, the integer value of the data and the next Node
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	/* Instance methods */
	// Returns the String representation of the Node, overriding the Object class 
	// implementation.
	@Override
	public String toString() {
		return "" + data;
	}
	
	// Returns whether two Nodes are identical, based on their data values
	public boolean equals(Node N) {
		return this.data == N.data;
	}
	
	// Determines the comparability of two Nodes, using the data instance variable.
	// The integer will be positive if the current Node is greater than Node n.
	public int compareTo(Node N) {
		return this.data - N.data;
	}
	
	// Checks if the Node has a next variable set
	public boolean hasNext() {
		return this.next != null;
	}
	
	/* Getters and Setters - though these will rarely be used as the instance variables
	will be accessed directly for convenience */
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		if (this.next != null) 
			return next;
		else 
			throw new NullPointerException();
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node N) {
		this.next = N;
	}
}
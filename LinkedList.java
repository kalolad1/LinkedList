/*
Programmer: Darshan Kalola, Summer of 2017

This class will make use of Node (see Node.java) to create a LinkedList data structure
that will allow for quick insertion and deletion times. It will contain three instance
variables, a Node head, a Node tail, and an int length. This data structure will have 
slow lookup (as iteration will be required).

*/

public class LinkedList {

	/* Instance data */
	// The first Node of the list
	private Node head;
	
	// The last Node of the list
	private Node tail;
	
	// The number of Node's present int he list
	private int size;
	
	/* Constructors */
	// Creates an empty LinkedList and takes in no parameters
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// Creates a LinkedList with one Node, which will be both the head and tail
	public LinkedList(Node N) {
		head = N;
		tail = N;
		size = 1;
	}
	
	// Creates a LinkedList with one Node from an integer value, which will be both the 
	// head and tail
	public LinkedList(int data) {
		Node N = new Node(data);
		head = N;
		tail = N;
		size = 1;
	}
	
	// Creates a LinkedList from an Array of Nodes. Creates new Nodes that correspond
	// with the Arrays Nodes
	public LinkedList(Node[] arrayOfNodes) {
		// Sets the size
		size = arrayOfNodes.length;
		
		// Sets the head if possible
		if (size > 0) {
			Node N = new Node(arrayOfNodes[0].data);
			head = N;
			
			for (int i = 1; i < size; i++) {
				Node newNode = new Node(arrayOfNodes[i].data);
				N.next = newNode;
				N = N.next;
			}
			tail = N;
		} else {
			head = null;
			tail = null;
			size = 0;
		}	
	}
	
	// Creates a LinkedList based on size, defaulting all nodes to the given value
	public LinkedList(int size, int value) {
		this.size = size;
		
		Node N = new Node(value);
		head = N;
		
		for (int i = 1; i < size; i++) {
			Node newNode = new Node(value);
			N.next = newNode;
			N = N.next;
		}	
	}	
	
	/* Instance methods */
	// Returns a String representation of the LinkedList object.
	@Override
	public String toString() {
		Node N = head;
		String str = "[" + N.data;
		
		while (N.next != null) {
			str += ", ";
			N = N.next;
			str += N.data;
		}
		
		str += "]";
		return str;
	}
	
	// Appends the given Node to the end of the list
	public void append(Node N) {
		if (tail != null) {
			tail.next = N;
			tail = N;
		}
		
		if (this.isEmpty()) {
			head = N;
			tail = N;
		}
		size++;
	}
	
	// Creates a new Node and appends that to the end of the list
	public void append(int data) {
		Node N = new Node(data);
		append(N);
	}	
	
	// Appends a Node after the inputed value. If the inputed value does not exist,
	// nothing will occur.
	public void appendAfter(int data, int newData) {
		if (this.isEmpty()) 
			return;
		
		Node N = head;
		boolean notFound = true;
		
		while (N != null && notFound) {
			if (N == tail && tail.data == data) {
				Node newNode = new Node(newData);
				tail.next = newNode;
				tail = newNode;
				size++;
				break;
			} 
		
			else if (N.data == data) {
				notFound = false;
				Node newNode = new Node(newData);
				newNode.next = N.next;
				N.next = newNode;
				size++;
			}
			N = N.next;
		}
	}
	
	// Prepends a Node to the list
	public void prepend(Node N) {		
		if (head != null) {
			N.next = head;
			head = N;
		}
		
		if (this.isEmpty()) {
			head = N;
			tail = N;
		}
		size++;
	}
	
	// Prepends a Node before the first occurence of a Node with the inputed data value
	public void prependBefore(int data) {
		if (this.isEmpty()) {
			return;
		}
		
		if (head.data == data) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
			size++;
			return;
		}
		
		Node pointer = head;
		while (pointer.next != null) {
			if (pointer.next.data == data) {
				Node newNode = new Node(data);
				newNode.next = pointer.next.next;
				pointer.next = newNode;
				size ++;
				break;
			}
			pointer = pointer.next;
		}
	}
	
	// Creates a new Node and prepends that to the list
	public void prepend(int data) {
		Node N = new Node(data);
		prepend(N);
	}
	
	// Checks if the list is empty
	public boolean isEmpty() {
		return size <= 0 && head == null && tail == null;
	}
	
	// Removes the first occurence of a Node with the inputed data value and return its
	public Node remove(int data) {
		Node removedNode = null;
	
		if (this.isEmpty()) {
			return null;
		}
		
		if (head.data == data) {
			removedNode = head;
			head = head.next;
			size--;
			return removedNode;
		} 
		
		Node N = head;
		while (N.next != null) {
			if (N.next.data == data) {
				if (N.next != tail) {
					removedNode = N.next;
					N.next = N.next.next;
					size--;
					break;
				} else {
					N.next = null;
					removedNode = tail;
					size--;
					break;
				}
			}
			N = N.next;
		}
		return removedNode;
	}
	
	// Removes all occurrences of the inputed data value - doesn't return anything
	public void removeAll(int data) {
		if (this.isEmpty()) {
			return;
		}
		
		if (head.data == data) {
			head = head.next;
			size--;
		}
		
		Node N = head;
		while (N.next != null) {
			if (N.next == tail && tail.data == data) {
				N.next = null;
				size--;
				break;
			} else if (N.next.data == data) {
				N.next = N.next.next;
				size--;
			}
			N = N.next;
		}
	}
	
	// Empties the list
	public void removeAll() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// Counts the number of occurrences of the inputed data value
	public int countOccurences(int data) {
		if (this.isEmpty()) 
			return 0;
			
		int counter = 0;
		Node N = head;
		while (N != null) {
			if (N.data == data) {
				counter++;
			}
			N = N.next;
		}
		return counter;
	}	
	
	// Returns a boolean value true if the inputed data value is contained within the 
	// LinkedList
	public boolean contains(int data) {
		if (this.isEmpty()) {
			return false;
		}
		
		Node N = head;
		while (N != null) {
			if (N.data == data) {
				return true;
			}
			N = N.next;
		}
		return false;
	}
	
	// Checks if two LinkedList's are equal -- if both contain the same number of Nodes
	// with the same data values in the same order
	public boolean equals(LinkedList secondList) {	
		LinkedList firstList = this;
		
		if (firstList.length() != secondList.length()) {
			return false;
		}
			
		if (firstList.isEmpty() || secondList.isEmpty()) {
			return false;
		}
			
		Node firstHead = firstList.getHead();
		Node secondHead = secondList.getHead();
		
		while (firstHead != null && secondHead != null) {
			if (!(firstHead.equals(secondHead))) {
				return false;
			}
			firstHead = firstHead.next;
			secondHead = secondHead.next;
		}
		return true;
	}
	
	// Returns the length of the LinkedList (number of Nodes)
	public int length() {
		return size;
	}
	
	// Returns the head of a LinkedList
	public Node getHead() {
		return head;
	}
	
	// Returns the tail of the LinkedList
	public Node getTail() {
		return tail;
	}
	
	// Gets the first node with the inputed data value
	public Node getNode(int data) {
		if (this.isEmpty()) {
			return null;
		}
		
		Node N = head;
		while (N != null) {
			if (N.data == data) {
				return N;
			}
			N = N.next;
		}	
		return null;
	}
	
	// Remove duplicates using a storage buffer in an unsorted LinkedList
	public void removeDuplicates() {
		int maximum = 100;
		boolean[] nodeDuplicates = new boolean[maximum];
		
		Node N = head;
		nodeDuplicates[N.data] = true;
		
		while (N != null && N.next != null) {
			if (nodeDuplicates[N.next.data]) {
				if (N.next == tail) {
					N.next = N.next.next;
					tail = N;
				} else {
					N.next = N.next.next;
				}
				size--;
			} else {
				nodeDuplicates[N.next.data] = true;	
			}
			N = N.next;
		}
	}
	
	// Removes duplicates without using a storage buffer
	public void removeDuplicatesWithoutBuffer() {
		Node runner = head;
		Node slowRunner = head;
		
		while (slowRunner != null) {
			int currentData = slowRunner.data;
			
			runner = slowRunner;
			while (runner != null && runner.next != null) {
				if (runner.next.data == currentData) {	
					if (runner.next == tail) {
						runner.next = runner.next.next;
						tail = runner;
					} else {
						runner.next = runner.next.next;
					}
					size--;
				} 
				runner = runner.next;
			}
			slowRunner = slowRunner.next;
		}
	}
	
	// Returns the Kth to last
	public Node returnKthLast(int k) {
		Node pointer1 = head;
		Node pointer2 = head;
		
		for (int i = 0; i < k; i++) {
			pointer1 = pointer1.next;
		}
		
		while (pointer1.next != null) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer2;
	}
	
	// Deletes a node in the middle of the list (not head or tail) accessing only that Node
	public void deleteNodeFromMiddle(Node N) {
		// Copy the node from its next
		N.data = N.next.data;
		N.next = N.next.next;
	}	
}


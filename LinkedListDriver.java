/*
Programmer: Darshan Kalola, Summer of 2017
This class tests and uses the implementation within the LinkedList and Node classes.
*/

public class LinkedListDriver {

	public static void main(String[] args) {
		
		/* Constructs a LinkedList object from an Array of Nodes. */
		Node[] array = new Node[3];
		array[0] = new Node(9);
		array[1] = new Node(15);
		array[2] = new Node(3);
		
		LinkedList list = new LinkedList(array);
		System.out.println(list); // Should be [1, 2, 3]
		
		/* Uses constructor that defaults 5 nodes to 0 */
		LinkedList list2 = new LinkedList(5, 0);
		System.out.println(list2); // Should be [0, 0, 0, 0, 0]
		
		LinkedList list3 = new LinkedList();
		list3.append(3);
		list3.append(6);
		list3.append(10);
		list3.append(1);
		list3.append(3);
		list3.append(10);
		System.out.println(list3); // Should be [3, 6, 10, 1, 3, 10]
		
		/* Removes the first instance of 3 */
		list3.remove(3);
		System.out.println(list3); // Should be [6, 10, 1, 3, 10]
		
		/* Removes all instances of 10 */
		list3.removeAll(10);
		System.out.println(list3); // Should be  [6, 1, 3]
		
		/* Appends the number 25 after 1 */
		list3.appendAfter(1, 25); 
		System.out.println(list3); // Should be [6, 1, 25, 3]
		
		/* Checks if list3 and list4 are equal */
		LinkedList list4 = new LinkedList();
		list4.append(6);
		list4.append(1);
		list4.append(25);
		list4.append(3);
		
		System.out.println(list3.equals(list3)); // Should be true
		
		LinkedList list5 = new LinkedList();
		list5.append(2);
		list5.append(2);
		list5.append(4);
		list5.append(6);
		list5.append(4);
		list5.append(6);
		
		System.out.println(list5);
		
		/* Removes the duplicates */
		list5.removeDuplicatesWithoutBuffer();
		
		System.out.println(list5);
		
		
		
		
	
	}

}
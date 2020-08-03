/* Author: James Wolfe
 * Date: May 1, 2018
 * Description: Utilizing linked list which will provide a way for data to be stored in a linear fashion. While using nodes to store the data 
 * the program resembles how a list might be created in a linked list fashion.  
 */

public interface StringBag {
	static void main(String[] args) {
		Node Item = new Node();
		Item.data = "Test_ShoppingBag.java";
	}

	Node head = new Node(); // some useful vars
	int size = 0;

	class Node { // linkedlist node
		private String data;
		private Node next;

		Node() { // making a node with no data
			data = null;
			next = null;
		}

		Node(String data) { // making a node with data
			this.data = data;
		}
	}

	private void insert(String element) { // Precondition: This StringBag is not full. Places element into this
											// StringBag.
		Node temp = head; // make a temp node that is a copy of head
		while (temp.next != null) { // search through the linked list until it finds the end
			temp = temp.next;
		}

		temp.next = new Node(element); // once the end is found make a new node containing the data and link it to
										// previous node

		if (head.data == null) head = temp.next; // if their where no items in the linked list make the head node = to the temp
		// node
		size++; // add 1 to size to keep track of how many items are in the linked list
	}

	boolean isFull(); // Returns true if this StringBag is full, otherwise returns false.

	private boolean isEmpty() { // Returns true if this StringBag contains no strings.
		return head.data == null;
	}

	private int size() { // Returns the number of Strings in this StringBag
		return size;
	}

	private String remove() { // Precondition: the Bag is not empty

		Node temp = head; // make copy of head node and new temp node
		Node temp2;

		if (temp.data != null) { // if there is an item in the linked list
			if (temp.next == null) { // if their is only 1 item in the inked list
				head.data = null;
				size--;
				return temp.data;
			}

			while (temp.next != null) { // if there is more than 1 item in linked list, search for the end of the linked
										// list
				temp2 = temp; // preserve 2nd to last node
				temp = temp.next; // move onto next node
			}

			temp2.next = null;
			size--;
			return temp.data;
		}
	}

	private void clear() { // Makes this StringBag empty.
		head = new Node();
		size = 0;
	}

	private String getName() { // Returns the name of this StringBag
		return "StringBag";
	}
}
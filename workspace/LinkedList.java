/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList {
  //instance variables go here (think about what you need to keep track of!)
  ListNode head;

  //constructors go here
  public LinkedList() {
    head = new ListNode(null, null);
  }

  public ListNode placeNode(String value, ListNode node) {
    if (node.getValue().compareTo(value) > 0) {
      placeNode(value, node.getNext());
    } else {
      node = new ListNode(value, node);
    }
    
    return node;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line) {
    return placeNode(count, line, head);
  }

  public ListNode removeNode(String value, ListNode node) {
    ListNode next = node.getNext();
    if (node.getValue() == value) {
      node = new ListNode(next.getValue(), next);
    } else {
      removeNode(value, next);
    }
    
    return node;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line) {
    return removeNode(line, head);
  }

  public String allNodes(ListNode node) {
    if (node.getNext() == null) {
      return node.getValue();
    }
    return node.getValue() + " " + allNodes(node.getNext());
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues() {
    return allNodes(head);
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = new ListNode(null, null);
  }
}

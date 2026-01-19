package assignments;

public class assignments {

    // --- Array Section ---

    // Q1: Create a duplicate copy of an existing array
    public static int[] makeArrayCopy(int[] sourceArray) {
        if (sourceArray == null) return null;
        int[] destination = new int[sourceArray.length];
        // Manual copy to show understanding of array indexing
        for (int i = 0; i < sourceArray.length; i++) {
            destination[i] = sourceArray[i];
        }
        return destination;
    }

    // Q3: Filter out a specific value from an array and return a new one
    public static int[] excludeElement(int[] data, int valueToDiscard) {
        int validCount = 0;
        for (int item : data) {
            if (item != valueToDiscard) validCount++;
        }

        int[] filteredResult = new int[validCount];
        int index = 0;
        for (int item : data) {
            if (item != valueToDiscard) {
                filteredResult[index++] = item;
            }
        }
        return filteredResult;
    }

    // --- Linked List Section ---

    // Q5: Connect two separate linked lists together
    public static MyNode linkTwoLists(MyNode listA, MyNode listB) {
        if (listA == null) return listB;

        MyNode current = listA;
        // Traverse until the end of the first list
        while (current.next != null) {
            current = current.next;
        }
        // Link the tail of A to the head of B
        current.next = listB;
        return listA;
    }

    // Q7: Find the index of a value in a Singly Linked List
    public static int locateItem(MyNode head, int targetValue) {
        MyNode temp = head;
        int counter = 0;
        while (temp != null) {
            if (temp.value == targetValue) {
                return counter; // Item found at this position
            }
            temp = temp.next;
            counter++;
        }
        return -1; // Value not present in the list
    }

    // Q9: Delete a node at a particular index (Singly Linked List)
    public static MyNode deleteFromPosition(MyNode head, int targetIdx) {
        if (head == null) return null;

        // Handle removing the first node
        if (targetIdx == 0) return head.next;

        MyNode walker = head;
        for (int i = 0; walker != null && i < targetIdx - 1; i++) {
            walker = walker.next;
        }

        // If index is out of bounds or no node to delete
        if (walker == null || walker.next == null) return head;

        // Skip the node to delete it
        walker.next = walker.next.next;
        return head;
    }

    // Q11: Walk through a Doubly Linked List from back to front
    public static void displayBackwards(MyNode tailNode) {
        MyNode current = tailNode;
        System.out.print("Reverse Order: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.prev; // Move to the previous link
        }
        System.out.println();
    }

    // Q13: Add a new node into a Circular Linked List at a specific spot
    public static MyNode addIntoCircular(MyNode head, int newValue, int position) {
        MyNode entry = new MyNode(newValue);
        if (head == null) {
            entry.next = entry; // Point to itself
            return entry;
        }

        MyNode pointer = head;
        for (int i = 0; i < position - 1; i++) {
            pointer = pointer.next;
        }

        entry.next = pointer.next;
        pointer.next = entry;
        return head;
    }

    // Q15: Check if an element exists in a Circular Linked List
    public static boolean findInCircular(MyNode head, int searchKey) {
        if (head == null) return false;

        MyNode current = head;
        do {
            if (current.value == searchKey) return true;
            current = current.next;
        } while (current != head); // Stop when we return to the start

        return false;
    }
}

// Basic Node class for all list types
class MyNode {
    int value;
    MyNode next, prev;
    MyNode(int v) { this.value = v; }
}
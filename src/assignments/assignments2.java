package assignments;

import java.util.*;

public class assignments2 {

    // Q1: Method to reverse a string using a Stack structure
    public static String reverseText(String input) {
        if (input == null) return null;

        Stack<Character> charStack = new Stack<>();
        // Push all characters into the stack
        for (int i = 0; i < input.length(); i++) {
            charStack.push(input.charAt(i));
        }

        // Pop characters to reverse the order
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            result.append(charStack.pop());
        }
        return result.toString();
    }

    // Q2: Sort elements in a stack using an auxiliary stack
    public static Stack<Integer> sortElements(Stack<Integer> mainStack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!mainStack.isEmpty()) {
            // Take the top element
            int current = mainStack.pop();

            // Move elements back if they are greater than current
            while (!sortedStack.isEmpty() && sortedStack.peek() > current) {
                mainStack.push(sortedStack.pop());
            }
            sortedStack.push(current);
        }
        return sortedStack;
    }

    // Q3: Reverse the items inside a Queue using a Stack
    public static void flipQueue(Queue<Integer> myQueue) {
        Stack<Integer> helper = new Stack<>();

        // Move everything from queue to stack
        while (!myQueue.isEmpty()) {
            helper.push(myQueue.remove());
        }

        // Move everything back to queue (it will be reversed)
        while (!helper.isEmpty()) {
            myQueue.add(helper.pop());
        }
    }

    // Q4: Implementation of a Priority Queue (Smallest first)
    public static void runPriorityQueue() {
        // PriorityQueue in Java uses Min-Heap by default
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        pQueue.add(100);
        pQueue.add(20);
        pQueue.add(50);

        // This will remove and return the smallest item (20)
        System.out.println("Processing: " + pQueue.poll());
    }

    // Q5: Merge two already sorted queues into one
    public static Queue<Integer> combineSortedQueues(Queue<Integer> queueA, Queue<Integer> queueB) {
        Queue<Integer> finalQueue = new LinkedList<>();

        // Compare heads of both queues
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            if (queueA.peek() <= queueB.peek()) {
                finalQueue.add(queueA.poll());
            } else {
                finalQueue.add(queueB.poll());
            }
        }

        // If items are left in queueA
        while (!queueA.isEmpty()) {
            finalQueue.add(queueA.poll());
        }

        // If items are left in queueB
        while (!queueB.isEmpty()) {
            finalQueue.add(queueB.poll());
        }

        return finalQueue;
    }
}
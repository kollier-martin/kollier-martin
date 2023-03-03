package CodingChallenges.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublyLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    /**
     * Helper function to add a node to the list
     *
     * @param data integer value to add as a node
     */
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        tail.next = null;
        size++;
    }

    /**
     * Helper function to print all the nodes of doubly linked list
     *
     * @return list data as a String
     */
    public String printList() {

        String printedList = "";

        Node current = head;

        if (head == null) {
            System.out.println("Doubly linked list is empty");
        }

        while (current != null) {
            printedList = printedList.concat(String.valueOf(current.data)).concat(" ");
            current = current.next;
        }

        return printedList.trim();
    }

    /**
     * Helper Function for copying content of one doubly linked list to another doubly linked list
     *
     * @param list initialized list to copy values from
     */
    public void copyList(DoublyLinkedList list) {
        Node temp;
        temp = list.head;

        addNode(temp.getData());
        while (temp.next != null) {
            temp = temp.next;

            addNode(temp.getData());
        }
    }

    /**
     * Helper Function for create doubly linked list from input array
     *
     * @param inputArray integer array to add to the list
     */
    public void createDoublyLinkedList(int[] inputArray) {
        for (int j : inputArray) {
            addNode(j);
        }
    }

    @Getter
    @Setter
    public static class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}

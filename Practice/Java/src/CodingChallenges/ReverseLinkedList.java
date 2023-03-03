package CodingChallenges;

import CodingChallenges.Models.DoublyLinkedList;

import java.util.Random;

import static CodingChallenges.Models.DoublyLinkedList.Node;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Random random = new Random();
        DoublyLinkedList list = new DoublyLinkedList();

        for (int i = 0; i < 10; i++) {
            list.addNode(random.nextInt(200));
        }

        System.out.println("PREVIOUS LIST: " + list.printList());
        System.out.println("REVERSED LIST: " + reverseLinkedList(list));
    }

    public static String reverseLinkedList(DoublyLinkedList list) {
        Node top = list.getHead();
        Node prev = null;
        Node temp;

        while (top != null) {
            temp = top.getNext();
            top.setNext(prev);
            prev = top;
            top = temp;
        }

        list.setHead(prev);

        return list.printList();
    }
}


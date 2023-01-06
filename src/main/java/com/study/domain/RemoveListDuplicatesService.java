package com.study.domain;

import com.study.domain.model.LinkedList;

public class RemoveListDuplicatesService {

    // You've given the head of a Singly Linked List whose nodes are sorted by its values.
    // Write a function that returns a modified version of this list without the duplicates
    // Do not create a new list, modify the existing one respecting the ordering by value
    // Complexity 0(n) where n is the number o nodes in the linked list
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        var currentNode = linkedList;

        while (currentNode.next != null) {
            if (currentNode.value == currentNode.next.value) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }

        return linkedList;
    }
}

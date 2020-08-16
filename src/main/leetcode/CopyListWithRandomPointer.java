package main.leetcode;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        Node iter = head;
        Node newListHead = new Node(head.val);
        Node newListIter = newListHead;
        Map<Node,Node> table = new HashMap<>();
        while(iter!=null){
            table.put(iter, newListIter);
            if(iter.next != null)
                newListIter.next = new Node(iter.next.val);
            iter = iter.next;
            newListIter = newListIter.next;
        }

        iter = head;
        newListIter = newListHead;

        while(iter!=null){
            Node random = null;
            if(iter.random!=null)
                random = table.get(iter.random);
            newListIter.random = random;
            iter = iter.next;
            newListIter = newListIter.next;
        }

        return newListHead;
    }
}

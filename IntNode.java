/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlouie_hw_5_reversedlinkedlist;

/**
 *
 * @author Jocelyn Louie
 *
 * The IntNode class creates Int Nodes which have data and a link
 */
public class IntNode {

    private int data;
    private IntNode link;
    private int manyNodes;

    /**
     * @param initialData An integer
     * @param initialLink An IntNode link
     *
     */
    public IntNode(int initialData, IntNode initialLink) {
        data = initialData;
        link = initialLink;
        manyNodes = 0;
    }

    /**
     * @param element An integer
     *
     */
    public void addNodeAfter(int element) {
        link = new IntNode(element, link);
        manyNodes++;
    }

    /**
     * @return returns data
     *
     */
    public int getData() {
        return data;
    }

    /**
     * @return returns link
     *
     */
    public IntNode getLink() {
        return link;
    }

    /**
     * @param newLink must be an integer node in order to be linked
     *
     */
    public void setLink(IntNode newLink) {
        link = newLink;
    }

    /**
     * @param newData must be an integer
     *
     */
    public void setData(int newData) {
        data = newData;
    }

    /**
     * @param head a reference to the start of a linked list
     * @return returns an IntNode reference for the reversed list head
     *
     */
    public static IntNode reversed(IntNode head) {
        if (head.link == null) {
            return head;
        }
        IntNode reverse = reversed(head.link);
        head.link.link = head;
        head.link = null;
        return reverse;
    }

    /**
     * @param head a reference to the head of a linked list
     * @return returns the length of the linked list
     *
     */
    public static int listLength(IntNode head) {
        IntNode cursor;
        int answer = 0;
        for (cursor = head; cursor != null; cursor = cursor.link) {
            answer++;
        }
        return answer;
    }
    public int getValue(IntNode head){
        if(head == null) throw new IllegalArgumentException("List is empty");
        IntNode cursor = head;
        int n = listLength(cursor)/3;
        int target = -1;
        for(int i =0; i<=n;i++){
            System.out.println(cursor.data);
            if(i==n){
                target = cursor.data;
            }
        }
        return target;
    }
    
    public static IntNode listSearch(IntNode head, int target) {
        IntNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link) {
            if (target == cursor.data) {
                return cursor;
            }
        }
        return null;
    }

    public static IntNode listPosition(IntNode head, int position) {
        IntNode cursor;
        int i;
        if (position <= 0) {
            throw new IllegalArgumentException("Position is not positive");
        }

        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++) {
            cursor = cursor.link;
        }
        return cursor;
    }

    public static void sortedInsert(IntNode head, IntNode new_node) {
        IntNode current;

        /* Special case for head node */
        if (head == null || head.data >= new_node.data) {
            //inserting infront of head
            new_node.link = head;
            //resetting head to new node
            head = new_node;
        } else {

            /* Locate the node before point of insertion. */
            current = head;
            //inserting new node to the right of the current link
            while (current.link != null && current.link.data < new_node.data) current = current.link;
            
            //lnking new node to current one
            new_node.link = current.link;
            //linking current link to new node
            current.link = new_node;
        }
    }

    public static void deal(IntNode deck) {
        IntNode end = deck;
        IntNode prev = null;
        IntNode curr = deck;

        /* Get pointer to last Node */
        while (end.link != null) {
            end = end.link;
        }

        IntNode new_end = end;

        // Consider all odd nodes before getting first eve node
        while (curr.data % 2 != 0 && curr != end) {
            new_end.link = curr;
            curr = curr.link;
            new_end.link.link = null;
            new_end = new_end.link;
        }

        // do following steps only if there is an even node
        if (curr.data % 2 == 0) {
            deck = curr;

            // now curr points to first even node
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.link;
                } else {
                    /* Break the link between prev and curr*/
                    prev.link = curr.link;

                    /* Make next of curr as null */
                    curr.link = null;

                    /*Move curr to end */
                    new_end.link = curr;

                    /*Make curr as new end of list */
                    new_end = curr;

                    /*Update curr pointer */
                    curr = prev.link;
                }
            }
        } /* We have to set prev before executing rest of this code */ else {
            prev = curr;
        }

        if (new_end != end && end.data % 2 != 0) {
            prev.link = end.link;
            end.link = null;
            new_end.link = end;
        }
        System.out.println();
    }

    public static int countOccurance(int target, IntNode head) {
        int answer;
        IntNode cursor;

        answer = 0;
        cursor = IntNode.listSearch(head, target);
        while (cursor != null) {
            answer++;
            cursor = cursor.getLink();
            cursor = IntNode.listSearch(cursor, target);
        }
        return answer;
    }

    public static boolean remove(int target, IntNode head) {
        IntNode targetNode = IntNode.listSearch(head, target);

        if (targetNode == null) {
            return false;
        } else {
            targetNode.setData(head.getData());
            head = head.getLink();
            head.manyNodes--;
            return true;
        }
    }

    public static IntNode listCopy(IntNode source) {
        IntNode copyHead;
        IntNode copyTail;

        //empty list
        if (source == null) {
            return null;
        }

        //first node for newly created list
        copyHead = new IntNode(source.data, null);
        copyTail = copyHead;

        //rest of nodes for list
        while (source.link != null) {
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
        //head reference or new list
        return copyHead;
    }

    @Override
    public String toString() {
        return "IntNode{" + "data =" + data + ", link =" + link + '}';
    }

}//end of IntNode class

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
 * This program implements the IntNode class
 * which creates an integer linked list
 */
public class JLouie_HW_5_reversedLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IntNode head = new IntNode(11,null);
        IntNode mid1 = new IntNode(22,null);
        IntNode mid2 = new IntNode(33,null);
        IntNode mid3 = new IntNode(44,null);
        IntNode mid4 = new IntNode(55, null);
        IntNode mid5 = new IntNode(4, null);
        IntNode tail = new IntNode(66, null);
        
        //adding nodes to list
        head.setLink(mid1);
        mid1.setLink(mid2);
        mid2.setLink(mid3);
        mid3.setLink(mid4);
        mid4.setLink(mid5);
        mid5.setLink(tail);
        
        //normal case linked list
        System.out.println(head);
        System.out.println(head.getValue(head));
            
    }
    public static void listTailInsert(IntNode head, int entry){
        if(head==null)head = new IntNode(entry, null);
        for(IntNode cursor = head; cursor.getLink()!=null;cursor= cursor.getLink()){
            cursor.setLink() = new IntNode(entry,cursor.getLink());
        }
    }
    public static int product(IntNode head){
        if(head == null) return 1;
        IntNode cursor = head;
        int product = 1;
        while(cursor!=null){
            product *= cursor.getData();
            cursor = cursor.getLink();
        }
        return product;
    }
    
}

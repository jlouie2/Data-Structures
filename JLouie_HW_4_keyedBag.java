/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlouie_hw_4_keyedbag;

/**
 *
 * @author Jocelyn Louie
 *
 * A bag that stores string entries that have unique numeric keys
 */
public class JLouie_HW_4_keyedBag {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KeyedBag kb = new KeyedBag();
        try {
            //System.out.println("Insert: "+kb.insert());
            //System.out.println("Insert: "+kb.insert("hi", 22));
            System.out.println("Insert: "+kb.insert("hi", 22));
            System.out.println("Insert: "+kb.insert("aloha", 34));
            System.out.println("Insert: "+kb.insert("Hilo", 67));
            System.out.println("Insert: "+kb.insert("Oahu", 55));
            System.out.println("Insert: "+kb.insert("h", 1));
            System.out.println("Insert: "+kb.insert("kona", 100));
            System.out.println("Insert: "+kb.insert("Honolulu", 20000000));
            System.out.println("Insert: "+kb.insert("Kauai", 450));
            System.out.println("Insert: "+kb.insert("Maui", 256));
            System.out.println("Insert: "+kb.insert("Lanai", 2));
            System.out.println("Insert: "+kb.insert("Lihue", 5));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Pleae increase bag size");
        }catch (java.lang.RuntimeException e) {
            System.out.println("Please insert a compatible value and key");
        }
        System.out.println("In bag: "+kb.inBag(22));
        System.out.println("Retrieve: "+kb.retrieve(22));
        System.out.println("Remove: "+kb.remove(22));

    }

}

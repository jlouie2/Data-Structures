/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlouie_hw_2_statistician;

/**
 *
 * @author Jocelyn Louie
 * 
 * Prints out the values of the various
 * attributes of the Statistician Class
 */
public class JLouie_HW_2_Statistician {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statistician s1 = new Statistician();
        Statistician s2 = new Statistician();
        try{
            //normal case
            //s1.nextNumber(-0.8);
            //s1.nextNumber(1.1);
            //s1.nextNumber(2.4);
            //s1.nextNumber(-5.4);
            
            //s2.nextNumber(5.1);
            //s2.nextNumber(6.1);
            
            //empty list
            //s1.nextNumber();
            //s2.nextNumber();
            
            //the in-between value
            s1.nextNumber(9.25);
            s2.nextNumber(-1.0);
            
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The value that was entered is not a valid number");
        }catch (java.lang.RuntimeException e){
            System.out.println("The value that was entered is not a valid number");
        }
        
        
        System.out.println("The length of sequence 1 is: " + s1.lenOSeq() + ". The length of sequence 2 is: " + s2.lenOSeq());
        System.out.println("The last number in sequence 1 is: " + s1.lastNum() + ". The last number in sequence 2 is: " + s2.lastNum());
        System.out.println("The largest number in sequence 1 is: " + s1.largestNum() + ". The largest number in sequence 2 is: " + s2.largestNum());
        System.out.println("The smallest number in sequence 1 is: " + s1.smallestNum() + ". The smallest number in sequence 2 is: " + s2.smallestNum());
        System.out.println("The sum of sequence 1 is: " + s1.sumSeq() + ". The sum of sequence 2 is: " + s2.sumSeq());
        System.out.println("The average of sequence 1 is: " + s1.avgSeq() + ". The average of sequence 2 is: " + s2.avgSeq());
        System.out.println("Sum of 2 statisticians is: " + Statistician.add(s1,s2));
          
    }
    
}

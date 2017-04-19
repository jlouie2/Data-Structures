/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlouie_hw_2_statistician;


/**
 *Add numbers to a sequence and print out specific values like
 * length, sum, average, last number, smallest number, and largest number
 * 
 * @author Jocelyn Louie
 */
public class Statistician {
    private double min;
    private double max;
    private double sum;
    private double last;
    private int length;
   
    //constructor 
    public Statistician() {
        length = 0;
    }
    
    /**
     * @param num 
     * a digit or char, not a string
     * @precondition
     * Double.isNaN(num) == false
     **/
    public void nextNumber(double num){
        if(length==0){
            max = num;
            min = num;
            sum = num;
            last = num;
        }
        else{
            if(max<num)max=num;
            if(min>num)min=num;
            sum+=num;
            last = num;
        }
            length++;                 
    }
    
    /**
     * @return
     * length of sequence
     **/
    public int lenOSeq(){
        return length;
    }
    
    /**
     * @return
     * last number of sequence
     **/
    public double lastNum(){
        if(length==0)return Double.NaN;
        return last;
    }
    
    /**
     * @return
     * sum of sequence
     **/
    public double sumSeq(){
        return sum;
    }
    
    /**
     * @return
     * average of sequence
     **/
    public double avgSeq(){
        if(length==0)return Double.NaN;
        return sum/(double)length;
    }
    
    /**
     * @return
     * smallest number in sequence
     **/
    public double smallestNum(){
        if(length==0)return Double.NaN;
        return min;
    }
    
    /**
     * @return
     * largest number in sequence
     **/    
    public double largestNum(){
        if(length==0)return Double.NaN;
        return max;
    }
    
    /** @param s
     * Must be a Statistician object
     * 
     * transfers contents of one Statistician to another
    **/
    public void moveAll(Statistician s){
       if(s.length == 0){
            sum = s.sum;
            max = s.max;
            System.out.println("hi"+s.max+""+max);
            min = s.min;
            System.out.println("hi"+s.min+""+min);
            last = s.last;
        }
        else{
            sum += s.sum;
            if(max<s.max) max = s.max;
            if(min>s.min) min = s.min;
            last = s.last;
        }
        length += s.length;
    }
    
    /**
     * @param s1
     * Must be a Statistician object
     * * @param s2
     * Must be a Statistician object
     * @return
     * s3 Statistician that is the combination of the 2 Statistician's
     **/  
    public static Statistician add(Statistician s1, Statistician s2){
        if (s1.length == 0){
            System.out.println("Please add numbers to the sequence one");
        }
        else if (s2.length == 0){
            System.out.println("Please add numbers to the sequence two");
        }
        Statistician s3 = new Statistician();
        s3.moveAll(s1);
        s3.moveAll(s2);
        return s3;
    }

    /**
     * @return
     * String representation of Statistician object
     **/  
    @Override
    public String toString() {
        return "Statistician{" + "min=" + min + ", max=" + max + ", sum=" + sum + ", last=" + last + ", length=" + length + '}';
    }
    
}//end of Statistician Class

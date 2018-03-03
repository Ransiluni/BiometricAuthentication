/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Authentication;

import java.util.ArrayList;

/**
 *
 * @author Mushi
 */
public class Identifier{
    public Integer identify(Integer[] tempPress, Integer[] tempDiff, Integer[] storePress,Integer[] storeDiff,int i) {
        
        int pass = 0;
        for(int j = 0; j < storePress.length; j++) {
            
            //System.out.println(tempPress[j]);
            //System.out.println(storePress[j]+"size   "+storePress.length+"size   "+tempPress.length);
            if ((tempPress[j] - storePress[j] < 500) && (tempPress[j] - storePress[j] > -500)) {
                
                pass++;
                //System.out.println("pass in one"+pass);
            }
        }
       if(pass==storePress.length){
           //System.out.println("one pass");
           pass = 0;
           for(int j = 0; j < storeDiff.length; j++) {
               //System.out.println(tempDiff[j]);
               //System.out.println(storeDiff[j]+"size   "+storeDiff.length+tempDiff.length);
            if ((tempDiff[j] - storeDiff[j] < 500) && (tempDiff[j] - storeDiff[j] >-500)) {
                pass++;
                //System.out.println("pass in two"+pass);
            }
        }if(pass==storeDiff.length){
            //System.out.println("two pass");
            return i;
        }else{
            return i+1;
        }
       
       }else{
           return i+1;
       }
        
        
}
}

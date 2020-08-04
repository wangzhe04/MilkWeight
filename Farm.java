///////////////////////File Header///////////////////////////
//Author: Zhe Wang
//Email: zwang2428@wisc.edu
//Term: Summer2020
//Program purpose:This program create a GUI that allow user view 
//and edit data of milk weights of different farms
////////////////////////////////////////////////////////////
package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 * This class was only created for data example 
 * the actual farm class would vary
 * @author 87179
 *
 */

public class Farm {
    private String[] dateArray;
    private int [] milkWeight;
    private int index = 0;
    public int monthWeight = 12;
    //public final int sI;
    int size;
    String farmID;
    
    /**
     * This is the constructor of the farm class
     * 
     */
    public Farm() {
    	size = 100;
    	dateArray = new String [size];
    	milkWeight = new int[size];
    }

    /**
     * This is the method that adds the milkweight 
     * data of certain date
     * @param milk
     * @param date
     */
    public void add(int milk, String date) {
    	if(index == size ) {
    		String[] mediumD = new String[size*2];
    		int [] mediumM = new int [size*2];
    		for(int i = 0; i < index; i++) {
    			mediumD[i] = dateArray[i];
    			mediumM[i] = milkWeight [i];
    		}
    		dateArray = mediumD;
    		milkWeight = mediumM;
    		size = size*2;
    	}
    	milkWeight [index] = milk;
    	dateArray[index] = date;
    	index++;
    }
    
    /**
     * This method calculates the monthWeight of the farm
     * @param month
     * @param year
     * @return totalWeight - the total month weight
     */
    public int getMonthWeight(int month, int year) {
    	int totalWeight = 0;
    	if(month < 10) {
        	for(int i = 0; i < index; i++) {
        		if(dateArray[i].contains("-"+month+"-")//Character.getNumericValue(dateArray[i].charAt(5)) == month 
        				&& dateArray[i].contains(""+year)) { //get milkweight with month
        			totalWeight += milkWeight[i];
        		}else {
        			continue;
        		}
        	}
    	}else {
        	for(int i = 0; i < index; i++) {
        		if(dateArray[i].contains("-"+month+"-")//Integer.parseInt(dateArray[i].substring(5, 7)) == month 
        				&& dateArray[i].contains(""+year)) { //get milkweight with month
        			totalWeight += milkWeight[i];
        		}else {
        			continue;
        		}
        	}
    	}
    	return totalWeight;
    }
    /**
     * This method calculates the yearWeight of the farm
     * @param year
     * @return yearWeight - the year weight
     */
    public int getYearWeight(int year) {
    	int yearWeight = 0;
    	for(int i = 0; i < index; i++) {
    		if(dateArray[i].contains("" + year)) {
    			yearWeight += milkWeight[i];
    		}else {
    			continue;
    		}
    	}
    	return yearWeight;
    }
    public boolean containsDate(String date) {
    	for(int i = 0; i < index; i++) {
    		if(dateArray[i].equals(date)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void setDateWeight(String date, int weight) {
    	for(int i = 0; i < index; i++) {
    		if(dateArray[i].equals(date)) {
    			milkWeight[i] = weight;
    		}
    	}
    	
    }
    /**
     * This method calculates the selectDaysWeight of the farm
     * @param startD
     * @param endD
     * @return totalWeight - the total weight
     * @throws ParseException 
     */
    public int getDaysWeight(String startD, String endD) throws ParseException {
    	int startIndex = 0;
    	int endIndex = 0;
    	int totalWeight = 0;
    	int sI = 0;
    	int j = 0;
    	int eI = 0;
    	double k = 1;
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startD1 = format.parse(startD);
			Date endD1 = format.parse(endD);
    	
    	
    	for(int i = 0; i < index; i++) {
				Date currentD = format.parse(dateArray[i]);
				if(currentD.compareTo(startD1) >= 0) {
					if(sI == 0) {
					startIndex = i;
					sI++;
					}
				}
				
				if(currentD.compareTo(endD1) >= 0) {
					if(currentD.compareTo(endD1) == 0) {
						endIndex = i;
						break;
					}else {
					endIndex = i - 1;
					break;
					}
				}

    		/*if(dateArray[i].equals(startD)) {
    			//System.out.println(1);
    			startIndex = i;
    		}
    		if(dateArray[i].equals(endD)) {
    			endIndex = i;
    		}*/
    	}
    	for(int i = startIndex; i <= endIndex; i++) {
    		totalWeight += milkWeight[i];
    	}
    	//System.out.println(totalWeight);
    	return totalWeight;
    }
    
    /**
     * Calculates the similarity (a number within 0 and 1) between two strings.
     */
    /*public static double similarity(String s1, String s2) {
      String longer = s1, shorter = s2;
      if (s1.length() < s2.length()) { // longer should always have greater length
        longer = s2; shorter = s1;
      }
      int longerLength = longer.length();
      if (longerLength == 0) { return 1.0; /* both strings are zero length  }
      return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    }
    
    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
          int lastValue = i;
          for (int j = 0; j <= s2.length(); j++) {
            if (i == 0)
              costs[j] = j;
            else {
              if (j > 0) {
                int newValue = costs[j - 1];
                if (s1.charAt(i - 1) != s2.charAt(j - 1))
                  newValue = Math.min(Math.min(newValue, lastValue),
                      costs[j]) + 1;
                costs[j - 1] = lastValue;
                lastValue = newValue;
              }
            }
          }
          if (i > 0)
            costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
      }
    */
    
    /*public int getMonthWeight(String month, int year) {
    	if(month != "Oct" && month != "Nov" && month != "Dec") {
    	for(int i = 0; i < index; i++) {
    		if(dateArray[i].charAt(0))
    	}
    	}
    }*/
    
    /*private int getMonthHelper() {
    	
    }*/
    
}
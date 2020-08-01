///////////////////////File Header///////////////////////////
//Author: Zhe Wang
//Email: zwang2428@wisc.edu
//Term: Summer2020
//Program purpose:This program create a GUI that allow user view 
//and edit data of milk weights of different farms
////////////////////////////////////////////////////////////
package application;

/**
 * This class was only created for data example 
 * the actual farm class would vary
 * @author 87179
 *
 */

public class Farm {
    private String month = null;
    private int weight = 0;
    private double percentage = 0;
    private String[] dateArray;
    private int [] milkWeight;
    private int index = 0;
    int size;
    String farmID;
    
    public Farm() {
    	size = 100;
    	dateArray = new String [size];
    	milkWeight = new int[size];
    }
    //
    public Farm(String month, int weight, double d) {
     this.month = month;
     this.weight = weight;
     this.percentage = d;
    }
    
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
    
    /*public int getMonthWeight(String month, int year) {
    	if(month != "Oct" && month != "Nov" && month != "Dec") {
    	for(int i = 0; i < index; i++) {
    		if(dateArray[i].charAt(0))
    	}
    	}
    }*/
    
    /*private int getMonthHelper() {
    	
    }*/
    
    public String getMonth() {
     return month;
    }
    public String setMonth() {
     return month;
    }
    
    public int getWeight() {
     return weight;
    }
    public void setWeight(int weight) {
     this.weight = weight;
    }
    public double getPercentage() {
     return percentage;
    }
       
    public void setWeight2(double percentage) {
     this.percentage = percentage;
    }
}
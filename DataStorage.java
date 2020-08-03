package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**This DataStorage class uses hashmap <String, Farm> to 
 * store the farm information. 
 * 
 * @author Zhe Wang
 *
 */
public class DataStorage {
	public HashMap <String, Farm>dataStorage;
	/**
	 * This is the constructor of the DataStorage
	 */
	public DataStorage() {
		dataStorage = new HashMap(); 
	}
	
	/**
	 * This method inserts a new farm into the DataStorage
	 * @param farmID
	 * @param farm
	 */
	public void insert(String farmID, Farm farm) {
		dataStorage.put(farmID, farm);
	}
	/**
	 * this method get the farm with corressponding
	 * farmID
	 * @param farmID
	 * @return farm 
	 */
	public Farm get(String farmID) {
		return (Farm) dataStorage.get(farmID);
	}
	
	/**
	 * this method checks if the DataStorage 
	 * contains the farm
	 * @param farmID
	 * @return true if contains, false otherwise
	 */
	public boolean contains(String farmID) {
		return dataStorage.containsKey(farmID);
	}
	
	/**
	 * this method remove the corresponding farm
	 * @param farmID
	 * 
	 * @return true if successfully removed, false otherwise
	 */
	public boolean remove(String farmID) {
		if(contains(farmID)) {
			dataStorage.remove(farmID);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method calculate the total Month weight of 
	 * all farms of certain month 
	 * @param month
	 * @param year
	 * @return totalWeight
	 */
	public int getTotalMonthWeight(int month, int year) {
		int totalWeight = 0;
		for(Entry<String, Farm> entry: dataStorage.entrySet()) {
			totalWeight += entry.getValue().getMonthWeight(month, year);
		}
		return totalWeight;
	}
	
	/**
	 * This method calculate the total weight of all 
	 * farms of a specific year
	 * @param year
	 * @return totalYearWeight
	 */
	public int getTotalYearWeight(int year) {
		int totalWeight = 0;
		for(Entry<String, Farm> entry: dataStorage.entrySet()) {
			totalWeight += entry.getValue().getYearWeight(year);
		}
		return totalWeight;
	}
	
	/**
	 * This method calculate the total weight of all 
	 * farms of a select dates
	 * @param startD
	 * @param endD
	 * @return totalWeight
	 */
	public int getTotalDaysWeight(String startD, String endD) {
		int totalWeight = 0;
		for(Entry<String, Farm> entry: dataStorage.entrySet()) {
			totalWeight += entry.getValue().getDaysWeight(startD, endD);
		}
		return totalWeight;
	}
	
	/*public void addFile( DataStorage b) {
		for(Entry<String, Farm> entry: b.dataStorage.entrySet()) {
			 insert(((Entry<String, Farm>) entry).getKey(), ((Entry<String, Farm>) entry).getValue());
			//totalWeight += entry.getValue().getMonthWeight(month, year);
		}
	}*/
	

	Object entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}

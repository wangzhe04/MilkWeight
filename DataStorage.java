package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataStorage {
	public HashMap <String, Farm>dataStorage;
	public DataStorage() {
		dataStorage = new HashMap(); 
	}
	
	public void insert(String farmID, Farm farm) {
		dataStorage.put(farmID, farm);
	}
	
	public Farm get(String farmID) {
		return (Farm) dataStorage.get(farmID);
	}
	
	public boolean contains(String farmID) {
		return dataStorage.containsKey(farmID);
	}
	public boolean remove(String farmID) {
		if(contains(farmID)) {
			dataStorage.remove(farmID);
			return true;
		}else {
			return false;
		}
	}
	
	public int getTotalMonthWeight(int month, int year) {
		int totalWeight = 0;
		for(Entry<String, Farm> entry: dataStorage.entrySet()) {
			totalWeight += entry.getValue().getMonthWeight(month, year);
		}
		return totalWeight;
	}
	
	public int getTotalYearWeight(int year) {
		int totalWeight = 0;
		for(Entry<String, Farm> entry: dataStorage.entrySet()) {
			totalWeight += entry.getValue().getYearWeight(year);
		}
		return totalWeight;
	}
	
	public void addFile( DataStorage b) {
		for(Entry<String, Farm> entry: b.dataStorage.entrySet()) {
			 insert(((Entry<String, Farm>) entry).getKey(), ((Entry<String, Farm>) entry).getValue());
			//totalWeight += entry.getValue().getMonthWeight(month, year);
		}
	}
	

	Object entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}

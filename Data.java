package application;

import java.util.Map.Entry;

public class Data {
	private int monthWeight = 0;
	private int yearWeight = 0;
	private String farmID = "";
    private double percentage = 0;
	public Data(String farmID, int monthWeight, double percentage) {
		this.monthWeight = monthWeight;
		this.percentage = percentage;
		this.farmID = farmID;
	}
	
	public Data( int yearWeight, String farmID, double percentage) {
		this.yearWeight = yearWeight;
		this.percentage = percentage;
		this.farmID = farmID;
	}
	
	public Data(Entry<String, Farm> entry) {
		// TODO Auto-generated constructor stub
	}

	public int getMonthWeight() {
		return this.monthWeight;
	}
	
	public String getFarmID() {
		return this.farmID;
	}
	
	public String getPercentage() {
		return "" + this.percentage *100 + "%";
	}
	
	public int getYearWeight() {
		return this.yearWeight;
	}

}

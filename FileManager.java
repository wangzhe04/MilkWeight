///////////////////////File Header///////////////////////////
//Author: Zhe Wang
//Email: zwang2428@wisc.edu
//Term: Summer2020
////////////////////////////////////////////////////////////
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * This class read in and add file into the dataStorage
 * @author Zhe Wang
 *
 */
public class FileManager {
	public Stage primaryStage;
	DataStorage a;
	public FileManager(File file, DataStorage a) throws IOException, NumberFormatException {
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null){
			String[] array = line.split(",");
			System.out.println(array[0]);
			
			if(array[0].contains("/")) {
				try {
					//System.out.println(array[0]);
					String start_dt = "2011-01-01";
					DateFormat formatter = new SimpleDateFormat("M/DD/yyyy"); 
					Date date = (Date)formatter.parse(array[0]);
					SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-M-DD");
					array[0] = newFormat.format(date);
					//System.out.println(array[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					continue;
				}
				
			}
			
			if(array[2].equals("weight"))
					continue;
			if(a.contains(array[1])) {
				a.get(array[1]).add(Integer.parseInt(array[2]), array[0]);
			}else {
				Farm newFarm = new Farm();
				newFarm.add(Integer.parseInt(array[2]), array[0]);
				a.insert(array[1], newFarm);
			}
		}
	}

	public DataStorage getStorage() {
		return this.a;
	}
	
	private static final SimpleDateFormat sdf = 
            new SimpleDateFormat("yyyy-MM-dd");

}
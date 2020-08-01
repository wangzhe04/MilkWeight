package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FileManager {
	public Stage primaryStage;
	DataStorage a;
	public FileManager(File file, DataStorage a) throws IOException {
		try {
		//a = new DataStorage();
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null){
			String[] array = line.split(",");
			if(array[2].equals("weight"))
					continue;
			if(a.contains(array[1])) {
				a.get(array[1]).add(Integer.parseInt(array[2]), array[0]);
			}else {
				Farm newFarm = new Farm();
				newFarm.add(Integer.parseInt(array[2]), array[0]);
				a.insert(array[1], newFarm);
			}
			//System.out.println(array[0]);
		}
		}catch(Exception e) {
			//a = new DataStorage();
			System.out.println("Invalid File Input");
		}
	}
	
	/*public void addFile( File file) {
		try {
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((line = br.readLine()) != null){
			String[] array = line.split(",");
			if(array[2].equals("weight"))
					continue;
			if(a.contains(array[1])) {
				a.get(array[1]).add(Integer.parseInt(array[2]), array[0]);
			}else {
				Farm newFarm = new Farm();
				newFarm.add(Integer.parseInt(array[2]), array[0]);
				a.insert(array[1], newFarm);
			}
			System.out.println(array[1]);
		}
		}catch(Exception e) {
			a = new DataStorage();
			System.out.println("Invalid File Input");
		}
	}*/ 
	
	/*public void invalidInput(Stage primaryStage) {
		Label invalidIn = new Label("Invalid Input ");
		Pane root = new Pane(invalidIn);
		root.getChildren().add(invalidIn);
		invalidIn.relocate(180, 180);
		Scene mainScene = new Scene(root, 600, 400);
		System.out.println("Invalid inputs");
    	primaryStage.setScene(mainScene);
    	primaryStage.show();
	}*/
	public DataStorage getStorage() {
		return this.a;
	}

}

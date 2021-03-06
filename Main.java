///////////////////////File Header///////////////////////////
//Author: Zhe Wang
//Email: zwang2428@wisc.edu
//Term: Summer2020
//Program purpose:This program create a GUI that allow user view 
//and edit data of milk weights of different farms
////////////////////////////////////////////////////////////
package application;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

/**
 * This class Main extends class applicatoin
 * @author Zhe Wang
 *
 */
public class Main extends Application {
	// store any command-line arguments that were entered.
	// NOTE: this.getParameters().getRaw() will get these also
	private List<String> args;

	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;
	private static final String APP_TITLE = "Milk Weight";
	private static final String Months[] = {"Jan", "Mar", "Apr", "May", "June","July", 
			"Aug", "Sep", "Oct", "Nov", "Dec"};
	private static DataStorage dataStorage = new DataStorage();
	DataStorage dataStorage1 = new DataStorage();


	@Override
	/*
	 * This method create the starter Gui that user can interact
	 * with
	 * 
	 * @param primaryStage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void start(Stage primaryStage) throws Exception {
		// save args example
		args = this.getParameters().getRaw();
		
		//title of the pane
		Label title = new Label("Milk Weight");
		title.relocate(270, 10);
		
		//add the photo of farm
		Image farmPicture = new Image(new FileInputStream("farm.jpg"));
		ImageView farmView = new ImageView(farmPicture);	
		farmView.setX(235);
		farmView.setY(30);
		farmView.setFitHeight(120);
		farmView.setFitWidth(400);
		farmView.setPreserveRatio(true);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        // create and add buttons to the starter GUI
        	Button farmReport = new Button("Farm Report");
        	Button monthlyReport = new Button("Monthly Report");
        	Button annualReport = new Button("Annual Report");
        	Button selectDateReport = new Button("Select Date Report");
        	Button edit = new Button("Edit");
        	Button exit = new Button("Exit");
        	Label tip = new Label("Please Enter farmID, month, year as integers" 
        	+"\n and Date in the form as year-month-date");
        	
        	root.getChildren().add(farmReport);
        	root.getChildren().add(monthlyReport);
        	root.getChildren().add(annualReport);
        	root.getChildren().add(selectDateReport);
        	root.getChildren().add(edit);
        	root.getChildren().add(exit);
        	root.getChildren().add(tip);
        	
        	farmReport.relocate(190, 160);
        	monthlyReport.relocate(320, 160);
        	annualReport.relocate(190, 220);
        	selectDateReport.relocate(320, 220);
        	edit.relocate(280, 265);
        	exit.relocate(560, 370);
        //add the image to the root	
            root.getChildren().add(farmView);
        //action events
            EventHandler<ActionEvent> farmReportEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						farmReport(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            
            EventHandler<ActionEvent> monthlyReportEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						monthlyReport(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            
            EventHandler<ActionEvent> annualReportEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						annualReport(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            
            EventHandler<ActionEvent> selectDateReportEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						selectDateReport(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            
            EventHandler<ActionEvent> editEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						edit(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            
            EventHandler<ActionEvent> exitEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            farmReport.setOnAction(farmReportEvent);
            monthlyReport.setOnAction(monthlyReportEvent);
            annualReport.setOnAction(annualReportEvent);
            selectDateReport.setOnAction(selectDateReportEvent);
            edit.setOnAction(editEvent);
            exit.setOnAction(exitEvent);

		Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

		// Add the stuff and set the primary stage
        	primaryStage.setTitle(APP_TITLE);
        	primaryStage.setScene(mainScene);
        	primaryStage.show();
	}
	
	/*
	 * This method is create the GUI that user chose farm Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void farmReport(Stage stage) throws Exception{
		
		//title of the pane
			Label title = new Label("Farm Report");
			title.relocate(270, 10);
		//add the photo of farm
			Image farmPicture = new Image(new FileInputStream("farm.jpg"));
			ImageView farmView = new ImageView(farmPicture);	
			farmView.setX(235);
			farmView.setY(30);
			farmView.setFitHeight(120);
			farmView.setFitWidth(400);
			farmView.setPreserveRatio(true);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	// add the labels to the root
        	Label farmID = new Label("Please Enter FarmID: ");
        	Label year = new Label("Please Enter Year: ");
        	
        	root.getChildren().add(farmID);
        	root.getChildren().add(year);
        	farmID.relocate(180, 180);
        	year.relocate(180, 220);
        	
        	//add Text fields to the root
        	TextField ID = new TextField();
        	TextField y = new TextField();        	
        	root.getChildren().add(ID);
        	root.getChildren().add(y);        	
        	ID.relocate(300, 180);
        	y.relocate(300, 220);
        	
        	//add buttons to the root
        	Button con = new Button("Continue");
        	root.getChildren().add(con);
        	con.relocate(270, 265);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	//Continue Event
        	EventHandler<ActionEvent> continueEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						if(ID.getText().isEmpty()|| y.getText().isEmpty()) {
							Label noInput = new Label ("Must enter all information correctly");
							root.getChildren().add(noInput);
							noInput.relocate(215, 300);
						}else {
							if(!dataStorage.contains("Farm " +ID.getText())) {
								System.out.println("Missing File");
							}
							FarmTable(stage, ID.getText(), Integer.parseInt(y.getText()));
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Label noInput = new Label ("Missing File");
						root.getChildren().add(noInput);
						noInput.relocate(215, 300);
						//e1.printStackTrace();
					}
                } 
            };
            con.setOnAction(continueEvent);
        	//back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						start(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            root.getChildren().add(farmView);
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();

	}
	private Label labelCreater(String farmID, int year, int month) {
		String month1 = "";
		switch(month) {
		case 6: month1 = "June";
		break;
		case 7: month1 = "July";
		break;
		case 8: month1 = "August";
		break;
		case 9: month1 = "September";
		break;
		case 10: month1 = "October";
		break;
		case 11: month1 = "November";
		break;
		case 12: month1 = "December";
		break;
			
		}
		Label a = new Label(""+month1+" weight: " + dataStorage.get("Farm " +farmID).getMonthWeight(month, year)+
    			"kg, Percentage: "+
    			(double)dataStorage.get("Farm " +farmID).getMonthWeight(month, year)/dataStorage.getTotalMonthWeight(month, year)*100 + "%");
		return a;
	}
	
	/*
	 * This method is create the GUI that user click continue in farm Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void FarmTable(Stage stage, String farmID, int year) throws Exception{
        
    	Pane root = new Pane();
    	
    	//add labels of minimum, maximum and average
    	//for(Map.Entry<String, Farm> entry: (dataStorage).entrySet())
    	Label feb = new Label("Feburary weight: "+dataStorage.get("Farm " + farmID ).getMonthWeight(2, year)+
    			"kg, Percentage: "+
    			(double)dataStorage.get("Farm " +farmID).getMonthWeight(2, year)/dataStorage.getTotalMonthWeight(2, year)*100 + "%");
    	//dataStorage.get(farmID).getMonthWeight(2, year)/dataStorage.getTotalMonthWeight(2, year) +", "+ dataStorage.getTotalMonthWeight(2, year)
    	Label jan = new Label("January weight: "+dataStorage.get("Farm " + farmID ).getMonthWeight(1, year)+
    			"kg, Percentage: "+
    			(double)dataStorage.get("Farm " +farmID).getMonthWeight(1, year)/dataStorage.getTotalMonthWeight(1, year)*100 + "%");
    	Label mar = new Label("March weight: "+dataStorage.get("Farm " + farmID ).getMonthWeight(3, year)+
    			"kg, Percentage: "+
    			(double)dataStorage.get("Farm " +farmID).getMonthWeight(3, year)/dataStorage.getTotalMonthWeight(3, year)*100 + "%");
    	
    	Label apr = new Label("April weight: "+dataStorage.get("Farm " + farmID ).getMonthWeight(4, year)+
    			"kg, Percentage: "+
    			(double)dataStorage.get("Farm " +farmID).getMonthWeight(4, year)/dataStorage.getTotalMonthWeight(4, year)*100 + "%");
    	Label may = new Label("May weight: "+dataStorage.get("Farm " + farmID ).getMonthWeight(5, year)+
    			"kg, Percentage: "+
    			(double)dataStorage.get("Farm " +farmID).getMonthWeight(5, year)/dataStorage.getTotalMonthWeight(5, year)*100 + "%");
    	Label june = labelCreater(farmID, year, 6);
    	Label july = labelCreater(farmID, year, 7);
    	Label aug = labelCreater(farmID, year, 8);
    	Label sep = labelCreater(farmID, year, 9);
    	Label oct = labelCreater(farmID, year, 10);
    	Label nov = labelCreater(farmID, year, 11);
    	
    	Label dec = new Label("December weight: "+dataStorage.get("Farm " + farmID ).getMonthWeight(12, year)+
    			"kg, Percentage: "+
    			(double)dataStorage.get("Farm " +farmID).getMonthWeight(12, year)/dataStorage.getTotalMonthWeight(12, year)*100 + "%");
    	
    	int max = 0;
    	int min = Integer.MAX_VALUE;
    	double average = 0;
    	int totalWeight = 0;
    	int i = 0;
    	for(int j = 1; j<=12; j++ ) {
    		if(dataStorage.get("Farm " + farmID ).getMonthWeight(j, year) > max) {
    			max = dataStorage.get("Farm " + farmID ).getMonthWeight(j, year);
    		}
    		if(dataStorage.get("Farm " + farmID ).getMonthWeight(j, year) < min) {
    			min = dataStorage.get("Farm " + farmID ).getMonthWeight(j, year);
    		}
    		totalWeight += dataStorage.get("Farm " + farmID ).getMonthWeight(j, year);
    		if(dataStorage.get("Farm " + farmID ).getMonthWeight(j, year)!= 0)
    		i++;
    	}
    	if (min == Integer.MAX_VALUE) {
    		min = 0;
    	}
    	 average = totalWeight/i; 
    	/*for(Entry<String, Farm> entry: dataStorage.dataStorage.entrySet()) {
        	i++;
        	if(((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year) > max) {
        		max = ((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year);
        	}
        	if(((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year) < min) {
        		min = ((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year);
        	}
        }*/
    	Label maxi = new Label("Maximum month weight: " + max);
    	Label mini = new Label("Minimum month weight: " + min);
    	Label avg = new Label("Average month weight: " + average);
    	
    	root.getChildren().add(maxi);
    	root.getChildren().add(mini);
    	root.getChildren().add(avg);
    	
    	root.getChildren().add(feb);
    	root.getChildren().add(jan);
    	root.getChildren().add(mar);
    	root.getChildren().add(apr);
    	root.getChildren().add(may);
    	root.getChildren().add(june);
    	root.getChildren().add(july);
    	root.getChildren().add(aug);
    	root.getChildren().add(sep);
    	root.getChildren().add(oct);
    	root.getChildren().add(nov);
    	root.getChildren().add(dec);
    	
    	feb.relocate(30, 40);
    	jan.relocate(30, 10);
    	mar.relocate(30, 70);
    	apr.relocate(30, 100);
    	may.relocate(30, 130);
    	june.relocate(30, 160);
    	july.relocate(30, 190);
    	aug.relocate(30, 220);
    	sep.relocate(30, 250);
    	oct.relocate(30, 280);
    	nov.relocate(30, 310);
    	dec.relocate(30, 340);
    	
    	maxi.relocate(300, 40);
    	mini.relocate(300, 60);
    	avg.relocate(300, 80);
    	
    	//add buttons to the root
    	Button back = new Button("Back");
    	root.getChildren().add(back);
    	back.relocate(0, 370);   	
    	//back event
    	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                 try {
					farmReport(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        };
        back.setOnAction(startEvent);
    	
		// Add the stuff and set the primary stage
        Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    	stage.setTitle("Farm " + farmID);
    	stage.setScene(mainScene);
    	stage.show();
	}
	
	/*
	 * This method is create the GUI that user chose monthly Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void monthlyReport(Stage stage) throws Exception{
		//title of the pane
			Label title = new Label("Monthly Report");
			title.relocate(270, 10);
		//add the photo of farm
			Image farmPicture = new Image(new FileInputStream("farm.jpg"));
			ImageView farmView = new ImageView(farmPicture);	
			farmView.setX(235);
			farmView.setY(30);
			farmView.setFitHeight(120);
			farmView.setFitWidth(400);
			farmView.setPreserveRatio(true);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	// add the labels to the root
        	Label month = new Label("Please Enter Month: ");
        	Label year = new Label("Please Enter Year: ");
        	
        	root.getChildren().add(month);
        	root.getChildren().add(year);
        	month.relocate(180, 180);
        	year.relocate(180, 220);
        	
        	//add Text fields to the root
        	TextField m = new TextField();
        	TextField y = new TextField();        
        	//ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(Months));
        	//root.getChildren().add(combo_box);
        	//combo_box.relocate(300, 180);
        	root.getChildren().add(m);
        	root.getChildren().add(y);        	
        	m.relocate(300, 180);
        	y.relocate(300, 220);
        	
        	//add buttons to the root
        	Button con = new Button("Continue");
        	root.getChildren().add(con);
        	con.relocate(270, 265);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	//continue event
        	EventHandler<ActionEvent> monthlyReportTableEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						monthlyReportTable(stage, Integer.parseInt(m.getText()),Integer.parseInt(y.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Label a = new Label("Please enter all inputs as integers");
						root.getChildren().add(a);
						a.relocate(220, 295);
						//System.out.println("Please enter all inputs with valid integer numbers");
						//e1.printStackTrace();
					}
                } 
            };
            con.setOnAction(monthlyReportTableEvent);
        	//back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						start(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            root.getChildren().add(farmView);
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();

	}
	
	/*
	 * This method is create the GUI that user click continue in monthly Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void monthlyReportTable (Stage stage, int month, int year) {
		TableView table = new TableView();
		table.setEditable(true);
		 
        TableColumn<String, Data> monthColumn = new TableColumn<>("Farm ID");
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("farmID"));
        
        TableColumn<String, Data> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("monthWeight"));
        
        TableColumn<String, Data> percentageColumn = new TableColumn<>("Percentage");
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        
        table.getColumns().add(monthColumn);
        table.getColumns().add(weightColumn);
        table.getColumns().add(percentageColumn);
        
        int i = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(Entry<String, Farm> entry: dataStorage.dataStorage.entrySet()) {
        	table.getItems().add(new Data(((Entry<String, Farm>) entry).getKey(),
        			((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year),
        			(double)((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year)/dataStorage.getTotalMonthWeight(month, year)));
        	i++;
        	if(((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year) > max) {
        		max = ((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year);
        	}
        	if(((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year) < min) {
        		min = ((Entry<String, Farm>) entry).getValue().getMonthWeight(month, year);
        	}
        }
    	if (min == Integer.MAX_VALUE) {
    		min = 0;
    	}
        
        double average = (double)dataStorage.getTotalMonthWeight(month, year)/i;
        
        //table.getItems().add(new Data("42", 20, 0.3));
        
        //Iterator it = dataStorage.entrySet().iterator();
        
        //table.getItems().add(new Farm("01", 20, 0.2));
        //dataStorage.get("Farm 42").monthWeight = dataStorage.get("Farm 42").getMonthWeight(2, 2019);
       
       // table.getItems().add(dataStorage.get("Farm 42"));
        //table.getItems().add(new Farm("02", 30, 0.3));
        //table.getItems().add(new Farm("03", 10, 0.1));
        VBox vbox = new VBox(table);
        
    	Pane root = new Pane();
    	root.getChildren().add(vbox);
    	vbox.relocate(350, 0);
    	
    	//add labels of minimum, maximum and average
    	Label mini = new Label("Minimun: " + min);
    	//Label min = new Label("Minimun: " + dataStorage.get("Farm 42").getMonthWeight(2, 2019));
    	Label maxi= new Label("Maximum: " + max);
    	Label avg = new Label("Average: " + average +"\n\n click titles to sort(ascending/descending)");
    	
    	root.getChildren().add(mini);
    	root.getChildren().add(maxi);
    	root.getChildren().add(avg);
    	
    	mini.relocate(30, 50);
    	maxi.relocate(30, 10);
    	avg.relocate(30, 90);
    	//add buttons to the root
    	Button back = new Button("Back");
    	root.getChildren().add(back);
    	back.relocate(0, 350);   	
    	//back event
    	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                 try {
					monthlyReport(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        };
        back.setOnAction(startEvent);
    	
		// Add the stuff and set the primary stage
        Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    	stage.setTitle("Monthly Report");
    	stage.setScene(mainScene);
    	stage.show();
	}
	
	/*
	 * This method is create the GUI that user chose annual Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void annualReport(Stage stage) throws Exception{
		//title of the pane
			Label title = new Label("Annual Report");
			title.relocate(270, 10);
		//add the photo of farm
			Image farmPicture = new Image(new FileInputStream("farm.jpg"));
			ImageView farmView = new ImageView(farmPicture);	
			farmView.setX(235);
			farmView.setY(30);
			farmView.setFitHeight(120);
			farmView.setFitWidth(400);
			farmView.setPreserveRatio(true);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	// add the labels to the root
        	//Label month = new Label("Please Enter Month: ");
        	Label year = new Label("Please Enter Year: ");
        	
        	//root.getChildren().add(month);
        	root.getChildren().add(year);
        	//month.relocate(180, 180);
        	year.relocate(180, 220);
        	
        	//add Text field to the root
        	TextField y = new TextField();        	
        	root.getChildren().add(y);        	
        	y.relocate(300, 220);
        	
        	//add buttons to the root
        	Button con = new Button("Continue");
        	root.getChildren().add(con);
        	con.relocate(270, 265);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	//continue event
        	EventHandler<ActionEvent> annualReportTableEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						annualReportTable(stage, Integer.parseInt(y.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Label a = new Label("Please enter all inputs as integers");
						root.getChildren().add(a);
						a.relocate(220, 295);
						//System.out.println("Please enter all inputs as integers");
					}
                } 
            };
            con.setOnAction(annualReportTableEvent);
        	//back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						start(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            root.getChildren().add(farmView);
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();

	}
	
	/*
	 * This method is create the GUI that user click continue in annual Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void annualReportTable (Stage stage, int year) {
		TableView table = new TableView();
		table.setEditable(true);
		 
        TableColumn<String, Data> monthColumn = new TableColumn<>("Farm ID");
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("farmID"));
        
        TableColumn<String, Data> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("yearWeight"));
        
        TableColumn<String, Data> percentageColumn = new TableColumn<>("Percentage");
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        
        table.getColumns().add(monthColumn);
        table.getColumns().add(weightColumn);
        table.getColumns().add(percentageColumn);
        int max = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for(Entry<String, Farm> entry: dataStorage.dataStorage.entrySet()) {
        	table.getItems().add(new Data(((Entry<String, Farm>) entry).getValue().getYearWeight(year),
        					((Entry<String, Farm>) entry).getKey(),
        			(double)((Entry<String, Farm>) entry).getValue().getYearWeight( year)/dataStorage.getTotalYearWeight(year)));
        	i++;
        	if(((Entry<String, Farm>) entry).getValue().getYearWeight(year) > max) {
        		max = ((Entry<String, Farm>) entry).getValue().getYearWeight(year);
        	}
        	if(((Entry<String, Farm>) entry).getValue().getYearWeight(year) < min) {
        		min = ((Entry<String, Farm>) entry).getValue().getYearWeight(year);
        	}
        }
    	if (min == Integer.MAX_VALUE) {
    		min = 0;
    	}
        double average = (double)dataStorage.getTotalYearWeight(year)/i;
        
        VBox vbox = new VBox(table);
        
    	Pane root = new Pane();
    	root.getChildren().add(vbox);
    	vbox.relocate(350, 0);
    	
    	//add labels of minimum, maximum and average
    	Label mini = new Label("Minimun: " + min);
    	Label maxi = new Label("Maximum: " + max);
    	Label avg = new Label("Average: " + average+"\n\n click titles to sort(ascending/descending)");
    	
    	root.getChildren().add(mini);
    	root.getChildren().add(maxi);
    	root.getChildren().add(avg);
    	
    	mini.relocate(30, 50);
    	maxi.relocate(30, 10);
    	avg.relocate(30, 90);
    	//add buttons to the root
    	Button back = new Button("Back");
    	root.getChildren().add(back);
    	back.relocate(0, 350);   	
    	//back event
    	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                 try {
					annualReport(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        };
        back.setOnAction(startEvent);
    	
		// Add the stuff and set the primary stage
        Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    	stage.setTitle("Annual Report");
    	stage.setScene(mainScene);
    	stage.show();
	}
	
	/*
	 * This method is create the GUI that user chose select Date Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void selectDateReport(Stage stage) throws Exception{
		//title of the pane
			Label title = new Label("Select Date Report");
			title.relocate(270, 10);
		//add the photo of farm
			Image farmPicture = new Image(new FileInputStream("farm.jpg"));
			ImageView farmView = new ImageView(farmPicture);	
			farmView.setX(235);
			farmView.setY(30);
			farmView.setFitHeight(120);
			farmView.setFitWidth(400);
			farmView.setPreserveRatio(true);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	// add the labels to the root
        	Label farmID = new Label("Please Enter Start Date: ");
        	Label year = new Label("Please Enter End Date: ");
        	Label format = new Label("Date Format: year-month-date, eg. 2019-2-15");
        	
        	root.getChildren().add(farmID);
        	root.getChildren().add(year);
        	root.getChildren().add(format);
        	farmID.relocate(175, 180);
        	year.relocate(180, 220);
        	format.relocate(200, 250);
        	
        	//add Text fields to the root
        	TextField ID = new TextField();
        	TextField y = new TextField();        	
        	root.getChildren().add(ID);
        	root.getChildren().add(y);        	
        	ID.relocate(300, 180);
        	y.relocate(300, 220);
        	
        	//add buttons to the root
        	Button con = new Button("Continue");
        	root.getChildren().add(con);
        	con.relocate(270, 265);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	//continue event
        	EventHandler<ActionEvent> selectDateReportTableEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
                    	 dateTable(stage, ID.getText(), y.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Label a = new Label("Invalid Date Format");
						root.getChildren().add(a);
						a.relocate(260, 300);
					}
                } 
            };
            con.setOnAction(selectDateReportTableEvent);
        	//back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						start(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            root.getChildren().add(farmView);
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();
	}
	
	/*
	 * This method is create the GUI that user click continue in select Date Report
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void dateTable(Stage stage, String startD, String endD) throws Exception {
		TableView table = new TableView();
		table.setEditable(true);
		 
        TableColumn<String, Data> monthColumn = new TableColumn<>("Farm ID");
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("farmID"));
        
        TableColumn<String, Data> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        
        TableColumn<String, Data> percentageColumn = new TableColumn<>("Percentage");
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        
        table.getColumns().add(monthColumn);
        table.getColumns().add(weightColumn);
        table.getColumns().add(percentageColumn);
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for(Entry<String, Farm> entry: dataStorage.dataStorage.entrySet()) {
        	table.getItems().add(new Data(((Entry<String, Farm>) entry).getValue().getDaysWeight(startD, endD),
        			(double)((Entry<String, Farm>) entry).getValue().getDaysWeight(startD, endD)/dataStorage.getTotalDaysWeight(startD, endD),
        			((Entry<String, Farm>) entry).getKey()));
        	i++;
        	if(((Entry<String, Farm>) entry).getValue().getDaysWeight(startD, endD) > max) {
        		max = ((Entry<String, Farm>) entry).getValue().getDaysWeight(startD, endD);
        	}
        	if(((Entry<String, Farm>) entry).getValue().getDaysWeight(startD, endD) < min) {
        		min = ((Entry<String, Farm>) entry).getValue().getDaysWeight(startD, endD);
        	}
        }
    	if (min == Integer.MAX_VALUE) {
    		min = 0;
    	}
        double average = (double)dataStorage.getTotalDaysWeight(startD, endD)/i;
        
        VBox vbox = new VBox(table);
        
    	Pane root = new Pane();
    	root.getChildren().add(vbox);
    	vbox.relocate(350, 0);
    	
    	//add labels of minimum, maximum and average
    	Label mini = new Label("Minimun: " + min);
    	Label maxi = new Label("Maximum: " + max);
    	Label avg = new Label("Average: " + average +"\n\n click titles to sort(ascending/descending)");
    	
    	root.getChildren().add(mini);
    	root.getChildren().add(maxi);
    	root.getChildren().add(avg);
    	
    	mini.relocate(30, 50);
    	maxi.relocate(30, 10);
    	avg.relocate(30, 90);
    	//add buttons to the root
    	Button back = new Button("Back");
    	root.getChildren().add(back);
    	back.relocate(0, 350);   	
    	//back event
    	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                 try {
					selectDateReport(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        };
        back.setOnAction(startEvent);
    	
		// Add the stuff and set the primary stage
        Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    	stage.setTitle(APP_TITLE);
    	stage.setScene(mainScene);
    	stage.show();
	}
	
	/*
	 * This method is create the GUI that user chose Edit
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void edit(Stage stage) throws Exception{
		FileChooser fileChooser = new FileChooser();
		//title of the pane
			Label title = new Label("Edit");
			title.relocate(270, 10);
		//add the photo of farm
			Image farmPicture = new Image(new FileInputStream("farm.jpg"));
			ImageView farmView = new ImageView(farmPicture);	
			farmView.setX(235);
			farmView.setY(30);
			farmView.setFitHeight(120);
			farmView.setFitWidth(400);
			farmView.setPreserveRatio(true);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	//add buttons to the root
        	Button addFiles = new Button("Add Files");
        	root.getChildren().add(addFiles);
        	addFiles.relocate(180, 180);
        	
        	Button addRFarm = new Button("Add/Remove Farm");
        	root.getChildren().add(addRFarm);
        	addRFarm.relocate(300, 180);
        	
        	Button editFarm = new Button("Edit Specific Farm Data");
        	root.getChildren().add(editFarm);
        	editFarm.relocate(220, 265);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	 
        	// Add File
        	EventHandler<ActionEvent> addFileEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
                    	
                    	 dataStorage1 = dataStorage;
                    	 File file = fileChooser.showOpenDialog(null);
                    	 if(file != null) {
                    		FileManager a = new FileManager(file, dataStorage);
                    		//dataStorage.addFile(a.getStorage());
                    		//dataStorage.addFile(dataStorage1);
                    	 }
                    	 Label error = new Label("Successfully added");
 						root.getChildren().add(error);
 						error.relocate(250, 250);
						//edit(stage);
					} catch ( NumberFormatException e1) {
						Label error = new Label("Invalid Characters or missing information, "
								+ "DataStorage had been restored");
						root.getChildren().add(error);
						error.relocate(120, 250);
						dataStorage = new DataStorage();
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						Label error = new Label("Invalid Inputs");
						root.getChildren().add(error);
						error.relocate(250, 250);
						//e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
                } 
            };
        	addFiles.setOnAction(addFileEvent);
        	
        	//Add/Remove Farm
        	EventHandler<ActionEvent> addRFarmEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						AddRemoveFarm(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
        	addRFarm.setOnAction(addRFarmEvent);
        	
        	//Edit Specific Farm
        	EventHandler<ActionEvent> editSpedificFarmEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						EditSpecificFarm(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            };
            editFarm.setOnAction(editSpedificFarmEvent);
        	//Back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						start(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            root.getChildren().add(farmView);
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();
	}
	
	/*
	 * This method is create the GUI that user chose AddFile
	 * in Edit
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	/*public void AddFile(Stage stage) throws Exception{
		//title of the pane
			Label title = new Label("Add File");
			title.relocate(270, 10);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	// add the labels to the root
        	Label fileName = new Label("Please Enter File Name/Path: ");
        	
        	root.getChildren().add(fileName);
        	fileName.relocate(130, 180);
        	
        	//add Text fields to the root
        	TextField fileN = new TextField();      	
        	root.getChildren().add(fileN);        	
        	fileN.relocate(300, 180);
        	
        	//add buttons to the root
        	Button con = new Button("Continue");
        	root.getChildren().add(con);
        	con.relocate(270, 265);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	
        	EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						dataStorage.insert(fileN.getText(), new Farm());
						Label added = new Label("successfully added");
						root.getChildren().add(added);
						added.relocate(280, 300);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            con.setOnAction(addEvent);
        	//back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						edit(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();
	}*/
	
	/*
	 * This method is create the GUI that user chose AddRemoveFarm
	 * in Edit
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void AddRemoveFarm(Stage stage) throws Exception{
		//title of the pane
			Label title = new Label("Add/Remove File");
			title.relocate(270, 10);		
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	// add the labels to the root
        	Label farmName = new Label("Please Enter Farm Name: ");
        	Label date = new Label("Please Enter Date: ");
        	Label weight = new Label("Please Enter Weight: ");
        	
        	root.getChildren().add(farmName);
        	root.getChildren().add(date);
        	root.getChildren().add(weight);
        	date.relocate(160, 160);
        	farmName.relocate(160, 180);
        	weight.relocate(160, 140);
        	
        	//add Text fields to the root
        	TextField farmN = new TextField();   
        	TextField farmD = new TextField(); 
        	TextField farmW = new TextField(); 
        	root.getChildren().add(farmN);        
        	root.getChildren().add(farmD); 
        	root.getChildren().add(farmW); 
        	farmN.relocate(300, 180);
        	farmD.relocate(300, 160);
        	farmW.relocate(300, 140);
        	
        	//add buttons to the root
        	Button add = new Button("Add");
        	root.getChildren().add(add);
        	add.relocate(220, 220);
        	
        	Button remove = new Button("Remove Farm");
        	root.getChildren().add(remove);
        	remove.relocate(320, 220);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	
        	EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
                    	 if(dataStorage.contains(farmN.getText())) {
                    		 dataStorage.get(farmN.getText()).add(Integer.parseInt(farmW.getText()), farmD.getText());
                    	 }else {
                    		 Farm a = new Farm();
                    		 a.add(Integer.parseInt(farmW.getText()), farmD.getText());
						dataStorage.insert(farmN.getText(), a);
                    	 }
						Label added = new Label("successfully added");
						root.getChildren().add(added);
						added.relocate(270, 300);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						Label added = new Label("please enter information correctly");
						root.getChildren().add(added);
						added.relocate(270, 300);
						//e1.printStackTrace();
					}
                } 
            };
            add.setOnAction(addEvent);
            
        	EventHandler<ActionEvent> removeEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
                    	 if(dataStorage.contains(farmN.getText())) {
						dataStorage.remove(farmN.getText());
						Label added = new Label(farmN.getText() + "successfully removed");
						root.getChildren().add(added);
						added.relocate(250, 330);
                    	 }else {
                    		 Label added = new Label("farm not contains");
     						root.getChildren().add(added);
     						added.relocate(270, 300);
                    	 }
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            remove.setOnAction(removeEvent);
        	//back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						edit(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();
	}
	
	/*
	 * This method is create the GUI that user chose EditSpecificFarm
	 * in Edit
	 * 
	 * @param stage  the stage of the program
	 * @throws Exception when exception occurs
	 */
	public void EditSpecificFarm(Stage stage) throws Exception{
		//title of the pane
			Label title = new Label("Edit Specific Farm");
			title.relocate(270, 10);	
		// Main layout isPane example (top,left,center,right,bottom)
        	Pane root = new Pane(title);
        	
        	// add the labels to the root
        	Label farmID = new Label("Please Enter Farm ID: ");
        	Label date = new Label("Please Enter Date: ");
        	
        	root.getChildren().add(farmID);
        	root.getChildren().add(date);
        	farmID.relocate(175, 180);
        	date.relocate(180, 220);
        	
        	//add Text fields to the root
        	TextField ID = new TextField();
        	TextField d = new TextField();        	
        	root.getChildren().add(ID);
        	root.getChildren().add(d);        	
        	ID.relocate(300, 180);
        	d.relocate(300, 220);
        	
        	//add buttons to the root
        	Button con = new Button("Continue");
        	root.getChildren().add(con);
        	con.relocate(270, 265);
        	
        	Button back = new Button("Back");
        	root.getChildren().add(back);
        	back.relocate(0, 350);
        	//continue Event
        	EventHandler<ActionEvent> editSpecificEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
                    	 Label a = new Label();
             			if(!ID.getText().isEmpty() && !d.getText().isEmpty()) {
             				if(dataStorage.contains("Farm "+ID.getText())) {
             					//if(dataStorage.get(ID.getText()).containsDate(d.getText())) {
             						editSpecificEventTable(stage, ID.getText(), d.getText());
             					//}else {
             						//a = new Label("date not contains");
             					//}
             				}else {
             					a = new Label("farm not contains");
             				}
             			}else{
             				a = new Label ("Please enter all information correctly");
             			}
             			root.getChildren().add(a);
             			a.relocate(250, 140);
             			
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            con.setOnAction(editSpecificEvent);
        	//back event
        	EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() { 
                public void handle(ActionEvent e) 
                { 
                     try {
						edit(stage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } 
            };
            back.setOnAction(startEvent);
        	//add the image to the root	
            Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    		// Add the stuff and set the primary stage
            	stage.setTitle(APP_TITLE);
            	stage.setScene(mainScene);
            	stage.show();
	}
	
	public void editSpecificEventTable(Stage stage, String farmID, String date) {
		Label title = new Label("Edit Specific Farm");
		title.relocate(270, 10);
		Pane root1 = new Pane(title);
		Label changeW = new Label("Change Weight to: ");
		//Label changeD = new Label("Change Date to: ");
		TextField toWeight = new TextField();
		//TextField toDate = new TextField();
		Button removeData = new Button("Remove this data");
		Button con1 = new Button ("Continue");
		
		root1.getChildren().add(changeW);
		//root1.getChildren().add(changeD);
		root1.getChildren().add(removeData);
		root1.getChildren().add(con1);
		root1.getChildren().add(toWeight);
		//root1.getChildren().add(toDate);
		
    	changeW.relocate(175, 180);
    	//changeD.relocate(180, 220);
    	toWeight.relocate(300, 180);
    	//toDate.relocate(300, 220);
    	removeData.relocate(250, 265);
    	con1.relocate(270, 310);
		//Back button and event
    	Button back = new Button("Back");
    	root1.getChildren().add(back);
    	back.relocate(0, 350);
    	
    	EventHandler<ActionEvent> conEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                 try {
                	 dataStorage.get("Farm " +farmID).setDateWeight(date, Integer.parseInt(toWeight.getText()));
                	 //Integer.parseInt(toWeight.getText());
					//EditSpecificFarm(stage);
                	 Label a = new Label("Successfully changed ");
                	 root1.getChildren().add(a);
                	 a.relocate(260, 350);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
               	 Label a = new Label("please enter in the form requested");
               	 root1.getChildren().add(a);
               	 a.relocate(260, 350);
					//e1.printStackTrace();
				}
            } 
        };
        con1.setOnAction(conEvent);
    	//back event
    	EventHandler<ActionEvent> backEvent = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                 try {
					EditSpecificFarm(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        };
        back.setOnAction(backEvent);
        //create scene
		Scene mainScene = new Scene(root1, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setTitle(APP_TITLE);
    	stage.setScene(mainScene);
    	stage.show();
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   launch(args);
	}
}
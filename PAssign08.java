package JavaFXPackage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PAssign08 extends Application {
	private TextField tfMiles = new TextField(); 
	private TextField tfGallons = new TextField(); 
	private TextField tfMPG = new TextField(); 
	private Button btCalculate = new Button("Calculate");
	private ToggleButton tbLKM = new ToggleButton("L/100KM"); 
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create UI 
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Miles:"), 0, 0);
		gridPane.add(tfMiles, 1, 0); 
		gridPane.add(tbLKM, 3, 0);
		gridPane.add(new Label("Gallons:"), 0, 1);
		gridPane.add(tfGallons, 1, 1); 
		gridPane.add(new Label("Result: "), 0, 2);
		gridPane.add(tfMPG, 1, 2);
		gridPane.add(btCalculate, 1, 3);
		
		//Set UI Properties 
		gridPane.setAlignment(Pos.CENTER);
		
		tfMPG.setEditable(false); 
		
		//Process Events 
		btCalculate.setOnAction(e -> calcMPG());
		//Create Scene and put in stage 
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("MPG Calculator"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	private void calcMPG() { 
		double miles = Double.parseDouble(tfMiles.getText()); 
		double gallons = Double.parseDouble(tfGallons.getText()); 
		if (tbLKM.isSelected()) { 
			double liters = gallons * 3.78333333; 
			//Converts into km  
			double km = miles * 1.60934 ; 
			System.out.println(liters + " L"); 
			System.out.println(km + " KM"); 
			tfMPG.setText(String.format("%.4fL/100KM", (liters/km) * 100));
		} else { 
			tfMPG.setText(String.format("%.4fMPG", miles/gallons));
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

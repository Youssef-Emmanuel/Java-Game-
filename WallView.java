package game.gui;

import game.engine.base.Wall;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;



public class WallView {

	VBox root = new VBox();
	
	Image img = new Image(getClass().getResource("images/wall1.jpg").toExternalForm());
    ImageView view = new ImageView(img);
    ProgressBar healthBar = new ProgressBar(); 
    Label healthValue = new Label(); 
    
    public WallView(){
    	 healthBar.setPrefWidth(50);
         healthBar.setPrefHeight(1);
         root.getChildren().addAll(healthBar, healthValue, view);
    }
    public void defeated(){
    	healthBar.setProgress(0);
    	healthValue.setText("Defeated");
    }
    public void updateHealth(Wall wall){
    	double healthPercentage = (double) wall.getCurrentHealth() / wall.getBaseHealth();
        healthBar.setProgress(healthPercentage);
        healthValue.setText("Health: " + wall.getCurrentHealth() + "/" + wall.getBaseHealth());
    }
}
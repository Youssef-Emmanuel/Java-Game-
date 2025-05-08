package game.gui;


import game.gui.TitanController;
import game.engine.Battle;
import game.engine.BattlePhase;
import game.engine.interfaces.Attackee;
import game.engine.lanes.Lane;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class TitanView {
	
	private VBox root;
    private ImageView imageView;
    private ProgressBar healthBar;
    private Label healthValue;
    private Battle battle;
   
    
    
    //////////////to be continued///////////////
    public TitanView() {
    	  root = new VBox(10);
    	 // Initialize the health bar and label
    	 this.healthBar = new ProgressBar();
         this.healthValue = new Label();
         
    	 imageView=new ImageView();
    	 imageView.setFitHeight(50);
 	     imageView.setFitWidth(50);
         

         // bnzabat dimensions el health bar
         this.healthBar.setPrefWidth(50);
         this.healthBar.setPrefHeight(0.5);
         healthBar.setStyle("-fx-accent: red;");
         this.healthValue.setStyle("-fx-text-fill: white; -fx-background-color: black;");
         imageView.setFitHeight(100);
         imageView.setFitWidth(100);  
         imageView.setScaleX(-1); // Flips the image vertically




         // hena bn3ml el Vbox bn7ot feh kol 7aga
         
        root.getChildren().addAll(healthValue, healthBar, imageView);
         
         

          

    }
    
    
	
	
  
   
    public  VBox getRoot() {
        return root;
    }

    public void updateHealth(Titan titan) {
        double healthPercentage = (double) titan.getCurrentHealth() / titan.getBaseHealth();
        this.healthBar.setProgress(healthPercentage);
        this.healthValue.setText("Health: " + titan.getCurrentHealth() + "/" + titan.getBaseHealth());
    }





	public ImageView getImageView() {
		return imageView;
	}





	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	
	/*VBox root = new VBox(10);
	
	// Titan 1
    Image img1 = new Image("titan1.png");
    ImageView view1 = new ImageView(img1);
    ProgressBar healthBar1 = new ProgressBar(); 
    Label healthValue1 = new Label(); 


    // Titan 2
    Image img2 = new Image("titan2.png");
    ImageView view2 = new ImageView(img2);
    ProgressBar healthBar2 = new ProgressBar();
    Label healthValue2 = new Label();
	
    // Titan 3
    Image img3 = new Image("titan3.png");
    ImageView view3 = new ImageView(img3);
    ProgressBar healthBar3 = new ProgressBar(); 
    Label healthValue3 = new Label(); 
    
    public TitanView() {
        healthBar1.setPrefWidth(50);
        healthBar1.setPrefHeight(1);
        healthBar2.setPrefWidth(50);
        healthBar2.setPrefHeight(1);
        healthBar3.setPrefWidth(50);
        healthBar3.setPrefHeight(1);

        // hena bn Add the elements for each titan to the VBox
        root.getChildren().addAll(healthBar1, healthValue1, view1);
        root.getChildren().addAll(healthBar2, healthValue2, view2);
        root.getChildren().addAll(healthBar3, healthValue3, view3);
    }
    
    public void updateHealth(Titan titan) {
        double healthPercentage = (double) titan.getCurrentHealth() / titan.getBaseHealth();
        healthBar1.setProgress(healthPercentage);
        healthValue1.setText("Health: " + titan.getCurrentHealth() + "/" + titan.getBaseHealth());
    }*/
    
    

}

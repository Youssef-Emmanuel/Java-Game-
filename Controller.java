package game.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;





















import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.AbnormalTitan;
import game.engine.titans.ArmoredTitan;
import game.engine.titans.ColossalTitan;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
import game.engine.weapons.WeaponRegistry;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private static Battle Battle1;
	//Info
    private Label currentScore;
    private Label currentTurn;
    private Label currentPhase;
    private Label currentResources;
    // WeaponShop
 	private VBox weaponShopBox;
 	private Button[] weaponShopButtons;
 	
 	//Lanes
 	private Label Lane1;
 	private Label Lane2;
 	private Label Lane3;
 	private Label Lane4;
 	private Label Lane5;
 	private HBox Lane1H;
 	private HBox Lane2H;
 	private HBox Lane3H;
 	private Pane[] Lanes;
 	//private Pane TitanController;
 	
 	//Youssef's last part Sunday 5/18/2024
 	private Lane currentLane;
	private Label[] lanesLabel;
	private Lane currentLane1;
	private Lane currentLane2;
	private Lane currentLane3;
	private StackPane rootPane;
	private AnchorPane[] laneGrid;
	private Label text1;
	private Label text2;
	private Label text3;
	private Label text4;
	private Label text5;
	private Lane currentLane4;
	
	
	
	
	
 	
    
    
    // First Scene choosing easy or hard
    @FXML
	public void Easy(ActionEvent e) throws IOException
	{
		//System.out.println("Easy");
		Battle1 = new Battle(1, 0, 10, 3, 250);
		SwitchToScene1Easy(e);
		
		
	}
	
	public void Hard(ActionEvent e) throws IOException
	{
		//System.out.println("Hard");
		Battle1 = new Battle(1, 0,10, 5, 125);
		SwitchToScene1Hard(e);
	}
	
	
	//Video intro for the easy scene
	public void SwitchToScene1Easy(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Scene1(Instructions).fxml"));
	    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    String path = "InstructionsVideo.mp4"; 
	    Media media = new Media(new File(path).toURI().toString());
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    MediaView mediaView = new MediaView(mediaPlayer);
	    mediaView.setFitWidth(1420); 
	    mediaView.setFitHeight(790); 
	    mediaPlayer.play();

	    // Button to go to scene 2
	    Button btnSwitch = new Button("Go GamePlay");
	    btnSwitch.setLayoutX(630);
	    btnSwitch.setLayoutY(630);
	    btnSwitch.setPrefWidth(150); 
	    btnSwitch.setPrefHeight(40); 
	    

	    // To set the button on top of the video
	    mediaView.setMediaPlayer(mediaPlayer);
	    mediaView.setPreserveRatio(true);

	    // Add the button to the layout
	    ((AnchorPane) scene.getRoot()).getChildren().addAll(mediaView, btnSwitch);

	    // Set the action for the button
	    btnSwitch.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	mediaPlayer.pause();
	            try {
	            	SwitchToScene2Easy(event); 
	            } catch (IOException e) {
	                e.printStackTrace(); 
	            }
	        }
	    });
	    ((AnchorPane) scene.getRoot()).getChildren().add(mediaView);
	}
	
	
	//video intro for the hard scene 
	public void SwitchToScene1Hard(ActionEvent event) throws IOException {
	    Parent root = FXMLLoader.load(getClass().getResource("Scene1(Instructions).fxml"));
	    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    String path = "InstructionsVideo.mp4"; 
	    Media media = new Media(new File(path).toURI().toString());
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    MediaView mediaView = new MediaView(mediaPlayer);
	    mediaView.setFitWidth(1420); 
	    mediaView.setFitHeight(790); 
	    mediaPlayer.play();

	    // Button to go to scene 2
	    Button btnSwitch = new Button("Lets Play!!");
	    btnSwitch.setLayoutX(630);
	    btnSwitch.setLayoutY(630);
	    btnSwitch.setPrefWidth(150); 
	    btnSwitch.setPrefHeight(40); 

	    // To set the button on top of the video
	    mediaView.setMediaPlayer(mediaPlayer);
	    mediaView.setPreserveRatio(true);

	    // Add the button to the layout
	    ((AnchorPane) scene.getRoot()).getChildren().addAll(mediaView, btnSwitch);

	    // Set the action for the button
	    btnSwitch.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	mediaPlayer.pause();
	            try {
	            	SwitchToScene2Hard(event);  
	            } catch (IOException e) {
	                e.printStackTrace(); 
	            }
	        }
	    });
	    ((AnchorPane) scene.getRoot()).getChildren().add(mediaView);
	}
	
    //method 3shan n update el values in gameplay 
    public void updateValues3()
    {
    	currentScore.setText("Current Score: " + Battle1.getScore());
    	currentTurn.setText("Turn : " + Battle1.getNumberOfTurns());
    	currentPhase.setText("Phase: " + Battle1.getBattlePhase());
    	currentResources.setText("Resources: " + Battle1.getResourcesGathered());
    	
    
    		Lane lane = Battle1.getOriginalLanes().get(0);
    		Lane1.setText("Danger: " + lane.getDangerLevel() + "\n" + "Health: " + lane.getLaneWall().getCurrentHealth());
    		
    		Lane lane2 = Battle1.getOriginalLanes().get(1);
    		Lane2.setText("Danger: " + lane2.getDangerLevel() + "\n" + "Health: " + lane2.getLaneWall().getCurrentHealth());
    		
    		Lane lane3 = Battle1.getOriginalLanes().get(2);
    		Lane3.setText("Danger: " + lane3.getDangerLevel() + "\n" + "Health: " + lane3.getLaneWall().getCurrentHealth());
    		
    	
    }
    public void updateValues5()
    {
    	currentScore.setText("Current Score: " + Battle1.getScore());
    	currentTurn.setText("Turn : " + Battle1.getNumberOfTurns());
    	currentPhase.setText("Phase: " + Battle1.getBattlePhase());
    	currentResources.setText("Resources: " + Battle1.getResourcesGathered());
    	
    
    		Lane lane = Battle1.getOriginalLanes().get(0);
    		Lane1.setText("Danger: " + lane.getDangerLevel() + "\n" + "Health: " + lane.getLaneWall().getCurrentHealth());
    		
    		Lane lane2 = Battle1.getOriginalLanes().get(1);
    		Lane2.setText("Danger: " + lane2.getDangerLevel() + "\n" + "Health: " + lane2.getLaneWall().getCurrentHealth());
    		
    		Lane lane3 = Battle1.getOriginalLanes().get(2);
    		Lane3.setText("Danger: " + lane3.getDangerLevel() + "\n" + "Health: " + lane3.getLaneWall().getCurrentHealth());
    		
    		Lane lane4 = Battle1.getOriginalLanes().get(2);
    		Lane4.setText("Danger: " + lane4.getDangerLevel() + "\n" + "Health: " + lane4.getLaneWall().getCurrentHealth());
    		
    		Lane lane5 = Battle1.getOriginalLanes().get(2);
    		Lane5.setText("Danger: " + lane5.getDangerLevel() + "\n" + "Health: " + lane5.getLaneWall().getCurrentHealth());
    	
    }
    
	
    ////////////////////////////////////////////Easy Game/////////////////////////////////////////////////
	@FXML
	public void SwitchToScene2Easy(ActionEvent event) throws IOException {
		//Parent root = FXMLLoader.load(getClass().getResource("Scene2(test).fxml"));
		AnchorPane root = new AnchorPane();
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	    
	    
	    //wall with weapons
	    
	    
	    

	    
	    // Background and lanes
	    root.setStyle("-fx-background-color: black;");
	    Image img = new Image("3lanes.png");
	    ImageView view = new ImageView(img);
	    view.setFitHeight(600);
	    view.setFitWidth(1000);
	    root.getChildren().add(view);
	    AnchorPane.setTopAnchor(view, 80.0);
	    AnchorPane.setLeftAnchor(view, 180.0);
	    
	    
	    
	    laneGrid = new AnchorPane[3];
        laneGrid[0] = new AnchorPane();
        laneGrid[0].setPrefWidth(1000);
       // laneGrid[0].setPrefHeight(200);
        AnchorPane.setRightAnchor(laneGrid[0], 200.0);
        AnchorPane.setTopAnchor(laneGrid[0], 150.0);
        root.getChildren().add(laneGrid[0]);
        laneGrid[1] = new AnchorPane();
        laneGrid[1].setPrefWidth(1000);
        laneGrid[1].setPrefHeight(200);
        AnchorPane.setRightAnchor(laneGrid[1], 100.0);
        AnchorPane.setTopAnchor(laneGrid[1], 350.0);
        root.getChildren().add(laneGrid[1]);
        laneGrid[2] = new AnchorPane();
        laneGrid[2].setPrefWidth(1000);
        laneGrid[2].setPrefHeight(200);
        AnchorPane.setRightAnchor(laneGrid[2], 100.0);
        AnchorPane.setTopAnchor(laneGrid[2], 550.0);
        root.getChildren().add(laneGrid[2]);
        
        text1 =new Label();
	    text2 =new Label();
	    text3 =new Label();
	    text1.setPrefSize(50,100);
	    text2.setPrefSize(50,100);
	    text3.setPrefSize(50,100);
	    text1.setLayoutY(188);
	    text2.setLayoutY(395);
	    text3.setLayoutY(580);
	    text1.setLayoutX(180);
	    text2.setLayoutX(180);
	    text3.setLayoutX(180);
	    root.getChildren().addAll(text1,text2,text3);
	    
	    ///////////WeaponShop 1////////////////
	    /*weaponShopBox = new VBox();
		weaponShopBox.setSpacing(10);
        weaponShopBox.setPadding(new Insets(10));
        weaponShopButtons = new Button[4];
        for (int i = 0; i<weaponShopButtons.length; i++){
        	weaponShopButtons[i] = new Button();
        	weaponShopButtons[i].setOnAction(null);
        	weaponShopBox.getChildren().add(weaponShopButtons[i]);
        	WeaponRegistry weapon = Battle1.getWeaponFactory().getWeaponShop().get(i+1);
        	String buttonText = "Name: " +weapon.getName() + "\n" + "Price: " + weapon.getPrice() + "\n" + "Damage: " +weapon.getDamage();
        	weaponShopButtons[i].setText(buttonText);
        }
        AnchorPane.setTopAnchor(weaponShopBox, 200.0);
        AnchorPane.setRightAnchor(weaponShopBox, 0.0);
        root.getChildren().add(weaponShopBox);*/
	    
	    //weaponshop updated
	    VBox weaponShopBox = new VBox();
	    weaponShopBox.setSpacing(10);
	    weaponShopBox.setPadding(new Insets(10));
	    weaponShopBox.setDisable(true);
	    currentLane = null;
        Button buyWeapon1 = new Button("Buy Weapon");
        currentLane1 = Battle1.getOriginalLanes().get(0);
        currentLane2 = Battle1.getOriginalLanes().get(1);
        currentLane3 = Battle1.getOriginalLanes().get(2);
        buyWeapon1.setOnAction(e -> {
        	weaponShopBox.setDisable(false);
        	currentLane = currentLane1;
        });
        Button buyWeapon2 = new Button("Buy Weapon");
        buyWeapon2.setOnAction(e -> {
        	weaponShopBox.setDisable(false);
        	currentLane = currentLane2;
        });
        Button buyWeapon3 = new Button("Buy Weapon");
        buyWeapon3.setOnAction(e -> {
        	weaponShopBox.setDisable(false);
        	currentLane = currentLane3;
        });
        VBox buttonsBox = new VBox(20);
        buttonsBox.getChildren().addAll(buyWeapon1,buyWeapon2,buyWeapon3);
        
        root.getChildren().add(buyWeapon1);
        root.getChildren().add(buyWeapon2);
        root.getChildren().add(buyWeapon3);
        buyWeapon1.setTranslateX(50);
        buyWeapon1.setTranslateY(200);
        AnchorPane.setLeftAnchor(buyWeapon2, 50.0);
        AnchorPane.setTopAnchor(buyWeapon2, 400.0);
        AnchorPane.setLeftAnchor(buyWeapon3, 50.0);
        AnchorPane.setTopAnchor(buyWeapon3, 600.0);
        
        weaponShopBox.setTranslateX(1180);
        weaponShopBox.setTranslateY(200);
        
        
        weaponShopButtons = new Button[4];
        for (int i = 0; i < weaponShopButtons.length; i++) {
            weaponShopButtons[i] = new Button();
            int weaponIndex = i + 1;
            weaponShopButtons[i].setOnAction(e -> purchaseWeapon(weaponIndex, currentLane,weaponShopBox));
            weaponShopBox.getChildren().add(weaponShopButtons[i]);
            WeaponRegistry weapon = Battle1.getWeaponFactory().getWeaponShop().get(weaponIndex);
            String buttonText = "Name: " + weapon.getName() + "\n" + "Price: " + weapon.getPrice() + "\n" + "Damage: " + weapon.getDamage();
            weaponShopButtons[i].setText(buttonText);
        }
        root.getChildren().add(weaponShopBox);
        //weaponShopBox.setDisable(true);
        
        /* General Game info*/
        //Score
        currentScore = new Label();
        currentScore.setStyle("-fx-text-fill: white;");
        currentScore.setText("Current Score: " + Battle1.getScore());
        AnchorPane.setLeftAnchor(currentScore, 300.0);
        root.getChildren().add(currentScore);
        //Current turn 
        currentTurn = new Label();
        currentTurn.setStyle("-fx-text-fill: white;");
        currentTurn.setText("Turn : " + Battle1.getNumberOfTurns());
	    AnchorPane.setLeftAnchor(currentTurn, 500.0);
        root.getChildren().add(currentTurn);
        //Current phase 
        currentPhase = new Label();
        currentPhase.setStyle("-fx-text-fill: white;");
        currentPhase.setText("Phase: " + Battle1.getBattlePhase());
        AnchorPane.setLeftAnchor(currentPhase, 700.0);
        root.getChildren().add(currentPhase);
	    //Current Resources
        currentResources = new Label();
        currentResources.setStyle("-fx-text-fill: white;");
        currentResources.setText("Resources: " + Battle1.getResourcesGathered());
        AnchorPane.setLeftAnchor(currentResources, 900.0);
        root.getChildren().add(currentResources);
        
        
        //Pass Turn btn
        Button btnPassTurn = new Button("PassTurn");
        btnPassTurn.setOnAction(new EventHandler <ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event) {
        	Battle1.passTurn();
        	System.out.print("test");
        	if (Battle1.isGameOver())
        	{
        		System.out.print("Game Over");
        		// to be continued
        	}
        	else
        	{
        		//method el bt update el values
        		updateValues3();
        		//updateLanesInfo(root);
        		//updateTitans( root);
        		//updateTitans2( root);
        		moveTitans();
        		//moveTitansLemby();
        		
        	}	
        	}
        	});
        root.getChildren().add(btnPassTurn);
        AnchorPane.setBottomAnchor(btnPassTurn, 20.0);
        AnchorPane.setLeftAnchor(btnPassTurn, 650.0);
        
        // The Lanes //
        //Lane 1
        Lane1 = new Label();
        Lane1.setStyle("-fx-text-fill: white;");
        AnchorPane.setLeftAnchor(Lane1, 50.0);
        AnchorPane.setTopAnchor(Lane1, 150.0);
        root.getChildren().add(Lane1);
        
        //Lane 2
        Lane2 = new Label("Lane 2");
        Lane2.setStyle("-fx-text-fill: white;");
        AnchorPane.setLeftAnchor(Lane2, 50.0);
        AnchorPane.setTopAnchor(Lane2, 350.0);
        root.getChildren().add(Lane2);
        
        //Lane 3
        Lane3 = new Label("Lane 3");
        Lane3.setStyle("-fx-text-fill: white;");
        AnchorPane.setLeftAnchor(Lane3, 50.0);
        AnchorPane.setTopAnchor(Lane3, 550.0);
        root.getChildren().add(Lane3);
        
        // Method to update lane details 
        /*for ( int i = 0; i<Battle1.getOriginalLanes().size(); i = i+1)
        {
        	Lane lane = Battle1.getOriginalLanes().get(i);
        	String LaneDetails = ("Danger: " + lane.getDangerLevel() + "\n" + "Health: " + lane.getLaneWall().getCurrentHealth());
        	if (!lane.isLaneLost())
        	{
        		// han3ml hena 7etet el weapons 
        		
        		// w han7ot hena bardo 7etet el Vbox bta3 el titans han7arako w keda
        		
        		for (int j=0; j<Battle1.getApproachingTitans().size(); j++)
        		{
        			Titan titan = Battle1.getApproachingTitans().get(j);
        			TitanController t =new TitanController(titan);
        		    root.getChildren().add(t.getTitanView().getRoot());
        		}
        	}
        
        }*/
        
//	    El kalam da mesh hena
//      Titan titan=new AbnormalTitan(1000, 0, 0, 0, 0, 0, 0);
//	    TitanController t=new TitanController(titan);
//	    root.getChildren().add(t.getTitanView().getRoot());
	  
        
        
        
   
}
	

	
	@FXML
	public void SwitchToScene2Hard(ActionEvent event) throws IOException {
		//Parent root = FXMLLoader.load(getClass().getResource("Scene2(test).fxml"));
				AnchorPane root = new AnchorPane();
			    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			    scene = new Scene(root);
			    stage.setScene(scene);
			    stage.show();
			    
			    
			    

			    
			    // Background and lanes
			    root.setStyle("-fx-background-color: black;");
			    Image img = new Image("Lanes5.jpg");
			    ImageView view = new ImageView(img);
			    view.setFitHeight(600);
			    view.setFitWidth(1000);
			    root.getChildren().add(view);
			    AnchorPane.setTopAnchor(view, 80.0);
			    AnchorPane.setLeftAnchor(view, 180.0);
			    
			    ///////////WeaponShop 1////////////////
			    /*weaponShopBox = new VBox();
				weaponShopBox.setSpacing(10);
		        weaponShopBox.setPadding(new Insets(10));
		        weaponShopButtons = new Button[4];
		        for (int i = 0; i<weaponShopButtons.length; i++){
		        	weaponShopButtons[i] = new Button();
		        	weaponShopButtons[i].setOnAction(null);
		        	weaponShopBox.getChildren().add(weaponShopButtons[i]);
		        	WeaponRegistry weapon = Battle1.getWeaponFactory().getWeaponShop().get(i+1);
		        	String buttonText = "Name: " +weapon.getName() + "\n" + "Price: " + weapon.getPrice() + "\n" + "Damage: " +weapon.getDamage();
		        	weaponShopButtons[i].setText(buttonText);
		        }
		        AnchorPane.setTopAnchor(weaponShopBox, 200.0);
		        AnchorPane.setRightAnchor(weaponShopBox, 0.0);
		        root.getChildren().add(weaponShopBox);*/
			    
			    //weaponshop updated
			    VBox weaponShopBox = new VBox();
			    weaponShopBox.setSpacing(10);
			    weaponShopBox.setPadding(new Insets(10));
			    weaponShopBox.setDisable(true);
			    currentLane = null;
		        Button buyWeapon1 = new Button("Buy Weapon");
		        currentLane1 = Battle1.getOriginalLanes().get(0);
		        currentLane2 = Battle1.getOriginalLanes().get(1);
		        currentLane3 = Battle1.getOriginalLanes().get(2);
		        currentLane4 = Battle1.getOriginalLanes().get(3);
		        
		        buyWeapon1.setOnAction(e -> {
		        	weaponShopBox.setDisable(false);
		        	currentLane = currentLane1;
		        });
		        Button buyWeapon2 = new Button("Buy Weapon");
		        buyWeapon2.setOnAction(e -> {
		        	weaponShopBox.setDisable(false);
		        	currentLane = currentLane2;
		        });
		        Button buyWeapon3 = new Button("Buy Weapon");
		        buyWeapon3.setOnAction(e -> {
		        	weaponShopBox.setDisable(false);
		        	currentLane = currentLane3;
		        });
		        Button buyWeapon4 = new Button("Buy Weapon");
		        buyWeapon4.setOnAction(e -> {
		        	weaponShopBox.setDisable(false);
		        	currentLane = currentLane3;
		        });
		        Button buyWeapon5 = new Button("Buy Weapon");
		        buyWeapon5.setOnAction(e -> {
		        	weaponShopBox.setDisable(false);
		        	currentLane = currentLane3;
		        });
		        VBox buttonsBox = new VBox(20);
		        buttonsBox.getChildren().addAll(buyWeapon1,buyWeapon2,buyWeapon3,buyWeapon4,buyWeapon5);
		        
		        root.getChildren().add(buyWeapon1);
		        root.getChildren().add(buyWeapon2);
		        root.getChildren().add(buyWeapon3);
		        root.getChildren().add(buyWeapon4);
		        root.getChildren().add(buyWeapon5);
		        buyWeapon1.setTranslateX(50);
		        buyWeapon1.setTranslateY(150);
		        AnchorPane.setLeftAnchor(buyWeapon2, 50.0);
		        AnchorPane.setTopAnchor(buyWeapon2, 280.0);
		        AnchorPane.setLeftAnchor(buyWeapon3, 50.0);
		        AnchorPane.setTopAnchor(buyWeapon3, 400.0);
		        AnchorPane.setLeftAnchor(buyWeapon4, 50.0);
		        AnchorPane.setTopAnchor(buyWeapon4, 520.0);
		        AnchorPane.setLeftAnchor(buyWeapon5, 50.0);
		        AnchorPane.setTopAnchor(buyWeapon5, 640.0);
		        
		        weaponShopBox.setTranslateX(1180);
		        weaponShopBox.setTranslateY(200);
		        laneGrid = new AnchorPane[5];
		        laneGrid[0] = new AnchorPane();
		        laneGrid[0].setPrefWidth(1000);
		        laneGrid[0].setPrefHeight(200);
		        AnchorPane.setRightAnchor(laneGrid[0], 200.0);
		        AnchorPane.setTopAnchor(laneGrid[0], 150.0);
		        root.getChildren().add(laneGrid[0]);
		        laneGrid[1] = new AnchorPane();
		        laneGrid[1].setPrefWidth(1000);
		        laneGrid[1].setPrefHeight(200);
		        AnchorPane.setRightAnchor(laneGrid[1], 100.0);
		        AnchorPane.setTopAnchor(laneGrid[1], 350.0);
		        root.getChildren().add(laneGrid[1]);
		        laneGrid[2] = new AnchorPane();
		        laneGrid[2].setPrefWidth(1000);
		        laneGrid[2].setPrefHeight(200);
		        AnchorPane.setRightAnchor(laneGrid[2], 100.0);
		        AnchorPane.setTopAnchor(laneGrid[2], 550.0);
		        root.getChildren().add(laneGrid[2]);
		        laneGrid[3] = new AnchorPane();
		        laneGrid[3].setPrefWidth(1000);
		        laneGrid[3].setPrefHeight(200);
		        AnchorPane.setRightAnchor(laneGrid[3], 100.0);
		        AnchorPane.setTopAnchor(laneGrid[3], 750.0);
		        root.getChildren().add(laneGrid[3]);
		        laneGrid[4] = new AnchorPane();
		        laneGrid[4].setPrefWidth(1000);
		        laneGrid[4].setPrefHeight(200);
		        AnchorPane.setRightAnchor(laneGrid[4], 100.0);
		        AnchorPane.setTopAnchor(laneGrid[4], 950.0);
		        root.getChildren().add(laneGrid[4]);
		        
		        
		        
		        weaponShopButtons = new Button[4];
		        for (int i = 0; i < weaponShopButtons.length; i++) {
		            weaponShopButtons[i] = new Button();
		            int weaponIndex = i + 1;
		            weaponShopButtons[i].setOnAction(e -> purchaseWeapon(weaponIndex, currentLane,weaponShopBox));
		            weaponShopBox.getChildren().add(weaponShopButtons[i]);
		            WeaponRegistry weapon = Battle1.getWeaponFactory().getWeaponShop().get(weaponIndex);
		            String buttonText = "Name: " + weapon.getName() + "\n" + "Price: " + weapon.getPrice() + "\n" + "Damage: " + weapon.getDamage();
		            weaponShopButtons[i].setText(buttonText);
		        }
		        root.getChildren().add(weaponShopBox);
		        //weaponShopBox.setDisable(true);
		        
		        /* General Game info*/
		        //Score
		        currentScore = new Label();
		        currentScore.setStyle("-fx-text-fill: white;");
		        currentScore.setText("Current Score: " + Battle1.getScore());
		        AnchorPane.setLeftAnchor(currentScore, 300.0);
		        root.getChildren().add(currentScore);
		        //Current turn 
		        currentTurn = new Label();
		        currentTurn.setStyle("-fx-text-fill: white;");
		        currentTurn.setText("Turn : " + Battle1.getNumberOfTurns());
			    AnchorPane.setLeftAnchor(currentTurn, 500.0);
		        root.getChildren().add(currentTurn);
		        //Current phase 
		        currentPhase = new Label();
		        currentPhase.setStyle("-fx-text-fill: white;");
		        currentPhase.setText("Phase: " + Battle1.getBattlePhase());
		        AnchorPane.setLeftAnchor(currentPhase, 700.0);
		        root.getChildren().add(currentPhase);
			    //Current Resources
		        currentResources = new Label();
		        currentResources.setStyle("-fx-text-fill: white;");
		        currentResources.setText("Resources: " + Battle1.getResourcesGathered());
		        AnchorPane.setLeftAnchor(currentResources, 900.0);
		        root.getChildren().add(currentResources);
		        
		        
		        //Pass Turn btn
		        Button btnPassTurn = new Button("PassTurn");
		        btnPassTurn.setOnAction(new EventHandler <ActionEvent>(){
		        	@Override
		        	public void handle(ActionEvent event) {
		        	Battle1.passTurn();
		        	System.out.print("test");
		        	if (Battle1.isGameOver())
		        	{
		        		System.out.print("Game Over");
		        		// to be continued
		        	}
		        	else
		        	{
		        		//method el bt update el values
		        		updateValues5();
		        		//updateLanesInfo(root);
		        		//updateTitans( root);
		        		//updateTitans2( root);
		        		//moveTitansLemby();
		        		moveTitans();
		        		
		        	}	
		        	}
		        	});
		        root.getChildren().add(btnPassTurn);
		        AnchorPane.setBottomAnchor(btnPassTurn, 20.0);
		        AnchorPane.setLeftAnchor(btnPassTurn, 650.0);
		        
		        // The Lanes //
		        //Lane 1
		        Lane1 = new Label("Lane 1");
		        Lane1.setStyle("-fx-text-fill: white;");
		        AnchorPane.setLeftAnchor(Lane1, 50.0);
		        AnchorPane.setTopAnchor(Lane1, 100.0);
		        root.getChildren().add(Lane1);
		        
		        //Lane 2
		        Lane2 = new Label("Lane 2");
		        Lane2.setStyle("-fx-text-fill: white;");
		        AnchorPane.setLeftAnchor(Lane2, 50.0);
		        AnchorPane.setTopAnchor(Lane2, 230.0);
		        root.getChildren().add(Lane2);
		        
		        //Lane 3
		        Lane3 = new Label("Lane 3");
		        Lane3.setStyle("-fx-text-fill: white;");
		        AnchorPane.setLeftAnchor(Lane3, 50.0);
		        AnchorPane.setTopAnchor(Lane3, 350.0);
		        root.getChildren().add(Lane3);
		        
		      //Lane 4
		        Lane4 = new Label("Lane 4");
		        Lane4.setStyle("-fx-text-fill: white;");
		        AnchorPane.setLeftAnchor(Lane4, 50.0);
		        AnchorPane.setTopAnchor(Lane4, 460.0);
		        root.getChildren().add(Lane4);
		        
		      //Lane 5
		        Lane5 = new Label("Lane 5");
		        Lane5.setStyle("-fx-text-fill: white;");
		        AnchorPane.setLeftAnchor(Lane5, 50.0);
		        AnchorPane.setTopAnchor(Lane5, 580.0);
		        root.getChildren().add(Lane5);
		        
		        // Method to update lane details 
		        /*for ( int i = 0; i<Battle1.getOriginalLanes().size(); i = i+1)
		        {
		        	Lane lane = Battle1.getOriginalLanes().get(i);
		        	String LaneDetails = ("Danger: " + lane.getDangerLevel() + "\n" + "Health: " + lane.getLaneWall().getCurrentHealth());
		        	if (!lane.isLaneLost())
		        	{
		        		// han3ml hena 7etet el weapons 
		        		
		        		// w han7ot hena bardo 7etet el Vbox bta3 el titans han7arako w keda
		        		
		        		for (int j=0; j<Battle1.getApproachingTitans().size(); j++)
		        		{
		        			Titan titan = Battle1.getApproachingTitans().get(j);
		        			TitanController t =new TitanController(titan);
		        		    root.getChildren().add(t.getTitanView().getRoot());
		        		}
		        	}
		        
		        }*/
		        
//			    El kalam da mesh hena
//		        Titan titan=new AbnormalTitan(1000, 0, 0, 0, 0, 0, 0);
//			    TitanController t=new TitanController(titan);
//			    root.getChildren().add(t.getTitanView().getRoot());
			  
		        
		        
		        
	    
	    

	}
	

	private void purchaseWeapon(int weaponIndex, Lane lane, VBox weaponButton) {
        try {
            Battle1.purchaseWeapon(weaponIndex, lane);
            WeaponRegistry weapon = Battle1.getWeaponFactory().getWeaponShop().get(weaponIndex);
            int laneIndex = getLaneIndex(lane);
            Label targetLabel = getTextArea(laneIndex);
            /*if(!lane.isLaneLost()){
                
                }*/
                /*else{
                	Label message = new Label("Lane is lost");
                	laneVBoxes[laneIndex].getChildren().add(message);
                }*/
           //targetLabel.setText(targetLabel.getText() + "\n" + weapon.getName());	
          weaponButton.setDisable(true);
          currentResources.setText("Resources: " + Battle1.getResourcesGathered());
        } catch (InsufficientResourcesException e) {
            displayAlert("Resources Alert", "You don't have enough resources");
        } catch (InvalidLaneException e) {
            displayAlert("Invalid Lane Alert", "This lane is lost");
        }
    }
	private int getLaneIndex(Lane lane) {
        if (lane.equals(currentLane1)) return 0;
        else if (lane.equals(currentLane2)) return 1;
        else if (lane.equals(currentLane3)) return 2;
        else if (lane.equals(currentLane4)) return 3;
        else return 4;

    }

			    private Lane getLaneByIndex(int index) {
			        switch (index) {
			            case 0:
			                return currentLane1;
			            case 1:
			                return currentLane2;
			            case 2:
			                return currentLane3;
			            default:
			                return null;
			        }
			    }

			    private void displayAlert(String title, String message) {
			        Stage alertStage = new Stage();
			        alertStage.setTitle(title);

			        Label label = new Label(message);
			        Button closeButton = new Button("Return to the game");
			        closeButton.setOnAction(event -> alertStage.close());

			        VBox pane = new VBox();
			        pane.setSpacing(10);
			        pane.getChildren().addAll(label, closeButton);

			        Scene scene = new Scene(pane, 300, 100);
			        alertStage.setScene(scene);
			        alertStage.show();
			    }
			   
			 
			    
			  
			    public void updateTitans2(AnchorPane root)
			    {
			    	Lane lane1 = Battle1.getOriginalLanes().get(0);
			    	if (!lane1.isLaneLost())
			    	{
			    		//root.getChildren().clear();
		        		for (int j=0; j<Battle1.getApproachingTitans().size(); j++)
		        		{
		        			Titan titan = Battle1.getApproachingTitans().get(j);
		        			TitanController t =new TitanController(titan);
		        			VBox titanViewRoot = t.getTitanView().getRoot();
		        			
		        			double newTopAnchor = 20; // Set the new top anchor value
		                    double newLeftAnchor = 1000.0 +50; // Set the new left anchor value, for example
		                    AnchorPane.setTopAnchor(titanViewRoot, newTopAnchor);
		                    AnchorPane.setLeftAnchor(titanViewRoot, newLeftAnchor);
		        			
		                    
		        			root.getChildren().add(titanViewRoot);
		        		
		        		}
			    	}
			    	
			    }

	
	
			    
			    ////////
			    public void updateTitans(AnchorPane root) {
			        AnchorPane rootext1 = new AnchorPane(); 
			        for (int i = 0; i < Battle1.getOriginalLanes().size(); i++) {
			            Lane lane = Battle1.getOriginalLanes().get(i);
			            if (!lane.isLaneLost())
			        	{
			        	
			        		for (int j=0; j<Battle1.getApproachingTitans().size(); j++)
			        		{	
			        			Titan titan = Battle1.getApproachingTitans().get(j);
			        			TitanController t =new TitanController(titan);
			        			rootext1.getChildren().add(t.getTitanView().getRoot());
			        			rootext1.setTranslateX(titan.getDistance()*10+1000);
			        			rootext1.setTranslateY(100);
			        			//rootext1.setSpacing(1);
			        		    root.getChildren().add(rootext1);
			        		    
			        			
			        				
			        			}
			        		    
			        		    
			        		    
			        		}
			        	}
			        }
			    
			    

			    
			    

		
		/*public void moveTitanView()
		{
			//Translate t = new Translate();
			//t.setX(-titan.getSpeed());
			g= new GridPane();
			g.getChildren().clear();
			for (Lane lane: Battle1.getOriginalLanes()){
				for (Titan titan: lane.getTitans()){
					VBox titanWithHealth= TitanView.getRoot();
					g.add(titanWithHealth, 0, Battle1.getOriginalLanes().indexOf(lane));
					titanWithHealth.setTranslateX(titan.getDistance()*12.5);
					if(titan instanceof PureTitan){
						titanWithHealth.setTranslateY(35);
					}
					else if(titan instanceof AbnormalTitan){
						titanWithHealth.setTranslateY(20);
					}
					else if(titan instanceof ArmoredTitan){
						
					}
					else{
						titanWithHealth.setTranslateY(-20);
					}
				}
			}*/
		/*public void moveTitans(){
			Lanes = new Pane[3];
			for(Lane lane: Battle1.getOriginalLanes()){
				Lanes[0].getChildren().clear();
				for(Titan titans: lane.getTitans()){
					VBox titanWithHealth= TitanView.getRoot();
					StackPane stack = new StackPane();
					stack.setLayoutX(titans.getDistance());
					stack.setLayoutY(Math.random()*70);
					stack.getChildren().add(titanWithHealth);
					Lanes[0].getChildren().add(stack);
				}
				
			}*/
		/*public void moveTitans() {
		    // Iterate over each lane and update the Titan positions
		    for (int i = 0; i < Battle1.getOriginalLanes().size(); i++) {
		        Lane lane = Battle1.getOriginalLanes().get(i);
		        Pane lanePane = Lanes[i]; // Assuming Lanes is an array of Pane objects corresponding to each lane
		        lanePane.getChildren().clear(); // Clear previous Titan views

		        for (Titan titan : lane.getTitans()) {
		            VBox titanWithHealth = TitanView.getRoot(); // Update to get the VBox for each Titan
		            StackPane stack = new StackPane();
		            stack.setLayoutX(titan.getDistance()); // Set the new position based on the updated distance
		            stack.setLayoutY(Math.random() * 70); // Random Y position for visual separation

		            stack.getChildren().add(titanWithHealth);
		            lanePane.getChildren().add(stack);
		        }
		    }
		}*/
			    
			   /* public void moveTitans() {
				    laneGrid.getChildren().clear();
				    for (int i = 0; i < Battle1.getOriginalLanes().size(); i++) {
				        Lane lane = Battle1.getOriginalLanes().get(i);
				        for (Titan titan : lane.getTitans()) {
				        	  TitanView titanView = new TitanView(); // Create a new TitanView for each Titan
				              VBox titanWithHealth = titanView.getRoot();
				            laneGrid.add(titanWithHealth, 0, Battle1.getOriginalLanes().indexOf(lane));
				            titanWithHealth.setTranslateX(titan.getDistance() * 12.5);
				            if(titan instanceof PureTitan){
				            	titanWithHealth.setTranslateY(35);
				            }
				            else if(titan instanceof AbnormalTitan){
				            	titanWithHealth.setTranslateY(20);
				            }
				            else if (titan instanceof ArmoredTitan){
				            	
				            }
				            else{
				            	titanWithHealth.setTranslateY(-30);
				            }
				        }
				    }
				}*/
				
			    
			   
			    
			    public void callStart (Stage primaryStage)
				{
					try
					{
						Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
						Scene scene = new Scene (root);
						primaryStage.setWidth(1400);
						primaryStage.setHeight(780);
						//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						primaryStage.setScene(scene);
						primaryStage.show();
						primaryStage.setResizable(false);
						//Image icon = new Image("icon1.png");//gebna el sora
						//primaryStage.getIcons().add(icon);//7atenaha mn foo2 fy el window
						primaryStage.setTitle("Attack on Titan");
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					
				}
				
			    public void moveTitansLemby(){
				    for (int i = 0; i < Battle1.getOriginalLanes().size(); i++) {
		        	Lane lane = Battle1.getOriginalLanes().get(i);
		        	laneGrid[i].getChildren().clear();
		        	for(Titan titan: lane.getTitans()){
		        		TitanView titanView = new TitanView();
		        		VBox titanWithHealth= titanView.getRoot();
		        		StackPane stack = new StackPane();
		        		stack.setLayoutX(titan.getDistance());
//					    root.getChildren().add(t.getTitanView().getRoot());
		        		if(titan instanceof PureTitan){
		        			stack.setLayoutX(titan.getDistance()*30);
			            }
			            else if(titan instanceof AbnormalTitan){
			            	stack.setLayoutX(titan.getDistance()*30);
			            }
			            else if (titan instanceof ArmoredTitan){
			            	stack.setLayoutX(titan.getDistance()*30);
			            }
			            else{
			            	 stack.setLayoutX(titan.getDistance()*30);
			            }
		        		stack.getChildren().add(titanWithHealth);
		        		laneGrid[i].getChildren().add(stack);
		        	}
		        }
			}
			    
			
			    public void moveTitans() {
				    for (int i = 0; i < Battle1.getOriginalLanes().size(); i++) {
		        	Lane lane = Battle1.getOriginalLanes().get(i);
		        	laneGrid[i].getChildren().clear();
		        	for(Titan titan: lane.getTitans()){
		        		TitanController titanCont= new TitanController(titan);
		        		String str = titanCont.titanImage(titan);
		        		ImageView image = new ImageView(str);
		        		image.setFitHeight(100);
		        		image.setFitWidth(100);
		        		Label text = new Label("Healt: "+titan.getCurrentHealth() +"\n"+ "Height:  " + titan.getHeightInMeters());
		        		text.setStyle("-fx-text-fill: white;");
		        		StackPane stack = new StackPane();
		        		stack.setLayoutX(titan.getDistance()*12.5);
		        		if(titan instanceof PureTitan){
			            	stack.setLayoutY(30);
			            }
			            else if(titan instanceof AbnormalTitan){
			            	stack.setLayoutY(20);
			            }
			            else if (titan instanceof ArmoredTitan){
			            	
			            }
			            else{
			            	stack.setLayoutY(-20);
			            }
		        		stack.getChildren().addAll(image);
		        		stack.getChildren().add(text);
		        		laneGrid[i].getChildren().add(stack);
		        	}
		        }
			  
			    }
			    public Label getTextArea(int n){
			    	if (n==0){
			    		return text1;
			    	}
			    	else if(n == 1){
			    		return text2;
			    	}
			    	else if(n == 2){
			    		return text3;
			    	}
			    	else if(n == 3){
			    		return text4;
			    	}
			    	else {
			    		return text5;
			    	}
			    	
			    }
		
}
			    


	

	
	
	
	


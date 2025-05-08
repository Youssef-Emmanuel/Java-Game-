package game.main;

import java.awt.Label;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main (String [] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		//Stage stage = new Stage();
		
		//Parent dan = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Group root = new Group();
		Scene scene = new Scene(root, Color.BLACK); //loon background el window
		stage.setScene(scene);
		stage.show();
		
		//icon el biban 3al task bar w foo2 fy el window
		Image icon = new Image("icon1.png");//gebna el sora
		stage.getIcons().add(icon);//7atenaha mn foo2 fy el window
		stage.setTitle("Attack on Titan"); // Title el game fy el window mn foo2
		stage.setWidth(1778);
		stage.setHeight(1000);
		//stage.setFullScreen(true);// bi5aly el window tfta7 full screen mn awel mara
		stage.setResizable(false); // bi5aly size el window msh bit8aiair
		
		
		
		// add main menu background image
		Image image = new Image("MainMenu.jpeg");
		ImageView imageView = new ImageView(image);
		imageView.setX(0);
		imageView.setY(0);
		root.getChildren().add(imageView);
		
		
		/*texts*/
		
		//Title of game in main menu text
		//Text TitleText = new Text();
		//TitleText.setText("Attack on Titan"); // el moktoob fy el text nafso
		//TitleText.setX(750); // Select location of text on window
		//TitleText.setY(750);
		//root.getChildren().add(TitleText); // 3shan t add el text fy el window
		//TitleText.setFont(Font.font("Vermin Vibes",50));
		//TitleText.setFill(Color.DARKTURQUOISE);
		

	
	}

}

package game.gui;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ClossalTitanSprite extends Application {
	 
	
    private Image[] frames;  // Array to hold all the frame images
    private ImageView imageView; // The view that will display the frames
    private int currentFrame = 0; // Index of the current frame to display
    private final int numFrames = 10; // Total number of frames in the animation
    private final long frameDuration = 1000000000 / 60; // Duration of each frame in nanoseconds (for 60 fps)
	
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Initialize the array of frame images
        frames = new Image[numFrames];
        for (int i = 0; i < numFrames; i++) {
            frames[i] = new Image("0_Zombie_Villager_Walking_" + i + ".png");
        }

        // Set up the ImageView with the first frame
        imageView = new ImageView(frames[0]);
        root.getChildren().add(imageView);

        // Create an AnimationTimer to cycle through the frames
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= frameDuration) {
                    currentFrame = (currentFrame + 1) % numFrames; // Update the frame index
                    imageView.setImage(frames[currentFrame]); // Set the ImageView to the current frame
                    lastUpdate = now;
                }
            }
        };

        timer.start(); // Start the animation

        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}

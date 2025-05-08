package game.gui;

import game.engine.base.Wall;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;
import game.engine.weapons.Weapon;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class WeaponView {

	private Weapon weapon;
	VBox root = new VBox();
	
	// weapon 1
    Image img1 = new Image(getClass().getResource("piercingcannon.jpg").toExternalForm());
    ImageView view1 = new ImageView(img1);
   
    // weapon 2
    Image img2 = new Image(getClass().getResource("snipercannon.jpg").toExternalForm());
    ImageView view2 = new ImageView(img2);
	
    // weapon 3
    Image img3 = new Image(getClass().getResource("volleyballspreadcannon.jpg").toExternalForm());
    ImageView view3 = new ImageView(img3);
 
    //weapon 4
    Image img4 = new Image(getClass().getResource("walltrap.jpg").toExternalForm());
    ImageView view4 = new ImageView(img4);
    
    public WeaponView(Weapon weapon){
    	if(weapon instanceof PiercingCannon)
    		root.getChildren().add(view1);
    	if(weapon instanceof SniperCannon)
    		root.getChildren().add(view2);
    	if(weapon instanceof VolleySpreadCannon)
    		root.getChildren().add(view3);
    	if(weapon instanceof WallTrap)
    		root.getChildren().add(view4);
    }

	public Weapon getWeapon() {
		return weapon;
	}
    
    
}
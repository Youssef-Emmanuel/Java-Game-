package game.gui;

import game.engine.weapons.Weapon;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class WeaponShopView {
    public VBox root;

    public WeaponShopView() {
        root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        // Add weapon shop view
        addWeaponItem("Piercing Cannon", "piercingcannon.jpg");
        addWeaponItem("Sniper Cannon", "snipercannon.jpg");
        addWeaponItem("Volley Spread Cannon", "volleyspreadcannon.jpg");
        addWeaponItem("Wall Trap", "walltrap.jpg");
    }

    // add weapon item to the shop view
    private void addWeaponItem(String name, String imageName) {
        Image image = new Image(getClass().getResourceAsStream(imageName));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        Label nameLabel = new Label(name);

        VBox itemBox = new VBox(imageView, nameLabel);
        itemBox.setSpacing(5);

        root.getChildren().add(itemBox);
    }
}
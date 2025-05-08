package game.gui;
import java.util.ArrayList;

import javafx.scene.image.Image;
import game.engine.Battle;
import game.engine.lanes.Lane;
import game.engine.titans.*;

public class TitanController {
	
	private Titan Titan;
	private TitanView titanView;
	
	
	
	public TitanController(Titan titan) {
		this.Titan = titan;
		this.titanView = new TitanView();
		titanImage(titan);
		updateTitanHealth();
		
	}
	
	public void updateTitanHealth() {
		titanView.updateHealth(Titan);
	}
	
	public String titanImage(Titan t)
	{	String str="";
		if ( Titan instanceof PureTitan)
		{
			str= "titan1.png";
		}
		if ( Titan instanceof AbnormalTitan)
		{
			str= "titan2.png";
		}
		if ( Titan instanceof ColossalTitan)
		{
			str= "titan3.png";
		}
		if ( Titan instanceof ArmoredTitan)
		{
			str= "titan4.png";
		}
		return str;
	}
	public Titan getTitan() {
		return Titan;
	}

	public TitanView getTitanView() {
		return titanView;
	}
	
	
	


}

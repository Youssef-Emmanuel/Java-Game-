package game.gui;

import game.engine.base.Wall;



public class WallController {
	
	private Wall wall;
	private WallView wallview; 
	
	public WallController(Wall wall,WallView wallview){
		this.wall=wall;
		this.wallview=wallview;
	}
	
	public void updateWallHealth(int damage){
		wall.takeDamage(damage);
		if(wall.isDefeated())
			wallview.defeated();
		else
			wallview.updateHealth(wall);
	}
	


}

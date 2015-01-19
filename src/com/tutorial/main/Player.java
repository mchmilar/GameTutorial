package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	private Handler handler;
	
	public Player(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp((int)x, 0, Game.WIDTH - 32);
		y = Game.clamp((int)y, 0, Game.HEIGHT - 32 );
		
		handler.addObject(new Trail((int)x, (int)y, 32, 32, 0.3f, ID.Trail, Color.WHITE, handler));
		
		collision();
		
	}
	
	private void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy){
				if (this.getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH -= 2;
					HUD.GREEN_VALUE -= 5;
					HUD.RED_VALUE += 5;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}
	
	

}

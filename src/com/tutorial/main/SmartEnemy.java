package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	
	private Handler handler;
	private GameObject player;

	public SmartEnemy(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getID() == ID.Player) player = handler.object.get(i);
		}
		
		
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		double diffX = x - player.getX() - 8;
		double diffY = y - player.getY() - 8;
		double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
		
		velX = ((-2 / distance) * diffX);
		velY = ((-2 / distance) * diffY);
		
	//	if (y <= 0 || y >= Game.HEIGHT - 16) velY *= -1;
	//	if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail(x, y, 16, 16, 0.03f, ID.Trail, Color.green, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}


}

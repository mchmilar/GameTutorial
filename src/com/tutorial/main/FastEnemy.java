package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
	
	private Handler handler;

	public FastEnemy(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		int sign = Game.r.nextInt(2);
		if (sign == 0) 
			velX = -2;
		else velX = 2;
		sign = Game.r.nextInt(2);
		if (sign == 0)
			velY = -9;
		else velY = 9;
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 16) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail(x, y, 16, 16, 0.03f, ID.Trail, Color.CYAN, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}


}

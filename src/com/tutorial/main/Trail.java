package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width, height;
	private float life;
	
	public Trail(double x, double y, int width, int height, float life, ID id, Color color, Handler handler){
		super(x, y, id);
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.life = life;
		this.color = color;
	}

	@Override
	public void tick() {
		if (alpha > life){
			alpha -= life - 0.0001f;
		} else handler.removeObject(this);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);

		g2d.setComposite(makeTransparent(1));
		
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}
	
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
}

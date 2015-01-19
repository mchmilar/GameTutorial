package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	
	static int HEALTH = 100;
	
	static int GREEN_VALUE = 255;
	static int RED_VALUE = 0;
	
	private int score = 0;
	private int level = 1;
	
	public void tick(){
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
						
		GREEN_VALUE = Game.clamp(GREEN_VALUE, 0, 255);
		RED_VALUE = Game.clamp(RED_VALUE, 0, 255);
		
		score++;
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(new Color(RED_VALUE, GREEN_VALUE, 0));
		g.fillRect(15, 15, HEALTH * 2, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 15 , 64);
		g.drawString("Level: " + level, 15 , 80);

	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}

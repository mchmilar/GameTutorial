package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_E) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_D) tempObject.setVelY(5);
				if(key == KeyEvent.VK_S) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_F) tempObject.setVelX(5);
			}
						
		}
		if (key == KeyEvent.VK_ESCAPE) System.exit(0);
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
for (int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_E) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelX(0);
				if(key == KeyEvent.VK_F) tempObject.setVelX(0);
			}
			
			
		}
	}

}

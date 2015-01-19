package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown;
	
	public KeyInput(Handler handler){
		this.handler = handler;
		keyDown = new boolean[4];
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_E) { 
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_D) {
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_S) {
					tempObject.setVelX(-5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_F) {
					tempObject.setVelX(5);
					keyDown[3] = true;
				}
			}
						
		}
		if (key == KeyEvent.VK_ESCAPE) System.exit(0);
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
for (int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_E) keyDown[0] = false; 
				if(key == KeyEvent.VK_D) keyDown[1] = false; 
				if(key == KeyEvent.VK_S) keyDown[2] = false; 
				if(key == KeyEvent.VK_F) keyDown[3] = false; 
				
				//vertical movement
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				
				//horizontal movement
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
			
			
		}
	}

}

package com.tutorial.main;

public class Spawn {
	
	private HUD hud;
	private Handler handler;
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scoreKeep++;
		
		if(scoreKeep >= 10) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1	);
			
			if (hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(Game.r.nextInt(Game.WIDTH - 16), Game.r.nextInt(Game.HEIGHT - 16), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(Game.r.nextInt(Game.WIDTH - 16), Game.r.nextInt(Game.HEIGHT - 16), ID.BasicEnemy, handler));
			} else if (hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(Game.r.nextInt(Game.WIDTH - 16), Game.r.nextInt(Game.HEIGHT - 16), ID.FastEnemy, handler));
			} else if (hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(Game.r.nextInt(Game.WIDTH - 16), Game.r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
			}
		}
	}
	

}

package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.Random;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;

	private Enemy enemy;

	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		
		player = new Player();

		enemy = new Enemy();
		
	}
	
	public void update(float dt) {
		
		handleInput();
		enemyInput();
		
		player.update(dt);

		enemy.update(dt);
		
	}
	
	public void draw() {
		player.draw(sr);
		enemy.draw(sr);
	}
	
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));

	}

	public void enemyInput(){
		Random rand = new Random();
		int random = rand.nextInt(4);

		if (random == 0){
			enemy.setUp(true);
			enemy.setRight(false);
			enemy.setLeft(false);
		} else if (random == 1) {
			enemy.setUp(false);
			enemy.setRight(true);
			enemy.setLeft(false);
		} else if (random == 2) {
			enemy.setUp(false);
			enemy.setRight(false);
			enemy.setLeft(true);
		}
	}
	
	public void dispose() {}
	
}










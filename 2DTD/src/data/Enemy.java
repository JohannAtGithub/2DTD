package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

public class Enemy {
	
	private int  width, height, health, currentCheckpoint;
	private float x, y, speed;
	private Texture texture;
	private Tile startTile;
	private boolean first = true;
	private TileGrid grid;
	
	private ArrayList<Checkpoint> checkpoints;
	private int[] directions;
	
	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed) {
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.grid = grid;
		
		this.checkpoints = new ArrayList<Checkpoint>();
		this.directions = new int[2];
		this.directions[0] = 0; //x direction
		this.directions[1] = 1; //y direction
		directions = FindNextDirection(startTile);
		this.currentCheckpoint = 0;
		PopulateCheckpointList();
	}
	
	public void Update() {
		if (first) 
			first = false;
		else {
			x += Delta() * directions[0];
			y += Delta() * directions[1];
		}	
	}
	
	private void PopulateCheckpointList() {
		checkpoints.add(FindNextCheckpoint(startTile, directions = FindNextDirection(startTile)));
		
		int counter = 0;
		boolean cont = true;
		while (cont) {
			int[] currentDirection = FindNextDirection(checkpoints.get(counter).getTile());
			if (currentDirection[0] == 2) {
				cont = false;
			} else {
				checkpoints.add(FindNextCheckpoint(checkpoints.get(counter).getTile(), 
						directions = FindNextDirection(checkpoints.get(counter).getTile())));
			}
			counter++;
		}
	}
	
	/*
	 * Find the next turn of the path from our current position
	 */
	private Checkpoint FindNextCheckpoint(Tile startTile, int[] dir) {
		Tile next = null;
		Checkpoint c = null;
		
		//Boolean to decide if next checkpoint is found
		boolean found = false;
		
		//Integer to increment each loop
		int counter = 1;
		
		while (!found) {
			if (startTile.getType() != 
					grid.getTile(startTile.getXPlace() + dir[0] * counter, 
							startTile.getYPlace() + dir[1] * counter).getType()) {
				found = true;
				//Move counter back 1 to find tile before new tiletype
				counter -= 1;
				next  = grid.getTile(startTile.getXPlace() + dir[0] * counter, 
							startTile.getYPlace() + dir[1] * counter);
			}
			
			counter++;
		}
		
		c = new Checkpoint(next, dir[0], dir[1]);
		return c;
	}
	
	/*
	 * The method calculates which direction the enemies needs to go next
	 * and giving back that data
	 */
	private int[] FindNextDirection(Tile startTile) {
		int[] dir = new int[2];
		Tile up = grid.getTile(startTile.getXPlace(), startTile.getYPlace() - 1);
		Tile right = grid.getTile(startTile.getXPlace() + 1, startTile.getYPlace());
		Tile down = grid.getTile(startTile.getXPlace(), startTile.getYPlace() + 1);
		Tile left = grid.getTile(startTile.getXPlace() - 1, startTile.getYPlace());
		
		if (startTile.getType() == up.getType()) {
			dir[0] = 0;
			dir[1] = -1;
		} else if (startTile.getType() == right.getType()) {
			dir[0] = 1;
			dir[1] = 0;
		} else if (startTile.getType() == down.getType()) {
			dir[0] = 0;
			dir[1] = 1;
		} else if (startTile.getType() == left.getType()) {
			dir[0] = -1;
			dir[1] = 0;
		} else {
			dir[0] = 2;
			dir[1] = 2;
			System.out.println("NO DIRECTION FOUND");
		}
			
		
		
		
		return dir;
	}
	
	
	
	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public TileGrid getTileGrid() {
		return grid;
	}
	
	
}

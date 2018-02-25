package data;

import static helpers.Artist.QuickLoad;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	
	//Temp Variables
	TowerCannon tower;
	
	public Game(int[][] map) {
		grid = new TileGrid(map);
		player = new Player(grid);
		waveManager = new WaveManager(new Enemy(QuickLoad("UFO64"), grid.getTile(12, 10), grid, 64, 64, 60), 
				4, 5);
		
		tower = new TowerCannon(QuickLoad("cannonBase"), grid.getTile(13, 8), 5);
	}
	
	public void Update() {
		grid.Draw();
		waveManager.Update();
		player.Update();
		
		tower.Update();
	}

}

package data;

import static helpers.Artist.*;

public class TileGrid {

	public Tile[][] map;
	
	public TileGrid() {
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i * 64, j * 64 , 64, 64, TileType.Grass);
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i * 64, j * 64 , 64, 64, TileType.Grass);
					break;
				case 1:
					map[i][j] = new Tile(i * 64, j * 64 , 64, 64, TileType.Dirt);
					break;
				case 2:
					map[i][j] = new Tile(i * 64, j * 64 , 64, 64, TileType.Water);
					break;
				default:
						break;
				}
			}
		}
	}
	
	public void Draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
	}
	
}

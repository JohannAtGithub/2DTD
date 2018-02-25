package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;

public class Boot {
	
	public Boot() {
		
		BeginSession();
		
		
		Tile tile = new Tile(0, 0, 64, 64, TileType.Grass);
		Tile tile2 = new Tile(64, 0, 64, 64, TileType.Dirt);
		/*
		 * game loop
		 * don't end until Display is closed
		 */
		while(!Display.isCloseRequested()) {
			
			DrawQuadTex(tile.getTexture(), tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
			DrawQuadTex(tile2.getTexture(), tile2.getX(), tile2.getY(), tile2.getWidth(), tile2.getHeight());
			
			Display.update();
			Display.sync(60);
		}
	}
	
	public static void main(String[] args) {
		new Boot();
	}
}

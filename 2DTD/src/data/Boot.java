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
		
		
		TileGrid grid = new TileGrid();
		/*
		 * game loop
		 * don't end until Display is closed
		 */
		while(!Display.isCloseRequested()) {
			
			grid.Draw();
			
			Display.update();
			Display.sync(60);
		}
	}
	
	public static void main(String[] args) {
		new Boot();
	}
}

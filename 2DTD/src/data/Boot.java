package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;

public class Boot {
	
	public Boot() {
		
		BeginSession();
		
		float width = 50, height = 50, x = 100, y = 100;
		
		/*
		 * game loop
		 * don't end until Display is not closed
		 */
		while(!Display.isCloseRequested()) {
			glBegin(GL_LINES);
			glVertex2f(10, 10);
			glVertex2f(100, 100);
			glEnd();
			
			glBegin(GL_QUADS);
			glVertex2f(x, y);
			glVertex2f(x + width, y);
			glVertex2f(x + width, y + height);
			glVertex2f(x, y + height);
			glEnd();
			
			Display.update();
			Display.sync(60);
		}
	}
	
	public static void main(String[] args) {
		new Boot();
	}
}

package data;

import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class TowerCannon {

	private float x, y, timeSinceLastShot, firingSpeed;
	private int width, height, damage;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;

	public TowerCannon(Texture baseTexture, Tile startTile, int damage) {
		this.baseTexture = baseTexture;
		this.cannonTexture = QuickLoad("cannonGun");
		this.startTile = startTile;
		this.damage = damage;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.firingSpeed = 3;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
	}

	private void Shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(QuickLoad("bullet"), x + 32,  y + 32, 150, 10));
	}

	public void Update() {
		timeSinceLastShot += Delta();
		if (timeSinceLastShot > firingSpeed)
			Shoot();
		
		for (Projectile p : projectiles) {
			p.Update();
		}
		
		Draw();
	}

	public void Draw() {
		DrawQuadTex(baseTexture, x, y, width, height);
		DrawQuadTexRotate(cannonTexture, x, y, width, height, 45);
	}
}

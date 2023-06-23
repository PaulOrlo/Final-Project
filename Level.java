import java.awt.*;

public class Level {
    private Rectangle[] enemies;
    private boolean hitWall;

    public Level() {
        // all variables are set here
        this.hitWall = false;
        this.enemies = new Rectangle[15];
        this.enemies[0] = new Rectangle(750, 50, 40, 60);
        this.enemies[1] = new Rectangle(750, 150, 40, 60);
        this.enemies[2] = new Rectangle(750, 250, 40, 60);
        this.enemies[3] = new Rectangle(750, 350, 40, 60);
        this.enemies[4] = new Rectangle(750, 450, 40, 60);
        this.enemies[5] = new Rectangle(700, 50, 40, 60);
        this.enemies[6] = new Rectangle(700, 150, 40, 60);
        this.enemies[7] = new Rectangle(700, 250, 40, 60);
        this.enemies[8] = new Rectangle(700, 350, 40, 60);
        this.enemies[9] = new Rectangle(700, 450, 40, 60);
        this.enemies[10] = new Rectangle(650, 50, 40, 60);
        this.enemies[11] = new Rectangle(650, 150, 40, 60);
        this.enemies[12] = new Rectangle(650, 250, 40, 60);
        this.enemies[13] = new Rectangle(650, 350, 40, 60);
        this.enemies[14] = new Rectangle(650, 450, 40, 60);

    }
// draw method
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        for (Rectangle r : this.enemies) {
            g.fill(r);
        }

    }

    public void hitDetection(Player laser) {
       //hit detection of the laser and the enemy
        for (Rectangle r : this.enemies) {

            if (laser.checkCollision(r)) {

                r.y = -600;
                laser.handleCollision(r);

            }

        }
    }
// hit detedtion with the enemy and the player
    public void playerHitDetection(Player player) {
        for (Rectangle r : this.enemies) {
            if (player.playerCheckCollision(r)) {
                player.playerHandleCollision(r);

                for (int i = 0; i < this.enemies.length; i++) {
                    this.enemies[i].y = -600;

                }
            }
        }
    }
// enemy movement
    public void eMovement() {
        // for loop runs and sees which enemy hits the wall first
        for (int i = 0; i < enemies.length; i++) {
            // if the hit wall boolean is false the enemies move up
            if (this.hitWall == false) {
                this.enemies[i].y -= 1;

            }

            if (enemies[i].y == 0) {
              // if the enemies are at the top of the scren and hit their position will be shiften 50 units forward
                for (int j = 0; j < enemies.length; j++) {
                    this.enemies[j].x = this.enemies[j].x - 50;
                }
                this.hitWall = true;
            }
            //if they hit the other wall they will continue to move down
            if (this.hitWall == true) {
                this.enemies[i].y += 1;
            }
            // if the enemy hits the botton their position will be shifted 50 units forward
            if (enemies[i].y == 550) {
                for (int j = 0; j < enemies.length; j++) {
                    this.enemies[j].x = this.enemies[j].x - 50;
                }
                this.hitWall = false;
            }
        }
    }

}
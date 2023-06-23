import java.awt.*;

public class Player {
    private Rectangle player;
    private Rectangle laser;
    private int speed;
    private boolean moveUp;
    private boolean moveDown;
    private boolean shoot;

    private int laserSpeed;

    public Player(int x, int y, int width, int height) {
        this.player = new Rectangle(x, y, width, height);
        this.laser = new Rectangle(player.x, player.y, 50, 30);

        this.speed = 5;
        this.moveUp = false;
        this.moveDown = false;
        this.shoot = false;
        this.laserSpeed = 10;

    }

    public void setMoveUp(boolean value) {
        this.moveUp = value;
    }

    public void setMoveDown(boolean value) {
        this.moveDown = value;
    }

    public void setShoot(boolean value) {
        this.shoot = value;
    }

    public boolean checkCollision(Rectangle enemy) {
        return this.laser.intersects(enemy);

    }

    public boolean playerCheckCollision(Rectangle enemy) {
        return this.player.intersects(enemy);
    }

    public void update() {
        // upwards movement
        if (this.moveUp) {
            this.player.y -= this.speed;
       // downards movement
        } else if (this.moveDown) {
            this.player.y += this.speed;
        }
        // this will return the laser back to the player once it goes past a certain point
        if (this.shoot) {

            this.laser.x += this.laserSpeed;

            if (this.laser.x > 850) {
                this.laser.x = this.player.x;
                shoot = false;
            }

        } else {
            this.laser.x = this.player.x;
            this.laser.y = this.player.y;
        }
       // these are the top and bottom boundaries for the player
        if (this.player.y == 0) {
            this.player.y += this.speed;
        } else if (this.player.y == 500) {
            this.player.y -= this.speed;
        }

    }
// this draws all the objects 
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fill(this.laser);
        g.setColor(Color.GREEN);
        g.fill(this.player);

    }
// laser collision
    public void handleCollision(Rectangle r) {
        if (this.laser.intersects(r)) {

            shoot = true;
        } else {
            shoot = false;
            this.laser.x = this.player.x;
            this.laser.y = this.player.y;
        }
    }
// enemy to player collision
    public void playerHandleCollision(Rectangle r) {
        if (r.y + r.height >= player.y) {

            this.player.y = -600;

        }

    }

}
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class Main {

  // Set up all the game variables to make the window work
  final int FPS = 60;
  final int WIDTH = 800;
  final int HEIGHT = 600;
  final String TITLE = "My Drawing";
  Drawing drawing;

  // ▼▼▼▼ Your own class variables go under here ▼▼▼▼
  Player player;
  Level level;

  // ▲▲▲▲ You own class variables go above here ▲▲▲▲

  // ☠ DO NOT TOUCH THE CODE IN THE MAIN METHOD ☠
  // this is what helps create the window
  // I have moved a bunch of code into another file to try and hide it from you
  public Main() {
    // initialize anything you need to before we see it on the screen
    start();
    // create the screen and show it
    drawing = new Drawing(TITLE, WIDTH, HEIGHT, FPS, this);
    // make sure key and mouse events work
    // this is like an actionListener on buttons except it's the keyboard and mouse
    drawing.addKeyListener(new Keyboard());
    Mouse m = new Mouse();
    drawing.addMouseListener(m);
    drawing.addMouseMotionListener(m);
    drawing.addMouseWheelListener(m);
    // start the game loop
    drawing.loop();
  }

  // use this method to set values to anything BEFORE the game starts
  // this only runs at the very beginning
  public void start() {
    this.player = new Player(50, 400, 50, 100);
    this.level = new Level();

  }

  // this is where all the drawing happens
  // put all of your drawing code in this method
  public void paintComponent(Graphics2D g) {
    this.level.draw(g);
    this.player.draw(g);
    

  }

  // this is the main game loop
  // this is where all of the program logic goes
  // this method automatically repeats over and over again
  // it tries to update as fast as the frames per second you set above (deault is
  // 60 updates each second)
  public void loop() {
    this.player.update();
    this.level.hitDetection(this.player);
    this.level.eMovement();
    this.level.playerHitDetection(this.player);
  

    
  }

  // Used to implement any of the Mouse Actions
  private class Mouse extends MouseAdapter {

    // if a mouse button has been pressed down
    @Override
    public void mousePressed(MouseEvent e) {

    }

    // if a mouse button has been released
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // if the scroll wheel has been moved
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    // if the mouse has moved positions
    @Override
    public void mouseMoved(MouseEvent e) {

    }
  }

  // Used to implements any of the Keyboard Actions
  private class Keyboard extends KeyAdapter {

    // if a key has been pressed down
    @Override
    public void keyPressed(KeyEvent e) {
      // determine which key was pressed
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_W) {
        player.setMoveUp(true);
      } else if (key == KeyEvent.VK_S) {
        player.setMoveDown(true);
      }
      if (key == KeyEvent.VK_SPACE) {
        player.setShoot(true);
      }

    }

    // if a key has been released
    @Override
    public void keyReleased(KeyEvent e) {
      // determine which key was pressed
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_W) {
        player.setMoveUp(false);
      } else if (key == KeyEvent.VK_S) {
        player.setMoveDown(false);
      }

    }
  }

  // the main method that launches the game when you hit run
  public static void main(String[] args) {
    Main game = new Main();
  }

}

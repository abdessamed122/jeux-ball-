import javax.swing.*;
import java.awt.*;
// import java.awt.Dimension;
// import java.awt.Graphics;

// import javax.swing.JPanel;

class Balle {
  private JPanel panneau;
  private int x, y, dx = 2, dy = 3;
  private static final int taille = 30;
  public Balle(JPanel panneau) { this.panneau = panneau; }
  public void dessine() {
    Graphics surface = panneau.getGraphics(); // r�cup�re les ressources graphiques
    surface.fillOval(x, y, taille, taille); // pour permettre le trac� des dessins
    surface.dispose();  // lib�re les ressources graphiques pour d'autres apllications
  }
  public void deplace() {
    Graphics surface = panneau.getGraphics();
    surface.setXORMode(panneau.getBackground());
    surface.fillOval(x, y, taille, taille);  // efface l'ancien trac� gr�ce � la fonction XOR
    x += dx; y += dy;
    Dimension dim = panneau.getSize(); // dimension du panneau
    if (x<0) { x=0; dx = -dx; }
    if (x+taille >= dim.width) { x = dim.width - taille; dx = -dx; }
    if (y<0) { y=0; dy = -dy; }
    if (y+taille >= dim.height) { y = dim.height - taille; dy = -dy; }
    surface.fillOval(x, y, taille, taille); // trace le nouvel emplacement de la balle
    surface.dispose();
  }
  public void rebond() {
    dessine();
    for (int i=0; i<1000; i++) {
      deplace();
      try { Thread.sleep(5); }
      catch (InterruptedException e) {}
    }
  }
}
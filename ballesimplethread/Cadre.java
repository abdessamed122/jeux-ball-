
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cadre extends JFrame {
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JButton boutonDemarrer = new JButton();
  JButton boutonFermer = new JButton();
  JPanel panneau = new JPanel();

  /**Construire le cadre*/
  public Cadre() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  /**Initialiser le composant*/
  private void jbInit() throws Exception  {
    //setIconImage(Toolkit.getDefaultToolkit().createImage(Cadre.class.getResource("[Votre ic�ne]")));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(315, 250));
    this.setTitle("Game balle pawred by abde ssamed");
    boutonDemarrer.setText("Dmarrer");
    boutonDemarrer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boutonDemarrer_actionPerformed(e);
      }
    });
    boutonFermer.setText("Fermer");
    boutonFermer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        boutonFermer_actionPerformed(e);
      }
    });
    panneau.setBackground(Color.orange);
    contentPane.add(jPanel1, BorderLayout.SOUTH);
    jPanel1.add(boutonDemarrer, null);
    jPanel1.add(boutonFermer, null);

    contentPane.add(panneau, BorderLayout.CENTER);
  }
  /**Remplac�, ainsi nous pouvons sortir quand la fen�tre est ferm�e*/
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void boutonDemarrer_actionPerformed(ActionEvent e) {
    Balle balle = new Balle(panneau);
    balle.rebond();
  }

  void boutonFermer_actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}
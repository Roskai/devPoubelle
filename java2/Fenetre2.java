import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Fenetre2 extends JFrame implements ActionListener {

  private JLabel messageEnvoiLabel;
  private JButton envoyerButton;
  private JLabel messageRecuLabel;
  private JTextArea messageEnvoiTextArea;
  private JButton recevoirButton;
  private JTextArea messageRecuTextArea;

  /*
   * Code du diagrame de classe
   */
  private BufferedWriter writer;
  private BufferedReader reader;
  private Socket socket;

  public Fenetre2(Socket socket, BufferedReader reader, BufferedWriter writer) {
    initComponents(socket, reader, writer);
  }

  private void initComponents(Socket socket, BufferedReader reader, BufferedWriter writer) {
    this.setTitle("Fenetre2");
    this.setSize(800, 800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    GridLayout grid = new GridLayout(3, 2);
    this.setLayout(grid);
    this.writer = writer;
    this.reader = reader;
    messageEnvoiLabel = new JLabel("Message à envoyer");
    this.add(messageEnvoiLabel);

    messageEnvoiTextArea = new JTextArea();
    this.add(messageEnvoiTextArea);

    envoyerButton = new JButton("Envoyer");
    this.add(envoyerButton);

    recevoirButton = new JButton("Recevoir");
    this.add(recevoirButton);

    messageRecuLabel = new JLabel("Message à recevoir");
    this.add(messageRecuLabel);

    messageRecuTextArea = new JTextArea();
    this.add(messageRecuTextArea);

    envoyerButton.addActionListener(this);
    recevoirButton.addActionListener(this);

    this.pack();
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == envoyerButton) {
      String message = messageEnvoiTextArea.getText();
      try {
        writer.write(message);
        writer.newLine();
        writer.flush();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (e.getSource() == recevoirButton) {
      String message;
      try {
        message = reader.readLine();
        messageRecuTextArea.append(message);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  /** main entry point */
  /**
   * public static void main(String[] args) throws Exception { BufferedWriter
   * writer = new BufferedWriter(new FileWriter("A2B.txt")); BufferedReader reader
   * = new BufferedReader(new FileReader("A2B.txt")); Fenetre2 f2 = new
   * Fenetre2(reader, writer); }
   **/

  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("localhost", 1952);
    
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in);
    Fenetre2 f2 = new Fenetre2(socket, reader, writer);
    Fenetre2 f22 = new Fenetre2(socket, reader, writer);
  }
}

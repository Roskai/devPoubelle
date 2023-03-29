import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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

public class Fenetre2 extends JFrame implements ActionListener, Runnable {

  private static final long serialVersionUID = 1L;

  private JLabel messageEnvoiLabel;
  private JButton envoyerButton;
  private JLabel messageRecuLabel;
  private JTextArea messageEnvoiTextArea;
  private JButton recevoirButton;
  private JTextArea messageRecuTextArea;

  private BufferedWriter writer;
  private BufferedReader reader;

  public Fenetre2(BufferedReader reader, BufferedWriter writer) {
    this.writer = writer;
    this.reader = reader;
    initComponents();
  }

  private void initComponents() {
    setTitle("Fenetre2");
    setSize(800, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    GridLayout grid = new GridLayout(3, 2);
    setLayout(grid);

    messageEnvoiLabel = new JLabel("Message à envoyer");
    add(messageEnvoiLabel);

    messageEnvoiTextArea = new JTextArea();
    add(messageEnvoiTextArea);

    envoyerButton = new JButton("Envoyer");
    add(envoyerButton);

    recevoirButton = new JButton("Recevoir");
    add(recevoirButton);

    messageRecuLabel = new JLabel("Message à recevoir");
    add(messageRecuLabel);

    messageRecuTextArea = new JTextArea();
    add(messageRecuTextArea);

    envoyerButton.addActionListener(this);
    recevoirButton.addActionListener(this);

    setVisible(true);
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

  @Override
  public void run() {
    setVisible(true);
  }

  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 10000);

      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

      Fenetre2 frame1 = new Fenetre2(reader, writer);
      Fenetre2 frame2 = new Fenetre2(reader, writer);

      Thread thread1 = new Thread(frame1);
      Thread thread2 = new Thread(frame2);

      thread1.start();
      thread2.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

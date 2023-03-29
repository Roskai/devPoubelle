/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Communica extends JFrame implements WindowListener, Runnable {

  private BufferedWriter writer;
  private BufferedReader reader;
  private JButton bReceive;
  private JButton bSend;
  private JLabel lmessrec;
  private JLabel lmesssend;
  private JTextArea textRec;
  private JTextArea textTosend;
  private Thread communicaThread;

  public Communica(BufferedReader r, BufferedWriter w) {

    this.reader = r;
    this.writer = w;
    initComponents();
    addWindowListener(this);
    bReceive.setEnabled(false);
    communicaThread = new Thread(this);
    communicaThread.start();
  }

  private void initComponents() {

    this.setAlwaysOnTop(true);

    setTitle("Communication window");

    lmesssend = new JLabel("Message to send : ");

    lmessrec = new JLabel("Received message : ");

    textTosend = new JTextArea(7, 20);

    JScrollPane scrollPaneTosend = new JScrollPane(textTosend);

    textRec = new JTextArea(7, 20);

    textRec.setEditable(false);

    JScrollPane scrollPaneToreceive = new JScrollPane(textRec);

    bSend = new JButton("Send");

    bReceive = new JButton("Receive");

    // Dimensions (taille) de la fenêtre
    setSize(500, 300);

    // Trois lignes sur deux colonnes avec GridLayout
    setLayout(new GridLayout(3, 2));

    // On ajoute chaque composant au contentPane
    getContentPane().add(lmesssend);
    getContentPane().add(scrollPaneTosend);
    getContentPane().add(bSend);
    getContentPane().add(bReceive);
    getContentPane().add(lmessrec);
    getContentPane().add(scrollPaneToreceive);

    bSend.addActionListener(new ActionListenerSend());

    bReceive.addActionListener(new ActionListenerReceive());

    // Rendre visible la fenêtre JFrame
    setVisible(true);

    // Arrêt du processus de JFrame lorsqu'on ferme la fenêtre
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  @Override
  public void run() {

    try {

      while (true) {

        textRec.append(reader.readLine());
        textRec.append("\n");
      }

    } catch (FileNotFoundException e) {

      e.printStackTrace();

    } catch (IOException e) {

      e.printStackTrace();
    }

  }

  public class ActionListenerSend implements ActionListener {

    public void actionPerformed(ActionEvent event) {

      try {

        writer.write(textTosend.getText());
        textTosend.setText("");
        writer.newLine();
        writer.flush();

      } catch (FileNotFoundException e) {

        e.printStackTrace();

      } catch (IOException e) {

        e.printStackTrace();
      }
    }
  }

  public class ActionListenerReceive implements ActionListener {

    public void actionPerformed(ActionEvent event) {

    }
  }

  @Override
  public void windowClosed(WindowEvent e) {

  }

  @Override
  public void windowOpened(WindowEvent e) {

  }

  @Override
  public void windowClosing(WindowEvent e) {

    try {

      if (writer != null) {

        writer.close();

      }
      if (reader != null) {

        reader.close();

      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

  @Override
  public void windowIconified(WindowEvent e) {

  }

  @Override
  public void windowDeiconified(WindowEvent e) {

  }

  @Override
  public void windowActivated(WindowEvent e) {

  }

  @Override
  public void windowDeactivated(WindowEvent e) {

  }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mamadou
 */
public class TCPServeur {

  public static void main(String[] args) {

    try {

      ServerSocket ss = new ServerSocket(20000);

      System.out.println("Serveur en attente d'un client");

      Socket s = ss.accept();

      System.out.println("Client connecté au Serveur");

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
      BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

      Communica c = new Communica(br, bw);

    } catch (IOException ex) {

      ex.printStackTrace();
      System.out.println("Error creating the serversocket" + ex);

    }

  }

}

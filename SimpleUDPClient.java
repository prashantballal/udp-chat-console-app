//package javaapplication5;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
 
/**
 * @author lycog
 */
public class SimpleUDPClient {
  public static void main(String[] args){
    DatagramSocket socket = null;
    DatagramPacket inPacket = null;
    DatagramPacket outPacket = null;
    byte[] inBuf, outBuf;
    final int PORT = 8888;
    String msg = null;
    
 
    try {
      InetAddress address = InetAddress.getByName("127.0.0.1");
      socket = new DatagramSocket();
 
      //Convert string to byte and send to server
      System.out.println("Enter the Message");
     Scanner scanner = new Scanner( System.in );
      msg = scanner.nextLine();
      outBuf = msg.getBytes();
      outPacket = new DatagramPacket(outBuf, 0, outBuf.length,
              address, PORT);
      socket.send(outPacket);
 
      //Receive reversed message from server
      inBuf = new byte[256];
      inPacket = new DatagramPacket(inBuf, inBuf.length);
      socket.receive(inPacket);
 
      String data = new String(inPacket.getData(), 0, inPacket.getLength());
 
      System.out.println("Server : " + data);
 
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }
}
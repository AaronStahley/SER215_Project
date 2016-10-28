package main;
import java.awt.*;
import java.io.IOException.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;
import java.net.*;

public class MancalaClient extends JApplet
	implements Runnable  {
	
	public static int PLAYER1 = 1; //constants for player statuses
	public static int PLAYER2 = 1;
	public static int PLAYER1_WON = 1;
	public static int PLAYER2_WON = 2;
	public static int CONTINUE = 4;
	
	private int[] piles = new int[12]; //integer array to handle all of the "piles"
	
	private JLabel jlblTitle = new JLabel();	
	private JLabel jlblStatus = new JLabel();
	
	private int pileSelected; //integer that refers to an index of the piles int array
	
	private DataInputStream fromServer; //iostream defined
	private DataOutputStream toServer;
	
	private boolean keepPlaying = true;	 //boolean to determine if the game is still goin
	private boolean waiting = true;  //waiting to receive info from server, yes or no?
	private boolean isStandAlone = false;  //boolean to let the app run as a standalone app
	private boolean myTurn = false;  //boolean to determine if its the players turn or not
	
	private String host = "localhost";  //host address string
	
	public void init() { //starts connecting to the server
		connectToServer();	
	}
	
	private void connectToServer() {  //method to create a socket and connect over port 8000
		try {
			Socket socket;
			if (isStandAlone)
				socket = new Socket(host, 8000);
			else
				socket = new Socket(getCodeBase().getHost(), 8000);
			
			fromServer = new DataInputStream(socket.getInputStream()); //create input stream to receive data from server
			
			toServer = new DataOutputStream(socket.getOutputStream()); //create output stream to send data to server	
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		
		Thread thread = new Thread(this); //control the game on a separate thread
		thread.start();
	}
	
	public void run() {
		try {
			int player = fromServer.readInt(); //get notification from the server
			
			if (player == PLAYER1) { //player 1 or player 2
				jlblTitle.setText("Player 1");
				jlblStatus.setText("Waiting for player 2 to join");
				
				fromServer.readInt();
				
				jlblStatus.setText("Player 2 has joined, I go first");
				
				myTurn = true; //it is my turn
			}
			else if (player == PLAYER2) {
				jlblTitle.setText("Player 2");
				jlblStatus.setText("Waiting for player 1 to move");
			}
			
			while (keepPlaying) { //keep playing the game
				if (player == PLAYER1) {
					waitForPlayerAction(); //wait for player 1 to take their turn
					sendMove(); //send move to server
					receiveInfoFromServer(); //receive info from server
				}
				else if (player == PLAYER2) {
					receiveInfoFromServer(); //receive info from server
					waitForPlayerAction(); // wait for player 2 to take their turn
					sendMove(); //send player 2's move to server
				}
			}
		}
		catch (Exception ex) {
			
		}
	}
	private void waitForPlayerAction() throws InterruptedException { //wait for player to move
		while (waiting) {
			Thread.sleep(100);
		}
		
		waiting = true;
	}
	
	private void sendMove() throws IOException { //send move to server
		toServer.writeInt(pileSelected);
	}
	
	private void receiveInfoFromServer() throws IOException { //receive info from server
		int status = fromServer.readInt();
		
		if(status == PLAYER1_WON) { //if player 1 wins stop playing
			keepPlaying = false;
			jlblStatus.setText("Player 1 Won!");
			receiveMove();
		}
		else if (status == PLAYER2_WON) { //if player 2 wins stop playing
			keepPlaying = false;
			jlblStatus.setText("Player 2 Won!");
			receiveMove();
		}
	}
	
	private void receiveMove() throws IOException { //get other players move
		int pileSelected = fromServer.readInt();
	}
	
	public class Pile extends JPanel { //inner class for "pile"
		private int pile;
		
		public Pile(int pileNum) { //which pile is it
			pileSelected = pileNum;
			setBorder(new LineBorder(Color.black, 1));
			addMouseListener(new ClickListener()); //listen for a click
		}
		
		public int getPile() { //return pile clicked
			return pileSelected;
		}
		
		public void setPile(int pileNum) { //set the pile clicked
			this.pile = pileSelected;
		}
		
		private class ClickListener extends MouseAdapter { //handle click on pile
			public void mouseClicked(MouseEvent e) {
				setPile(pileSelected); //set the pile that was clicked
				myTurn = false;
				jlblStatus.setText("Waiting for the other player to move");
				waiting = false; //completed a move
			}
		}		
	}	

public static void main(String[] args) { //unnecessary main method to be deleted
    // Create a frame
    JFrame frame = new JFrame("Mancala Client");

    // Create an instance of the applet
    MancalaClient applet = new MancalaClient();
    applet.isStandAlone = true;

    // Get host
    if (args.length == 1) applet.host = args[0];

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();
    


	frame.setVisible(true); 
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
  }
}
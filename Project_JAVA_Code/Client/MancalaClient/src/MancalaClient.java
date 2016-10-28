import java.awt.*;
import java.io.IOException.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;
import java.net.*;

public class MancalaClient extends JApplet
	implements Runnable {
	
	public static int PLAYER1 = 1;
	public static int PLAYER2 = 1;
	public static int PLAYER1_WON = 1;
	public static int PLAYER2_WON = 2;
	public static int CONTINUE = 4;

	
	
	//indicates whether or not it is the players turn
	private boolean myTurn = false;
	
	private int[] piles = new int[12];
	
	private JLabel jlblTitle = new JLabel();
	
	private JLabel jlblStatus = new JLabel();
	
	private int pileSelected;
	
	private DataInputStream fromServer;
	private DataOutputStream toServer;
	
	private boolean keepPlaying = true;
	
	private boolean waiting = true;
	
	private boolean isStandAlone = false;
	
	private String host = "localhost";
	
	public void init() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 6, 0, 0));
		
				
	p.setBorder(new LineBorder(Color.black, 1));
	jlblTitle.setHorizontalAlignment(JLabel.CENTER);
	jlblTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
	jlblTitle.setBorder(new LineBorder(Color.black, 1));
	jlblTitle.setBorder(new LineBorder(Color.black, 1));
	
	add(jlblTitle, BorderLayout.NORTH);
	add(p, BorderLayout.CENTER);
	add(jlblStatus, BorderLayout.SOUTH);
	
	connectToServer();	
	}
	
	private void connectToServer() {
		try {
			Socket socket;
			if (isStandAlone)
				socket = new Socket(host, 8000);
			else
				socket = new Socket(getCodeBase().getHost(), 8000);
			
			fromServer = new DataInputStream(socket.getInputStream());
			
			toServer = new DataOutputStream(socket.getOutputStream());		
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		try {
			int player = fromServer.readInt();
			
			if (player == PLAYER1) {
				jlblTitle.setText("Player 1");
				jlblStatus.setText("Waiting for player 2 to join");
				
				fromServer.readInt();
				
				jlblStatus.setText("Player 2 has joined, I go first");
				
				myTurn = true;
			}
			else if (player == PLAYER2) {
				jlblTitle.setText("Player 2");
				jlblStatus.setText("Waiting for player 1 to move");
			}
			
			while (keepPlaying) {
				if (player == PLAYER1) {
					waitForPlayerAction();
					sendMove();
					receiveInfoFromServer();
				}
				else if (player == PLAYER2) {
					receiveInfoFromServer();
					waitForPlayerAction();
					sendMove();
				}
			}
		}
		catch (Exception ex) {
			
		}
	}
	private void waitForPlayerAction() throws InterruptedException {
		while (waiting) {
			Thread.sleep(100);
		}
		
		waiting = true;
	}
	
	private void sendMove() throws IOException {
		toServer.writeInt(pileSelected);
	}
	
	private void receiveInfoFromServer() throws IOException {
		int status = fromServer.readInt();
		
		if(status == PLAYER1_WON) {
			keepPlaying = false;
			jlblStatus.setText("Player 1 Won!");
			receiveMove();
		}
		else if (status == PLAYER2_WON) {
			keepPlaying = false;
			jlblStatus.setText("Player 2 Won!");
			receiveMove();
		}
	}
	
	private void receiveMove() throws IOException {
		int pileSelected = fromServer.readInt();
	}
	
	public class Pile extends JPanel {
		private int pile;
		
		public Pile(int pileNum) {
			pileSelected = pileNum;
			setBorder(new LineBorder(Color.black, 1));
			addMouseListener(new ClickListener());
		}
		
		public int getPile() {
			return pileSelected;
		}
		
		public void setPile(int pileNum) {
			this.pile = pileSelected;
		}
		
		private class ClickListener extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				setPile(pileSelected);
				myTurn = false;
				jlblStatus.setText("Waiting for the other player to move");
				waiting = false;
			}
		}		
	}	

public static void main(String[] args) {
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
package GUI;

import javax.swing.JButton;

public class pits {
	
	private JButton pit;
	
	public pits(){
		
		pit = new JButton("4");
		pit.setVisible(true);

	}
	
	public void setPitBounds(int x, int y, int length, int width){
		
		pit.setBounds(x,y,length,width);
		
	}
	
	public void updatePitValue(String num){
		pit.setText(num);
	}
	

	
	
	

}

package shuffle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import shuffle.Shuffle;


public class ShuffleGUI implements ActionListener{
	
	protected ArrayList<JTextArea> texts = new ArrayList<JTextArea>();
	protected int i=0;
	
	protected JPanel panel2;
	protected JPanel centerPanel;
	
	protected String input;
	protected int iterations;
	
	protected JTextField word = new JTextField(50); 
	protected JTextField num = new JTextField(11); 
	
	protected Shuffle shuf=new Shuffle();
	protected JFrame frame;
	
	protected Font f=new Font("Didot",Font.BOLD,30);
	
	public void createGUI()
	{
		frame = new JFrame("ShuffleGUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		
		JButton button = new JButton("Shuffle");
		button.addActionListener(this);
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.PINK.darker());
		panel.add(word);
		panel.add(num);
		panel.add(button);
		
		panel2=new JPanel();
		panel2.setBackground(Color.PINK);
		
		word.setBackground(Color.PINK.brighter());
		word.addActionListener(this);
		
		num.addActionListener(this);
				
		frame.setBackground(Color.yellow.brighter());
		frame.getContentPane().add(BorderLayout.NORTH,panel);
		frame.getContentPane().add(BorderLayout.CENTER,panel2);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		ShuffleGUI gui=new ShuffleGUI();
		gui.createGUI();		
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		input=word.getText();
		shuf.shuffle(50, input);
		for(String s: shuf.getMatching())
		{
			texts.add(new JTextArea());
			
			if(!s.equals(shuf.getMostFreq()))
			{
				if(shuf.getMatchFreq().get(s)>30)
					texts.get(i).setFont(new Font("Monotype Corsiva", Font.PLAIN, 100+shuf.getMatchFreq().get(s)));
				else
					texts.get(i).setFont(new Font("Monotype Corsiva", Font.PLAIN, 10+(10*shuf.getMatchFreq().get(s))));
				texts.get(i).append(s+" ");
				texts.get(i).setBackground(Color.PINK);
				texts.get(i).setForeground(Color.PINK.darker().darker());
				panel2.add(texts.get(i));
			}
			else
			{	if(shuf.getMatchFreq().get(s)>30)
					texts.get(i).setFont(new Font("Monotype Corsiva", Font.BOLD, 200+shuf.getMatchFreq().get(s)));
				else
					texts.get(i).setFont(new Font("Monotype Corsiva", Font.BOLD, 10+(10*shuf.getMatchFreq().get(s))));
				texts.get(i).setSelectedTextColor(Color.RED.brighter());
				texts.get(i).append(s+" ");
				texts.get(i).setBackground(Color.PINK);
				texts.get(i).setForeground(Color.RED.brighter().brighter());
				panel2.add(texts.get(i));
			}
			
			i++;
		}
		
		//frame.repaint();
		
	/*	@Override
		public void actionPerformed2(ActionEvent arg02) {
			iterations=num.getText().toInt();
		}*/
		
	}

}

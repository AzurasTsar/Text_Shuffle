package shuffle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import shuffle.Shuffle;


public class ShuffleGUI implements ActionListener{
	
	protected boolean onePer=true;
	protected boolean textReady=false;
	protected boolean iterReady=false;
	
	/*************************/ //input frame
	
	protected ArrayList<JTextArea> texts = new ArrayList<JTextArea>();
	protected int i=0;
	
	protected JPanel panel2;
	
	protected String input;
	protected int iterations;
	
	protected JTextField word = new JTextField(50); 
	protected JTextField num = new JTextField(50); 
	
	JButton button = new JButton("Shuffle");
	
	protected Shuffle shuf=new Shuffle();
	protected JFrame frame;
	
	protected Font f=new Font("Didot",Font.BOLD,30);
	
	/********************************/ //output frame
	protected JFrame wordFrame;
	protected JPanel shufpanel,matchpanel,shufpanel2;
	
	
	public void createGUI()
	{
		frame = new JFrame("ShuffleGUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1000, 1000);
		
		button.addActionListener(this);
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.PINK.darker());
		panel.add(word);
				
		panel2=new JPanel();
		panel2.add(num);
		panel2.setBackground(Color.PINK.darker());
		
		JPanel panelc=new JPanel();
		panelc.add(button);
		
		word.setBackground(Color.PINK.brighter());
		word.addActionListener(this);
		
		num.setBackground(Color.PINK.brighter());
		num.addActionListener(this);
				
		frame.getContentPane().setBackground(Color.yellow.brighter());
		frame.getContentPane().add(BorderLayout.NORTH,panel);
		frame.getContentPane().add(BorderLayout.CENTER,panel2);
		frame.getContentPane().add(BorderLayout.SOUTH,panelc);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		ShuffleGUI gui=new ShuffleGUI();
		gui.createGUI();		
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int c=0;
		
		if(word.getText()!=null)
			textReady=true;
		
		if(num.getText()!=null)
			iterReady=true;
		
		
		if(arg0.getSource()==button && textReady && iterReady && onePer)
		{
			shufpanel=new JPanel();
			matchpanel=new JPanel();
			shufpanel2=new JPanel();

			onePer=false;
			input=word.getText();
			iterations=Integer.parseInt(num.getText());
			shuf.shuffle(iterations, input);
			for(String s: shuf.getMatching())
			{
				c++;//(=
				texts.add(new JTextArea());
				texts.get(i).setEditable(false);
				texts.get(i).setBackground(Color.PINK.darker());
				texts.get(i).append(s+" ");
				//top
				if(!s.equals(shuf.getMostFreq())&&(c<shuf.getNumMatches()/2))
				{
					if(shuf.getMatchFreq().get(s)>30)
						texts.get(i).setFont(new Font("Monotype Corsiva", Font.PLAIN, 100/*+shuf.getMatchFreq().get(s)*/));
					else
						texts.get(i).setFont(new Font("Monotype Corsiva", Font.PLAIN, 20+(5*shuf.getMatchFreq().get(s))));
				
					texts.get(i).setForeground(Color.PINK);
					shufpanel.add(texts.get(i));
				}
				//bottom
				else if(!s.equals(shuf.getMostFreq())&&(c>=shuf.getNumMatches()/2))
				{
					if(shuf.getMatchFreq().get(s)>30)
						texts.get(i).setFont(new Font("Monotype Corsiva", Font.PLAIN, 100/*+shuf.getMatchFreq().get(s)*/));
					else
						texts.get(i).setFont(new Font("Monotype Corsiva", Font.PLAIN, 20+(5*shuf.getMatchFreq().get(s))));
				
					texts.get(i).setForeground(Color.PINK);
					shufpanel2.add(texts.get(i));
				}
				//middle
				else
				{	
					if(shuf.getMatchFreq().get(s)>30)
						texts.get(i).setFont(new Font("Monotype Corsiva", Font.BOLD, 200/*+shuf.getMatchFreq().get(s)*/));
					else
						texts.get(i).setFont(new Font("Monotype Corsiva", Font.BOLD, 20+(10*shuf.getMatchFreq().get(s))));
			
					texts.get(i).setForeground(Color.magenta.darker());
					matchpanel.add(texts.get(i));
				}
			
				i++;
			}
			
			wordFrame=new JFrame("(✿◠‿◠)Shuffled!");
			wordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Dimension d=new Dimension(1000, 2000);
			//wordFrame.setPreferredSize(d);
			
			wordFrame.setSize(1000,4000);
			
			shufpanel.setBackground(Color.pink.darker());
			matchpanel.setBackground(Color.pink.darker());
			shufpanel2.setBackground(Color.pink.darker());
			
			wordFrame.getContentPane().add(BorderLayout.NORTH,shufpanel);
			wordFrame.getContentPane().add(BorderLayout.CENTER,matchpanel);
			wordFrame.getContentPane().add(BorderLayout.SOUTH,shufpanel2);
			wordFrame.getContentPane().setBackground(Color.pink.darker());
			wordFrame.pack();
			
			frame.setVisible(false);
			wordFrame.setVisible(true);
		
		}
	}
	

}

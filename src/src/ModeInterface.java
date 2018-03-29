package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ModeInterface class
 * @author Miruku
 * contains the interface for the start Dialog
 */
@SuppressWarnings("serial")
public class ModeInterface extends JFrame implements ActionListener 
{
	private InterfaceHelper IFH = new InterfaceHelper();
	
	private JFrame mainWnd, TimeBox;
	private JButton bStandard, bTime, bok;
	private JLabel lmode, limg, lmsg;
	private JTextField tftime;
	private int time = 0;
	
	protected int ScreenWidth = (int)(IFH.getScreenResolution().getWidth());
	protected int ScreenHeight = (int)(IFH.getScreenResolution().getHeight()); 
	
	private String color, name;
	
	/**
	 * Constructor
	 * @param color
	 * @param name
	 */
	public ModeInterface(String color, String name)
	{
		this.color = color;
		this.name = name;
	}
	
	/**
	 * Create the mode dialog for BananyaClicker
	 */
	public void createInterface()
	{
		mainWnd = new JFrame();
		mainWnd.setLayout(null);
		mainWnd.setSize(ScreenWidth / 2, ScreenHeight / 2);
		mainWnd.setLocation(ScreenWidth / 4, ScreenHeight / 4);
		mainWnd.setUndecorated(true);
		
		int width, height;
		width = mainWnd.getWidth();
		height = mainWnd.getHeight();
		
		limg = new JLabel();
		limg.setBounds(0,0,width, height);
		limg.setIcon(IFH.loadImg("images/ModeBackg.jpg")); 

		bStandard = new JButton("Standard Mode!");
		bStandard.setBounds(130,300,300,100);
		
		bTime = new JButton("Time Mode!");
		bTime.setBounds(530,300,300,100);
		
		lmode = new JLabel("Choose Mode");
		lmode.setBounds(100,50,500,150);
		
		lmode.setFont(new Font("Arial", Font.CENTER_BASELINE, 46));
		bStandard.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
		bTime.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));

		mainWnd.add(lmode);
		mainWnd.add(bStandard);
		mainWnd.add(bTime);
		mainWnd.add(limg);
		
		mainWnd.setVisible(true);
		
		bStandard.addActionListener(this);
		bTime.addActionListener(this);
	}
	
	public void SendTimeBox()
	{
		TimeBox = new JFrame();
		
		TimeBox.setSize(mainWnd.getWidth() / 4, mainWnd.getHeight() / 4);
		TimeBox.setLocation(ScreenWidth / 2, ScreenHeight / 2);
		TimeBox.setLayout(new BorderLayout());
		TimeBox.setUndecorated(true);
		
		tftime = new JTextField(time); 
		tftime.setBounds(0,200,80,50);
		
		lmsg = new JLabel(" Time: ");
		lmsg.setBounds(0, 0, 200, 50);
		lmsg.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		bok = new JButton("Ok");
		bok.setBounds(0,400,50,50);
		bok.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		TimeBox.add(lmsg, BorderLayout.WEST);
		TimeBox.add(tftime, BorderLayout.CENTER);
		TimeBox.add(bok, BorderLayout.EAST);
		TimeBox.setVisible(true);
		
		bok.addActionListener(this);
	}

	/**
	 * actionPerformer 
	 */
	public void actionPerformed(ActionEvent event) 
	{	
		if(event.getSource() == bStandard)
		{
			mainWnd.dispose();
			ClickerInterface ci = new ClickerInterface(color,name);
			ci.creatInterface();
			ci.OsuMoveButton();
		}
		else if(event.getSource() == bTime)
		{
			mainWnd.dispose();
			SendTimeBox();
		}
		else if(event.getSource() == bok)
		{
			if(tftime.getText().matches("[0-9]*"))
			{
				time = Integer.parseInt(tftime.getText());
				if (!(time <= 0))
				{
					TimeBox.dispose();
					ClickerInterface ci = new ClickerInterface(color,name);
					ci.setTime(time);
					ci.creatInterface();
					ci.OsuMoveButton();
				}
			}

		}
	}	
}

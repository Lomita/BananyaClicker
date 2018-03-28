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
	
	private JFrame mainWnd;
	private JButton bStandard, bTime;
	private JLabel lmode, limg;
	
	protected int ScreenWidth = (int)(IFH.getScreenResolution().getWidth());
	protected int ScreenHeight = (int)(IFH.getScreenResolution().getHeight()); 
	
	/**
	 * Constructor 
	 */	
	public ModeInterface()
	{
	}
	
	/**
	 * Create the mode dialog for bc
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
	
	public int SendMsgBox(String msg)
	{
		int time = 0;
		JFrame msgBox = new JFrame();
		
		msgBox.setSize(mainWnd.getWidth() / 4, mainWnd.getHeight() / 4);
		msgBox.setLocation(ScreenWidth / 2, ScreenHeight / 2);
		msgBox.setLayout(new BorderLayout());
		msgBox.setUndecorated(true);
		
		JTextField tfname = new JTextField(time);
		tfname.setBounds(0,200,80,50);
		
		JLabel lmsg = new JLabel(msg);
		lmsg.setBounds(0, 0, 200, 50);
		lmsg.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		msgBox.add(lmsg, BorderLayout.CENTER);
		msgBox.setVisible(true);
		return time;
	}

	/**
	 * actionPerformer 
	 */
	public void actionPerformed(ActionEvent event) 
	{	
		if(event.getSource() == bStandard)
		{
			mainWnd.dispose();
			ClickerInterface ci = new ClickerInterface();
		}
		else if(event.getSource() == bTime)
		{
			mainWnd.dispose();
			
			int time = SendMsgBox("Time");
			
			ClickerInterface ci = new ClickerInterface();
			ci.setTime(time);
		}
	}	
}

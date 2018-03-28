package src;
import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;
import javax.swing.*;

/**
 * StartInterface class
 * @author Miruku
 * contains the interface for the Bananya Clicker frame
 */
@SuppressWarnings("serial")
public class ClickerInterface extends JFrame implements ActionListener
{
	private InterfaceHelper IFH = new InterfaceHelper();
	
	private int ScreenFrameWidth = (int)(IFH.getScreenResolution().getWidth());
	private int ScreenHeight = (int)(IFH.getScreenResolution().getHeight()); 
	
	private JFrame mainWnd;
	private JButton bBananya, bEnd, bBackToMenu, bTime;							
	private JLabel limg, lCount, lTime, lGreat, lCountTimerA;						

	private JList list;
	private DefaultListModel model = new DefaultListModel();
	
	private int count = 0, time = 0, Rtime, FrameHeight, FrameWidth; 		
	private boolean isTimeMode;
	
	/**
	 * Constructor
	 */
	public ClickerInterface()
	{
		isTimeMode = false;
	}

	/**
	 * Create the Clicker dialog for BananyaClicker
	 */
	public void creatInterface()
	{
		mainWnd = new JFrame();
		mainWnd.setLocation(0,0);
		mainWnd.setSize(ScreenFrameWidth,ScreenHeight);
		mainWnd.setLayout(null);
		mainWnd.setUndecorated(true);
		
		FrameWidth = mainWnd.getWidth();
		FrameHeight = mainWnd.getHeight();
		
		limg = new JLabel();
		limg.setBounds(0,0,FrameWidth, FrameHeight);
		//limg.setIcon(IFH.loadImg("images/Bananyaception.jpg")); 
	
		bEnd = new JButton();
		bEnd.setBounds(2,2,100,100);
		bEnd.setIcon(IFH.loadImg("images/Button_exit.png"));
		bEnd.setContentAreaFilled(false);
		bEnd.setBorder(null);

		count = 0;
		lCount = new JLabel ("Counter :  " + count);
		lCount.setBounds(ScreenFrameWidth - (int)(ScreenFrameWidth * 0.1),0,1000,50);

		if(isTimeMode)
		{
			lTime = new JLabel ("Time left " + time + "s");
			lTime.setBounds(1150,0,1000,50);
			lTime.setFont(new Font("Arial", Font.BOLD, 25));

			mainWnd.add(lTime);
			
			Rtime = time;
			
			myTimer.scheduleAtFixedRate(task, 1000, 1000);
		}
		
		lCount.setFont(new Font("Arial", Font.CENTER_BASELINE, 25));
		lCount.setForeground(Color.black);

		bBananya = new JButton ();
		bBananya.setSize(100,100);
		bBananya.setIcon(IFH.loadImg("images/auto.png"));
		bBananya.setContentAreaFilled(false);
		bBananya.setBorder(null);

		mainWnd.add(lCount);
		mainWnd.add(bEnd);
		mainWnd.add(bBananya);
		mainWnd.add(limg);
		
		mainWnd.setVisible(true);
		
		bBananya.addActionListener(this);
		bEnd.addActionListener(this);
	}
	
	/**
	 * set timeMode true and time
	 */
	public void setTime(int time)
	{
		isTimeMode = true;
		this.time = time;
	}

	/**
	 * moves the bananya
	 */
	public void OsuMoveButton()
	{	
		bBananya.setLocation(((int)(Math.random()*(FrameWidth-100))+1),
							((int)(Math.random()*(FrameHeight-150))+1));
		mainWnd.repaint();
	}
	
	/**
	* timer
	*/
	Timer myTimer = new Timer();
	TimerTask task  = new TimerTask()
	{
		public void run()
		{
			if(time > 0)
			{
				time--;
				lTime.setText("Time left " + time + "s");
			}
			else
			{	
				gameEnd();
			}
		}
	};
	
	/**
	 * triggered when either the time runs out or the end button was clicked
	 */
	public void gameEnd()
	{
		mainWnd.remove(bEnd);
		mainWnd.remove(bBananya);
		mainWnd.remove(lCount);
		
		if(isTimeMode)
		{
			myTimer.cancel();
			mainWnd.remove(lTime);
		}

		lGreat = new JLabel("GREAT JOB!");
		lGreat.setBounds(680,300,400,100);
		lGreat.setFont(new Font("Arial", Font.BOLD, 40));

		/*
		if(isTimeMode)
			String[] data = {count + " Bananya's cSatched in " + "s ","B","C"};
		else
			String[] data = {count + " Bananya's catched!","B","C"};
		
		*/
	    
	    list = new JList(data);
	    list.setLocation(670,400);
	    list.setSize(100,50);
	    list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	    list.setVisibleRowCount(3);
		list.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
		
		/*
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		*/
		
		bBackToMenu = new JButton ("Back to menu");
		bBackToMenu.setBounds(720,500,200,50);
		bBackToMenu.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
		
		mainWnd.add(lGreat);
		mainWnd.add(lCountTimerA);
		mainWnd.add(bBackToMenu);
		mainWnd.add(list);
		
		mainWnd.repaint();
		
		bBackToMenu.addActionListener(this);
	}

	/**
	 * actionPerformer 
	 */
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == bBananya)
		{	
			OsuMoveButton();	
			count++;
			lCount.setText("Counter :  " + count);
		}

		else if (event.getSource() == bEnd)
		{
			gameEnd();
		}
		
		else if (event.getSource() == bBackToMenu)
		{
			mainWnd.dispose();
			@SuppressWarnings("unused")
			StartInterface menu = new StartInterface();
			menu.createInterface();
		}	
	}
}
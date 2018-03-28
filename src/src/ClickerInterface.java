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
	
	protected int ScreenWidth = (int)(IFH.getScreenResolution().getWidth());
	protected int ScreenHeight = (int)(IFH.getScreenResolution().getHeight()); 
	
	private JFrame mainWnd;
	
	private JButton bClick,	bEnd, bTime,bEndStat;							
	private JLabel limg, lCount, lTime, lTimer, lGreat, lCountTimerA;						

	private int count = 0,								
				time = 0,								
				Rtime; 									
	
	/**
	 * Constructor
	 */
	public ClickerInterface()
	{
		creatInterface();
		OsuMoveButton();
		pressEnd();
		lcounter(0);
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
				lTimer();
			}
			else
			{
				gameEnd();
			}
		}
	};

	/**
	 * Create the Clicker dialog for bc
	 */
	public void creatInterface()
	{
		mainWnd = new JFrame();
		mainWnd.setLayout(null);
		mainWnd.setSize(1600,900);
		mainWnd.setLocation(150,65);
		mainWnd.setUndecorated(true);
		
		int width, height;
		width = mainWnd.getWidth();
		height = mainWnd.getHeight();
		
		limg = new JLabel();
		limg.setBounds(0,0,width, height);
		limg.setIcon(IFH.loadImg("images/Bananyaception.jpg")); 
	
		mainWnd.add(limg);
		
		mainWnd.setVisible(true);
	}
	
	public void setTime(int time)
	{
		this.time = time;
	}

	public void OsuMoveButton()
	{
		int width, height;
		width = this.getWidth()-100;
		height = this.getHeight()-150;

		@SuppressWarnings("unused")
		int z = (int)(Math.random()*1000+1);

		bClick = new JButton ();
		bClick.setBounds(((int)(Math.random()*width)+1),((int)(Math.random()*height)+1),100,100);
		bClick.setIcon(IFH.loadImg("images/auto.png"));
		bClick.setContentAreaFilled(false);
		bClick.setBorder(null);

		this.add(bClick);
		bClick.addActionListener(this);
	}

	public void pressEnd()
	{
		bEnd = new JButton ("Quit");
		bEnd.setBounds(0,0,100,100);
		bEnd.setIcon(IFH.loadImg("images/Button_exit.png"));
		bEnd.setContentAreaFilled(false);
		bEnd.setBorder(null);

		this.add(bEnd);
		bEnd.addActionListener(this);
	}

	public void lcounter(int count)
	{
		lCount = new JLabel ("Counter :  " + count);
		lCount.setBounds(1400,0,1000,50);

		lCount.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
		lCount.setForeground(Color.black);

		this.add(lCount);
	}

	public void lTimer()
	{
		this.remove(lTime);
		this.repaint();

		lTime = new JLabel ("Time left " + time + "s");
		lTime.setBounds(1150,0,1000,50);
		lTime.setFont(new Font("Arial", Font.BOLD, 17));

		this.add(lTime);
		this.repaint();
	}

	public void gameEnd()
	{
		myTimer.cancel();
		this.remove(bEnd);
		this.remove(bClick);
		this.remove(lTime);
		this.remove(lCount);

		lGreat = new JLabel("GREAT JOB!");
		lGreat.setBounds(680,300,400,100);
		lGreat.setFont(new Font("Arial", Font.BOLD, 40));

		lCountTimerA = new JLabel(count + " Bananya's gefangen in " + Rtime + "s ");
		lCountTimerA.setBounds(650,400,1000,50);
		lCountTimerA.setFont(new Font("Arial", Font.BOLD, 24));

		bEndStat = new JButton ("Back to menu");
		bEndStat.setBounds(720,500,150,30);

		this.add(lGreat);
		this.add(lCountTimerA);
		this.add(bEndStat);
		this.repaint();
		bEndStat.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == bClick)
		{
			this.remove(bClick);
			this.remove(lCount);
			this.repaint();
			
			OsuMoveButton();
			
			count++;
			lcounter(count);
		}

		/*else if (event.getSource() == bTime)
		{
			time = Integer.parseInt(tTime.getText());
			Rtime = time;
			
			this.remove(lTimer);
			this.remove(tTime);
			this.remove(bTime);
			this.repaint();

			OsuMoveButton();
			pressEnd();
			lcounter(0);

			lTime = new JLabel ("Time left " + time + "s");
			lTime.setBounds(1150,0,1000,50);
			lTime.setFont(new Font("Arial", Font.BOLD, 17));
			
			this.add(lTime);
			myTimer.scheduleAtFixedRate(task,1000, 1000);
		}*/

		else if (event.getSource() == bEndStat)
		{
			this.dispose();
			@SuppressWarnings("unused")
			StartInterface menu = new StartInterface();
		}

		else if (event.getSource() == bEnd)
		{
			this.dispose();

			myTimer.cancel();

			@SuppressWarnings("unused")
			StartInterface menu = new StartInterface();
		}
	}
}
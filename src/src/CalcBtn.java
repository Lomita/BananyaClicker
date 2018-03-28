package src;
import java.awt.*;
import javax.swing.*;

public class CalcBtn extends StartInterface
{
	private InterfaceHelper IFH = new InterfaceHelper();
	
	private Dimension screenSize;
	private JButton bBanya;
	
	//private int ScreenWidth = (int)(IFH.getScreenResolution().getWidth());
	//private int ScreenHeight = (int)(IFH.getScreenResolution().getHeight()); 
	
	public CalcBtn()
	{
		bBanya.setBounds(0,0,100,100);
		
		bBanya.setIcon(IFH.loadImg("/resources/auto.png"));
		bBanya.setContentAreaFilled(false);
		bBanya.setBorder(null);

		mainWnd.add(bBanya);
		//bBanya.addActionListener(this);
	}
			
	private Dimension ranLoc()
	{
		int ranWidth = ((int)(Math.random()*ScreenWidth)+1);
		int ranHeight = ((int)(Math.random()*ScreenHeight)+1);
		
		screenSize = new Dimension(ranWidth,ranHeight);
		
		return screenSize;
	}
}

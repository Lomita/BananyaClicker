package src;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CalcBtn extends ClickerInterface
{
	private InterfaceHelper IFH = new InterfaceHelper();
	
	private Dimension screenSize;
	private JButton bBanya;
	
	public CalcBtn()
	{
		bBanya.setBounds(0,0,100,100);
		
		bBanya.setIcon(IFH.loadImg("/resources/auto.png"));
		bBanya.setContentAreaFilled(false);
		bBanya.setBorder(null);

		mainWnd.add(bBanya);
		bBanya.addActionListener();
	}
			
	private void ChangeLocation()
	{
		int width, height;
		width = mainWnd.getWidth()-100;
		height = mainWnd.getHeight()-150;

		@SuppressWarnings("unused")
		int z = (int)(Math.random()*1000+1);

		bClick = new JButton ();
		bClick.setBounds(((int)(Math.random()*width)+1),((int)(Math.random()*height)+1),100,100);
	}
}

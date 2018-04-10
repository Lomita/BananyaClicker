package src;
import java.awt.*;
import javax.swing.*;

/**
 * Interface Helper class
 * @author Silian Barlogis
 * contains functions for interfaces
 */
public class InterfaceHelper
{
	/**
	 * Get image from path
	 * @param path
	 * @return image
	 */
	public ImageIcon loadImg(String path)
	{	
		ImageIcon img = new ImageIcon(getClass().getResource(path));;
		return img;
	} 
	
	/**
	 * Get the screen resolution
	 * @return screen size
	 */
	public Dimension getScreenResolution()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize; 
	}
}
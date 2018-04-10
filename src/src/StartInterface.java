package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * StartInterface class
 * @author Silian Barlogis
 * contains the interface for the start Dialog
 */
@SuppressWarnings("serial")
public class StartInterface extends JFrame implements ActionListener
{
	private InterfaceHelper IFH = new InterfaceHelper();
		
	public JFrame mainWnd; 
	public JFrame msgBox; 

	private JButton bstartGame, bexit;
	private JTextField tfname;
	private JComboBox<String> cbrace;
	private JLabel limg, ltitel, lusername, ltype;
	private String name, race;
	
	private int idx;
	protected int ScreenWidth = (int)(IFH.getScreenResolution().getWidth());
	protected int ScreenHeight = (int)(IFH.getScreenResolution().getHeight()); 

	/**
	 * Constructor 
	 */	
	public StartInterface()
	{
		name = "";
		idx = 3;
	}
	
	/**
	 * Create the start dialog for BananyaClicker
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
	
		ltitel = new JLabel("");
		ltitel.setBounds(130,50,600,129);
		ltitel.setIcon(IFH.loadImg("images/BananyaClicker.png")); 
		
		limg = new JLabel();
		limg.setBounds(0,0,width,height);
		limg.setIcon(IFH.loadImg("images/bg.png")); 
		
		lusername = new JLabel("Username");
		lusername.setBounds(150,200,150,35);
		
		ltype = new JLabel("Bananya's color");
		ltype.setBounds(150,250,150,35);

		tfname = new JTextField(name);
		tfname.setBounds(330,200,150,35);		
		
		String[] raceStr = {"Blue Bananya","Red Bananya","Black Bananya","White Bananya"};
		cbrace = new JComboBox<String>(raceStr);
		cbrace.setBounds(330,255,150,35);
		cbrace.setSelectedIndex(idx);
			
		bstartGame = new JButton("Start");
		bstartGame.setBounds(150,430,350,50);
		
		bexit = new JButton("Exit");
		bexit.setBounds(700,430,80,50);
		
		lusername.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		ltype.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		tfname.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		cbrace.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		bstartGame.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		bexit.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		
		mainWnd.add(tfname);
		mainWnd.add(ltype);
		mainWnd.add(lusername);
		mainWnd.add(cbrace);
		mainWnd.add(bstartGame);
		mainWnd.add(bexit);
		mainWnd.add(ltitel);
		mainWnd.add(limg);
		
	
		mainWnd.setResizable(false);
		mainWnd.setVisible(true);
		
		cbrace.addActionListener(this);
		bstartGame.addActionListener(this);
		bexit.addActionListener(this);
	}
	
	/**
	 * send a messagebox
	 */
	private void SendMsgBox()
	{
		msgBox = new JFrame();
		
		msgBox.setSize(mainWnd.getWidth() / 4, mainWnd.getHeight() / 4);
		msgBox.setLocation(ScreenWidth / 2, ScreenHeight / 2);
		msgBox.setLayout(new BorderLayout());
		
		JLabel lmsg = new JLabel("Name to short!");
		lmsg.setBounds(0, 0, msgBox.getWidth() - 5, msgBox.getHeight() - 50);
		lmsg.setFont(new Font("Arial", Font.CENTER_BASELINE, 26));
		
		msgBox.add(lmsg, BorderLayout.CENTER);
		msgBox.setVisible(true);
	}
	
	/**
	 * set the name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * set the selected index for the cbrace combo box
	 * @param idx
	 */
	public void setColor(int idx)
	{
		this.idx = idx;
	}
	
	/**
	 * actionPerformer 
	 */
	public void actionPerformed(ActionEvent event) 
	{	
		if(event.getSource() == bstartGame)
		{
			name = tfname.getText();
			if(name.equals(""))
			{
				SendMsgBox();
				name = null;
			}
			
			race = (String) cbrace.getSelectedItem();
			
			if(name != null && race != null)
			{
				mainWnd.removeAll();
				mainWnd.dispose();
				
				ModeInterface MI = new ModeInterface((String)cbrace.getSelectedItem(),tfname.getText());
				MI.createInterface();
			}
		}
		
		else if(event.getSource() == bexit) 
		{
			mainWnd.removeAll();
			System.exit(0);
		}
	}
}
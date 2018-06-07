package rms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Restaurant {

	private JFrame Rbms;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt11;
	private JTextField txt12;
	private JTextField txt13;
	private JTextField txtA;
	double num,ans;
	int calculation;
	private JTextField txtConvertion;
	private JTextField textField;
	private JTextField txtCurrency;
	private JTextField order_no;
	private JTable table;
	private JTable table_1;
	private JTextField date;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurant window = new Restaurant();
					window.Rbms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Restaurant() {
		initialize();
	}
	public Connection connection()
	{
		Connection conn=null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return conn;
         
		
	}
	

	
	public void arithmatic(){
		switch (calculation) {
		case 1: //addition
			ans=num+Double.parseDouble(txtA.getText());
			txtA.setText(Double.toString(ans));
			break;
		case 2: //substruction
			ans=num-Double.parseDouble(txtA.getText());
			txtA.setText(Double.toString(ans));
			break;
		case 3: //multiplication
			ans=num*Double.parseDouble(txtA.getText());
			txtA.setText(Double.toString(ans));
			break;
		case 4: //divition
			ans=num/Double.parseDouble(txtA.getText());
			txtA.setText(Double.toString(ans));
			break;
		case 5: //reminder
			ans=num%Double.parseDouble(txtA.getText());
			txtA.setText(Double.toString(ans));
			break;

		default:
			break;
		}
	}
	
//---------------------------- Database Connection ------------------------	
	
	int DB(String name) throws Exception
	{
		int fdname=0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
		PreparedStatement pst = conn.prepareStatement("select price from food_item where food_name=?");
		pst.setString(1, name);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			fdname=rs.getInt("price");
		}
		
		return fdname;
	}
	
	
	
	private void initialize() {
		
        
		
		Rbms = new JFrame();
		Rbms.setFont(new Font("Dialog", Font.PLAIN, 12));
		Rbms.setTitle("Restaurant Bill Management System");
		Rbms.setBackground(SystemColor.controlDkShadow);
		Rbms.getContentPane().setBackground(SystemColor.controlDkShadow);
		Rbms.getContentPane().setLayout(null);
		
//-----------------------Panel for Foods-------------------------
		
		JPanel panlForFood = new JPanel();
		panlForFood.setBackground(new Color(192, 192, 192));
		panlForFood.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panlForFood.setBounds(12, 64, 328, 278);
		Rbms.getContentPane().add(panlForFood);
		panlForFood.setLayout(null);

//-------------------------- JLabel select for Foods--------------
		
		
		
		JLabel lblIlishPolao = new JLabel("Ilish Polao");
		lblIlishPolao.setForeground(UIManager.getColor("Slider.tickColor"));
		lblIlishPolao.setBackground(UIManager.getColor("Separator.shadow"));
		lblIlishPolao.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIlishPolao.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlishPolao.setBounds(0, 14, 98, 30);
		panlForFood.add(lblIlishPolao);
		
		JLabel lblMorogPolao = new JLabel("Morog Polao");
		lblMorogPolao.setHorizontalAlignment(SwingConstants.CENTER);
		lblMorogPolao.setForeground(Color.BLACK);
		lblMorogPolao.setFont(new Font("Dialog", Font.BOLD, 12));
		lblMorogPolao.setBackground(Color.GRAY);
		lblMorogPolao.setBounds(10, 55, 88, 19);
		panlForFood.add(lblMorogPolao);
		
		JLabel lblKacchi = new JLabel("Kacchi Birani");
		lblKacchi.setHorizontalAlignment(SwingConstants.CENTER);
		lblKacchi.setForeground(Color.BLACK);
		lblKacchi.setFont(new Font("Dialog", Font.BOLD, 12));
		lblKacchi.setBackground(Color.GRAY);
		lblKacchi.setBounds(12, 100, 88, 19);
		panlForFood.add(lblKacchi);
		
		JLabel lblTehari = new JLabel("Tehari (Beef)");
		lblTehari.setHorizontalAlignment(SwingConstants.CENTER);
		lblTehari.setForeground(Color.BLACK);
		lblTehari.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTehari.setBackground(Color.GRAY);
		lblTehari.setBounds(0, 139, 110, 21);
		panlForFood.add(lblTehari);
		
		JLabel lblGrill = new JLabel("Grill(Chicken)");
		lblGrill.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrill.setForeground(Color.BLACK);
		lblGrill.setFont(new Font("Dialog", Font.BOLD, 12));
		lblGrill.setBackground(Color.GRAY);
		lblGrill.setBounds(0, 171, 110, 30);
		panlForFood.add(lblGrill);
		
		JLabel lblBread = new JLabel("Bread\r\n");
		lblBread.setHorizontalAlignment(SwingConstants.CENTER);
		lblBread.setForeground(Color.BLACK);
		lblBread.setFont(new Font("Dialog", Font.BOLD, 12));
		lblBread.setBackground(Color.GRAY);
		lblBread.setBounds(-15, 212, 113, 26);
		panlForFood.add(lblBread);
		
		
		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lblBurger.setForeground(Color.BLACK);
		lblBurger.setFont(new Font("Dialog", Font.BOLD, 12));
		lblBurger.setBackground(SystemColor.controlShadow);
		lblBurger.setBounds(188, 14, 64, 30);
		panlForFood.add(lblBurger);
		
		JLabel lblSandwich = new JLabel("Sandwich");
		lblSandwich.setHorizontalAlignment(SwingConstants.CENTER);
		lblSandwich.setForeground(Color.BLACK);
		lblSandwich.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSandwich.setBackground(Color.GRAY);
		lblSandwich.setBounds(178, 55, 78, 19);
		panlForFood.add(lblSandwich);
		
		
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizza.setForeground(Color.BLACK);
		lblPizza.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPizza.setBackground(Color.GRAY);
		lblPizza.setBounds(176, 100, 88, 19);
		panlForFood.add(lblPizza);
		
		JLabel lblSomucha = new JLabel("Somucha");
		lblSomucha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSomucha.setForeground(Color.BLACK);
		lblSomucha.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSomucha.setBackground(Color.GRAY);
		lblSomucha.setBounds(167, 139, 110, 21);
		panlForFood.add(lblSomucha);
		
		JLabel lblRoll = new JLabel("Roll");
		lblRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoll.setForeground(Color.BLACK);
		lblRoll.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRoll.setBackground(Color.GRAY);
		lblRoll.setBounds(167, 171, 110, 30);
		panlForFood.add(lblRoll);
		
		JLabel lblSingara = new JLabel("Singara");
		lblSingara.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingara.setForeground(Color.BLACK);
		lblSingara.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSingara.setBackground(Color.GRAY);
		lblSingara.setBounds(164, 212, 113, 26);
		panlForFood.add(lblSingara);
		
//------------------------------- JComboBox Select for Foods-----------------------------------
		
		JComboBox comboSandwich = new JComboBox();
		comboSandwich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"sandwich",comboSandwich.getSelectedItem().toString());
			}
		});
		comboSandwich.setBounds(266, 56, 52, 22);
		panlForFood.add(comboSandwich);
		comboSandwich.setModel(new DefaultComboBoxModel(new String[] {"0" ,"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

		
		
		JComboBox comboMorogPolao = new JComboBox();
		comboMorogPolao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order( order_no.getText(),"morog polao",comboMorogPolao.getSelectedItem().toString());
			}
		});
		comboMorogPolao.setModel(new DefaultComboBoxModel(new String[] {"0" ,"0.25", "0.5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboMorogPolao.setBounds(112, 56, 52, 22);
		panlForFood.add(comboMorogPolao);
		
		JComboBox comboKacchi = new JComboBox();
		comboKacchi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"kacchi birani",comboKacchi.getSelectedItem().toString());
			}
		});
		comboKacchi.setModel(new DefaultComboBoxModel(new String[] {"0" ,"0.25", "0.5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboKacchi.setBounds(112, 101, 52, 22);
		panlForFood.add(comboKacchi);
		
		JComboBox comboTehari = new JComboBox();
		comboTehari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"tehari",comboTehari.getSelectedItem().toString());
			}
		});
		comboTehari.setModel(new DefaultComboBoxModel(new String[] {"0" ,"0.25", "0.5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboTehari.setBounds(112, 139, 52, 22);
		panlForFood.add(comboTehari);
		
		JComboBox comboGrill = new JComboBox();
		comboGrill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"Grill",comboGrill.getSelectedItem().toString());
			}
		});
		comboGrill.setModel(new DefaultComboBoxModel(new String[] {"0" ,"0.25", "0.5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboGrill.setBounds(112, 178, 52, 22);
		panlForFood.add(comboGrill);
		
				
		JComboBox comboBread = new JComboBox();
		comboBread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"bread",comboBread.getSelectedItem().toString());
			}
		});
		comboBread.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBread.setBounds(112, 217, 52, 22);
		panlForFood.add(comboBread);
		
		JComboBox comboPizza = new JComboBox();
		comboPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"pizza",comboPizza.getSelectedItem().toString());
			}
		});
		comboPizza.setBounds(266, 101, 52, 22);
		panlForFood.add(comboPizza);
		comboPizza.setModel(new DefaultComboBoxModel(new String[] {"0" ,"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

		
		
		JComboBox comboSomucha = new JComboBox();
		comboSomucha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"somucha",comboSomucha.getSelectedItem().toString());
			}
		});
		comboSomucha.setBounds(266, 139, 52, 22);
		panlForFood.add(comboSomucha);
		comboSomucha.setModel(new DefaultComboBoxModel(new String[] {"0" ,"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

		
		JComboBox comboRoll = new JComboBox();
		comboRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"roll",comboRoll.getSelectedItem().toString());
			}
		});
		comboRoll.setBounds(266, 178, 52, 22);
		panlForFood.add(comboRoll);
		comboRoll.setModel(new DefaultComboBoxModel(new String[] {"0" ,"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

		
				
		JComboBox comboSingara = new JComboBox();
		comboSingara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"singara",comboSingara.getSelectedItem().toString());
			}
		});
		comboSingara.setBounds(266, 217, 52, 22);
		panlForFood.add(comboSingara);
		comboSingara.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

		
		JComboBox comboIlishPolao = new JComboBox();
		comboIlishPolao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order( order_no.getText(),"ilish polao",comboIlishPolao.getSelectedItem().toString());
			}
		});
		comboIlishPolao.setBounds(112, 20, 52, 22);
		panlForFood.add(comboIlishPolao);
		comboIlishPolao.setModel(new DefaultComboBoxModel(new String[] {"0" ,"0.25", "0.5", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		
		JComboBox comboBurger = new JComboBox();
		comboBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"burger",comboBurger.getSelectedItem().toString());
			}
		});
		comboBurger.setBounds(266, 20, 52, 22);
		panlForFood.add(comboBurger);
		comboBurger.setModel(new DefaultComboBoxModel(new String[] {"0" ,"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

		
//----------------------------- Panel for Drinks----------------------------------------
		
	    JPanel panlForDrinks = new JPanel();
		panlForDrinks.setBackground(new Color(192, 192, 192));
		panlForDrinks.setLayout(null);
	    panlForDrinks.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panlForDrinks.setBounds(352, 62, 313, 278);
		Rbms.getContentPane().add(panlForDrinks);
		

//------------------------ JLabel Selection for Drinks----------------------	
		
		JLabel lblAppleJu = new JLabel("Apple Juice");
		lblAppleJu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppleJu.setForeground(Color.BLACK);
		lblAppleJu.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAppleJu.setBackground(UIManager.getColor("Button.select"));
		lblAppleJu.setBounds(12, 12, 79, 30);
		panlForDrinks.add(lblAppleJu);
				
		JLabel lblTea = new JLabel("Mango Juice\r\n");
		lblTea.setHorizontalAlignment(SwingConstants.CENTER);
		lblTea.setForeground(Color.BLACK);
		lblTea.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTea.setBackground(Color.GRAY);
		lblTea.setBounds(12, 42, 79, 30);
		panlForDrinks.add(lblTea);
				
		JLabel lblCola = new JLabel("Malta Juice");
		lblCola.setHorizontalAlignment(SwingConstants.CENTER);
		lblCola.setForeground(Color.BLACK);
		lblCola.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCola.setBackground(Color.GRAY);
		lblCola.setBounds(12, 72, 79, 30);
		panlForDrinks.add(lblCola);
				
		JLabel lblCoke = new JLabel("Pineapple Juice\r\n");
		lblCoke.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoke.setForeground(Color.BLACK);
		lblCoke.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCoke.setBackground(Color.GRAY);
		lblCoke.setBounds(8, 103, 90, 30);
		panlForDrinks.add(lblCoke);
				
		JLabel lblCoffee = new JLabel("Soft Drinks\r\n");
		lblCoffee.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoffee.setForeground(Color.BLACK);
		lblCoffee.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCoffee.setBackground(Color.GRAY);
		lblCoffee.setBounds(12, 135, 79, 30);
		panlForDrinks.add(lblCoffee);
				
				
				
		JLabel lblIceTea = new JLabel("Lassi");
		lblIceTea.setHorizontalAlignment(SwingConstants.CENTER);
		lblIceTea.setForeground(Color.BLACK);
		lblIceTea.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIceTea.setBackground(Color.GRAY);
		lblIceTea.setBounds(12, 168, 79, 30);
		panlForDrinks.add(lblIceTea);
				
		
//---------------------------------	JcomboBox select for Drinks-----------------------------
		
		JComboBox comboApple = new JComboBox();
		comboApple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"apple juice",comboApple.getSelectedItem().toString());
			}
		});
		comboApple.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboApple.setBounds(101, 17, 52, 22);
		panlForDrinks.add(comboApple);
		
		JComboBox comboMango = new JComboBox();
		comboMango.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"mango juice",comboMango.getSelectedItem().toString());
			}
		});
		comboMango.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboMango.setBounds(101, 47, 52, 22);
		panlForDrinks.add(comboMango);
		
		JComboBox comboMalta = new JComboBox();
		comboMalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"malta juice",comboMalta.getSelectedItem().toString());
			}
		});
		comboMalta.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboMalta.setBounds(101, 77, 52, 22);
		panlForDrinks.add(comboMalta);
		
		JComboBox comboPineapple = new JComboBox();
		comboPineapple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"pineapple juice",comboPineapple.getSelectedItem().toString());
			}
		});
		comboPineapple.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboPineapple.setBounds(101, 107, 52, 24);
		panlForDrinks.add(comboPineapple);
		
		JComboBox comboSoftDrinks = new JComboBox();
		comboSoftDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"soft drinks",comboSoftDrinks.getSelectedItem().toString());
			}
		});
		comboSoftDrinks.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboSoftDrinks.setBounds(101, 140, 52, 22);
		panlForDrinks.add(comboSoftDrinks);
		
		JComboBox comboLassi = new JComboBox();
		comboLassi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"lassi",comboLassi.getSelectedItem().toString());
			}
		});
		comboLassi.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboLassi.setBounds(101, 173, 52, 22);
		panlForDrinks.add(comboLassi);
		
		JComboBox comboCofee = new JComboBox();
		comboCofee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"cofee",comboCofee.getSelectedItem().toString());
			}
		});
		comboCofee.setBounds(251, 47, 52, 22);
		panlForDrinks.add(comboCofee);
		comboCofee.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

		
		JComboBox comboTea = new JComboBox();
		comboTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order( order_no.getText(),"tea",comboTea.getSelectedItem().toString());
			}
		});
		comboTea.setBounds(251, 17, 52, 22);
		panlForDrinks.add(comboTea);
		comboTea.setModel(new DefaultComboBoxModel(new String[] {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));

//---------------------------------------------------converter part----------------------------------------------------------------
		double US =78.43;
		double india =1.18;
		double pakistan=.75;
		double mal =19.02;
		double saudi =20.91;
		double singapur =57.55;
			
		
//---------------------------- Panel for Currency Converter------------------------
		
		JPanel panlForConverter = new JPanel();
		panlForConverter.setBackground(new Color(192, 192, 192));
		panlForConverter.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panlForConverter.setBounds(676, 64, 328, 278);
		Rbms.getContentPane().add(panlForConverter);
		panlForConverter.setLayout(null);
		
//--------------------------- Required options for Currency Converter------------------
		
		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		lblCurrencyConverter.setBackground(Color.WHITE);
		lblCurrencyConverter.setForeground(Color.BLACK);
		lblCurrencyConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrencyConverter.setFont(new Font("DejaVu Serif", Font.BOLD, 18));
		lblCurrencyConverter.setBounds(12, 0, 316, 32);
		panlForConverter.add(lblCurrencyConverter);
		
		txtConvertion = new JTextField();
		txtConvertion.setFont(new Font("Dialog", Font.BOLD, 18));
		txtConvertion.setHorizontalAlignment(SwingConstants.RIGHT);
		txtConvertion.setBounds(70, 186, 193, 47);
		panlForConverter.add(txtConvertion);
		txtConvertion.setColumns(10);
		
		txtCurrency = new JTextField();
		txtCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrency.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCurrency.setBounds(70, 84, 190, 42);
		panlForConverter.add(txtCurrency);
		txtCurrency.setColumns(10);
		
		JComboBox comboCountry = new JComboBox();
		comboCountry.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		comboCountry.setModel(new DefaultComboBoxModel(new String[] {"Choose One...", "India", "Malaysia", "Pakistan", "Saudi Arabia", "Singapur", "USA"}));
		comboCountry.setBounds(70, 40, 193, 32);
		panlForConverter.add(comboCountry);

//-------------------------------- Calculations for "Convert" button----------------------------
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Bd_Taka= Double.parseDouble(txtCurrency.getText());
				if(comboCountry.getSelectedItem().equals("India"))
				{
					String cConvert= String.format("BDT %.2f", Bd_Taka*india);	
					txtConvertion.setText(cConvert);
					
				}
				

				if(comboCountry.getSelectedItem().equals("Malaysia"))
				{
					String cConvert= String.format("BDT %.2f", Bd_Taka*mal);	
					txtConvertion.setText(cConvert);
					
				}
				
				if(comboCountry.getSelectedItem().equals("Pakistan"))
				{
					String cConvert= String.format("BDT %.2f", Bd_Taka*pakistan);	
					txtConvertion.setText(cConvert);
					
				}
				
				if(comboCountry.getSelectedItem().equals("Saudi Arabia"))
				{
					String cConvert= String.format("BDT %.2f", Bd_Taka*saudi);	
					txtConvertion.setText(cConvert);
					
				}
				
				if(comboCountry.getSelectedItem().equals("Singapur"))
				{
					String cConvert= String.format("BDT %.2f", Bd_Taka*singapur);	
					txtConvertion.setText(cConvert);
					
				}
				
				if(comboCountry.getSelectedItem().equals("USA"))
				{
					String cConvert= String.format("BDT %.2f", Bd_Taka*US);	
					txtConvertion.setText(cConvert);
					
				}
							
				
			}
		});
		btnConvert.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		btnConvert.setBounds(102, 138, 117, 25);
		panlForConverter.add(btnConvert);
				
		
		JPanel panlForCalc = new JPanel();
		panlForCalc.setBackground(new Color(192, 192, 192));
		panlForCalc.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panlForCalc.setBounds(1016, 62, 328, 526);
		Rbms.getContentPane().add(panlForCalc);
		panlForCalc.setLayout(null);
		
		order_no = new JTextField();
		order_no.setBounds(226, 11, 86, 20);
		panlForCalc.add(order_no);
		order_no.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 39, 292, 448);
		panlForCalc.add(tabbedPane);
		
		
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_7, null);
		panel_7.setLayout(null);
		
		table = new JTable();
		table.setBounds(24, 34, 253, 270);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		panel_7.add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(177, 350, 68, 20);
		panel_7.add(lblNewLabel);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalCost.setBounds(24, 356, 68, 14);
		panel_7.add(lblTotalCost);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(0, 12, 287, 397);
		panel_7.add(textField);
		textField.setColumns(10);
		
//---------------------------------  Calculator --------------------
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(UIManager.getColor("FormattedTextField.foreground"));
		tabbedPane.addTab("Calculator", null, panel_6, null);
		panel_6.setLayout(null);
		
		JButton button = new JButton("<--");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = txtA.getText().length();
				int number= txtA.getText().length()-1;
				String store;
				if (length>0) {
					StringBuilder back= new StringBuilder(txtA.getText());
					back.deleteCharAt(number);
					store=back.toString();
					txtA.setText(store);
				}
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setBorder(null);
		button.setBounds(17, 154, 50, 37);
		panel_6.add(button);
		
		txtA = new JTextField();
		txtA.setHorizontalAlignment(SwingConstants.RIGHT);
		txtA.setFont(new Font("Dialog", Font.BOLD, 20));
		txtA.setColumns(10);
		txtA.setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		txtA.setBounds(17, 39, 255, 90);
		panel_6.add(txtA);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.setBackground(UIManager.getColor("DesktopIcon.background"));
		lbl1.setBounds(162, 7, 110, 20);
		panel_6.add(lbl1);
		
		JButton button_1 = new JButton("C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText("");
				lbl1.setText("");
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBorder(null);
		button_1.setBounds(85, 154, 49, 37);
		panel_6.add(button_1);
		
		JButton button_2 = new JButton("%");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num= Double.parseDouble(txtA.getText());
				calculation=5;
				txtA.setText("");
				lbl1.setText(num+"%");
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBorder(null);
		button_2.setBounds(155, 154, 50, 37);
		panel_6.add(button_2);
		
		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num= Double.parseDouble(txtA.getText());
				calculation=1;
				txtA.setText("");
				lbl1.setText(num+"+");
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBorder(null);
		button_3.setBounds(225, 154, 50, 37);
		panel_6.add(button_3);
		
		JButton button_4 = new JButton("-");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num= Double.parseDouble(txtA.getText());
				calculation=2;
				txtA.setText("");
				lbl1.setText(num+"-");
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 14));
		button_4.setBorder(null);
		button_4.setAlignmentY(1.0f);
		button_4.setAlignmentX(1.0f);
		button_4.setBounds(225, 208, 50, 37);
		panel_6.add(button_4);
		
		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"9");
			}
		});
		button_5.setFont(new Font("Dialog", Font.BOLD, 14));
		button_5.setBorder(null);
		button_5.setAlignmentY(1.0f);
		button_5.setAlignmentX(1.0f);
		button_5.setBounds(154, 208, 50, 37);
		panel_6.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"8");
			}
		});
		button_6.setFont(new Font("Dialog", Font.BOLD, 14));
		button_6.setBorder(null);
		button_6.setAlignmentY(1.0f);
		button_6.setAlignmentX(1.0f);
		button_6.setBounds(83, 208, 50, 37);
		panel_6.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"7");
			}
		});
		button_7.setFont(new Font("Dialog", Font.BOLD, 14));
		button_7.setBorder(null);
		button_7.setAlignmentY(1.0f);
		button_7.setAlignmentX(1.0f);
		button_7.setBounds(16, 208, 50, 37);
		panel_6.add(button_7);
		
		JButton button_8 = new JButton("4");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"4");
			}
		});
		button_8.setFont(new Font("Dialog", Font.BOLD, 14));
		button_8.setBorder(null);
		button_8.setAlignmentY(1.0f);
		button_8.setAlignmentX(1.0f);
		button_8.setBounds(16, 257, 50, 37);
		panel_6.add(button_8);
		
		JButton button_9 = new JButton("5");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"5");
			}
		});
		button_9.setFont(new Font("Dialog", Font.BOLD, 14));
		button_9.setBorder(null);
		button_9.setAlignmentY(1.0f);
		button_9.setAlignmentX(1.0f);
		button_9.setBounds(83, 257, 50, 37);
		panel_6.add(button_9);
		
		JButton button_10 = new JButton("6");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"6");
			}
		});
		button_10.setFont(new Font("Dialog", Font.BOLD, 14));
		button_10.setBorder(null);
		button_10.setAlignmentY(1.0f);
		button_10.setAlignmentX(1.0f);
		button_10.setBounds(154, 257, 50, 37);
		panel_6.add(button_10);
		
		JButton button_11 = new JButton("*");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num= Double.parseDouble(txtA.getText());
				calculation=3;
				txtA.setText("");
				lbl1.setText(num+"*");
			}
		});
		button_11.setFont(new Font("Dialog", Font.BOLD, 14));
		button_11.setBorder(null);
		button_11.setAlignmentY(1.0f);
		button_11.setAlignmentX(1.0f);
		button_11.setBounds(225, 257, 50, 37);
		panel_6.add(button_11);
		
		JButton button_12 = new JButton("/");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num= Double.parseDouble(txtA.getText());
				calculation=4;
				txtA.setText("");
				lbl1.setText(num+"/");
			}
		});
		button_12.setFont(new Font("Dialog", Font.BOLD, 14));
		button_12.setBorder(null);
		button_12.setAlignmentY(1.0f);
		button_12.setAlignmentX(1.0f);
		button_12.setBounds(225, 306, 50, 37);
		panel_6.add(button_12);
		
		JButton button_13 = new JButton("3");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"3");
			}
		});
		button_13.setFont(new Font("Dialog", Font.BOLD, 14));
		button_13.setBorder(null);
		button_13.setAlignmentY(1.0f);
		button_13.setAlignmentX(1.0f);
		button_13.setBounds(154, 306, 50, 37);
		panel_6.add(button_13);
		
		JButton button_14 = new JButton("2");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"2");
			}
		});
		button_14.setFont(new Font("Dialog", Font.BOLD, 14));
		button_14.setBorder(null);
		button_14.setAlignmentY(1.0f);
		button_14.setAlignmentX(1.0f);
		button_14.setBounds(83, 306, 50, 37);
		panel_6.add(button_14);
		
		JButton button_15 = new JButton("1");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"1");
			}
		});
		button_15.setFont(new Font("Dialog", Font.BOLD, 14));
		button_15.setBorder(null);
		button_15.setAlignmentY(1.0f);
		button_15.setAlignmentX(1.0f);
		button_15.setBounds(16, 306, 50, 37);
		panel_6.add(button_15);
		
		JButton button_16 = new JButton(".");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+".");
			}
		});
		button_16.setFont(new Font("Dialog", Font.BOLD, 14));
		button_16.setBorder(null);
		button_16.setAlignmentY(1.0f);
		button_16.setAlignmentX(1.0f);
		button_16.setBounds(16, 356, 50, 37);
		panel_6.add(button_16);
		
		JButton button_17 = new JButton("0");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtA.setText(txtA.getText()+"0");
			}
		});
		button_17.setFont(new Font("Dialog", Font.BOLD, 14));
		button_17.setBorder(null);
		button_17.setAlignmentY(1.0f);
		button_17.setAlignmentX(1.0f);
		button_17.setBounds(84, 355, 50, 37);
		panel_6.add(button_17);
		
		JButton bt18 = new JButton("=");
		bt18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arithmatic();
				lbl1.setText("");
			}
		});
		bt18.setFont(new Font("Dialog", Font.BOLD, 14));
		bt18.setBorder(null);
		bt18.setAlignmentY(1.0f);
		bt18.setAlignmentX(1.0f);
		bt18.setBounds(155, 356, 121, 37);
		//contentPane.add(bt18);
		panel_6.add(bt18);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("history", null, panel, null);
		panel.setLayout(null);
		
		date = new JTextField();
		date.setBounds(65, 26, 86, 20);
		panel.add(date);
		date.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				srdate(date.getText());
				//JOptionPane.showMessageDialog(null, order_no.getText());
			}
		});
		btnNewButton_1.setBounds(176, 25, 89, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 267, 285);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setShowHorizontalLines(false);
		table_1.setShowVerticalLines(false);
		table_1.setShowGrid(false);
		
		JLabel lblOrderNo = new JLabel("Order No:");
		lblOrderNo.setForeground(Color.BLACK);
		lblOrderNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrderNo.setBounds(166, 13, 58, 14);
		panlForCalc.add(lblOrderNo);
		

		
		JPanel panlForCosts = new JPanel();
		panlForCosts.setBackground(new Color(192, 192, 192));
		panlForCosts.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panlForCosts.setBounds(12, 354, 652, 237);
		Rbms.getContentPane().add(panlForCosts);
		panlForCosts.setLayout(null);
		
		JLabel lbl9 = new JLabel("Cost of Delivery");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setForeground(Color.BLACK);
		lbl9.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl9.setBackground(Color.GRAY);
		lbl9.setBounds(12, 109, 237, 30);
		panlForCosts.add(lbl9);
		
		JLabel lbl8 = new JLabel("Cost of Drink");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setForeground(Color.BLACK);
		lbl8.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl8.setBackground(Color.GRAY);
		lbl8.setBounds(12, 67, 208, 30);
		panlForCosts.add(lbl8);
		
		JLabel lbl7 = new JLabel("Cost of Food");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setForeground(Color.BLACK);
		lbl7.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl7.setBackground(UIManager.getColor("Button.select"));
		lbl7.setBounds(12, 25, 208, 30);
		panlForCosts.add(lbl7);
		
		txt6 = new JTextField();
		txt6.setHorizontalAlignment(SwingConstants.RIGHT);
		txt6.setFont(new Font("Dialog", Font.BOLD, 17));
		txt6.setColumns(10);
		txt6.setBackground(UIManager.getColor("Button.select"));
		txt6.setBounds(312, 25, 237, 30);
		panlForCosts.add(txt6);
		
		txt7 = new JTextField();
		txt7.setHorizontalAlignment(SwingConstants.RIGHT);
		txt7.setFont(new Font("Dialog", Font.BOLD, 17));
		txt7.setColumns(10);
		txt7.setBackground(UIManager.getColor("Button.select"));
		txt7.setBounds(312, 67, 237, 30);
		panlForCosts.add(txt7);
		
		txt8 = new JTextField();
		txt8.setHorizontalAlignment(SwingConstants.RIGHT);
		txt8.setFont(new Font("Dialog", Font.BOLD, 17));
		txt8.setColumns(10);
		txt8.setBackground(UIManager.getColor("Button.select"));
		txt8.setBounds(312, 109, 237, 30);
		panlForCosts.add(txt8);
		
		JPanel panlForTotal = new JPanel();
		panlForTotal.setBackground(new Color(192, 192, 192));
		panlForTotal.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panlForTotal.setBounds(676, 354, 328, 237);
		Rbms.getContentPane().add(panlForTotal);
		panlForTotal.setLayout(null);
		
		txt11 = new JTextField();
		txt11.setHorizontalAlignment(SwingConstants.RIGHT);
		txt11.setFont(new Font("Dialog", Font.BOLD, 17));
		txt11.setColumns(10);
		txt11.setBackground(UIManager.getColor("Button.select"));
		txt11.setBounds(179, 25, 123, 30);
		panlForTotal.add(txt11);
		
		JLabel lbl12 = new JLabel("Tax");
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		lbl12.setForeground(Color.BLACK);
		lbl12.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl12.setBackground(UIManager.getColor("Button.select"));
		lbl12.setBounds(26, 24, 108, 30);
		panlForTotal.add(lbl12);
		
		txt12 = new JTextField();
		txt12.setHorizontalAlignment(SwingConstants.RIGHT);
		txt12.setFont(new Font("Dialog", Font.BOLD, 17));
		txt12.setColumns(10);
		txt12.setBackground(UIManager.getColor("Button.select"));
		txt12.setBounds(179, 80, 123, 30);
		panlForTotal.add(txt12);
		
		JLabel lbl13 = new JLabel("Sub Total");
		lbl13.setHorizontalAlignment(SwingConstants.CENTER);
		lbl13.setForeground(Color.BLACK);
		lbl13.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl13.setBackground(UIManager.getColor("Button.select"));
		lbl13.setBounds(26, 79, 108, 30);
		panlForTotal.add(lbl13);
		
		txt13 = new JTextField();
		txt13.setHorizontalAlignment(SwingConstants.RIGHT);
		txt13.setFont(new Font("Dialog", Font.BOLD, 17));
		txt13.setColumns(10);
		txt13.setBackground(UIManager.getColor("Button.select"));
		txt13.setBounds(179, 138, 123, 30);
		panlForTotal.add(txt13);
		
		JLabel lbl14 = new JLabel("Total\n");
		lbl14.setHorizontalAlignment(SwingConstants.CENTER);
		lbl14.setForeground(Color.BLACK);
		lbl14.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl14.setBackground(UIManager.getColor("Button.select"));
		lbl14.setBounds(26, 137, 108, 30);
		panlForTotal.add(lbl14);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panel_5.setBounds(12, 600, 1332, 46);
		Rbms.getContentPane().add(panel_5);
		
		JCheckBox ckbox1 = new JCheckBox("Home Delivery");
		ckbox1.setForeground(Color.BLACK);
		ckbox1.setFont(new Font("Century Schoolbook L", Font.BOLD, 14));
		ckbox1.setBackground(Color.GRAY);
		ckbox1.setBounds(23, 221, 138, 30);
		panlForDrinks.add(ckbox1);
		
		JCheckBox ckbox2 = new JCheckBox("Tax");
		ckbox2.setSelected(true);
		ckbox2.setForeground(Color.BLACK);
		ckbox2.setFont(new Font("Century Schoolbook L", Font.BOLD, 14));
		ckbox2.setBackground(Color.GRAY);
		ckbox2.setBounds(215, 221, 72, 30);
		panlForDrinks.add(ckbox2);
		
		JLabel lblTea_1 = new JLabel("Tea");
		lblTea_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTea_1.setForeground(Color.BLACK);
		lblTea_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTea_1.setBackground((Color) null);
		lblTea_1.setBounds(162, 12, 79, 30);
		panlForDrinks.add(lblTea_1);
		
		
		JLabel lblCofee = new JLabel("Cofee");
		lblCofee.setHorizontalAlignment(SwingConstants.CENTER);
		lblCofee.setForeground(Color.BLACK);
		lblCofee.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCofee.setBackground(Color.GRAY);
		lblCofee.setBounds(162, 42, 79, 30);
		panlForDrinks.add(lblCofee);
		
		
		Rbms.setBounds(0,0, 1367, 689);
		Rbms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
	//----------------------------- Calculate Total for food ------------------ 				
					
					double IlishPolao = Double.parseDouble((String) comboIlishPolao.getSelectedItem());
					int IlishPolaoPrice=IlishPolaoPrice = DB("ilish_polao");
					
					double tIlishPolao= IlishPolao*IlishPolaoPrice;
					
					double morogPolao = Double.parseDouble((String) comboMorogPolao.getSelectedItem());
					double morogPolaoPrice = DB("morog_palao");
					double tmorogPolao= morogPolao*morogPolaoPrice;
					
					double kacchiBirani = Double.parseDouble((String) comboKacchi.getSelectedItem());
					double kacchiBiraniPrice = DB("kacchi_birani");
					double tkacchiBirani= kacchiBirani*kacchiBiraniPrice;
					
					double tehari = Double.parseDouble((String) comboTehari.getSelectedItem());
					double tehariPrice = DB("tehari");
					double ttehari= tehari*tehariPrice;
					
					double grill = Double.parseDouble((String) comboGrill.getSelectedItem());
					double grillPrice = DB("grill");
					double tgrill= grill*grillPrice;
					
					
					double bread = Double.parseDouble((String) comboBread.getSelectedItem());
					double breadPrice = DB("bread");
					double tbread= bread*breadPrice;
					
					double burger = Double.parseDouble((String) comboBurger.getSelectedItem());
					double burgerPrice = DB("burger");
					double tburger = burger*burgerPrice;
					
					double sandwich = Double.parseDouble((String) comboSandwich.getSelectedItem());
					double sandwichPrice = DB("sandwich");
					double tsandwich = sandwich*sandwichPrice;
					
					double pizza = Double.parseDouble((String) comboPizza.getSelectedItem());
					double pizzaPrice = DB("sandwich");
					double tpizza = pizza*pizzaPrice;
					
					double roll = Double.parseDouble((String) comboRoll.getSelectedItem());
					double rollPrice = DB("roll");
					double troll = roll*rollPrice;
					
					double somucha = Double.parseDouble((String) comboSomucha.getSelectedItem());
					double somuchaPrice = DB("somucha");
					double tsomucha = somucha*somuchaPrice;
					
					double singara = Double.parseDouble((String) comboSingara.getSelectedItem());
					double singaraPrice = DB("singara");
					double tsingara = singara*singaraPrice;
					
					
					double totalmealcost=tIlishPolao+tmorogPolao+tkacchiBirani+ttehari+tgrill+tbread+tburger+tsandwich+tpizza+tsomucha+troll+tsingara;
					String totalmeal = String.format("%.2f",totalmealcost );
					
					txt6.setText(totalmeal);

//--------------------------- Calculate Total for Drinks -------------------
					
					double appleJuice = Double.parseDouble((String) comboApple.getSelectedItem());
					double appleJuicePrice = DB("apple_juice");;
					double tappleJuice= appleJuice*appleJuicePrice;
					
					double mangoJuice = Double.parseDouble((String) comboMango.getSelectedItem());
					double mangoJuicePrice = DB("mango_juice");;
					double tmangoJuice= mangoJuice*mangoJuicePrice;
					
					double maltaJuice = Double.parseDouble((String) comboMalta.getSelectedItem());
					double maltaJuicePrice = DB("malta_juice");;
					double tmaltaJuice= maltaJuice*maltaJuicePrice;
					
					double pineappleJuice = Double.parseDouble((String) comboPineapple.getSelectedItem());
					double pineappleJuicePrice = DB("pineapple_juice");;
					double tpineappleJuice= pineappleJuice*pineappleJuicePrice;
					
					double softDrinks = Double.parseDouble((String) comboSoftDrinks.getSelectedItem());
					double softDrinksPrice = DB("soft_drinks");;
					double tsoftDrinksPrice= softDrinks*softDrinksPrice;
					
					double lassi = Double.parseDouble((String) comboLassi.getSelectedItem());
					double lassiPrice = DB("lassi");;
					double tlassi= lassi*lassiPrice;
					
					double tea = Double.parseDouble((String) comboTea.getSelectedItem());
					double teaPrice = DB("tea");;
					double ttea= tea*teaPrice;
					
					double cofee = Double.parseDouble((String) comboCofee.getSelectedItem());
					double cofeePrice = DB("tea");;
					double tcofee= cofee*cofeePrice;
					
					double totaldrinkcost = tappleJuice+tmangoJuice+tmaltaJuice+tpineappleJuice+tsoftDrinksPrice+tlassi+ttea+tcofee;
					String totaldrink = String.format("%.2f",totaldrinkcost );
					txt7.setText(totaldrink);
					
					double hd=100.0;
					String hdl = String.format("%.2f", hd);
					if (ckbox1.isSelected()) {
						txt8.setText(hdl);
					} else {
						hd=0;
						txt8.setText("0.00");
					}
					
					double subtotal = hd+totaldrinkcost+totalmealcost;
					String subtotalt= String.format("%.2f", subtotal);
					txt12.setText(subtotalt);
					
					double tax= subtotal * (15.0/100.0);
					if (ckbox2.isSelected()) {
						
						String taxT= String.format("%.2f", tax);
						txt11.setText(taxT);
					} else {
						tax=0;
						String taxT1= String.format("%.2f", tax);
						txt11.setText(taxT1);
					}
					
					
					double total= tax+subtotal;
					String totalt= String.format("%.2f", total);
					txt13.setText(totalt);
					
					
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
				
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		panel_5.add(btnNewButton);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double q1= Double.parseDouble(txt6.getText());
				double q2= Double.parseDouble(txt7.getText());
				double q3= Double.parseDouble(txt8.getText());
				
				Info();
				lblNewLabel.setText(txt13.getText());
				
			}
		});
		panel_5.add(btnReceipt);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboIlishPolao.setSelectedItem("0");
				comboMorogPolao.setSelectedItem("0");
				comboKacchi.setSelectedItem("0");
				comboTehari.setSelectedItem("0");
				comboGrill.setSelectedItem("0");
				comboBread.setSelectedItem("0");
				comboApple.setSelectedItem("0");
				comboMango.setSelectedItem("0");
				comboMalta.setSelectedItem("0");
				comboPineapple.setSelectedItem("0");
				comboSoftDrinks.setSelectedItem("0");
				comboLassi.setSelectedItem("0");
				comboBurger.setSelectedItem("0");
				comboSandwich.setSelectedItem("0");
				comboPizza.setSelectedItem("0");
				comboSomucha.setSelectedItem("0");
				comboRoll.setSelectedItem("0");
				comboSingara.setSelectedItem("0");
				comboTea.setSelectedItem("0");
				comboCofee.setSelectedItem("0");
				comboCountry.setSelectedItem("Choose One...");
				txt6.setText(null);
				txt7.setText(null);
				txt8.setText(null);
				txtConvertion.setText(null);
				txt11.setText(null);
				txt12.setText(null);
				txt13.setText(null);
				txtCurrency.setText(null);
				order_no.setText(null);
				
				ckbox1.setSelected(false);
				ckbox2.setSelected(false);
				
				PreparedStatement psa;
				try {
					psa = connection().prepareStatement("delete from order_info where quantity=0");
					psa.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		panel_5.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_5.add(btnExit);
		
		JLabel a = new JLabel("Kutum Korai Restaurant");
		a.setForeground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		a.setHorizontalAlignment(SwingConstants.CENTER);
		a.setFont(new Font("Dialog", Font.BOLD, 40));
		a.setBackground(SystemColor.inactiveCaption);
		a.setBounds(22, 0, 1322, 52);
		Rbms.getContentPane().add(a);
		

		
		
	}
	void order(String x,String y,String z)
	{
		
		String s ="select *from order_info where order_no=? and food_name=? ";
		PreparedStatement p;
		ResultSet rst=null;
		try {
			p = connection().prepareStatement(s);
			p.setString(1, x);
			p.setString(2, y);
			
			
			rst=p.executeQuery();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			if(rst.next())
			{
			}
			else
			{
			if(order_no.getText()!=null && z!=null)
			{
			String sql= "Insert into order_info values(?,?,?,CURDATE())";
			try {
				PreparedStatement ps = connection().prepareStatement(sql);
				ps.setString(1, x);
				ps.setString(2, y);
				ps.setString(3, z);
				
				ps.executeUpdate();
				
				PreparedStatement psa = connection().prepareStatement("delete from order_info where quantity=0");
				psa.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Please insert Order Number first at the top right corner!");
			}
			finally {
				connection().close();
				
			}
			}	
}
		} catch (HeadlessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Info()
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
        	String sql="select food_name,quantity from order_info where order_no=?";
            ist = connection().prepareStatement(sql);
            ist.setString(1, order_no.getText());
            JOptionPane.showMessageDialog(null, order_no.getText());
            s =  ist.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(s));
            
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }
       
    }
	public void srdate(String tb)
    {
        PreparedStatement ist=null;
        ResultSet s=null;
        try
        {
        	String sql="SELECT food_name, SUM( quantity ) as 'total sale' FROM  order_info WHERE DATE =? GROUP BY food_name";
            ist = connection().prepareStatement(sql);
            ist.setString(1, tb);
          
            s =  ist.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(s));
            
        } 
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, e);
        }
       
    }
}
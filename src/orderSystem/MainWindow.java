package orderSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MainWindow {
	/*
	 * Project      : EspressoHub Order System Version 1.0
	 * Developer    : Castro John Christian
	 * Message      : This is just a simple order system
	 * Date Created : 12/02/2023
	 */
	private JFrame frmEspressohub;
	double getBlkCoffee = 0, getLatte = 0, getCappuccino = 0, getAmericano = 0, getEspresso = 0;
	double subBlkCoffee = 0, subLatte = 0, subCappuccino = 0, subAmericano = 0, subEspresso = 0;
	int cntBlkCoffee = 0, cntLatte = 0, cntCappuccino = 0, cntAmericano = 0, cntEspresso = 0;

	double subspcBlkCoffee = 0, subspcLatte = 0, subspcCappuccino = 0, subspcAmericano = 0, subspcEspresso = 0;
	int cntspcBlkCoffee = 0, cntspcLatte = 0, cntspcCappuccino = 0, cntspcAmericano = 0, cntspcEspresso = 0;
	double spcTotal = 0;

	double allTotal = 0;
	double userBudget = 0, userChange = 0;
	private JTextField TxtF_Budget;
	private JTextField TxtF_Specify_Qty;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmEspressohub.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		// Instantiating Created Object
		GetCoffeePrice objPrice = new GetCoffeePrice();
		CoffeeDescriptions objCoffeeDscrpt = new CoffeeDescriptions();

		frmEspressohub = new JFrame();
		frmEspressohub.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/orderSystem/images/icons/EspressoHub.png")));
		frmEspressohub.getContentPane().setBackground(new Color(244, 164, 96));
		frmEspressohub.setTitle("EspressoHub");
		frmEspressohub.setResizable(false);
		frmEspressohub.setBounds(100, 100, 855, 700);
		frmEspressohub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEspressohub.setLocationRelativeTo(null);
		frmEspressohub.getContentPane().setLayout(null);

		JPanel Pnl_Header = new JPanel();
		Pnl_Header.setBackground(new Color(255, 127, 80));
		Pnl_Header.setBounds(0, 0, 874, 39);
		frmEspressohub.getContentPane().add(Pnl_Header);

		JLabel Lbl_Header = new JLabel("EspressoHub");
		Lbl_Header.setForeground(new Color(139, 69, 19));
		Lbl_Header.setFont(new Font("Tahoma", Font.BOLD, 24));
		Pnl_Header.add(Lbl_Header);

		JLabel Lbl_Black = new JLabel("");
		Lbl_Black.setIcon(
				new ImageIcon(MainWindow.class.getResource("/orderSystem/images/coffees/Black Coffee Price.PNG")));
		Lbl_Black.setBounds(20, 62, 130, 138);
		frmEspressohub.getContentPane().add(Lbl_Black);

		JLabel Lbl_Espresso = new JLabel("");
		Lbl_Espresso.setIcon(
				new ImageIcon(MainWindow.class.getResource("/orderSystem/images/coffees/Espresso Coffee Price.PNG")));
		Lbl_Espresso.setBounds(160, 259, 130, 138);
		frmEspressohub.getContentPane().add(Lbl_Espresso);

		JLabel Lbl_Latte = new JLabel("");
		Lbl_Latte.setIcon(
				new ImageIcon(MainWindow.class.getResource("/orderSystem/images/coffees/Latte Coffee Price.PNG")));
		Lbl_Latte.setBounds(20, 259, 130, 138);
		frmEspressohub.getContentPane().add(Lbl_Latte);

		JLabel Lbl_Cappuccino = new JLabel("");
		Lbl_Cappuccino.setIcon(
				new ImageIcon(MainWindow.class.getResource("/orderSystem/images/coffees/Cappuccino Coffee Price.PNG")));
		Lbl_Cappuccino.setBounds(20, 454, 130, 138);
		frmEspressohub.getContentPane().add(Lbl_Cappuccino);

		JLabel Lbl_Americano = new JLabel("");
		Lbl_Americano.setIcon(
				new ImageIcon(MainWindow.class.getResource("/orderSystem/images/coffees/Americano Coffee Price.PNG")));
		Lbl_Americano.setBounds(160, 62, 130, 138);
		frmEspressohub.getContentPane().add(Lbl_Americano);

		JLabel Lbl_Empty = new JLabel("");
		Lbl_Empty.setIcon(new ImageIcon(MainWindow.class.getResource("/orderSystem/images/coffees/Empty Price.PNG")));
		Lbl_Empty.setBounds(160, 454, 130, 138);
		frmEspressohub.getContentPane().add(Lbl_Empty);

		// Buttons
		JButton Btn_Coffee = new JButton("Coffee");
		Btn_Coffee.setForeground(new Color(255, 255, 255));
		Btn_Coffee.setBackground(new Color(139, 69, 19));
		Btn_Coffee.setFocusable(false);
		Btn_Coffee.setToolTipText("Want Black Coffee?");
		Btn_Coffee.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Coffee.setBounds(20, 211, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Coffee);

		JButton Btn_Latte = new JButton("Latte");
		Btn_Latte.setFocusable(false);
		Btn_Latte.setToolTipText("Want Latte?");
		Btn_Latte.setForeground(Color.WHITE);
		Btn_Latte.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Latte.setBackground(new Color(139, 69, 19));
		Btn_Latte.setBounds(20, 408, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Latte);

		JButton Btn_Cappuccino = new JButton("Cappuccino");
		Btn_Cappuccino.setFocusable(false);
		Btn_Cappuccino.setToolTipText("Want Cappuccino?");
		Btn_Cappuccino.setForeground(Color.WHITE);
		Btn_Cappuccino.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Cappuccino.setBackground(new Color(139, 69, 19));
		Btn_Cappuccino.setBounds(20, 603, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Cappuccino);

		JButton Btn_Americano = new JButton("Americano");
		Btn_Americano.setFocusable(false);
		Btn_Americano.setToolTipText("Want Americano?");
		Btn_Americano.setForeground(Color.WHITE);
		Btn_Americano.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Americano.setBackground(new Color(139, 69, 19));
		Btn_Americano.setBounds(160, 211, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Americano);

		JButton Btn_Espresso = new JButton("Espresso");
		Btn_Espresso.setFocusable(false);
		Btn_Espresso.setToolTipText("Want Espresso?");
		Btn_Espresso.setForeground(Color.WHITE);
		Btn_Espresso.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Espresso.setBackground(new Color(139, 69, 19));
		Btn_Espresso.setBounds(160, 408, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Espresso);

		JButton Btn_Coming = new JButton("Coming Soon");
		Btn_Coming.setEnabled(false);
		Btn_Coming.setToolTipText("Coming Soon");
		Btn_Coming.setForeground(Color.WHITE);
		Btn_Coming.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Coming.setBackground(new Color(139, 69, 19));
		Btn_Coming.setBounds(160, 603, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Coming);

		// Panel Initial Status
		JPanel Pnl_Initial_Status = new JPanel();
		Pnl_Initial_Status.setBackground(new Color(210, 180, 140));
		Pnl_Initial_Status.setBounds(300, 408, 250, 184);
		frmEspressohub.getContentPane().add(Pnl_Initial_Status);
		Pnl_Initial_Status.setLayout(null);

		JLabel Lbl_Qty_Num = new JLabel("QUANTITY: 00.00");
		Lbl_Qty_Num.setBounds(10, 57, 190, 35);
		Pnl_Initial_Status.add(Lbl_Qty_Num);
		Lbl_Qty_Num.setForeground(new Color(139, 69, 19));
		Lbl_Qty_Num.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel Lbl_Initial = new JLabel("INITIAL STATUS");
		Lbl_Initial.setForeground(new Color(139, 69, 19));
		Lbl_Initial.setFont(new Font("Tahoma", Font.BOLD, 16));
		Lbl_Initial.setBounds(10, 0, 190, 35);
		Pnl_Initial_Status.add(Lbl_Initial);

		JLabel Lbl_Coffee_Order = new JLabel("COFFEE: ");
		Lbl_Coffee_Order.setForeground(new Color(139, 69, 19));
		Lbl_Coffee_Order.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lbl_Coffee_Order.setBounds(10, 36, 190, 35);
		Pnl_Initial_Status.add(Lbl_Coffee_Order);

		JLabel Lbl_SubTotal = new JLabel("SUB TOTAL: 00.00");
		Lbl_SubTotal.setBounds(10, 114, 190, 35);
		Pnl_Initial_Status.add(Lbl_SubTotal);
		Lbl_SubTotal.setForeground(new Color(139, 69, 19));
		Lbl_SubTotal.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel Lbl_Total = new JLabel("TOTAL: 00.00");
		Lbl_Total.setBounds(10, 134, 190, 39);
		Pnl_Initial_Status.add(Lbl_Total);
		Lbl_Total.setForeground(new Color(139, 69, 19));
		Lbl_Total.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Panel Transaction
		JPanel Pnl_Transaction = new JPanel();
		Pnl_Transaction.setLayout(null);
		Pnl_Transaction.setBackground(new Color(250, 235, 215));
		Pnl_Transaction.setBounds(560, 335, 250, 184);
		frmEspressohub.getContentPane().add(Pnl_Transaction);

		JLabel Lbl_Transaction = new JLabel("TRANSACTION");
		Lbl_Transaction.setForeground(new Color(139, 69, 19));
		Lbl_Transaction.setFont(new Font("Tahoma", Font.BOLD, 16));
		Lbl_Transaction.setBounds(10, 0, 190, 35);
		Pnl_Transaction.add(Lbl_Transaction);

		JLabel lblNewLabel = new JLabel("ENTER BUDGET:");
		lblNewLabel.setBounds(10, 36, 93, 14);
		Pnl_Transaction.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		TxtF_Budget = new JTextField();
		TxtF_Budget.setBounds(10, 53, 130, 23);
		Pnl_Transaction.add(TxtF_Budget);
		TxtF_Budget.setText("00.00");
		TxtF_Budget.setForeground(new Color(255, 255, 255));
		TxtF_Budget.setBackground(new Color(160, 82, 45));
		TxtF_Budget.setFont(new Font("Tahoma", Font.BOLD, 14));
		TxtF_Budget.setColumns(10);

		JButton Btn_Budget = new JButton("Enter");
		Btn_Budget.setBounds(51, 79, 89, 23);
		Btn_Budget.setFocusable(false);
		Pnl_Transaction.add(Btn_Budget);
		Btn_Budget.setForeground(new Color(240, 248, 255));
		Btn_Budget.setBackground(new Color(255, 127, 80));
		Btn_Budget.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel Lbl_Change = new JLabel("CHANGE: 00.00");
		Lbl_Change.setBounds(10, 112, 130, 14);
		Pnl_Transaction.add(Lbl_Change);
		Lbl_Change.setForeground(new Color(139, 69, 19));
		Lbl_Change.setFont(new Font("Tahoma", Font.BOLD, 14));

		JButton Btn_Receipt = new JButton("RECEIPT");
		Btn_Receipt.setFocusable(false);
		Btn_Receipt.setBounds(110, 138, 130, 35);
		Pnl_Transaction.add(Btn_Receipt);
		Btn_Receipt.setEnabled(false);
		Btn_Receipt.setToolTipText("Black Coffee");
		Btn_Receipt.setForeground(Color.WHITE);
		Btn_Receipt.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Receipt.setBackground(new Color(139, 69, 19));

		JPanel Pnl_Notif = new JPanel();
		Pnl_Notif.setBackground(new Color(253, 245, 230));
		Pnl_Notif.setBounds(300, 601, 510, 37);
		frmEspressohub.getContentPane().add(Pnl_Notif);
		Pnl_Notif.setLayout(null);

		JLabel Lbl_Icon_Notify = new JLabel("");
		Lbl_Icon_Notify.setBounds(10, 0, 30, 37);
		Pnl_Notif.add(Lbl_Icon_Notify);
		Lbl_Icon_Notify
				.setIcon(new ImageIcon(MainWindow.class.getResource("/orderSystem/images/icons/Notification.png")));

		JLabel Lbl_Notify = new JLabel("");
		Lbl_Notify.setBounds(50, 11, 450, 14);
		Pnl_Notif.add(Lbl_Notify);
		Lbl_Notify.setForeground(new Color(160, 82, 45));
		Lbl_Notify.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel Pnl_Specified_Qty = new JPanel();
		Pnl_Specified_Qty.setLayout(null);
		Pnl_Specified_Qty.setBackground(new Color(205, 133, 63));
		Pnl_Specified_Qty.setBounds(300, 335, 250, 62);
		frmEspressohub.getContentPane().add(Pnl_Specified_Qty);

		JLabel Lbl_Specify_Qty = new JLabel("SPECIFIED QUANTITY");
		Lbl_Specify_Qty.setForeground(new Color(139, 69, 19));
		Lbl_Specify_Qty.setFont(new Font("Tahoma", Font.BOLD, 12));
		Lbl_Specify_Qty.setBounds(10, 11, 229, 14);
		Pnl_Specified_Qty.add(Lbl_Specify_Qty);

		TxtF_Specify_Qty = new JTextField();
		TxtF_Specify_Qty.setText("00.00");
		TxtF_Specify_Qty.setForeground(Color.WHITE);
		TxtF_Specify_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		TxtF_Specify_Qty.setColumns(10);
		TxtF_Specify_Qty.setBackground(new Color(160, 82, 45));
		TxtF_Specify_Qty.setBounds(10, 28, 130, 23);
		Pnl_Specified_Qty.add(TxtF_Specify_Qty);

		// Button Specified Quantity Coffee
		JButton Btn_Sp_Coffee_Qty = new JButton("Enter");
		Btn_Sp_Coffee_Qty.setFocusable(false);
		Btn_Sp_Coffee_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Coffee_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Coffee_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Coffee_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Coffee_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Coffee_Qty);

		JButton Btn_Sp_Latte_Qty = new JButton("Enter");
		Btn_Sp_Latte_Qty.setFocusable(false);
		Btn_Sp_Latte_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Latte_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Latte_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Latte_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Latte_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Latte_Qty);

		JButton Btn_Sp_Cappuccino_Qty = new JButton("Enter");
		Btn_Sp_Cappuccino_Qty.setFocusable(false);
		Btn_Sp_Cappuccino_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Cappuccino_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Cappuccino_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Cappuccino_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Cappuccino_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Cappuccino_Qty);

		JButton Btn_Sp_Americano_Qty = new JButton("Enter");
		Btn_Sp_Americano_Qty.setFocusable(false);
		Btn_Sp_Americano_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Americano_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Americano_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Americano_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Americano_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Americano_Qty);

		JButton Btn_Sp_Espresso_Qty = new JButton("Enter");
		Btn_Sp_Espresso_Qty.setFocusable(false);
		Btn_Sp_Espresso_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Espresso_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Espresso_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Espresso_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Espresso_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Espresso_Qty);
		
		JPanel Pnl_Reset = new JPanel();
		Pnl_Reset.setBackground(new Color(222, 184, 135));
		Pnl_Reset.setBounds(560, 530, 250, 62);
		frmEspressohub.getContentPane().add(Pnl_Reset);
		Pnl_Reset.setLayout(null);
		
		
		// Button Reset
		JButton Btn_Reset_All = new JButton("GREAT RESET");
		Btn_Reset_All.setFocusable(false);
		Btn_Reset_All.setForeground(new Color(255, 250, 250));
		Btn_Reset_All.setBackground(new Color(160, 82, 45));
		Btn_Reset_All.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Reset_All.setBounds(10, 11, 230, 40);
		Btn_Reset_All.setEnabled(false);
		Pnl_Reset.add(Btn_Reset_All);
		
		JLabel Lbl_Logo_View = new JLabel("");
		Lbl_Logo_View.setBounds(430, 72, 228, 228);
		frmEspressohub.getContentPane().add(Lbl_Logo_View);
		Lbl_Logo_View.setIcon(new ImageIcon(MainWindow.class.getResource("/orderSystem/images/icons/EspressoHubSmallView.png")));
		
		JPanel Pnl_CoffeeDscpt_Vw = new JPanel();
		Pnl_CoffeeDscpt_Vw.setBackground(new Color(139, 69, 19));
		Pnl_CoffeeDscpt_Vw.setBounds(300, 62, 510, 250);
		frmEspressohub.getContentPane().add(Pnl_CoffeeDscpt_Vw);
		Pnl_CoffeeDscpt_Vw.setLayout(null);
		Pnl_CoffeeDscpt_Vw.setVisible(false);
		
		JLabel Lbl_Coffee_Img = new JLabel("");		
		Lbl_Coffee_Img.setBounds(10, 19, 200, 211);
		Pnl_CoffeeDscpt_Vw.add(Lbl_Coffee_Img);
		
		JLabel Lbl_BlkCoffee_Vw = new JLabel("");
		Lbl_BlkCoffee_Vw.setForeground(new Color(233, 150, 122));
		Lbl_BlkCoffee_Vw.setBackground(new Color(240, 240, 240));
		Lbl_BlkCoffee_Vw.setFont(new Font("Tahoma", Font.BOLD, 20));
		Lbl_BlkCoffee_Vw.setBounds(220, 30, 280, 14);
		Pnl_CoffeeDscpt_Vw.add(Lbl_BlkCoffee_Vw);
		
		JLabel Lbl_Dscrpt_Vw = new JLabel("DESCRIPTION:");
		Lbl_Dscrpt_Vw.setForeground(new Color(255, 255, 255));
		Lbl_Dscrpt_Vw.setBackground(new Color(240, 240, 240));
		Lbl_Dscrpt_Vw.setFont(new Font("Tahoma", Font.BOLD, 16));
		Lbl_Dscrpt_Vw.setBounds(220, 60, 280, 14);
		Pnl_CoffeeDscpt_Vw.add(Lbl_Dscrpt_Vw);
		
		JTextArea TxtA_Vw = new JTextArea();
		TxtA_Vw.setForeground(new Color(255, 255, 255));
		TxtA_Vw.setBackground(new Color(139, 69, 19));
		TxtA_Vw.setLineWrap(true);
		TxtA_Vw.setWrapStyleWord(true);
		TxtA_Vw.setEditable(false);
		
		TxtA_Vw.setFont(new Font("Monospaced", Font.BOLD, 14));
		TxtA_Vw.setBounds(220, 80, 280, 150);
		Pnl_CoffeeDscpt_Vw.add(TxtA_Vw);
		
		Btn_Coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Setting Logo to not Visible
				Lbl_Logo_View.setVisible(false);
				
				Lbl_BlkCoffee_Vw.setText(objCoffeeDscrpt.getBlkCoffeeLbl());
				Lbl_Coffee_Img.setIcon(new ImageIcon(MainWindow.class.getResource(objCoffeeDscrpt.getImgBlkCoffee())));
				TxtA_Vw.setText(objCoffeeDscrpt.getBlkCoffeeDscrpt());
				Pnl_CoffeeDscpt_Vw.setVisible(true);
				
				// Btn_Sp_Coffee_Qty.setVisible(true)
				Btn_Sp_Coffee_Qty.setVisible(true);
				Btn_Sp_Latte_Qty.setVisible(false);
				Btn_Sp_Cappuccino_Qty.setVisible(false);
				Btn_Sp_Americano_Qty.setVisible(false);
				Btn_Sp_Espresso_Qty.setVisible(false);

				getBlkCoffee = objPrice.getBlkCoffeePrice();
				cntBlkCoffee++;

				subBlkCoffee += getBlkCoffee;
				allTotal += getBlkCoffee;

				Lbl_Coffee_Order.setText("COFFEE: Black Coffee");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntBlkCoffee));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subBlkCoffee));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
				
				Btn_Reset_All.setEnabled(true);
			}
		});

		Btn_Latte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Setting Logo to not Visible
				Lbl_Logo_View.setVisible(false);
				
				Lbl_BlkCoffee_Vw.setText(objCoffeeDscrpt.getLatteLbl());
				Lbl_Coffee_Img.setIcon(new ImageIcon(MainWindow.class.getResource(objCoffeeDscrpt.getImgLatte())));
				TxtA_Vw.setText(objCoffeeDscrpt.getLatteDscrpt());
				Pnl_CoffeeDscpt_Vw.setVisible(true);

				// Btn_Sp_Latte_Qty.setVisible(true)
				Btn_Sp_Coffee_Qty.setVisible(false);
				Btn_Sp_Latte_Qty.setVisible(true);
				Btn_Sp_Cappuccino_Qty.setVisible(false);
				Btn_Sp_Americano_Qty.setVisible(false);
				Btn_Sp_Espresso_Qty.setVisible(false);
				getLatte = objPrice.getLattePrice();
				cntLatte++;

				subLatte += getLatte;
				allTotal += getLatte;

				Lbl_Coffee_Order.setText("COFFEE: Latte");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntLatte));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subLatte));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
				
				Btn_Reset_All.setEnabled(true);
			}
		});

		Btn_Cappuccino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Setting Logo to not Visible
				Lbl_Logo_View.setVisible(false);
				
				Lbl_BlkCoffee_Vw.setText(objCoffeeDscrpt.getCappuccinoLbl());
				Lbl_Coffee_Img.setIcon(new ImageIcon(MainWindow.class.getResource(objCoffeeDscrpt.getImgCappuccino())));
				TxtA_Vw.setText(objCoffeeDscrpt.getCappuccinoDscrpt());
				Pnl_CoffeeDscpt_Vw.setVisible(true);

				// Btn_Sp_Cappuccino_Qty.setVisible(true)
				Btn_Sp_Coffee_Qty.setVisible(false);
				Btn_Sp_Latte_Qty.setVisible(false);
				Btn_Sp_Cappuccino_Qty.setVisible(true);
				Btn_Sp_Americano_Qty.setVisible(false);
				Btn_Sp_Espresso_Qty.setVisible(false);
				getCappuccino = objPrice.getCappuccinoPrice();
				cntCappuccino++;

				subCappuccino += getCappuccino;
				allTotal += getCappuccino;

				Lbl_Coffee_Order.setText("COFFEE: Cappuccino");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntCappuccino));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subCappuccino));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
				
				Btn_Reset_All.setEnabled(true);
			}
		});

		Btn_Americano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Setting Logo to not Visible
				Lbl_Logo_View.setVisible(false);
				
				Lbl_BlkCoffee_Vw.setText(objCoffeeDscrpt.getAmericanoLbl());
				Lbl_Coffee_Img.setIcon(new ImageIcon(MainWindow.class.getResource(objCoffeeDscrpt.getImgAmericano())));
				TxtA_Vw.setText(objCoffeeDscrpt.getAmericanoDscrpt());
				Pnl_CoffeeDscpt_Vw.setVisible(true);

				// Btn_Sp_Americano_Qty.setVisible(true)
				Btn_Sp_Coffee_Qty.setVisible(false);
				Btn_Sp_Latte_Qty.setVisible(false);
				Btn_Sp_Cappuccino_Qty.setVisible(false);
				Btn_Sp_Americano_Qty.setVisible(true);
				Btn_Sp_Espresso_Qty.setVisible(false);
				getAmericano = objPrice.getAmericanoPrice();
				cntAmericano++;

				subAmericano += getAmericano;
				allTotal += getAmericano;

				Lbl_Coffee_Order.setText("COFFEE: Americano");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntAmericano));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subAmericano));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
				
				Btn_Reset_All.setEnabled(true);
			}
		});

		Btn_Espresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Setting Logo to not Visible
				Lbl_Logo_View.setVisible(false);
				
				Lbl_BlkCoffee_Vw.setText(objCoffeeDscrpt.getEspressoLbl());
				Lbl_Coffee_Img.setIcon(new ImageIcon(MainWindow.class.getResource(objCoffeeDscrpt.getImgEspresso())));
				TxtA_Vw.setText(objCoffeeDscrpt.getEspressoDscrpt());
				Pnl_CoffeeDscpt_Vw.setVisible(true);

				// Btn_Sp_Espresso_Qty.setVisible(true);
				Btn_Sp_Coffee_Qty.setVisible(false);
				Btn_Sp_Latte_Qty.setVisible(false);
				Btn_Sp_Cappuccino_Qty.setVisible(false);
				Btn_Sp_Americano_Qty.setVisible(false);
				Btn_Sp_Espresso_Qty.setVisible(true);
				getEspresso = objPrice.getEspressoPrice();
				cntEspresso++;

				subEspresso += getEspresso;
				allTotal += getEspresso;

				Lbl_Coffee_Order.setText("COFFEE: Espresso");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntEspresso));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subEspresso));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
				
				Btn_Reset_All.setEnabled(true);
			}
		});
		
		// Reset All
		Btn_Reset_All.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getBlkCoffee = 0; getLatte = 0; getCappuccino = 0; getAmericano = 0; getEspresso = 0;
				subBlkCoffee = 0; subLatte = 0; subCappuccino = 0; subAmericano = 0; subEspresso = 0;
				cntBlkCoffee = 0; cntLatte = 0; cntCappuccino = 0; cntAmericano = 0; cntEspresso = 0;

				subspcBlkCoffee = 0; subspcLatte = 0; subspcCappuccino = 0; subspcAmericano = 0; subspcEspresso = 0;
				cntspcBlkCoffee = 0; cntspcLatte = 0; cntspcCappuccino = 0; cntspcAmericano = 0; cntspcEspresso = 0;
				spcTotal = 0;

				allTotal = 0;
				userBudget = 0; userChange = 0;
				
				TxtF_Specify_Qty.setText("00.00");
				TxtF_Budget.setText("0.00");
				
				Lbl_Coffee_Order.setText("COFFEE: ");
				Lbl_Qty_Num.setText("QUANTITY: 0");
				Lbl_SubTotal.setText("SUB TOTAL: 0.00");
				Lbl_Total.setText("TOTAL: 0.00");
				
				Lbl_Change.setText("CHANGE: 0.00");
				Lbl_Notify.setText("");
				
				Lbl_Logo_View.setVisible(true);
				Pnl_CoffeeDscpt_Vw.setVisible(false);
				
				Btn_Receipt.setEnabled(false);
				Btn_Reset_All.setEnabled(false);
			}
		});

		// Button Specified Quantity
		Btn_Sp_Coffee_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntspcBlkCoffee = Integer.parseInt(TxtF_Specify_Qty.getText());
				cntspcBlkCoffee += cntBlkCoffee;

				getBlkCoffee = objPrice.getBlkCoffeePrice();
				subspcBlkCoffee = getBlkCoffee * cntspcBlkCoffee;

				cntBlkCoffee = cntspcBlkCoffee;
				subBlkCoffee = subspcBlkCoffee;
				spcTotal += subBlkCoffee;
				allTotal = spcTotal;

				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntspcBlkCoffee));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subspcBlkCoffee));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", spcTotal));

				TxtF_Specify_Qty.setText("00.00");
			}
		});

		Btn_Sp_Latte_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntspcLatte = Integer.parseInt(TxtF_Specify_Qty.getText());
				cntspcLatte += cntLatte;
				
				getLatte = objPrice.getLattePrice();
				subspcLatte = getLatte * cntspcLatte;
				
				cntLatte = cntspcLatte;
				subLatte = subspcLatte;
				spcTotal += subLatte;
				allTotal = spcTotal;
				
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntspcLatte));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subspcLatte));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", spcTotal));

				TxtF_Specify_Qty.setText("00.00");
			}
		});

		Btn_Sp_Cappuccino_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntspcCappuccino = Integer.parseInt(TxtF_Specify_Qty.getText());
				cntspcCappuccino += cntCappuccino;
				
				getCappuccino = objPrice.getCappuccinoPrice();
				subspcCappuccino = getCappuccino * cntspcCappuccino;
				
				cntCappuccino = cntspcCappuccino;
				subCappuccino = subspcCappuccino;
				spcTotal += subCappuccino;
				allTotal = spcTotal;
				
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntspcCappuccino));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subspcCappuccino));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", spcTotal));

				TxtF_Specify_Qty.setText("00.00");
			}
		});

		Btn_Sp_Americano_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntspcAmericano = Integer.parseInt(TxtF_Specify_Qty.getText());
				cntspcAmericano += cntAmericano;
				
				getAmericano = objPrice.getAmericanoPrice();
				subspcAmericano = getAmericano * cntspcAmericano;
				
				cntAmericano = cntspcAmericano;
				subAmericano = subspcAmericano;
				spcTotal += subAmericano;
				allTotal = spcTotal;
				
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntspcAmericano));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subspcAmericano));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", spcTotal));

				TxtF_Specify_Qty.setText("00.00");
			}
		});

		Btn_Sp_Espresso_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cntspcEspresso = Integer.parseInt(TxtF_Specify_Qty.getText());
				cntspcEspresso += cntEspresso;
				
				getEspresso = objPrice.getEspressoPrice();
				subspcEspresso = getEspresso * cntspcEspresso;
				
				cntEspresso = cntspcEspresso;
				subEspresso = subspcEspresso;
				spcTotal += subEspresso;
				allTotal = spcTotal;
				
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntspcEspresso));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subspcEspresso));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", spcTotal));

				TxtF_Specify_Qty.setText("00.00");
			}
		});

		Btn_Budget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String budgetText = TxtF_Budget.getText();

				try {
					userBudget = Double.parseDouble(budgetText);

					if (allTotal != 0.00) {
						if (allTotal <= userBudget) {
							userChange = userBudget - allTotal;

							Lbl_Change.setText("CHANGE: " + String.format("%.2f", userChange));
							Lbl_Notify.setForeground(new Color(0, 255, 0));
							Lbl_Notify.setText("PAID SUCCESSFULLY");

							Btn_Receipt.setEnabled(true);							
						} else {
							Lbl_Notify.setForeground(new Color(255, 0, 0));
							Lbl_Notify.setText("NOT ENOUGH BUDGET");
						}
					} else {
						Lbl_Notify.setForeground(new Color(255, 0, 0));
						Lbl_Notify.setText("NO COFFEE ORDERED");
					}

				} catch (NumberFormatException ex) {
					Lbl_Notify.setForeground(new Color(255, 0, 0));
					Lbl_Notify.setText("INVALID INPUT");
				}
				
				TxtF_Budget.setText("0.00");
			}
		});

		Btn_Receipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OfficialReceipt.displayReceipt(frmEspressohub, cntBlkCoffee, cntLatte, cntCappuccino, cntAmericano,
						cntEspresso, subBlkCoffee, subLatte, subCappuccino, subAmericano, subEspresso, allTotal,
						userBudget, userChange);
			}
		});

	}
}

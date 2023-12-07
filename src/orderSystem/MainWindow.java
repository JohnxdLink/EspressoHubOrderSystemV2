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
import java.awt.BorderLayout;

public class MainWindow {
	/*
	 * Project : EspressoHub Order System Version 1.0 Developer : Castro John
	 * Christian Message : This is just a simple order system Date Created :
	 * 12/02/2023
	 */
	private JFrame frmEspressohub;
	double getBlkCoffee = 0, getLatte = 0, getCappuccino = 0, getAmericano = 0, getEspresso = 0;
	double subBlkCoffee = 0, subLatte = 0, subCappuccino = 0, subAmericano = 0, subEspresso = 0;
	int cntBlkCoffee = 0, cntLatte = 0, cntCappuccino = 0, cntAmericano = 0, cntEspresso = 0;
	
	double subspcBlkCoffee = 0;
	int cntspcBlkCoffee = 0;
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

		frmEspressohub = new JFrame();
		frmEspressohub.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MainWindow.class.getResource("/orderSystem/images/coffees/Espresso Coffee Price.PNG")));
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

		JLabel Lbl_Header = new JLabel("EsspressoHub");
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
		Btn_Coffee.setToolTipText("Want Black Coffee?");
		Btn_Coffee.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Coffee.setBounds(20, 211, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Coffee);

		JButton Btn_Latte = new JButton("Latte");
		Btn_Latte.setToolTipText("Want Latte?");
		Btn_Latte.setForeground(Color.WHITE);
		Btn_Latte.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Latte.setBackground(new Color(139, 69, 19));
		Btn_Latte.setBounds(20, 408, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Latte);

		JButton Btn_Cappuccino = new JButton("Cappuccino");
		Btn_Cappuccino.setToolTipText("Want Cappuccino?");
		Btn_Cappuccino.setForeground(Color.WHITE);
		Btn_Cappuccino.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Cappuccino.setBackground(new Color(139, 69, 19));
		Btn_Cappuccino.setBounds(20, 603, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Cappuccino);

		JButton Btn_Americano = new JButton("Americano");
		Btn_Americano.setToolTipText("Want Americano?");
		Btn_Americano.setForeground(Color.WHITE);
		Btn_Americano.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Americano.setBackground(new Color(139, 69, 19));
		Btn_Americano.setBounds(160, 211, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Americano);

		JButton Btn_Espresso = new JButton("Espresso");
		Btn_Espresso.setToolTipText("Want Espresso?");
		Btn_Espresso.setForeground(Color.WHITE);
		Btn_Espresso.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Espresso.setBackground(new Color(139, 69, 19));
		Btn_Espresso.setBounds(160, 408, 130, 35);
		frmEspressohub.getContentPane().add(Btn_Espresso);

		JButton Btn_Coming = new JButton("Coming Soon");
		Btn_Coming.setEnabled(false);
		Btn_Coming.setToolTipText("Black Coffee");
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
		Pnl_Transaction.setBounds(560, 408, 250, 184);
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

		JLabel Lbl_Notify = new JLabel("NOTIFICATION");
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

		JButton Btn_Sp_Coffee_Qty = new JButton("Enter");
		Btn_Sp_Coffee_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Coffee_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Coffee_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Coffee_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Coffee_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Coffee_Qty);

		JButton Btn_Sp_Latte_Qty = new JButton("Enter");
		Btn_Sp_Latte_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Latte_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Latte_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Latte_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Latte_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Latte_Qty);

		JButton Btn_Sp_Cappuccino_Qty = new JButton("Enter");
		Btn_Sp_Cappuccino_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Cappuccino_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Cappuccino_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Cappuccino_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Cappuccino_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Cappuccino_Qty);

		JButton Btn_Sp_Americano_Qty = new JButton("Enter");
		Btn_Sp_Americano_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Americano_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Americano_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Americano_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Americano_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Americano_Qty);

		JButton Btn_Sp_Espresso_Qty = new JButton("Enter");
		Btn_Sp_Espresso_Qty.setForeground(new Color(240, 248, 255));
		Btn_Sp_Espresso_Qty.setFont(new Font("Tahoma", Font.BOLD, 14));
		Btn_Sp_Espresso_Qty.setBackground(new Color(255, 127, 80));
		Btn_Sp_Espresso_Qty.setBounds(150, 28, 89, 23);
		Btn_Sp_Espresso_Qty.setVisible(false);
		Pnl_Specified_Qty.add(Btn_Sp_Espresso_Qty);

		Btn_Coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btn_Sp_Coffee_Qty.setVisible(true);
				getBlkCoffee = objPrice.getBlkCoffeePrice();
				cntBlkCoffee++;

				subBlkCoffee += getBlkCoffee;				
				allTotal += getBlkCoffee;

				Lbl_Coffee_Order.setText("COFFEE: Black Coffee");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntBlkCoffee));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subBlkCoffee));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
			}
		});

		Btn_Latte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btn_Sp_Latte_Qty.setVisible(true);
				getLatte = objPrice.getLattePrice();
				cntLatte++;

				subLatte += getLatte;
				allTotal += getLatte;

				Lbl_Coffee_Order.setText("COFFEE: Latte");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntLatte));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subLatte));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
			}
		});

		Btn_Cappuccino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btn_Sp_Cappuccino_Qty.setVisible(true);
				getCappuccino = objPrice.getCappuccinoPrice();
				cntCappuccino++;

				subCappuccino += getCappuccino;
				allTotal += getCappuccino;

				Lbl_Coffee_Order.setText("COFFEE: Cappuccino");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntCappuccino));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subCappuccino));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
			}
		});

		Btn_Americano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btn_Sp_Americano_Qty.setVisible(true);
				getAmericano = objPrice.getAmericanoPrice();
				cntAmericano++;

				subAmericano += getAmericano;
				allTotal += getAmericano;

				Lbl_Coffee_Order.setText("COFFEE: Americano");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntAmericano));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subAmericano));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
			}
		});

		Btn_Espresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btn_Sp_Espresso_Qty.setVisible(true);
				getEspresso = objPrice.getEspressoPrice();
				cntEspresso++;

				subEspresso += getEspresso;
				allTotal += getEspresso;

				Lbl_Coffee_Order.setText("COFFEE: Espresso");
				Lbl_Qty_Num.setText("QUANTITY: " + Integer.toString(cntEspresso));
				Lbl_SubTotal.setText("SUB TOTAL: " + String.format("%.2f", subEspresso));
				Lbl_Total.setText("TOTAL: " + String.format("%.2f", allTotal));
			}
		});

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
			}
		});

		Btn_Sp_Cappuccino_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Btn_Sp_Americano_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Btn_Sp_Espresso_Qty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

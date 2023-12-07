package orderSystem;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OfficialReceipt {

    public static void displayReceipt(JFrame owner,int cntBlkCoffee, int cntLatte, int cntCappuccino, int cntAmericano, int cntEspresso, double subBlkCoffee, double subLatte, double subCappuccino, double subAmericano, double subEspresso, double allTotal, double userBudget, double userChange) {

    	JDialog receiptDialog = new JDialog(owner, "Receipt", true);

        receiptDialog.setSize(300, 400);
        receiptDialog.setLocationRelativeTo(null);

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);

        receiptTextArea.append("OFFICIAL RECEIPT\n");
        receiptTextArea.append("----------------------------------------------------------------------\n");
        receiptTextArea.append("Item\tQuantity\tSubtotal\n");
        receiptTextArea.append("----------------------------------------------------------------------\n");
        receiptTextArea.append("Black Coffee\t" + cntBlkCoffee + "\t₱" + String.format("%.2f", subBlkCoffee) + "\n");
        receiptTextArea.append("Latte\t" + cntLatte + "\t₱" + String.format("%.2f", subLatte) + "\n");
        receiptTextArea.append("Cappuccino\t" + cntCappuccino + "\t₱" + String.format("%.2f", subCappuccino) + "\n");
        receiptTextArea.append("Americano\t" + cntAmericano + "\t₱" + String.format("%.2f", subAmericano) + "\n");
        receiptTextArea.append("Espresso\t" + cntEspresso + "\t₱" + String.format("%.2f", subEspresso) + "\n");
        receiptTextArea.append("----------------------------------------------------------------------\n");
        receiptTextArea.append("Total\t\t₱" + String.format("%.2f", allTotal) + "\n");
        receiptTextArea.append("Budget\t\t₱" + String.format("%.2f", userBudget) + "\n");
        receiptTextArea.append("Change\t\t₱" + String.format("%.2f", userChange) + "\n");

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);

        receiptDialog.add(scrollPane);
        receiptDialog.setVisible(true);
    }
}

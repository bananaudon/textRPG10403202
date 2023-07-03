package textRPG10403202.items;

//import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

//import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;

//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemBagJFrame extends JFrame implements ActionListener {

	private ItemBag OpenBag;

	private JTextField[] itemtxt;

	private JButton selectedUp = new JButton("↑");
	private JButton selectedDown = new JButton("↓");
	private JButton useItem = new JButton("使う");

	private int selectedBagNumber = 0;

	public ItemBagJFrame(ItemBag itembag) {
		
		OpenBag = itembag;
		itemtxt = new JTextField[OpenBag.getItemLength()];

		JPanel bwjpC = new JPanel();
		JPanel bwjpE = new JPanel();

		getContentPane().add(bwjpC, BorderLayout.CENTER);
		getContentPane().add(bwjpE, BorderLayout.EAST);

		bwjpC.setLayout(new BoxLayout(bwjpC, BoxLayout.Y_AXIS));
		bwjpE.setLayout(new BoxLayout(bwjpE, BoxLayout.Y_AXIS));

		String[] itemNames = OpenBag.getItemNames();
		for (int i = 0; i < itemNames.length; i++) {
			itemtxt[i] = new JTextField(itemNames[i]);
			itemtxt[i].setEditable(false);
			bwjpC.add(itemtxt[i]);
		}

		bwjpE.add(selectedUp);
		bwjpE.add(selectedDown);
		bwjpE.add(useItem);

		useItem.addActionListener(this);
		selectedUp.addActionListener(this);
		selectedDown.addActionListener(this);

		selectedItem();
		pack();
		setSize(450, getSize().height);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == selectedUp) {
			selectedBagNumber--;
		} else if (e.getSource() == selectedDown) {
			selectedBagNumber++;
		} else if (e.getSource() == useItem) {
			OpenBag.useItem(selectedBagNumber);
		}

		selectedItem();
	}

	public void selectedItem() {

		if (selectedBagNumber < 0) {
			selectedBagNumber = itemtxt.length - 1;
		} else if (selectedBagNumber >= itemtxt.length) {
			selectedBagNumber = 0;
		}

		for (int i = 0; i < itemtxt.length; i++) {
			itemtxt[i].setBackground(new Color(255, 255, 255));
		}

		itemtxt[selectedBagNumber].setBackground(new Color(128, 128, 255));
		itemtxt[selectedBagNumber].setText(OpenBag.getItemInfo(selectedBagNumber).getItemName());
	}

	public void openItemBag() {
		setVisible(true);
	}
}
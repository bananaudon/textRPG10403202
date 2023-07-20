package textRPG10403202.items;

//import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Dimension;

//import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;

//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemBagJFrame extends JFrame implements ActionListener {

	private ItemBag OpenBag;

	private JLabel[] itemName;

	private JButton selectedUp = new JButton("↑");
	private JButton selectedDown = new JButton("↓");
	private JButton useItem = new JButton("使う");

	private int selectedBagNumber = 0;

	public ItemBagJFrame(ItemBag itembag) {
		
		OpenBag = itembag;
		itemName = new JLabel[OpenBag.getItemLength()];

		JPanel bwjpC = new JPanel();
		JPanel bwjpE = new JPanel();

		getContentPane().add(bwjpC, BorderLayout.CENTER);
		getContentPane().add(bwjpE, BorderLayout.EAST);

		bwjpC.setLayout(new BoxLayout(bwjpC, BoxLayout.Y_AXIS));
		bwjpE.setLayout(new BoxLayout(bwjpE, BoxLayout.Y_AXIS));

		String[] itemNames = OpenBag.getItemNames();
		for (int i = 0; i < itemNames.length; i++) {
			itemName[i] = new JLabel(itemNames[i]);
			itemName[i].setOpaque(true);
			itemName[i].setHorizontalAlignment(SwingConstants.LEFT);
			itemName[i].setMaximumSize(new Dimension(Integer.MAX_VALUE,itemName[i].getPreferredSize().height));
			bwjpC.add(itemName[i]);
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
			selectedBagNumber = itemName.length - 1;
		} else if (selectedBagNumber >= itemName.length) {
			selectedBagNumber = 0;
		}

		for (int i = 0; i < itemName.length; i++) {
			itemName[i].setBackground(new Color(255, 255, 255));
		}

		itemName[selectedBagNumber].setBackground(new Color(128, 128, 255));
		itemName[selectedBagNumber].setText(OpenBag.getItemInfo(selectedBagNumber).getItemName());
	}

	public void openItemBag() {
		setVisible(true);
	}
}
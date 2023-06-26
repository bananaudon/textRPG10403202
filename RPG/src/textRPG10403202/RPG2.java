package textRPG10403202;
//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import java.awt.*;
import java.awt.BorderLayout;

//import javax.swing.*
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class RPG2 extends JFrame implements ActionListener {

	//mainCharacterがHeroじゃなくなるようなことがあればfinalを外す
	static final Hero mainCharacter = new Hero(1,100,100,5,100,0,1,0);

	// static itemBag itembag = new itemBag();
	ItemBagJFrame iBJ;
	static EventList Event = new EventList();

	GameManager gameManager = new GameManager();
	public static void main(String args[]) {
		//refresh();
		Event.executeEvent(Event.selectEvent(30));
		new RPG2("RPG");
	}
	static String EnemyName = "";
	static boolean fight = false;
	static boolean turn = false;
	static int pos = 1;
	static int risk = 100;
	static JTextField Lvtxt = new JTextField("Lv." + mainCharacter.lv + "(" + mainCharacter.nextLv + ")");
	static JTextField HPtxt = new JTextField("HP" + mainCharacter.maxHP + "/" + mainCharacter.nowHP);
	static JTextField Powtxt = new JTextField("Power" + mainCharacter.Pow);
	public static JTextArea log = new JTextArea(5, 20);
	JScrollPane scroll = new JScrollPane(log,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton next = new JButton("前に進む");
	static JButton heal;
	JButton GiveUp = new JButton("あきらめる");
	JButton Attack = new JButton("攻撃");
	JButton charge = new JButton("ためる");
	JButton itemBag = new JButton("アイテム");
	static int[] EnemyStatus = Enemy(0);

	RPG2(String title) {
		iBJ = new ItemBagJFrame(mainCharacter.characterHave);
		setTitle(title);

		log.setLineWrap(true);
		log.setEditable(false);
		HPtxt.setEditable(false);
		Lvtxt.setEditable(false);
		Powtxt.setEditable(false);

		JPanel jpN = new JPanel();
		JPanel jpE = new JPanel();
		JPanel jpS = new JPanel();

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jpN, BorderLayout.NORTH);
		getContentPane().add(jpS, BorderLayout.SOUTH);
		getContentPane().add(jpE, BorderLayout.EAST);

		heal = new JButton("");

		jpN.add(next);
		jpN.add(heal);
		jpN.add(GiveUp);

		getContentPane().add(scroll, BorderLayout.CENTER);

		jpS.add(Lvtxt);
		jpS.add(HPtxt);
		jpS.add(Powtxt);

		jpE.setLayout(new BoxLayout(jpE, BoxLayout.Y_AXIS));

		jpE.add(Attack);
		jpE.add(charge);
		jpE.add(itemBag);

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(450, 300);
		setVisible(true);

		next.addActionListener(this);
		heal.addActionListener(this);
		Attack.addActionListener(this);
		itemBag.addActionListener(this);
		refresh();
	}

	public static void walk(int steps) {

		if (fight) {
			log.append("敵がいて前に進めそうにない\n");
		} else {
			log.append("area" + pos + "→" + "area" + (pos + 1) + "に進んだ(" + steps + ")\n");
			pos += steps;
			Event.executeEvent(Event.selectEvent(risk));
			// event();
		}

		risk += steps;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == next) {
			walk(1);
		} else if (e.getSource() == heal) {
			mainCharacter.useHealItem();
		} else if (e.getSource() == Attack) {
			if (fight) {
				EnemyStatus[2] -= mainCharacter.Pow;
				log.append(EnemyName + "に" + mainCharacter.Pow + "のダメージ\n");
				if (EnemyStatus[2] <= 0) {
					log.append(EnemyName + "を倒した\n");
					mainCharacter.nextLv -= EnemyStatus[0] * 5;
					fight = false;
				} else {
					Damage(0);
				}
			} else {
				log.append("攻撃はむなしく空ぶった\n");
			}
		} else if (e.getSource() == itemBag) {
			iBJ.openItemBag();
		}
		refresh();
	}

	public static void battle(int EnemyTag) {
		fight = true;
		EnemyStatus = Enemy(EnemyTag);
		logWrite(EnemyName);
	}

	public static int[] Enemy(int tag) {
		int LvRange = 0, PowRange = 0, HPRange = 0;
		int addLv = 0, addPow = 0, addHP = 0;
		double Rand = Math.random();
		switch (tag) {
			case 0:
				EnemyName = "スライム";
				LvRange = 1;
				PowRange = 2;
				HPRange = 4;
				addLv = (int) (Rand * (LvRange + 1));
				addPow = (int) (Rand * (PowRange + 1));
				addHP = (int) (Rand * (HPRange + 1));
				return new int[] { 1 + addLv, 12 + addHP, 12 + addHP, 3 + addPow };
			case 1:
				EnemyName = "ゴブリン";
				LvRange = 4;
				PowRange = 5;
				HPRange = 2;
				addLv = (int) (Rand * (LvRange + 1));
				addPow = (int) (Rand * (PowRange + 1));
				addHP = (int) (Rand * (HPRange + 1));
				return new int[] { 4 + addLv, 15 + addHP, 15 + addHP, 10 + addPow };
			case 100:
				EnemyName = "死";
				addLv = (int) (Rand * (LvRange + 1));
				addPow = (int) (Rand * (PowRange + 1));
				addHP = (int) (Rand * (HPRange + 1));
				return new int[] { 999 + addLv, 1000 + addHP, 1000 + addHP, 5000 + addPow };
		}
		return new int[] { 1, 12, 12, 3 };
	}

	public static void Damage(int damagetype) {
		switch (damagetype) {
			case 0:
				mainCharacter.damage(EnemyStatus[3]);
				log.append(EnemyName + "から" + EnemyStatus[3] + "のダメージ\n");
				refresh();
				break;
		}
		if (mainCharacter.nowHP <= 0) {
			log.append("死んだ\n");
			System.exit(1);
		}
	}
	public static void refresh() {
		if (mainCharacter.nowHP > mainCharacter.maxHP) {
			mainCharacter.nowHP = mainCharacter.maxHP;
		}
		Powtxt.setText("Power" + mainCharacter.Pow);
		heal.setText("回復耐久値:" + mainCharacter.characterHave.healItem.getdurability());
		HPtxt.setText("HP" + mainCharacter.nowHP + "/" + mainCharacter.maxHP);
		Lvtxt.setText("Lv." + mainCharacter.lv + "(" + mainCharacter.nextLv + ")");
	}
	public static void logWrite(String MAIN) {
		MAIN += "\n";
		log.append(MAIN);
	}
}
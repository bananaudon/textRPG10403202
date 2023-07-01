package textRPG10403202;
//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import java.awt.*;
import java.awt.BorderLayout;

//import javax.swing.*
import javax.swing.JFrame;
import javax.swing.JTextField;

import textRPG10403202.items.Heal_Low;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class RPG2 extends JFrame implements ActionListener {

	//mainCharacterがHeroじゃなくなるようなことがあればfinalを外す
	private static Hero mainCharacter;

	private EventList Event = new EventList(this);

	private GameManager gameManager = new GameManager();
	public static void main(String args[]) {
		new RPG2("RPG");
	}
	private String EnemyName = "";
	private boolean fight = false;
	private int pos = 1;
	private int risk = 100;
	private JTextField Lvtxt;
	private JTextField HPtxt;
	private JTextField Powtxt;
	private static JTextArea log = new JTextArea(5, 20);
	private JScrollPane scroll = new JScrollPane(log,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	private JButton next = new JButton("前に進む");
	static JButton heal;
	private JButton GiveUp = new JButton("あきらめる");
	private JButton Attack = new JButton("攻撃");
	private JButton charge = new JButton("ためる");
	private JButton itemBag = new JButton("アイテム");
	private int[] EnemyStatus = Enemy(0);

	private RPG2(String title) {
		mainCharacter = new Hero(1,100,100,5,this,100,0,1,0);
		System.out.println("RPG2のコンストラクタでアイテムを追加します、動作確認用");

		mainCharacter.gotItem(new Heal_Low(40,this));
		mainCharacter.setHeal(0);
		mainCharacter.gotItem(new Heal_Low(40,this));
		mainCharacter.gotItem(new Heal_Low(40,this));
		
		HPtxt = new JTextField("HP" + mainCharacter.maxHP + "/" + mainCharacter.nowHP);
		Powtxt = new JTextField("Power" + mainCharacter.Pow);
		Lvtxt = new JTextField("Lv." + mainCharacter.lv + "(" + mainCharacter.nextLv + ")");
		Event.executeEvent(Event.selectEvent(30));
		//iBJ = new ItemBagJFrame(mainCharacter);
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

	void walk(int steps) {

		if (GameManager.isPossibleACT(getActiveGameState())) {
			log.append("area" + pos + "→" + "area" + (pos + 1) + "に進んだ(" + steps + ")\n");
			pos += steps;
			Event.executeEvent(Event.selectEvent(risk));
			this.gameManager.nextStatus();
		} else {
			log.append("今はできない\n");
		}

		risk += steps;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == next) {
			walk(1);
		}

		else if (e.getSource() == heal) {
			mainCharacter.useHealItem();
		}

		else if (e.getSource() == Attack) {
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
		}

		else if (e.getSource() == itemBag) {
			mainCharacter.openItemBag();
		}
		refresh();
	}

	public void battle(int EnemyTag) {
		fight = true;
		EnemyStatus = Enemy(EnemyTag);
		logWrite(EnemyName);
	}

	public int[] Enemy(int tag) {
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

	public void Damage(int damagetype) {
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
	public void refresh() {
		if (mainCharacter.nowHP > mainCharacter.maxHP) {
			mainCharacter.nowHP = mainCharacter.maxHP;
		}
		Powtxt.setText("Power" + mainCharacter.Pow);
		heal.setText("回復耐久値:" + mainCharacter.getHealItemInfo().getdurability());
		HPtxt.setText("HP" + mainCharacter.nowHP + "/" + mainCharacter.maxHP);
		Lvtxt.setText("Lv." + mainCharacter.lv + "(" + mainCharacter.nextLv + ")");
	}

	public void nextGameState(){
		gameManager.nextStatus();
	}

	public GameState getActiveGameState(){
		return gameManager.getStatus();
	}

	public static void logWrite(String MAIN) {
		MAIN += "\n";
		log.append(MAIN);
	}
}
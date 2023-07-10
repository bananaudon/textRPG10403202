package textRPG10403202;
//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import java.awt.*;
import java.awt.BorderLayout;

//import javax.swing.*
import javax.swing.JFrame;
import javax.swing.JTextField;

import textRPG10403202.characters.Explorer;
import textRPG10403202.items.Heal_Low;
import textRPG10403202.characters.enemy.Enemy;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class RPG2 extends JFrame implements ActionListener {

	//mainCharacterがHeroじゃなくなるようなことがあればfinalを外す
	private static Explorer mainCharacter;

	private EventList Event = new EventList(this);

	private GameManager gameManager = new GameManager(this);
	public static void main(String args[]) {
		new RPG2("RPG");
	}
	private String EnemyName = "";
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
	private Enemy enemy;

	private RPG2(String title) {
		mainCharacter = new Explorer(1,100,100,5,this,100,1,0);
		System.out.println("RPG2のコンストラクタでアイテムを追加します、動作確認用");

		mainCharacter.gotItem(new Heal_Low(40,this));
		mainCharacter.setHeal(0);
		mainCharacter.gotItem(new Heal_Low(40,this));
		mainCharacter.gotItem(new Heal_Low(40,this));
		
		HPtxt = new JTextField(mainCharacter.getHPText());
		Powtxt = new JTextField(mainCharacter.getPowText());
		Lvtxt = new JTextField();
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

		//switch式でゲームステータスごとに固有のメッセージを表示するかも
		if (gameManager.getStatus() == GameState.EXPLORE) {
			log.append("area" + pos + "→" + "area" + (pos + 1) + "に進んだ(" + steps + ")\n");
			pos += steps;
			risk += steps;
			this.nextGameState();
			Event.executeEvent(Event.selectEvent(risk));
		} else {
			log.append("今はできない\n");
		}

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == next) {
			walk(1);
		}

		else if (e.getSource() == heal) {
			mainCharacter.useHealItem();
		}

		else if (e.getSource() == Attack) {
			System.out.println("現在のゲームステータス:" + gameManager.getStatus() + "このメッセージはRPG2のactionPerformedから");
			if (GameManager.isPossibleAttack(gameManager.getStatus())) {
				mainCharacter.attack(enemy);
				//log.append(EnemyName + "に" + mainCharacter.Pow + "のダメージ\n");
				nextGameState();
				if (enemy.isDeath()) {
					log.append(EnemyName + "を倒した\n");
					mainCharacter.addEXP(enemy.getEXP());
					gameManager.setStatus(GameState.EXPLORE);
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
		enemy = Enemy(EnemyTag);
		gameManager.setStatus(GameState.BATTLE);
		logWrite(EnemyName);
	}

	public Enemy Enemy(int tag) {
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
				return new Enemy("スライム",1 + addLv, 12 + addHP, 12 + addHP, 3 + addPow);
			case 1:
				EnemyName = "ゴブリン";
				LvRange = 4;
				PowRange = 5;
				HPRange = 2;
				addLv = (int) (Rand * (LvRange + 1));
				addPow = (int) (Rand * (PowRange + 1));
				addHP = (int) (Rand * (HPRange + 1));
				return new Enemy("ゴブリン",4 + addLv, 15 + addHP, 15 + addHP, 10 + addPow );
			case 100:
				EnemyName = "死";
				addLv = (int) (Rand * (LvRange + 1));
				addPow = (int) (Rand * (PowRange + 1));
				addHP = (int) (Rand * (HPRange + 1));
				return new Enemy("死", 999, 1000, 1000, 5000);
		}
		return null;
	}

	public void Damage(int damagetype) {
		switch (damagetype) {
			case 0:
				enemy.attack(mainCharacter);
				refresh();
			break;
		}
		if (mainCharacter.isDeath()) {
			log.append("死んだ");
			System.out.println("死んだ");
			System.exit(0);
		}
	}
	public void refresh() {
		mainCharacter.sutatusFix();
		heal.setText("回復耐久値:" + mainCharacter.getHealItemInfo().getdurability());
		HPtxt.setText(mainCharacter.getHPText());
		Powtxt.setText(mainCharacter.getPowText());
		Lvtxt.setText(mainCharacter.getLvText());
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
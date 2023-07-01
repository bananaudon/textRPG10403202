package textRPG10403202;

import textRPG10403202.items.Item;
import textRPG10403202.items.ItemBag;
import textRPG10403202.items.ItemBagJFrame;
import textRPG10403202.items.ItemInfo;
public abstract class RPGCharacter {
    public String name;
    
    //将来的にprotectedに書き換えたい
    public int lv;
    public int maxHP;
    public int nowHP;
    public int Pow;
    private RPG2 mainClass;
    private ItemBag characterHave;
    private ItemBagJFrame characterHaveJFrame;
    RPGCharacter(int level, int maxHP, int currentHP, int power, RPG2 setMainClass) {
        this.lv = level;
        this.maxHP = maxHP;
        this.nowHP = currentHP;
        this.Pow = power;
        this.mainClass = setMainClass;
        this.characterHave = new ItemBag(this);
        this.characterHaveJFrame = new ItemBagJFrame(characterHave);
    }

    void useHealItem(){
        if(GameManager.isPossibleACT(mainClass.getActiveGameState())){
            this.characterHave.useHealItem();
            mainClass.nextGameState();
        }
    }

    public void gotItem(Item item){
        this.characterHave.addItem(item);
    }

    public void openItemBag(){
        this.characterHaveJFrame.openItemBag();
    }

    public ItemInfo getHealItemInfo(){
        return this.characterHave.getHealItemInfo();
    }
    
    public void randomStatus(int minLv, int minMaxHP, int minNowHP, int minPow, int LRange, int MHRange, int NHRange,
            int PRange) {
        lv = (int) (Math.random() * (LRange + 1)) + minLv;
        maxHP = (int) (Math.random() * (MHRange + 1)) + minMaxHP;
        nowHP = (int) (Math.random() * (NHRange + 1)) + minNowHP;
        Pow = (int) (Math.random() * (PRange + 1)) + minPow;
    }

    abstract void attack(RPGCharacter c);

    public abstract void damage(int damage);

    public abstract void heal(int heal);
}
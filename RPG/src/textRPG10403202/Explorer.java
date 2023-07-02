package textRPG10403202;

import textRPG10403202.items.Item;
import textRPG10403202.items.ItemBag;
import textRPG10403202.items.ItemBagJFrame;
import textRPG10403202.items.ItemInfo;

public class Explorer extends RPGCharacter {
    int nextLv, EXP, steps, luck;
    private ItemBag characterHave;
    private ItemBagJFrame characterHaveJFrame;
    private RPG2 mainClass;
    Explorer(int level, int maxHP, int currentHP, int power, RPG2 setMainClass,int nL, int E, int s, int lu){
        //characterとして必要な情報
        super(level,maxHP,currentHP,power);

        //主人公として必要な情報
        this.mainClass = setMainClass;
        this.nextLv = nL;
        this.EXP = E;
        this.steps = s;
        this.luck = lu;
        this.characterHave = new ItemBag(this);
        this.characterHaveJFrame = new ItemBagJFrame(characterHave);
    }

    public void useHealItem(){
        this.characterHave.useHealItem();
        mainClass.nextGameState();
    }

    public void setHeal(int bagNumber){
        this.characterHave.setHealItem(bagNumber);
        mainClass.nextGameState();
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
    
    @Override
    void attack(RPGCharacter c) {
        System.out.println(this.name + "は" + c.name + "を攻撃した");
    }

    @Override
    public void damage(int damage) {
        this.nowHP -= damage;
    }

    @Override
    public void heal(int heal) {
        this.nowHP += heal;
    }
}
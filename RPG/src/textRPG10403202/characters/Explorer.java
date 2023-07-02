package textRPG10403202.characters;

import textRPG10403202.RPG2;
import textRPG10403202.items.Item;
import textRPG10403202.items.ItemBag;
import textRPG10403202.items.ItemBagJFrame;
import textRPG10403202.items.ItemInfo;

public class Explorer extends RPGCharacter {
    private int nextLv, EXP, steps, luck;
    private ItemBag characterHave;
    private ItemBagJFrame characterHaveJFrame;
    private RPG2 mainClass;
    public Explorer(int level, int maxHP, int currentHP, int power, RPG2 setMainClass,int nL, int s, int lu){
        //characterとして必要な情報
        super(level,maxHP,currentHP,power);

        //主人公として必要な情報
        this.mainClass = setMainClass;
        this.nextLv = nL;
        this.EXP = 0;
        this.steps = s;
        this.luck = lu;
        this.characterHave = new ItemBag(this);
        this.characterHaveJFrame = new ItemBagJFrame(characterHave);
    }

    //Item関連のメソッド
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

    //UIで使用する文字列を取得
    public String getLvText(){
        return ("Lv." + this.lv + "(" + this.nextLv + ")");
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
    //探索者固有のメソッド
    public void addEXP(int getEXP){
        this.EXP += getEXP;
        this.nextLv -= getEXP;
        if(nextLv <= 0){
            //レベルアップ時の処理を書く
            //レベルアップメソッドを実装して、そこでnextLvの値を定義しなおす予定
        }
    }
}
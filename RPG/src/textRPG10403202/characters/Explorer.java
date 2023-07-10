package textRPG10403202.characters;

import textRPG10403202.RPG2;
import textRPG10403202.items.Item;
import textRPG10403202.items.ItemBag;
import textRPG10403202.items.ItemBagJFrame;
import textRPG10403202.items.ItemInfo;

public class Explorer implements RPGCharacter {
    private int lv,maxHP,nowHP,Pow;
    private int nextLv, EXP, steps, luck;
    private ItemBag characterHave;
    private ItemBagJFrame characterHaveJFrame;
    private RPG2 mainClass;
    private String name;
    public Explorer(int level, int maxHP, int currentHP, int power, RPG2 setMainClass,int nL, int s, int lu){
        //characterとして必要な情報
        lv = level;
        this.maxHP = maxHP;
        this.nowHP = currentHP;
        this.Pow = power;
        //主人公として必要な情報
        this.mainClass = setMainClass;
        this.nextLv = nL;
        this.EXP = 0;
        this.steps = s;
        this.luck = lu;
        this.characterHave = new ItemBag(this);
        this.characterHaveJFrame = new ItemBagJFrame(characterHave);

        //後から決定するようにしてもいい
        name = "名無しの探索者";
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
    public String getPowText(){
        return ("Pow:" + this.Pow);
    }
    public String getHPText(){
        return ("HP:" + this.nowHP + "/" + this.maxHP);
    }
    public String getLvText(){
        return ("Lv." + this.lv + "(" + this.nextLv + ")");
    }

    public void sutatusFix(){
        if(nowHP >= maxHP){
            nowHP = maxHP;
        }
    }

    @Override
    public void attack(RPGCharacter c) {
        c.damage(this.Pow);
        RPG2.logWrite(this.name + "は拳を振り上げて" + this.Pow + "ダメージを与えた");
    }

    @Override
    public void damage(int damage) {
        this.nowHP -= damage;
        RPG2.logWrite(this.name + "は" + damage + "ダメージを受けた");
    }

    @Override
    public void heal(int heal) {
        this.nowHP += heal;
        RPG2.logWrite(this.name + "は" + heal + "回復した");
    }

    public int getMaxHP(){
        return this.maxHP;
    }

    public void randomStatus(){
        //未定
    }

    public boolean isDeath(){
        if(this.nowHP <= 0){
            return true;
        }
        return false;
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
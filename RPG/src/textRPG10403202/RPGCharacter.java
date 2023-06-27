package textRPG10403202;

import textRPG10403202.items.Item;
public abstract class RPGCharacter {
    public String name;
    
    //将来的にprotectedに書き換えたい
    public int lv;
    public int maxHP;
    public int nowHP;
    public int Pow;
    private ItemBag characterHave;
    RPGCharacter(int level, int maxHP, int currentHP, int power) {
        this.characterHave = new ItemBag(this);
        this.lv = level;
        this.maxHP = maxHP;
        this.nowHP = currentHP;
        this.Pow = power;
    }

    void useHealItem(){
        this.characterHave.useHealItem();
    }

    void useItem(int bagNumber){
        this.characterHave.useItem(bagNumber);
    }

    void gotItem(Item item){
        this.characterHave.addItem(item);
    }

    void setHeal(int bagNumber){
        this.characterHave.setHealItem(bagNumber);
    }

    String[] getItemNames(){
        return this.characterHave.getItemNames();
    }

    int getHealItemdurability(){
        return characterHave.healItem.getdurability();
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
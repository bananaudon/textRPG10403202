package textRPG10403202;

public abstract class RPGCharacter {
    public String name;
    
    //将来的にprotectedに書き換えたい
    public int lv;
    public int maxHP;
    public int nowHP;
    public int Pow;
    RPGCharacter(int level, int maxHP, int currentHP, int power) {
        this.lv = level;
        this.maxHP = maxHP;
        this.nowHP = currentHP;
        this.Pow = power;
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
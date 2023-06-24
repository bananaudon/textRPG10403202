package textRPG10403202;
import textRPG10403202.statusAilments.statusAilment;
public abstract class RPGCharacter {
    public String name;
    
    //将来的にprotectedに書き換えたい
    public int lv;
    public int maxHP;
    public int nowHP;
    public int Pow;
    private statusAilment[] characterAilment = new statusAilment[100];
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

    public int countAilment(Class<? extends statusAilment> ailment){
        int count = 0;
        for(int i = 0;i < characterAilment.length;i++){
            if(characterAilment[i] != null){
                if(ailment.isInstance(characterAilment[i])){
                    count++;
                }
            }
        }
        return count;
    }
    public void addAilment(statusAilment sa){
        for(int i = 0;i < characterAilment.length;i++){
            if(characterAilment[i] == null){
                characterAilment[i] = sa;
                return;
            }
        }
    }
}
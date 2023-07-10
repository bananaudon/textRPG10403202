package textRPG10403202.characters.enemy;

import textRPG10403202.characters.RPGCharacter;

public class Enemy implements RPGCharacter{
    private String name;
    private int lv;
    private int maxHP;
    private int nowHP;
    private int Pow;
    public Enemy(String setEnemyName,int setLv,int setMaxHP,int setnowHP,int setPow){
        lv = setLv;
        maxHP = setMaxHP;
        nowHP = setnowHP;
        Pow = setPow;
        name = setEnemyName;
    }

    public void randomStatus(){
        //未定
    }
    public int getMaxHP(){
        return this.maxHP;
    }

    public void attack(RPGCharacter target){
        target.damage(this.Pow);
    }

    public void damage(int d){
        this.nowHP -= d;
    }

    public void heal(int h){
        this.nowHP -= h;
    }

    public void ACT(RPGCharacter target){
        this.attack(target);
    }

    public int getEXP(){
        return this.lv * 5;
    }
    public boolean isDeath(){
        if(nowHP <= 0){
            return true;
        }
        return false;
    }
}

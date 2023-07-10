package textRPG10403202.characters.enemy;

import textRPG10403202.RPG2;
import textRPG10403202.characters.RPGCharacter;

public class Enemy implements RPGCharacter{
    private String name;
    private int lv,maxHP,nowHP,Pow;
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
        System.out.println("b");
        RPG2.logWrite(this.name + "の攻撃");
        target.damage(this.Pow);
    }

    public void damage(int d){
        this.nowHP -= d;
        RPG2.logWrite(this.name + "は" + d + "ダメージを受けた");
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

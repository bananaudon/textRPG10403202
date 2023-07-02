package textRPG10403202.characters.enemy;

import textRPG10403202.characters.RPGCharacter;

public abstract class Enemy extends RPGCharacter{
    public Enemy(String setEnemyName,int setLv,int setMaxHP,int setnowHP,int setPow){
        super(setLv,setMaxHP,setnowHP,setPow);
        name = setEnemyName;
    }
    public abstract void attack(RPGCharacter target);
    public void damage(int d){
        this.nowHP -= d;
    }
    public void heal(int h){
        this.nowHP -= h;
    }
    public abstract void ACT(RPGCharacter target);
}

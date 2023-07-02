package textRPG10403202.characters.enemy;

import textRPG10403202.characters.RPGCharacter;
public class normalMonster extends Enemy{
    public normalMonster(String setEnemyName,int setLv,int setMaxHP,int setnowHP,int setPow){
        super(setEnemyName,setLv,setMaxHP,setnowHP,setPow);
    } 

    public void attack(RPGCharacter target){
        target.damage(this.Pow);
    }

    public void ACT(RPGCharacter target){
        this.attack(target);
    }
}
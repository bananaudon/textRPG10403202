package textRPG10403202.items.weapon.classes;

import textRPG10403202.characters.RPGCharacter;
import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.items.weapon.interfaces.Sword;
public class BasicSword implements Sword{
    WeaponCategory nowCategory;
    public BasicSword(){
        nowCategory = WeaponCategory.SWORD;
    }
    public int getSwordATK(){
        return 10;
    }
    public int getDamage(int pow){
        return getSwordATK();
    }
    
    //Itemメソッド
    public String getItemName(){
        return "none";
    }
    public int getdurability(){
        return 0;
    }
    public void Rename(String name){}
    public void setdurability(int durability){}
    public void use(RPGCharacter target){}
    public void decrementdurability() {}
    public boolean isBreak(){
        return false;
    };
}
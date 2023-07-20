package textRPG10403202.items.weapon.classes;

import textRPG10403202.characters.RPGCharacter;
import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.items.weapon.interfaces.Spear;
public class BasicSpear implements Spear{
    WeaponCategory nowCategory;
    public BasicSpear(){
        nowCategory = WeaponCategory.SPEAR;
    }
    public int getSpearATK(){
        return 8;
    }
    public int getDamage(int pow){
        return getSpearATK();
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
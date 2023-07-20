package textRPG10403202.items.weapon.classes;

import textRPG10403202.items.weapon.interfaces.Axe;
import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.characters.RPGCharacter;
public class BasicAxe implements Axe{
    WeaponCategory nowCategory;
    public BasicAxe(){
        nowCategory = WeaponCategory.AXE;
    }

    public int getAxeATK(){
        return 5;
    }

    public int getDamage(int pow){
        return getAxeATK();
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
package textRPG10403202.items.weapon.classes;

import textRPG10403202.characters.RPGCharacter;
import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.items.weapon.interfaces.Sword;
import textRPG10403202.items.weapon.interfaces.Spear;
public class SpearSword implements Sword, Spear{
    WeaponCategory nowCategory;
    SpearSword(){

    }
    public int getSpearATK(){
        return 10;
    }
    public int getSwordATK(){
        return 8;
    }
    public boolean set(WeaponCategory w){
        if(this.getClass().isInstance(w.getTypeClass())){
            nowCategory = w;
            return true;
        }
        return false;
    }
    public int getDamage(int pow){
        switch(nowCategory){
            case SWORD -> {
                return getSwordATK();
            }
            case SPEAR -> {
                return getSpearATK();
            }
            default ->{
                return 0;
            }
        }
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
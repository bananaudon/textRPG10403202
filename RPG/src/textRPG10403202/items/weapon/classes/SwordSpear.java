package textRPG10403202.items.weapon.classes;

import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.items.weapon.Weapon;
import textRPG10403202.items.weapon.interfaces.Sword;
import textRPG10403202.items.weapon.interfaces.Spear;
public class SwordSpear implements Sword, Spear,Weapon{
    WeaponCategory nowCategory;
    SwordSpear(WeaponCategory w){
        nowCategory = w;
    }
    public int getSwordATK(){
        return 10;
    }
    public int getSpearATK(){
        return 8;
    }
    public void attack(int pow){
        switch(nowCategory){
            case SWORD -> {

            }
            case SPEAR -> {

            }
        }
    }
}
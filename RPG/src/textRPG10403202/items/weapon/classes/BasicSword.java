package textRPG10403202.items.weapon.classes;

import textRPG10403202.items.weapon.Weapon;
import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.items.weapon.interfaces.Sword;
public class BasicSword implements Sword,Weapon{
    WeaponCategory nowCategory;
    public BasicSword(){
        nowCategory = WeaponCategory.SWORD;
    }
    public int getSwordATK(){
        return 10;
    }
    public void attack(int pow){

    }
}
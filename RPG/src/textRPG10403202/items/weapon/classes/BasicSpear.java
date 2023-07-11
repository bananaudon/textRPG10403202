package textRPG10403202.items.weapon.classes;

import textRPG10403202.items.weapon.Weapon;
import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.items.weapon.interfaces.Spear;
public class BasicSpear implements Spear,Weapon{
    WeaponCategory nowCategory;
    public BasicSpear(){
        nowCategory = WeaponCategory.SPEAR;
    }
    public int getSpearATK(){
        return 8;
    }
    public void attack(int pow){
        
    }
}
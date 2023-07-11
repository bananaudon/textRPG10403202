package textRPG10403202.items.weapon.classes;

import textRPG10403202.items.weapon.interfaces.Axe;
import textRPG10403202.items.weapon.WeaponCategory;
import textRPG10403202.items.weapon.Weapon;
public class BasicAxe implements Axe,Weapon{
    WeaponCategory nowCategory;
    public BasicAxe(){
        nowCategory = WeaponCategory.AXE;
    }

    public int getAxeATK(){
        return 5;
    }

    public void attack(int pow){
        
    }
}
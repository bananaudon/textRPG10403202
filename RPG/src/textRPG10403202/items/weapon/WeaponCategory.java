package textRPG10403202.items.weapon;

import textRPG10403202.items.weapon.interfaces.Axe;
import textRPG10403202.items.weapon.interfaces.Sword;
import textRPG10403202.items.weapon.interfaces.Spear;
public enum WeaponCategory {
    AXE(Axe.class),
    SWORD(Sword.class),
    SPEAR(Spear.class)
    ;
    private Class<? extends Weapon> typeClass;
    private WeaponCategory(Class<? extends Weapon> c){
        typeClass = c;
    }
    public Class<? extends Weapon> getTypeClass(){
        return typeClass;
    }
}

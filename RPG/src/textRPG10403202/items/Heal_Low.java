package textRPG10403202.items;

import textRPG10403202.RPGCharacter;
import textRPG10403202.RPG2;
public class Heal_Low extends Heal implements item{
    public Heal_Low(int fixedHeal) {
        this(fixedHeal,"低位ポーション",5);
    }
    public Heal_Low(int fixedHeal,String name) {
        this(fixedHeal,name,5);
    }
    public Heal_Low(int fixedHeal,String name,int durability) {
        super(name,durability,1);
        this.fixedHeal = fixedHeal;
    }
    public static void applyEffect(RPGCharacter c,Heal_Low HL) {
        int percentageHeal = (c.maxHP / 10);
        c.heal(HL.fixedHeal + percentageHeal);
        RPG2.logWrite((HL.fixedHeal + percentageHeal) + "回復した");
    }
    public void use(RPGCharacter target){
        RPG2.logWrite(this.getItemName() + "を使った");
        applyEffect(target,this);
        decrementdurability();
    }
}
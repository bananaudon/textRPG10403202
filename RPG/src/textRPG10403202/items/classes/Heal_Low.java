package textRPG10403202.items.classes;

import textRPG10403202.RPG2;
import textRPG10403202.characters.RPGCharacter;
import textRPG10403202.items.interfaces.Item;
public class Heal_Low extends Heal implements Item{
    public Heal_Low(int fixedHeal, RPG2 setMainClass) {
        this(fixedHeal,"低位ポーション",5,setMainClass);
    }
    public Heal_Low(int fixedHeal,String name, RPG2 setMainClass) {
        this(fixedHeal,name,5,setMainClass);
    }
    public Heal_Low(int fixedHeal,String name,int durability, RPG2 setMainClass) {
        super(name,durability,1,setMainClass);
        this.fixedHeal = fixedHeal;
    }
    public static void applyEffect(RPGCharacter c,Heal_Low HL) {
        int percentageHeal = (c.getMaxHP() / 10);
        c.heal(HL.fixedHeal + percentageHeal);
    }
    public void use(RPGCharacter target){
        if(this.isItemUsable()){
            RPG2.logWrite(this.getItemName() + "を使った");
            applyEffect(target,this);
            decrementdurability();
            nextGameState();
        }else{
            RPG2.logWrite("現在アイテムを使用できません");
        }
    }
}
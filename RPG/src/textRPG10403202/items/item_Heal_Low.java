package textRPG10403202.items;
import textRPG10403202.RPGCharacter;
import textRPG10403202.RPG2;
public class item_Heal_Low extends item_Heal {
    public item_Heal_Low(int fixedHeal) {
        this.remaining = 5;
        this.fixedHeal = fixedHeal;
        this.itemName = "低位ポーション";
    }

    public void executionItem(RPGCharacter c) {
        percentageHeal = (c.maxHP / 10);
        c.heal(fixedHeal + percentageHeal);
        RPG2.logWrite(itemName + "を使って" + (fixedHeal + percentageHeal) + "回復した");
        remaining--;
    }
}
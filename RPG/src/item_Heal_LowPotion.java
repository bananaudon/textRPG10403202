public class item_Heal_LowPotion extends item_Heal {
    item_Heal_LowPotion(int fixedHeal) {
        this.remaining = 5;
        this.fixedHeal = fixedHeal;
        this.itemName = "低位ポーション";
    }

    void executionItem(Character c) {
        percentageHeal = (c.maxHP / 10);
        c.heal(fixedHeal + percentageHeal);
        RPG2.logWrite(itemName + "を使って" + (fixedHeal + percentageHeal) + "回復した");
        remaining--;
    }
}
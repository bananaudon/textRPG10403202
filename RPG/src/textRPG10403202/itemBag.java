package textRPG10403202;
import textRPG10403202.items.item;
import textRPG10403202.items.item_void;
import textRPG10403202.items.item_Heal;
public class itemBag {
    item[] bags = new item[20];
    item healItem = new item_void();

    public void setEmpty() {
        for (int i = 0; i < bags.length; i++) {
            bags[i] = new item_void();
        }
    }

    public void setHealItem(int bagNumber) {
        if (bags[bagNumber] instanceof item_Heal) {
            healItem = bags[bagNumber];
            bags[bagNumber] = new item_void();
        }
    }

    public void setItem(int bagNumber, item Item) {
        bags[bagNumber] = Item;
        System.out.println(bagNumber + "番に" + Item.getItemName() + "を入れたよ このコメントはitemBagクラスのsetItemメソッド");
    }

    public void addItem(item Item) {
        for (int i = 0; i < bags.length; i++) {
            if (bags[i] instanceof item_void) {
                bags[i] = Item;
                System.out.println(i + "番に" + Item.getItemName() + "を入れたよ このコメントはitemBagクラスのaddItemメソッド");
                break;
            }
        }
    }

    public void breakItem(int bagNumber) {
        RPG2.logWrite(String.valueOf(bags[bagNumber].getItemName() + "が壊れた"));
        bags[bagNumber] = new item_void();
    }
}
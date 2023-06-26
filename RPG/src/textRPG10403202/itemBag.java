package textRPG10403202;
import textRPG10403202.items.Item;
import textRPG10403202.items.Item_void;
import textRPG10403202.items.Heal;
public class ItemBag {
    Item[] items = new Item[20];
    Item healItem = new Item_void();
    RPGCharacter owner;
    ItemBag(RPGCharacter owner){
        this.owner = owner;
    }
    void setEmpty() {
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item_void();
        }
    }

    void setHealItem(int bagNumber) {
        if (items[bagNumber] instanceof Heal) {
            healItem = items[bagNumber];
            items[bagNumber] = new Item_void();
        }
    }

    void breakHealItem(){
        healItem = new Item_void();
    }
    void setItem(int bagNumber, Item Item) {
        items[bagNumber] = Item;
        System.out.println(bagNumber + "番に" + Item.getItemName() + "を入れたよ このコメントはitemBagクラスのsetItemメソッド");
    }

    void addItem(Item Item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof Item_void) {
                items[i] = Item;
                System.out.println(i + "番に" + Item.getItemName() + "を入れたよ このコメントはitemBagクラスのaddItemメソッド");
                break;
            }
        }
    }

    void breakItem(int bagNumber) {
        RPG2.logWrite(String.valueOf(items[bagNumber].getItemName() + "が壊れた"));
        items[bagNumber] = new Item_void();
    }
}
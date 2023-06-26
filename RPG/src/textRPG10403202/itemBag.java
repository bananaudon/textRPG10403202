package textRPG10403202;
import textRPG10403202.items.item;
import textRPG10403202.items.item_void;
import textRPG10403202.items.Heal;
public class itemBag {
    item[] items = new item[20];
    item healItem = new item_void();
    RPGCharacter owner;
    itemBag(RPGCharacter owner){
        this.owner = owner;
    }
    void setEmpty() {
        for (int i = 0; i < items.length; i++) {
            items[i] = new item_void();
        }
    }

    void setHealItem(int bagNumber) {
        if (items[bagNumber] instanceof Heal) {
            healItem = items[bagNumber];
            items[bagNumber] = new item_void();
        }
    }

    void breakHealItem(){
        healItem = new item_void();
    }
    void setItem(int bagNumber, item Item) {
        items[bagNumber] = Item;
        System.out.println(bagNumber + "番に" + Item.getItemName() + "を入れたよ このコメントはitemBagクラスのsetItemメソッド");
    }

    void addItem(item Item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof item_void) {
                items[i] = Item;
                System.out.println(i + "番に" + Item.getItemName() + "を入れたよ このコメントはitemBagクラスのaddItemメソッド");
                break;
            }
        }
    }

    void breakItem(int bagNumber) {
        RPG2.logWrite(String.valueOf(items[bagNumber].getItemName() + "が壊れた"));
        items[bagNumber] = new item_void();
    }
}
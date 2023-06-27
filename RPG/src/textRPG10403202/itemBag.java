package textRPG10403202;

import textRPG10403202.items.ItemInfo;
import textRPG10403202.items.Item;
import textRPG10403202.items.Item_void;
import textRPG10403202.items.Heal;

public class ItemBag {
    private Item[] items = new Item[20];
    private Item healItem = new Item_void();
    RPGCharacter owner;
    ItemBag(RPGCharacter character){
        this.owner = character;
        this.setEmpty();
    }

    //キャラクターが実行できるメソッド
    //ここから

    void setEmpty() {
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item_void();
        }
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

    void setHealItem(int bagNumber) {
        if (items[bagNumber] instanceof Heal) {
            healItem = items[bagNumber];
            items[bagNumber] = new Item_void();
        }
    }

    void useItem(int bagNumber){
        items[bagNumber].use(owner);
        if(items[bagNumber].isBreak()){
            breakItem(bagNumber);
        }
    }
    
    void useHealItem(){
        healItem.use(owner);
        if(healItem.isBreak()){
            breakHealItem();
        }
    }

    String[] getItemNames(){
        String itemNames[] = new String[items.length];
            for(int i = 0;i < items.length;i++){
                itemNames[i] = items[i].getItemName();
            }
        return itemNames;
    }

    ItemInfo getItemInfo(int bagNumber){
        return (ItemInfo)items[bagNumber];
    }

    int getHealItemdurability(){
        return healItem.getdurability();
    }
    //ここまで

    private void breakHealItem(){
        healItem = new Item_void();
    }

    private void breakItem(int bagNumber) {
        RPG2.logWrite(String.valueOf(items[bagNumber].getItemName() + "が壊れた"));
        items[bagNumber] = new Item_void();
    }
}
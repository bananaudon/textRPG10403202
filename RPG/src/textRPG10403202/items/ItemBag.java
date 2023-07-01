package textRPG10403202.items;

import textRPG10403202.RPG2;
import textRPG10403202.RPGCharacter;

public class ItemBag {
    private Item[] items = new Item[20];
    private Item healItem = new Item_void();
    RPGCharacter owner;
    public ItemBag(RPGCharacter character){
        this.owner = character;
        this.setEmpty();
    }

    //キャラクターが実行できるメソッド
    //ここから

    public void setEmpty() {
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item_void();
        }
    }

    public void addItem(Item Item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof Item_void) {
                items[i] = Item;
                System.out.println(i + "番に" + Item.getItemName() + "を入れたよ このコメントはitemBagクラスのaddItemメソッド");
                break;
            }
        }
    }

    public void setHealItem(int bagNumber) {
        if (items[bagNumber] instanceof Heal) {
            healItem = items[bagNumber];
            items[bagNumber] = new Item_void();
        }
    }


    
    public void useHealItem(){
        healItem.use(owner);
        if(healItem.isBreak()){
            breakHealItem();
        }
    }

    public ItemInfo getHealItemInfo(){
        return (ItemInfo)healItem;
    }

    //ここまで

    int getItemLength(){
        return this.items.length;
    }
    
    ItemInfo getItemInfo(int bagNumber){
        return (ItemInfo)items[bagNumber];
    }

    void useItem(int bagNumber){
        items[bagNumber].use(owner);
        if(items[bagNumber].isBreak()){
            breakItem(bagNumber);
        }
    }

    String[] getItemNames(){
        String itemNames[] = new String[items.length];
            for(int i = 0;i < items.length;i++){
                itemNames[i] = items[i].getItemName();
            }
        return itemNames;
    }

    private void breakHealItem(){
        healItem = new Item_void();
    }

    private void breakItem(int bagNumber) {
        RPG2.logWrite(String.valueOf(items[bagNumber].getItemName() + "が壊れた"));
        items[bagNumber] = new Item_void();
    }
}
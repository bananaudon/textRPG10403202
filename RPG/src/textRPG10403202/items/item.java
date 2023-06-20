package textRPG10403202.items;
import textRPG10403202.RPGCharacter;
public abstract class item {
    int itemID;
    int itemType;
    String itemName;
    int remaining;

    void setItemStatus(int I, int IT, String N, int R) {
        itemID = I;
        itemType = IT;
        itemName = N;
        remaining = R;
    }

    public abstract void executionItem(RPGCharacter c);
    public String getItemName(){
        return this.itemName;
    }
    public int getRemaining(){
        return this.remaining;
    }
    public void use(){
        remaining--;
    }
    item() {
        itemID = 0;
        itemType = 0;
        itemName = "NONE";
        remaining = -1;
    }
}
package textRPG10403202.items;
import textRPG10403202.RPGCharacter;
public abstract class item {
    String itemName;
    int remaining;
    void setItemStatus(String N, int R) {
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
}
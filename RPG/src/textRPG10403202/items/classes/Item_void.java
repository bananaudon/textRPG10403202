package textRPG10403202.items.classes;

import textRPG10403202.items.interfaces.Item;

public class Item_void implements Item {
    public String getItemName(){
        return "none";
    }
    public int getdurability(){
        return 0;
    }
    public void Rename(String name){}
}

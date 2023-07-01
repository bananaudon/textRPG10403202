package textRPG10403202.items;

import textRPG10403202.RPGCharacter;
public class Item_void implements Item {
    public String getItemName(){
        return "none";
    }
    public int getdurability(){
        return 0;
    }
    public void Rename(String name){}
    public void setdurability(int durability){}
    public void use(RPGCharacter target){}
    public void decrementdurability() {}
    //public void applyEffect(RPGCharacter target){}
    public boolean isBreak(){
        return false;
    };
}
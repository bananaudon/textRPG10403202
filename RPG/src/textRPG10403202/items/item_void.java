package textRPG10403202.items;

import textRPG10403202.RPGCharacter;
public class item_void implements item {
    public String getItemName(){
        return "none";
    }
    public int getdurability(){
        return -1;
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
package textRPG10403202.items;

import textRPG10403202.RPGCharacter;
public interface Item extends ItemInfo{
    public String getItemName();
    public void Rename(String name);
    public int getdurability();
    public void use(RPGCharacter target);
    public void decrementdurability();
    public boolean isBreak();
}

package textRPG10403202.items;

import textRPG10403202.characters.RPGCharacter;
public interface Item extends ItemInfo{
    public void Rename(String name);
    public void use(RPGCharacter target);
    public void decrementdurability();
    public boolean isBreak();
}
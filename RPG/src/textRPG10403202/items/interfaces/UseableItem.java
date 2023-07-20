package textRPG10403202.items.interfaces;

import textRPG10403202.characters.RPGCharacter;
public interface UseableItem{
    public void use(RPGCharacter target);
    public void decrementdurability();
    public boolean isBreak();
}
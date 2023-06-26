package textRPG10403202.items;

import textRPG10403202.RPGCharacter;
public interface item {
    public String getItemName();
    public void setItemName(String name);
    public int getdurability();
    public void setdurability(int durability);
    public void use(RPGCharacter target);
    public void decrementdurability();
    public boolean isBreak();
}
package textRPG10403202.items;

import textRPG10403202.RPG2;
import textRPG10403202.GameManager;
import textRPG10403202.characters.RPGCharacter;
public abstract class Heal implements UseableItem{
    private String itemName;
    private int durability,durabilityLossPerUse;
    private RPG2 mainClass;
    protected int fixedHeal;
    Heal(String n,int d,int dl,RPG2 setMainClass){
        this.durability = d;
        this.durabilityLossPerUse = dl;
        this.itemName = n;
        this.mainClass = setMainClass;
    }

    //Item
    public void Rename(String name){
        this.itemName = name;
    }

    //ItemInfo
    public String getItemName(){
        return this.itemName;
    }

    public int getdurability(){
        return this.durability;
    }

    //UseableItem
    public void decrementdurability(){
        this.durability -= durabilityLossPerUse;
    }
    
    public boolean isBreak(){
        if(this.durability <= 0){
            return true;
        }
        return false;
    }

    public abstract void use(RPGCharacter target);

    //this
    protected boolean isItemUsable(){
        return GameManager.isPossibleACT(mainClass.getActiveGameState());
    }
    
    protected void nextGameState(){
        mainClass.nextGameState();
    }
}
package textRPG10403202.items;

import textRPG10403202.RPG2;
import textRPG10403202.GameManager;
public abstract class Heal{
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

    public String getItemName(){
        return this.itemName;
    }

    public void Rename(String name){
        this.itemName = name;
    }

    public int getdurability(){
        return this.durability;
    }

    public void decrementdurability(){
        this.durability -= durabilityLossPerUse;
    }
    
    boolean isItemUsable(){
        return GameManager.isPossibleACT(mainClass.getActiveGameState());
    }
    
    void nextGameState(){
        mainClass.nextGameState();
    }
    
    public boolean isBreak(){
        if(this.durability <= 0){
            return true;
        }
        return false;
    }
}
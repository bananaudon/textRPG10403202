package textRPG10403202.items;

public abstract class Heal{
    private String itemName;
    private int durability,durabilityLossPerUse;
    protected int fixedHeal;
    Heal(String n,int d,int dl){
        this.durability = d;
        this.durabilityLossPerUse = dl;
        this.itemName = n;
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
    
    public boolean isBreak(){
        if(this.durability <= 0){
            return true;
        }
        return false;
    }
}
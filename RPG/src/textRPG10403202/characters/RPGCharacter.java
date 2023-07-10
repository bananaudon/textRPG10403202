package textRPG10403202.characters;

public interface RPGCharacter {
    
    public int getMaxHP();

    public void randomStatus();

    public void attack(RPGCharacter c);

    public void damage(int damage);

    public void heal(int heal);

    public boolean isDeath();
}
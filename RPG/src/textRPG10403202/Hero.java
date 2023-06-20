package textRPG10403202;
public class Hero extends RPGCharacter {
    int nextLv, EXP, steps, luck;

    Hero(int level, int maxHP, int currentHP, int power,int nL, int E, int s, int lu){
        //characterとして必要な情報
        super(level,maxHP,currentHP,power);

        //主人公として必要な情報
        this.nextLv = nL;
        this.EXP = E;
        this.steps = s;
        this.luck = lu;
    }

    @Override
    void attack(RPGCharacter c) {
        System.out.println(this.name + "は" + c.name + "を攻撃した");
        RPG2.refresh();
    }

    @Override
    public void damage(int damage) {
        this.nowHP -= damage;
        RPG2.refresh();
    }

    @Override
    public void heal(int heal) {
        this.nowHP += heal;
        RPG2.refresh();
    }
}
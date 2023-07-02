package textRPG10403202;
public class Explorer extends RPGCharacter {
    int nextLv, EXP, steps, luck;

    Explorer(int level, int maxHP, int currentHP, int power, RPG2 setMainClass,int nL, int E, int s, int lu){
        //characterとして必要な情報
        super(level,maxHP,currentHP,power,setMainClass);

        //主人公として必要な情報
        this.nextLv = nL;
        this.EXP = E;
        this.steps = s;
        this.luck = lu;
    }

    @Override
    void attack(RPGCharacter c) {
        System.out.println(this.name + "は" + c.name + "を攻撃した");
    }

    @Override
    public void damage(int damage) {
        this.nowHP -= damage;
    }

    @Override
    public void heal(int heal) {
        this.nowHP += heal;
    }
}
public class character_main extends character{
    int nextLv,EXP,steps,luck;
    void PStatusSet(int nL,int E,int s,int lu){
        nextLv = nL;
        EXP = E;
        steps = s;
        luck = lu;
    }
    void attack(character c){
        System.out.println(this.name + "は" + c.name + "を攻撃した");
        RPG2.refresh();
    }
    void damage(int damage){
        this.nowHP -= damage;
        RPG2.refresh();
    }
    void heal(int heal){
        this.nowHP += heal;
        RPG2.refresh();
    }
}
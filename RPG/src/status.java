public class status{
    int Lv,maxHP,nowHP,Pow;
    public void statusSet(int L,int MH,int NH,int P){
        Lv = L;
        maxHP = MH;
        nowHP = NH;
        Pow = P;
    }
    public void randomStatus(int minLv,int minMaxHP,int minNowHP,int minPow,int LRange,int MHRange,int NHRange,int PRange){
        Lv = (int)(Math.random()*(LRange+1))+minLv;
        maxHP = (int)(Math.random()*(MHRange+1))+minMaxHP;
        nowHP = (int)(Math.random()*(NHRange+1))+minNowHP;
        Pow = (int)(Math.random()*(PRange+1))+minPow;
    }
}
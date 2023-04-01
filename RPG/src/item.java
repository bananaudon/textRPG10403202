public class item {
    int itemID;
    int itemType;
    String itemName;
    int remaining;
    int[] effectType;
    int[] effectSize;
    public void setItemStatus(int I,int IT,String N,int R,int[] ET,int[] ES){
        itemID = I;
        itemType = IT;
        itemName = N;
        remaining = R;
        effectType = new int[ET.length];
        effectType = ET;
        effectSize = new int[ES.length];
        effectSize = ES;
    }
    item(){
        itemID = 0;
        itemType = 0;
        itemName = "NONE";
        remaining = -1;
        effectType = new int[]{0};
        effectSize = new int[]{0};
    }
}
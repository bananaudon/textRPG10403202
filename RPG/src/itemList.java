public class itemList{
    public static goodItem[] goodItems = new goodItem[5];
    public static badItem[] badItems = new badItem[1];
    public static equipment[] equipments = new equipment[1];
    public static item[] items = new item[lengthSum()];
    itemList(){
        for(int i = 0;i < badItems.length;i++){
            badItems[i] = new badItem();
        }
        for(int i = 0;i < goodItems.length;i++){
            goodItems[i] = new goodItem();
        }
        for(int i = 0;i < equipments.length;i++){
            equipments[i] = new equipment();
        }
        //goodItems[0].setItemStatus(0,0,"NONE",-1,0);
        goodItems[1].setItemStatus(1,0,"LowPotion",5,new int[] {1},new int[] {50});
        goodItems[2].setItemStatus(2,0,"MiddlePotion",5,new int[] {1},new int[] {150});
        goodItems[3].setItemStatus(3,0,"HighPotion",5,new int[] {2},new int[] {60});
        goodItems[4].setItemStatus(4,0,"BigLowPotion",10,new int[] {1},new int[] {50});
        badItems[0].setItemStatus(0,1,"DamegePotion",1,new int[] {2},new int[] {50});
        equipments[0].setItemStatus(0,2,"test",-1,new int[] {0},new int[] {0});
        //equipments[0].setItemStatus(0,2,"test",10,new SizeAndType[]{new SizeAndType(new int[]{1},new int[]{2}),new SizeAndType(new int[]{1},new int[]{2})});
        int i = 0;
        for(int j = 0;j < goodItems.length;j++,i++){
            items[i] = goodItems[i];
        }
        for(int j = 0;j < badItems.length;j++,i++){
            items[i] = badItems[j];
        }
        for(int j = 0;j < equipments.length;j++,i++){
            items[i] = equipments[j];
        }
    }
    static int lengthSum(){
        return badItems.length + goodItems.length + equipments.length;
    }
    public static item findAllItem(int ItemID,int ItemType){
        for(int i = 0;i < lengthSum();i++){
            if(items[i].itemID == ItemID && items[i].itemType == ItemType){
                return items[i];
            }
        }
        return items[0];
    }
    public static goodItem findGoodItem(item ItemData){
        for(int i = 0;i < goodItems.length;i++){
            if(goodItems[i].itemID == ItemData.itemID && goodItems[i].itemType == ItemData.itemType){
                return goodItems[i];
            }
        }
        return new goodItem();
    }
    public static badItem findBadItem(item ItemData){
        for(int i = 0;i < badItems.length;i++){
            if(goodItems[i].itemID == ItemData.itemID && goodItems[i].itemType == ItemData.itemType){
                return badItems[i];
            }
        }
        return new badItem();
    }
}
class itemEfect{
    public static void executionItem(item EI){
        String S = "このアイテムは使えないようだ";
        if(EI.remaining <= 0){
            RPG2.logWrite(S);
            return;
        }
        S = String.valueOf(EI.itemName+"を使った");
        EI.remaining--;
        //System.out.println(EI.remaining);
        RPG2.logWrite(S);
        for(int i = 0;i<EI.effectType.length;i++){
            S = "エラーメッセージ、異常なconstentNumber";
            switch(EI.effectType[i]){
                case 0:
                    S = String.valueOf("何も起きなかった");
                break;
                case 1:
                    S = String.valueOf(RPG2.mainStatus.nowHP+"から");
                    RPG2.fixedHeal(EI.effectSize[i]);
                    S += String.valueOf(RPG2.mainStatus.nowHP+"まで回復した");
                break;
                case 2:
                    S = String.valueOf(RPG2.mainStatus.nowHP+"から");
                    RPG2.percentageHeal(EI.effectSize[i]);
                    S += String.valueOf(RPG2.mainStatus.nowHP+"まで回復した");
                break;
            }
            RPG2.logWrite(S);
        }
    }
    public static boolean searchEffect(int[] ET,int[] eE){
        int count = 0;
        for(int i : ET){
            for(int j : eE){
                if(i == j){
                    count++;
                }
            }
        }
        if(count >= eE.length){
            System.out.println("true "+count+" "+ET.length);
            return true;
        }else{
            System.out.println("false "+count+" "+ET.length);
            return false;
        }
    }
}
public class itemBag{
    item[] bags = new item[20];
    item healItem = new item();
    public void setEmpty(){
        for(int i = 0;i < bags.length;i++){
            bags[i] = itemList.items[0];
        }
    }
    public void setHealItem(int bagNumber){
        if(itemEfect.searchEffect(bags[bagNumber].effectType,new int[]{1})){
            healItem = bags[bagNumber];
            bags[bagNumber]=itemList.items[0];
        }
    }
    public void setItem(int bagNumber,item Item){
        bags[bagNumber] = Item;
        System.out.println(bagNumber+"番に"+Item.itemName+"を入れたよ");
    }
    public void addItem(item Item){
        for(int i = 0;i < bags.length;i++){
            if(bags[i].itemID == 0&&bags[i].itemType == 0){
                bags[i] = Item;
                System.out.println(i+"番に"+Item.itemName+"を入れたよ");
                break;
            }
        }
    }
    public void breakItem(int bagNumber){
        RPG2.logWrite(String.valueOf(bags[bagNumber].itemName + "が壊れた"));
        bags[bagNumber] = new item();
    }
}
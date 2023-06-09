public abstract class item {
    int itemID;
    int itemType;
    String itemName;
    int remaining;

    void setItemStatus(int I, int IT, String N, int R) {
        itemID = I;
        itemType = IT;
        itemName = N;
        remaining = R;
    }

    abstract void executionItem(character c);

    item() {
        itemID = 0;
        itemType = 0;
        itemName = "NONE";
        remaining = -1;
    }
}
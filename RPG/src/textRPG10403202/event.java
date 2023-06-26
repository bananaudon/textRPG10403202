package textRPG10403202;
public class Event {
    int probability;
    int eventType;
    int eventPower;

    Event() {
        probability = 0;
        eventType = 0;
        eventPower = 0;
    }

    Event(int P, int ET, int EP) {
        probability = P;
        eventType = ET;
        eventPower = EP;
    }
}
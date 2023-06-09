public class event {
    int probability;
    int eventType;
    int eventPower;

    event() {
        probability = 0;
        eventType = 0;
        eventPower = 0;
    }

    event(int P, int ET, int EP) {
        probability = P;
        eventType = ET;
        eventPower = EP;
    }
}
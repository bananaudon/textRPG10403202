package textRPG10403202;
public class EventList {
    private Event[] events = new Event[4];
    private RPG2 mainClass;
    EventList(RPG2 setMainClass) {
        mainClass = setMainClass;
        for (int i = 0; i < events.length; i++)
            events[i] = new Event();
        events[0] = new Event(40, 0, 0);
        events[1] = new Event(60, 1, 0);
        events[2] = new Event(80, 2, 0);
        events[3] = new Event(90, 1, 1);
    }

    Event selectEvent(int randomRange) {
        int randomNumber = (int) (Math.random() * randomRange);
        for (int i = 0; i < events.length; i++) {
            if (randomNumber <= events[i].probability) {
                return events[i];
            }
        }
        return new Event();
    }

    void executeEvent(Event exeEvent) {

        String EventMessage = switch (exeEvent.eventType) {

            case 0 -> {
                int RandomNum = (int) (Math.random() * 3);

                yield switch (RandomNum) {
                    case 0 -> "何か物音がした気がする......";
                    case 1 -> "不気味なほど静かだ......";
                    case 2 -> "太陽が恋しい......";
                    default -> "異常なメッセージ";
                };
            }
            case 1 -> {
                mainClass.battle(exeEvent.eventPower);
                yield "";
            }
            case 2 -> {
                yield "みじっそう";
            }
            default -> {
                yield "異常なメッセージ";
            }
        };
        RPG2.logWrite(EventMessage);
    }
}

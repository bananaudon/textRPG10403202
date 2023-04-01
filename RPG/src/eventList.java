public class eventList{
    event[] events = new event[4];
    eventList(){
        for(int i = 0;i < events.length;i++)events[i] = new event();
        events[0] = new event(40,0,0);
        events[1] = new event(60,1,0);
        events[2] = new event(80,2,0);
        events[3] = new event(90,1,1);
    }
    public event selectEvent(int randomRange){
        int randomNumber = (int)(Math.random() * randomRange);
        for(int i = 0;i < events.length;i++){
            if(randomNumber <= events[i].probability){
                return events[i];
            }
        }
        return new event();
    }
    public void executeEvent(event executeEvent){
        String EventMessage = "異常なメッセージ";
        switch(executeEvent.eventType){
            case 0:
                int RandomNum = (int)(Math.random() * 3);
                switch(RandomNum){
                    case 0:
                        EventMessage = "何か物音がした気がする......";
                    break;
                    case 1:
                        EventMessage = "不気味なほど静かだ......";
                    break;
                    case 2:
                        EventMessage = "太陽が恋しい......";
                    break;
                }
            break;
            case 1:
                EventMessage = "";
                RPG2.battle(executeEvent.eventPower);
                return;
            case 2:
                EventMessage = "みじっそう";
            break;
        }
        RPG2.logWrite(EventMessage);
    }
}

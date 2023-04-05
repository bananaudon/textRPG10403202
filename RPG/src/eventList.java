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

        String EventMessage = switch(executeEvent.eventType){

            case 0 ->{
                int RandomNum = (int)(Math.random() * 3);

                yield switch(RandomNum){
                    case 0 -> "何か物音がした気がする......";
                    case 1 -> "不気味なほど静かだ......";
                    case 2 -> "太陽が恋しい......";
                    default -> "異常なメッセージ";
                };
            }
            case 1 ->{
                RPG2.battle(executeEvent.eventPower);
                yield "";
            }
            case 2 ->{
                yield "みじっそう";
            }
            default -> {
                yield "異常なメッセージ";
            }
        };
        RPG2.logWrite(EventMessage);
    }
}

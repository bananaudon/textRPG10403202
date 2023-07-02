package textRPG10403202;
public class GameManager {
    
    private GameState activeGameState = GameState.EXPLORE;
    private RPG2 mainClass;

    GameManager(RPG2 setmainClass){
        mainClass = setmainClass;
    }

    GameState getStatus(){
        return this.activeGameState;
    }

    void setStatus(GameState newState){
        if(checkStatus(newState)){
            activeGameState = newState;
            return;
        }
        System.out.println("エラーメッセージ:" + activeGameState + "から" + newState + "へは移行できません、システムを終了します");
        System.exit(0);
    }

    private boolean checkStatus(GameState newState){
        if(newState == GameState.EXPLORE||newState == GameState.GAME_OVER){
            return true;
        }
        if(this.activeGameState == GameState.EXPLORE){
            return true;
        }
        return false;
    }

    void nextStatus(){
        switch(activeGameState){
            case EXPLORE -> {

            }
            case ACT -> {

            }
            case BATTLE -> {
                activeGameState = GameState.BATTLE_ENEMY;
                mainClass.Damage(0);
                activeGameState = GameState.BATTLE;
            }
            case BATTLE_ENEMY -> {
                activeGameState = GameState.BATTLE;
            }
            case SELECT -> {

            }
            case GAME_OVER -> {

            }
        }
    }

    public static boolean isPossibleACT(GameState checkState){
        switch(checkState){
            case EXPLORE:
            case ACT:
            case BATTLE:
            case SELECT:
                return true;
            default:
                return false;
        }
    }

    public static boolean isPossibleAttack(GameState checkState){
        switch(checkState){
            case BATTLE:
                return true;
            default:
                return false;
        }
    }
}
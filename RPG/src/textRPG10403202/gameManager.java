package textRPG10403202;
public class GameManager {
    private GameState activeGameState = GameState.EXPLORE;
    GameState getActiveGameState(){
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
    boolean checkStatus(GameState newState){
        if(newState == GameState.EXPLORE||newState == GameState.GAME_OVER){
            return true;
        }
        if(this.activeGameState == GameState.EXPLORE){
            return true;
        }
        return false;
    }
}
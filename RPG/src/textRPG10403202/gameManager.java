package textRPG10403202;
public class gameManager {
    private gameState activeGameState = gameState.EXPLORE;
    gameState getActiveGameState(){
        return this.activeGameState;
    }
    void setStatus(gameState newState){
        if(checkStatus(newState)){
            activeGameState = newState;
            return;
        }
        System.out.println("エラーメッセージ:" + activeGameState + "から" + newState + "へは移行できません、システムを終了します");
        System.exit(0);
    }
    boolean checkStatus(gameState newState){
        if(newState == gameState.EXPLORE||newState == gameState.GAME_OVER){
            return true;
        }
        if(this.activeGameState == gameState.EXPLORE){
            return true;
        }
        return false;
    }
}
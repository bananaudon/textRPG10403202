package textRPG10403202;
public class gameManager {
    private gameState activeGameState = gameState.EXPLORE;
    gameState getNowGameState(){
        return this.activeGameState;
    }
    void setStatus(gameState newState){
        if(newState == gameState.EXPLORE||newState == gameState.GAME_OVER){
            this.activeGameState = newState;
            return;
        }
        if(this.activeGameState == gameState.EXPLORE){
            this.activeGameState = newState;
            return;
        }
        System.out.println("エラーメッセージ:" + activeGameState + "から" + newState + "へは移行できません、システムを終了します");
        System.exit(0);
    }
}
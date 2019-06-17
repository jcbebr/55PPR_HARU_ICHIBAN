package br.udesc.ppr.haruichiban.control.observer;

public interface MainScreenObserver extends Observer {

    void notifyNextRoundStep(String round, String info);
    
    void notifyEmptyDesck(String deck);
    
    void notifyNextRound(String winner);
    
    void notifyGameOver(String winner);    
}

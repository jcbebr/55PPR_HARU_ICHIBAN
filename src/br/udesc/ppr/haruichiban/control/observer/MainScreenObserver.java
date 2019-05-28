package br.udesc.ppr.haruichiban.control.observer;

public interface MainScreenObserver extends Observer {

    void notifyNextRound(String round, String info);
    
    void notifyEmptyDesck(String deck);
}

package br.udesc.ppr.haruichiban.control.observer;

public interface Observed {

    void addObservador(Observer obs);

    void removerObservador(Observer obs);
}

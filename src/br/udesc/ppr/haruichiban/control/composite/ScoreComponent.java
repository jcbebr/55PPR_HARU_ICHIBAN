package br.udesc.ppr.haruichiban.control.composite;

public abstract class ScoreComponent {

    protected String name;
    
    public abstract void doScore();
    
    public abstract int[] getScore();

    public ScoreComponent(String name) {
        this.name = name;
    }

}

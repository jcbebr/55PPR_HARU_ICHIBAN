package br.udesc.ppr.haruichiban.control.composite;

import java.util.ArrayList;
import java.util.List;

public class ScoreGroup extends ScoreComponent {

    private List<ScoreComponent> components = new ArrayList<>();

    public ScoreGroup(String name) {
        super(name);
    }

    public void add(ScoreComponent scoreComponent) {
        this.components.add(scoreComponent);
    }

    public void remove(ScoreComponent scoreComponent) {
        this.components.remove(scoreComponent);
    }

    public ScoreComponent getScoreComponent(int index) {
        return this.components.get(index);
    }

    @Override
    public void doScore() {
        for (ScoreComponent comp : components) {
            comp.doScore();
        }
    }
    
    @Override
    public int[] getScore() {
        int[] r = new int[]{0, 0};
        for (ScoreComponent comp : components) {
            r[0] += comp.getScore()[0];
            r[1] += comp.getScore()[1];
        }
        return r;
    }
}

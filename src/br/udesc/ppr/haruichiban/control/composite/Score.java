package br.udesc.ppr.haruichiban.control.composite;

import br.udesc.ppr.haruichiban.control.builder.Board;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Score extends ScoreComponent {

    private final String refMethod;
    private final int scoreValue;
    private int[] totalvalue;
    private Board board;

    public Score(String name, String refMethod, int scoreValue, Board board) {
        super(name);
        this.refMethod = refMethod;
        this.scoreValue = scoreValue;
        this.board = board;
    }
    
    @Override
    public void doScore() {
        try {
            Method[] methods = Class.forName(ScoreCalculation.class.getName()).getMethods();
            for (Method m : methods) {
                if (m.getName().toLowerCase().equals(refMethod.toLowerCase())) {
                    totalvalue = ((int[]) m.invoke(null, board));
                    return;
                }
            }
        } catch (ClassNotFoundException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException ex) {
            System.out.println("Error [getScore] [Score]");
        }
    }

    @Override
    public int[] getScore() {
        return new int[]{totalvalue[0] * scoreValue, totalvalue[1] * scoreValue};
    }

}

package br.udesc.ppr.haruichiban.control.composite;

import br.udesc.ppr.haruichiban.control.builder.Board;

public class ScoreController {

    private final ScoreGroup scores;
    
    public ScoreController(Board board) {
        scores = new ScoreGroup("Grupo com todos os tipos de pontuação");
        
        Score condition01 = new Score("Primeira condição de pontuação","squareScoreCalc", 1, board);
        
        ScoreGroup condition02 = new ScoreGroup("Segunda condição de pontuação");
        condition02.add(new Score("Pontuação horizontal da segunda condição de pontuação","horizontalFourScoreCalc", 2, board));
        condition02.add(new Score("Pontuação vertical da segunda condição de pontuação","verticalFourScoreCalc", 2, board));
        
        ScoreGroup condition03 = new ScoreGroup("Terceira condição de pontuação");
        condition03.add(new Score("Pontuação diagonal crescente da terceira condição de pontuação","diagonalCrescentFourScoreCalc", 3, board));
        condition03.add(new Score("Pontuação diagonal decrescente da terceira condição de pontuação","diagonalDecrescentFourScoreCalc", 3, board));
        
        ScoreGroup condition04 = new ScoreGroup("Quarta condição de pontuação");
        condition04.add(new Score("Pontuação vertical da quarta condição de pontuação","verticalFiveScoreCalc", 5, board));
        condition04.add(new Score("Pontuação horizontal da quarta condição de pontuação","horizontalFiveScoreCalc", 5, board));
        condition04.add(new Score("Pontuação diagonal decrescente da quarta condição de pontuação","diagonalDecrescentFiveScoreCalc", 5, board));
        condition04.add(new Score("Pontuação diagonal crescente da quarta condição de pontuação","diagonalCrescentFiveScoreCalc", 5, board));
        
        scores.add(condition01);
        scores.add(condition02);
        scores.add(condition03);
        scores.add(condition04);
    }
    
    public int[] getTotalScore(){
        scores.doScore();
        return scores.getScore();
    }

}

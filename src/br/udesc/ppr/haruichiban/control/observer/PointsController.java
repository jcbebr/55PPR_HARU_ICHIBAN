package br.udesc.ppr.haruichiban.control.observer;

import java.util.ArrayList;
import java.util.List;
import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.Rock;
import br.udesc.ppr.haruichiban.model.card.Water;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public class PointsController implements PanelTableController {

    private Card[] cards;
    private List<PanelTableObserver> obss;
    private int redPoints = 0;
    private int yellowPoints = 0;

    public int getRedPoints() {
        return redPoints;
    }

    public void addRedPoints(int redPoints) {
        this.redPoints += redPoints;
        if (this.redPoints == 0) {
            paintR(10, 0);
        } else if (this.redPoints == 1) {
            paintR(9, 1);
        } else if (this.redPoints == 2) {
            paintR(8, 2);
        } else if (this.redPoints == 3) {
            paintR(7, 3);
        } else if (this.redPoints == 4) {
            paintR(6, 4);
        } else if (this.redPoints >= 5) {
            paintR(5, 5);
        }

        for (PanelTableObserver obs : obss) {
            obs.notifyChangedCards();
        }
    }

    public int getYellowPoints() {
        return yellowPoints;
    }

    public void addYellowPoints(int yellowPoints) {
        this.yellowPoints += yellowPoints;
        if (this.yellowPoints == 0) {
            paintY(0);
        } else if (this.yellowPoints == 1) {
            paintY(1);
        } else if (this.yellowPoints == 2) {
            paintY(2);
        } else if (this.yellowPoints == 3) {
            paintY(3);
        } else if (this.yellowPoints == 4) {
            paintY(4);
        } else if (this.yellowPoints >= 5) {
            paintY(5);
        }

        for (PanelTableObserver obs : obss) {
            obs.notifyChangedCards();
        }
    }

    private void paintY(int position) {
        if (position >= 0) {
            cards[position] = new Rock(position);
            paintY(position - 1);
        }
    }

    private void paintR(int position, int value) {
        if (position <= 10) {
            cards[position] = new Rock(value);
            paintR(position + 1, value - 1);
        }
    }

    public boolean hasSingleWinner() {
        return (redPoints >= 5 && yellowPoints < 5) || (yellowPoints >= 5 && redPoints < 5);
    }

    public String getWinner() {
        if (redPoints > yellowPoints) {
            return "vermelho";
        } else if (yellowPoints > redPoints) {
            return "amarelo";
        } else {
            return "";
        }
    }

    public PointsController() {
        this.cards = new Card[11];
        this.obss = new ArrayList<>();

        cards[0] = new Rock(0);
        cards[1] = new Water();
        cards[2] = new Water();
        cards[3] = new Water();
        cards[4] = new Water();
        cards[5] = new Water();
        cards[6] = new Water();
        cards[7] = new Water();
        cards[8] = new Water();
        cards[9] = new Water();
        cards[10] = new Rock(0);
    }

    @Override
    public Card getValueAt(int row, int column, boolean selected) {
        if (column == 1) {
            return cards[row];
        }
        return new Water();
    }

    @Override
    public int getRowCount() {
        return 11;
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public void clickCell(int row, int column) {
    }

    @Override
    public void addObservador(PanelTableObserver obs) {
        this.obss.add(obs);
    }

    @Override
    public void removerObservador(PanelTableObserver obs) {
        this.obss.remove(obs);
    }

}

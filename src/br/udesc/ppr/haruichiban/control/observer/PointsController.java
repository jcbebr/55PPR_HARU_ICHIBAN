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

    public PointsController() {
        this.cards = new Card[9];
        this.obss = new ArrayList<>();
        
        cards[0] = new Rock(1);
        cards[1] = new Rock(2);
        cards[2] = new Rock(3);
        cards[3] = new Rock(4);
        cards[4] = new Rock(5);
        cards[5] = new Rock(4);
        cards[6] = new Rock(3);
        cards[7] = new Rock(2);
        cards[8] = new Rock(1);
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
        return 9;
    }

    @Override
    public int getColumnCount() {
        return 9;
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

package br.udesc.ppr.haruichiban.control.observer;

import br.udesc.ppr.haruichiban.model.GameFlow;
import java.util.ArrayList;
import java.util.List;
import br.udesc.ppr.haruichiban.model.Deck;
import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.Gardeners;
import br.udesc.ppr.haruichiban.model.YellowDeck;
import br.udesc.ppr.haruichiban.model.card.Water;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public class YellowHandController implements PanelTableController {

    private Deck deck;
    private List<PanelTableObserver> obss;
    private int selectedCard;
    private Gardeners gardener;

    public YellowHandController() {
        this.obss = new ArrayList<>();
        this.deck = new YellowDeck();
        this.selectedCard = -1;
    }

    public Deck getDeck() {
        return deck;
    }

    public void reserveSelectedCard() {
        deck.reserveCard(selectedCard);
        selectedCard = -1;
    }

    public void removeSelectedCard() {
        deck.removeCard(selectedCard);
        selectedCard = -1;
    }

    public void removeGardener() {
        this.gardener = null;
        for (PanelTableObserver obs : obss) {
            obs.notifyChangedGardeners("");
        }
    }

    public Gardeners getGardener() {
        return gardener;
    }

    public void setGardener(Gardeners gardener) {
        this.gardener = gardener;
        for (PanelTableObserver obs : obss) {
            obs.notifyChangedGardeners(gardener.getName());
        }
    }

    public int getSelectedCardValue() throws IndexOutOfBoundsException{
        if (deck.isEmpty()) {
            throw new IndexOutOfBoundsException("amarelo");
        }
        return deck.getFlowerAt(selectedCard).getId();
    }

    @Override
    public Card getValueAt(int row, int column, boolean selected) {
        if ((selected) && (GameController.getInstance().getGameFlow().equals(GameFlow.STAGE01))) {
            try {
                return (Card) deck.getFlowerAt(column);
            } catch (IndexOutOfBoundsException e) {
                return new Water();
            }
        } else {
            try {
                deck.getFlowerAt(column);
                return (Card) deck.getFlowerFactory().buildFlower00();
            } catch (IndexOutOfBoundsException e) {
                return new Water();
            }
        }
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public void clickCell(int row, int column) {
        if (GameController.getInstance().getGameFlow().equals(GameFlow.STAGE01) && selectedCard == -1) {
            selectedCard = column;
            GameController.getInstance().nextGameFlow();
        }
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

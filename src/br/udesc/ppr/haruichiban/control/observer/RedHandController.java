package br.udesc.ppr.haruichiban.control.observer;

import br.udesc.ppr.haruichiban.model.GameFlow;
import java.util.ArrayList;
import java.util.List;
import br.udesc.ppr.haruichiban.model.Deck;
import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.Gardeners;
import br.udesc.ppr.haruichiban.model.RedDeck;
import br.udesc.ppr.haruichiban.model.card.Water;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public class RedHandController implements PanelTableController {

    private Deck deck;
    private List<PanelTableObserver> obss;
    private int selectedCard;
    private Gardeners gardener;

    public RedHandController() {
        this.deck = new RedDeck();
        this.obss = new ArrayList<>();
        this.selectedCard = -1;
    }

    public Card getSelectedCard() {
        return (Card)deck.getFlowerAt(selectedCard);
    }

    public Deck getDeck() {
        return deck;
    }

    public void removeGardener(){
        this.gardener = null;
        for (PanelTableObserver obs : obss) {
            obs.notifyChangedGardeners("");
        }
    }
    
    public void reserveSelectedCard() {
        deck.reserveCard(selectedCard);
        selectedCard = -1;
    }
    
    public void removeSelectedCard() {
        deck.removeCard(selectedCard);
        selectedCard = -1;
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
            throw new IndexOutOfBoundsException("vermelho");
        }
        return deck.getFlowerAt(selectedCard).getId();
    }

    @Override
    public Card getValueAt(int row, int column, boolean selected) {
        if ((selected) && (GameController.getInstance().getGameFlow().equals(GameFlow.STAGE02))) {
            try {
                return (Card) deck.getFlowerAt(column);
            } catch (IndexOutOfBoundsException e) {
                return new Water();
            }
        } else {
            try {
                deck.getFlowerAt(column);
                return (Card)deck.getFlowerFactory().buildFlower00();
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
        if (GameController.getInstance().getGameFlow().equals(GameFlow.STAGE02) && selectedCard == -1) {
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

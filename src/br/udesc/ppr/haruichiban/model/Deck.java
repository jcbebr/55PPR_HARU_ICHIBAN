package br.udesc.ppr.haruichiban.model;

import br.udesc.ppr.haruichiban.control.abstractfactory.FlowerFactory;
import java.util.ArrayList;
import java.util.List;
import br.udesc.ppr.haruichiban.model.card.flower.Flower;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public abstract class Deck {

    protected List<Flower> cards = new ArrayList();
    protected FlowerFactory flowerFactory;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Deck{" + "cards=" + cards + '}';
    }

    public Flower getFlowerAt(int x) {
        return cards.get(x);
    }
    
    public int getSize(){
        return cards.size();
    }

    public void removeCard(int index) {
        cards.remove(index);
    }

    public void reserveCard(int index) {
        cards.add(cards.remove(index));
    }

    public FlowerFactory getFlowerFactory() {
        return flowerFactory;
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }
}

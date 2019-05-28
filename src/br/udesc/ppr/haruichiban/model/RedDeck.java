package br.udesc.ppr.haruichiban.model;

import br.udesc.ppr.haruichiban.control.abstractfactory.RedFlowerFactory;
import java.util.Collections;

public class RedDeck extends Deck {

    public RedDeck() {
        super();

        super.flowerFactory = new RedFlowerFactory();

        super.cards.add(flowerFactory.buildFlower01());
        super.cards.add(flowerFactory.buildFlower02());
        super.cards.add(flowerFactory.buildFlower03());
        super.cards.add(flowerFactory.buildFlower04());
        super.cards.add(flowerFactory.buildFlower05());
        super.cards.add(flowerFactory.buildFlower06());
        super.cards.add(flowerFactory.buildFlower07());
        super.cards.add(flowerFactory.buildFlower08());

        Collections.shuffle(super.cards);
    }

}

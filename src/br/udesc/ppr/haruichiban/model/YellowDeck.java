package br.udesc.ppr.haruichiban.model;

import br.udesc.ppr.haruichiban.control.abstractfactory.YellowFlowerFactory;
import java.util.Collections;

public class YellowDeck extends Deck {

    public YellowDeck() {
        super();

        super.flowerFactory = new YellowFlowerFactory();

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

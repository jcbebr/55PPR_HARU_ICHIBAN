package br.udesc.ppr.haruichiban.control.builder;

import br.udesc.ppr.haruichiban.model.card.Card;
import br.udesc.ppr.haruichiban.model.card.Water;
import br.udesc.ppr.haruichiban.model.card.nenuphar.*;

/**
 *
 * @author 10480989907
 */
public class Board {

    private Card[][] cards;

    public Board() {
        this.cards = new Card[5][5];
    }

    public Card[][] getCards() {
        return cards;
    }

    public Card get(int row, int column) {
        return cards[row][column];
    }

    public int getSize() {
        return cards.length;
    }

    public void setBoard(Card[][] cards) {
        this.cards = cards;
    }

    public void setWater(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new Water(Water.class);
        } else {
            cards[row][column] = new Water(((Card) cards[row][column]).getName());
        }
    }

    public void setBrightNenuphar(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new BrightNenuphar(BrightNenuphar.class);
        } else {
            cards[row][column] = new BrightNenuphar(((Card) cards[row][column]).getName());
        }
    }

    public void setBrightNenupharRedFlower(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new BrightNenupharRedFlower(BrightNenupharRedFlower.class);
        } else {
            cards[row][column] = new BrightNenupharRedFlower(((Card) cards[row][column]).getName());
        }
    }

    public void setBrightNenupharYellowFlower(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new BrightNenupharYellowFlower(BrightNenupharYellowFlower.class);
        } else {
            cards[row][column] = new BrightNenupharYellowFlower(((Card) cards[row][column]).getName());
        }
    }

    public void setDarkNenuphar(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new DarkNenuphar(DarkNenuphar.class);
        } else {
            cards[row][column] = new DarkNenuphar(((Card) cards[row][column]).getName());
        }
    }

    public void setDarkNenupharYellowFlower(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new DarkNenupharYellowFlower(DarkNenupharYellowFlower.class);
        } else {
            cards[row][column] = new DarkNenupharYellowFlower(((Card) cards[row][column]).getName());
        }
    }

    public void setDarkNenupharRedFlower(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new DarkNenupharRedFlower(DarkNenupharRedFlower.class);
        } else {
            cards[row][column] = new DarkNenupharRedFlower(((Card) cards[row][column]).getName());
        }
    }

    public void setRedFrog(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new BrightNenupharRedFrog(BrightNenupharRedFrog.class);
        } else {
            cards[row][column] = new BrightNenupharRedFrog(((Card) cards[row][column]).getName());
        }
    }

    public void setYellowFrog(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new BrightNenupharYellowFrog(BrightNenupharYellowFrog.class);
        } else {
            cards[row][column] = new BrightNenupharYellowFrog(((Card) cards[row][column]).getName());
        }
    }
}

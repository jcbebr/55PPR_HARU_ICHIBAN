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
        cards[row][column] = new Water();
    }

    public void setBrightNenuphar(int row, int column) {
        cards[row][column] = new BrightNenuphar();
    }

    public void setBrightNenupharRedFlower(int row, int column) {
        cards[row][column] = new BrightNenupharRedFlower();
    }

    public void setBrightNenupharYellowFlower(int row, int column) {
        cards[row][column] = new BrightNenupharYellowFlower();
    }

    public void setDarkNenuphar(int row, int column, boolean father) {
        cards[row][column] = new DarkNenuphar(father);
    }

    public void setDarkNenupharYellowFlower(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new DarkNenupharYellowFlower(false);
        } else {
            cards[row][column] = new DarkNenupharYellowFlower(((DarkNenuphar)cards[row][column]).isFather());
        }
    }

    public void setDarkNenupharRedFlower(int row, int column) {
        if (cards[row][column] == null) {
            cards[row][column] = new DarkNenupharRedFlower(false);
        } else {
            cards[row][column] = new DarkNenupharRedFlower(((DarkNenuphar)cards[row][column]).isFather());
        }
    }

    public void setRedFrog(int row, int column) {
        cards[row][column] = new BrightNenupharRedFrog();
    }

    public void setYellowFrog(int row, int column) {
        cards[row][column] = new BrightNenupharYellowFrog();
    }
}

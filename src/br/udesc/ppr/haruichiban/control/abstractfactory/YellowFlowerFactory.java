package br.udesc.ppr.haruichiban.control.abstractfactory;

import br.udesc.ppr.haruichiban.model.card.flower.*;

public class YellowFlowerFactory extends FlowerFactory {

    @Override
    public Flower buildFlower00() {
        return new YellowFlower00();
    }

    @Override
    public Flower buildFlower01() {
        return new YellowFlower01();
    }

    @Override
    public Flower buildFlower02() {
        return new YellowFlower02();
    }

    @Override
    public Flower buildFlower03() {
        return new YellowFlower03();
    }

    @Override
    public Flower buildFlower04() {
        return new YellowFlower04();
    }

    @Override
    public Flower buildFlower05() {
        return new YellowFlower05();
    }

    @Override
    public Flower buildFlower06() {
        return new YellowFlower06();
    }

    @Override
    public Flower buildFlower07() {
        return new YellowFlower07();
    }

    @Override
    public Flower buildFlower08() {
        return new YellowFlower08();
    }

}

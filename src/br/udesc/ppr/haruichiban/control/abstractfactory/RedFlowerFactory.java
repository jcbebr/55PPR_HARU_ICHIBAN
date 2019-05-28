package br.udesc.ppr.haruichiban.control.abstractfactory;

import br.udesc.ppr.haruichiban.model.card.flower.*;

public class RedFlowerFactory extends FlowerFactory {

    @Override
    public Flower buildFlower00() {
        return new RedFlower00();
    }

    @Override
    public Flower buildFlower01() {
        return new RedFlower01();
    }

    @Override
    public Flower buildFlower02() {
        return new RedFlower02();
    }

    @Override
    public Flower buildFlower03() {
        return new RedFlower03();
    }

    @Override
    public Flower buildFlower04() {
        return new RedFlower04();
    }

    @Override
    public Flower buildFlower05() {
        return new RedFlower05();
    }

    @Override
    public Flower buildFlower06() {
        return new RedFlower06();
    }

    @Override
    public Flower buildFlower07() {
        return new RedFlower07();
    }

    @Override
    public Flower buildFlower08() {
        return new RedFlower08();
    }

}

package br.udesc.ppr.haruichiban.control.builder;

public class TestBuilder extends Builder {

    @Override
    public void buildWater() {
        this.board.setBrightNenupharRedFlower(0, 0);
        this.board.setBrightNenupharRedFlower(0, 1);
        this.board.setBrightNenupharRedFlower(0, 2);
        this.board.setBrightNenupharRedFlower(0, 3);
        this.board.setBrightNenupharRedFlower(0, 4);
        this.board.setWater(1, 0);
        this.board.setBrightNenupharRedFlower(1, 1);
        this.board.setWater(1, 2);
        this.board.setBrightNenupharRedFlower(1, 3);
        this.board.setBrightNenupharRedFlower(1, 4);
        this.board.setWater(2, 0);
        this.board.setWater(2, 1);
        this.board.setBrightNenupharRedFlower(2, 2);
        //this.board.setWater(2, 2);
        this.board.setWater(2, 3);
        this.board.setBrightNenupharRedFlower(2, 4);
        this.board.setWater(3, 0);
        this.board.setBrightNenupharRedFlower(3, 1);
        this.board.setWater(3, 2);
        this.board.setBrightNenupharRedFlower(3, 3);
        this.board.setBrightNenupharRedFlower(3, 4);
        this.board.setDarkNenuphar(4, 0);
        this.board.setWater(4, 1);
        this.board.setWater(4, 2);
        this.board.setBrightNenupharRedFlower(4, 3);
        this.board.setBrightNenupharRedFlower(4, 4);
    }

    @Override
    public void buildBrightNenuphar() {
    }

    @Override
    public void buildDarkNenuphar() {
    }

    @Override
    public void buildRedFrog() {
    }

    @Override
    public void buildYellowFrog() {
    }

}

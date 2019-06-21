package br.udesc.ppr.haruichiban.control.builder;

public class EasyBuilder extends Builder {

    @Override
    public void buildWater() {
        this.board.setWater(0, 1);
        this.board.setWater(0, 3);
        this.board.setWater(1, 0);
        this.board.setWater(1, 4);
        this.board.setWater(2, 2);
        this.board.setWater(3, 0);
        this.board.setWater(3, 4);
        this.board.setWater(4, 1);
        this.board.setWater(4, 3);
    }

    @Override
    public void buildBrightNenuphar() {
        this.board.setBrightNenuphar(0,0);
        this.board.setBrightNenuphar(0,2);
        this.board.setBrightNenuphar(0,4);
        this.board.setBrightNenuphar(1,1);
        this.board.setBrightNenuphar(2,0);
        this.board.setBrightNenuphar(2,1);
        this.board.setBrightNenuphar(2,3);
        this.board.setBrightNenuphar(2,4);
        this.board.setBrightNenuphar(3,1);
        this.board.setBrightNenuphar(3,2);
        this.board.setBrightNenuphar(4,0);
        this.board.setBrightNenuphar(4,2);
        this.board.setBrightNenuphar(4,4);
    }

    @Override
    public void buildDarkNenuphar() {
        this.board.setDarkNenuphar(1, 3);
    }

    @Override
    public void buildRedFrog() {
        this.board.setRedFrog(3, 3);
    }

    @Override
    public void buildYellowFrog() {
        this.board.setYellowFrog(1, 2);
    }

    
    
}

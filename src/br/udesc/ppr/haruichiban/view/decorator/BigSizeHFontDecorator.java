package br.udesc.ppr.haruichiban.view.decorator;

public class BigSizeHFontDecorator extends HFontDecorator {

    public BigSizeHFontDecorator(HFont hFont) {
        super(hFont);
    }

    @Override
    public int size() {
        return 20;
    }

}

package br.udesc.ppr.haruichiban.view.decorator;

public class SmallSizeHFontDecorator extends HFontDecorator {

    public SmallSizeHFontDecorator(HFont hFont) {
        super(hFont);
    }

    @Override
    public int size() {
        return 10;
    }

}

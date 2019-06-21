package br.udesc.ppr.haruichiban.view.decorator;

public class NormalSizeHFontDecorator extends HFontDecorator {

    public NormalSizeHFontDecorator(HFont hFont) {
        super(hFont);
    }

    @Override
    public int size() {
        return 15;
    }

}

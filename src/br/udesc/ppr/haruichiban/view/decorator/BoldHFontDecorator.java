package br.udesc.ppr.haruichiban.view.decorator;

import java.awt.Font;

public class BoldHFontDecorator extends HFontDecorator {

    public BoldHFontDecorator(HFont hFont) {
        super(hFont);
    }

    @Override
    public int style() {
        return Font.BOLD;
    }
    
}

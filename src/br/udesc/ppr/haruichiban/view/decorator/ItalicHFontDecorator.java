package br.udesc.ppr.haruichiban.view.decorator;

import java.awt.Font;

public class ItalicHFontDecorator extends HFontDecorator {

    public ItalicHFontDecorator(HFont hFont) {
        super(hFont);
    }

    @Override
    public int style() {
        return Font.ITALIC;
    }
    
}

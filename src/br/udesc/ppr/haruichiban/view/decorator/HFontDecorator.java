package br.udesc.ppr.haruichiban.view.decorator;

import java.awt.Font;

public abstract class HFontDecorator implements HFont {

    private HFont hFont;

    public HFontDecorator(HFont hFont) {
        this.hFont = hFont;
    }

    @Override
    public Font getFont() {
        return hFont.getFont().deriveFont(style(), size());
    }

    @Override
    public int size(){
        return hFont.size();
    }

    @Override
    public int style(){
        return hFont.style();
    }
    
}

package br.udesc.ppr.haruichiban.view.decorator;

import java.awt.Font;

public class ConsolasSimpleHFont implements HFont {

    private Font font;

    public ConsolasSimpleHFont() {
        this.font = new Font("Consolas", Font.PLAIN, 1);
    }

    @Override
    public Font getFont() {
        return this.font;
    }

    @Override
    public int style() {
        return font.getStyle();
    }

    @Override
    public int size() {
        return font.getSize();
    }
    
}

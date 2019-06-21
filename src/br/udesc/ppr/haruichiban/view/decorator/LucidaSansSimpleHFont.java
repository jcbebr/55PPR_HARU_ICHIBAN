package br.udesc.ppr.haruichiban.view.decorator;

import java.awt.Font;

public class LucidaSansSimpleHFont implements HFont {

    private Font font;

    public LucidaSansSimpleHFont() {
        this.font = new Font("Lucida Sans", Font.PLAIN, 1);
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

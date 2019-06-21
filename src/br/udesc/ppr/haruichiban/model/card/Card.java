package br.udesc.ppr.haruichiban.model.card;

import br.udesc.ppr.haruichiban.control.visitor.Visitor;
import javax.swing.ImageIcon;

/**
 * @author José Carlos Bernardes Brümmer
 * @since 20/04/2019
 */
public abstract class Card {

    private final ImageIcon image;

    public Card(String imageName, Class name) {
        this.image = new ImageIcon("images/" + imageName + ".png");
        this.name = name;
    }

    public ImageIcon getImage() {
        return image;
    }

    private final Class name;

    public Class getName() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}

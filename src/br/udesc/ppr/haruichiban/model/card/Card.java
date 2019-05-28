package br.udesc.ppr.haruichiban.model.card;

import javax.swing.ImageIcon;

/**
 * @author José Carlos Bernardes Brümmer
 * @since 20/04/2019
 */
public abstract class Card {

    private final ImageIcon image;

    public Card(String imageName) {
        this.image = new ImageIcon("images/" + imageName + ".png");
    }

    public ImageIcon getImage() {
        return image;
    }

}

package br.udesc.ppr.haruichiban.model.card.flower;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 14/05/2019
 */
public class YellowFlower04 extends Card implements YellowFlower {

    public YellowFlower04() {
        super("YellowFlower04", RedFlower.class);
    }

    @Override
    public int getId() {
        return 4;
    }

}

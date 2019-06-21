package br.udesc.ppr.haruichiban.model.card.flower;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 16/06/2019
 */
public class YellowFlower07 extends Card implements YellowFlower {

    public YellowFlower07() {
        super("YellowFlower07", RedFlower.class);
    }

    @Override
    public int getId() {
        return 7;
    }

}

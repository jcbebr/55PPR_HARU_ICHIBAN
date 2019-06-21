package br.udesc.ppr.haruichiban.model.card.flower;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 13/05/2019
 */
public class YellowFlower03 extends Card implements YellowFlower {

    public YellowFlower03() {
        super("YellowFlower03", RedFlower.class);
    }

    @Override
    public int getId() {
        return 3;
    }

}

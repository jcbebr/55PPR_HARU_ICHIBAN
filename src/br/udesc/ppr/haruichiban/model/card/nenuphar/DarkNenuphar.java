package br.udesc.ppr.haruichiban.model.card.nenuphar;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public class DarkNenuphar extends Nenuphar {

    private boolean father;

    public boolean isFather() {
        return father;
    }
    
    public DarkNenuphar(boolean father) {
        super("DarkNenuphar");
        this.father = father;
    }

    public DarkNenuphar(String imageName, boolean father) {
        super(imageName);
        this.father = father;
    }

}

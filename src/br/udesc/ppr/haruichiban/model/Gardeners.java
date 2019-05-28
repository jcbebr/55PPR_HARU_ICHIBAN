package br.udesc.ppr.haruichiban.model;

/**
 *
 * @author José Carlos Bernardes Brümmer
 */
public enum Gardeners {
    
    JUNIOR("Jardineiro Júnior"),
    SENIOR("Jardineiro Sênior");

    private final String name;

    private Gardeners(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

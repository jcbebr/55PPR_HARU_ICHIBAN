package br.udesc.ppr.haruichiban.control.observer;

import br.udesc.ppr.haruichiban.model.card.Card;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 01/05/2019
 */
public interface PanelTableController {

    Card getValueAt(int row, int column, boolean selected);

    int getRowCount();

    int getColumnCount();

    void clickCell(int row, int column);

    void addObservador(PanelTableObserver obs);

    void removerObservador(PanelTableObserver obs);

}

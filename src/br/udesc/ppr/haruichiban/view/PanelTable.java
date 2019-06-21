package br.udesc.ppr.haruichiban.view;

import br.udesc.ppr.haruichiban.control.observer.PanelTableController;
import br.udesc.ppr.haruichiban.control.observer.PanelTableObserver;
import br.udesc.ppr.haruichiban.view.decorator.BigSizeHFontDecorator;
import br.udesc.ppr.haruichiban.view.decorator.BoldHFontDecorator;
import br.udesc.ppr.haruichiban.view.decorator.ConsolasSimpleHFont;
import br.udesc.ppr.haruichiban.view.decorator.ItalicHFontDecorator;
import br.udesc.ppr.haruichiban.view.decorator.NormalSizeHFontDecorator;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 21/04/2019
 */
public abstract class PanelTable extends JPanel implements PanelTableObserver {

    protected final JTable table;
    private final JLabel gardener;
    private PanelTableController controller;

    public PanelTable(PanelTableController controller, int x, int y) {
        this.controller = controller;
        this.controller.addObservador(this);
        PanelTableUtils paUtils = new PanelTableUtils(this, controller);

        gardener = new JLabel();
        gardener.setForeground(Color.WHITE);
        gardener.setFont(new BigSizeHFontDecorator(new ItalicHFontDecorator(new ConsolasSimpleHFont())).getFont());

        table = new JTable(paUtils.getPanelTableModel());

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setWidth(paUtils.getCellSize());
            table.getColumnModel().getColumn(i).setMinWidth(paUtils.getCellSize());
            table.getColumnModel().getColumn(i).setMaxWidth(paUtils.getCellSize());
        }
        table.setRowHeight(paUtils.getCellSize());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setDefaultRenderer(Object.class, paUtils.getPanelTableRenderer());
        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        table.setSize(paUtils.getCellSize() * table.getColumnModel().getColumnCount(),
                paUtils.getCellSize() * table.getColumnModel().getColumnCount());

        table.addMouseListener(paUtils.getPanelTableMouseListener());

        super.add(table);
        super.setLocation(x, y);
        super.setSize(paUtils.getCellSize() * table.getColumnModel().getColumnCount(),
                paUtils.getCellSize() * table.getColumnModel().getColumnCount() + 5);
        super.setOpaque(false);

        super.add(gardener);

    }

    @Override
    public void notifyChangedCards() {
        table.repaint();
    }

    @Override
    public void notifyChangedGardeners(String name) {
        gardener.setText(name);
    }

}

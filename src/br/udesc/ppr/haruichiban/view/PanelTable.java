package br.udesc.ppr.haruichiban.view;

import br.udesc.ppr.haruichiban.control.observer.PanelTableController;
import br.udesc.ppr.haruichiban.control.observer.PanelTableObserver;
import br.udesc.ppr.haruichiban.control.observer.PointsController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 21/04/2019
 */
public abstract class PanelTable extends JPanel implements PanelTableObserver {

    protected final JTable table;
    private final JLabel gardener;
    protected int cellSize = 64; //pixels
    private PanelTableController controller;
    private Boolean selected = false;

    private class PanelTableRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon((ImageIcon) value);
            setSize(cellSize, cellSize);
            return this;
        }
    }

    /**
     *
     * @author José Carlos Bernardes Brümmer
     * @date 20/04/2019
     */
    private class PanelTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return controller.getRowCount();
        }

        @Override
        public int getColumnCount() {
            return controller.getColumnCount();
        }

        @Override
        public ImageIcon getValueAt(int row, int column) {
            return new ImageIcon(controller.getValueAt(row, column, selected).getImage().getImage().getScaledInstance(cellSize, cellSize, java.awt.Image.SCALE_SMOOTH));
        }
    }

    /**
     *
     */
    private class PanelTableMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            controller.clickCell(table.rowAtPoint(e.getPoint()), table.columnAtPoint(e.getPoint()));
            table.repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            selected = true;
            table.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            selected = false;
            table.repaint();
        }
    }

    public PanelTable(PanelTableController controller, int x, int y) {
        this.controller = controller;
        this.controller.addObservador(this);

        if (controller.getClass().equals(PointsController.class)) {
            cellSize = 35;
        }

        gardener = new JLabel();
        gardener.setForeground(Color.WHITE);
        gardener.setFont(new Font("Consolas", 1, 15));

        table = new JTable(new PanelTableModel());

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setWidth(cellSize);
            table.getColumnModel().getColumn(i).setMinWidth(cellSize);
            table.getColumnModel().getColumn(i).setMaxWidth(cellSize);
        }
        table.setRowHeight(cellSize);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setDefaultRenderer(Object.class, new PanelTableRenderer());
        //table.setVisible(true);
        table.setOpaque(false);
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);

        table.setSize(cellSize * table.getColumnModel().getColumnCount(),
                cellSize * table.getColumnModel().getColumnCount());

        table.addMouseListener(new PanelTableMouseListener());

        super.add(table);
        super.setLocation(x, y);
        super.setSize(cellSize * table.getColumnModel().getColumnCount(),
                cellSize * table.getColumnModel().getColumnCount() + 5);
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

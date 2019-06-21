
package br.udesc.ppr.haruichiban.view;

import br.udesc.ppr.haruichiban.control.observer.PanelTableController;
import br.udesc.ppr.haruichiban.control.observer.PointsController;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 20/06/2019
 */
public class PanelTableUtils {
    
    private final PanelTable ptable;
    private final PanelTableRenderer panelTableRenderer;
    private final PanelTableModel panelTableModel;
    private final PanelTableMouseListener panelTableMouseListener;
    private PanelTableController controller;
    private Boolean selected;
    protected int cellSize;
    
    public PanelTableUtils(PanelTable pTable, PanelTableController controller) {
        this.panelTableRenderer = new PanelTableRenderer();
        this.panelTableModel = new PanelTableModel();
        this.panelTableMouseListener = new PanelTableMouseListener();
        this.selected = false;
        this.ptable = pTable;
        this.controller = controller;
        if (controller.getClass().equals(PointsController.class)) {
            cellSize = 35;
        } else {
            cellSize = 64;
        }
    }

    public PanelTableRenderer getPanelTableRenderer() {
        return panelTableRenderer;
    }

    public PanelTableModel getPanelTableModel() {
        return panelTableModel;
    }

    public PanelTableMouseListener getPanelTableMouseListener() {
        return panelTableMouseListener;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    
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
            controller.clickCell(ptable.table.rowAtPoint(e.getPoint()), ptable.table.columnAtPoint(e.getPoint()));
            ptable.table.repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            selected = true;
            ptable.table.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            selected = false;
            ptable.table.repaint();
        }
    }
    
}

package br.udesc.ppr.haruichiban.view;

import br.udesc.ppr.haruichiban.control.observer.GameController;
import br.udesc.ppr.haruichiban.control.observer.PanelTableController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class Points extends PanelTable {

    public Points(PanelTableController controller) {
        super(controller, 1200, 165);
        this.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                GameController.getInstance().nextRound();
                System.out.print("1");
            }
        });
    }

    @Override
    public void not() {

    }

}

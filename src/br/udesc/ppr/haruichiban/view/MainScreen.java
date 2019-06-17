package br.udesc.ppr.haruichiban.view;

import br.udesc.ppr.haruichiban.control.observer.MainScreenObserver;
import br.udesc.ppr.haruichiban.control.observer.GameController;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author José Carlos Bernardes Brümmer
 * @date 21/04/2019
 */
public class MainScreen extends JFrame implements MainScreenObserver {

    private JPanel contentPane;

    private JTextArea lbRoundInfo;
    private JTextArea lbDetailInfo;
    private JTextArea lbNewGame;

    public MainScreen() throws HeadlessException {
        super("55PPR - Haru Ichiban");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        GameController.getInstance().addObservador(this);

        super.setVisible(true);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
    }

    private void initComponents() {
        contentPane = new ImagePanel("Background");
        getContentPane().add(contentPane);

        contentPane.add(new Board(GameController.getInstance().getBoardController()));
        contentPane.add(new YellowHand(GameController.getInstance().getYellowHandController()));
        contentPane.add(new RedHand(GameController.getInstance().getRedHandController()));
        contentPane.add(new Points(GameController.getInstance().getPointsController()));
        
        lbRoundInfo = addLabel(400, 20, 70, 200, 15);
        lbRoundInfo.setText(GameController.getInstance().getStage().getName());
        lbDetailInfo = addLabel(500, 50, 80, 230, 15);
        lbDetailInfo.setText(GameController.getInstance().getStage().getInfo());
        lbNewGame = addLabel(200, 40, 50, 670, 30);
        lbNewGame.setText("Novo jogo");
        lbNewGame.addMouseListener(newGameMouseListener());

        contentPane.add(lbRoundInfo);
        contentPane.add(lbDetailInfo);
        contentPane.add(lbNewGame);

        pack();
    }

    private JTextArea addLabel(int sizeX, int sizeY, int posX, int posY, int fontSize) {
        JTextArea textArea = new JTextArea("");
        textArea.setSize(sizeX, sizeY);
        textArea.setLocation(posX, posY);
        textArea.setVisible(true);
        textArea.setFont(new Font("Lucida Sans", 1, fontSize));
        textArea.setEditable(false);
        textArea.setOpaque(false);
        return textArea;
    }

    @Override
    public void notifyNextRoundStep(String round, String info) {
        lbRoundInfo.setText(round);
        lbDetailInfo.setText(info);
    }

    @Override
    public void notifyEmptyDesck(String deck) {
        JOptionPane.showMessageDialog(this, "O baralho " + deck + " está vazio", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void notifyNextRound(String winner) {
        JOptionPane.showMessageDialog(this, "Fim da rodada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void notifyGameOver(String winner){
        JOptionPane.showMessageDialog(this, "Gameober", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private MouseListener newGameMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                GameController.getInstance().kill();
                dispose();
                new MainScreen();
            }
        };
    }
    
}

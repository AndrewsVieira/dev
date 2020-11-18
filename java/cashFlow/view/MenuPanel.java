package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
    Frame frame;

    private JButton btnMain;
    private JButton btnPay;
    private JButton btnToReceive;
    private JButton btnExtract;

    public MenuPanel(Frame frame) {
        this.frame = frame;

        createBtnMain();
        createBtnPay();
        createBtnToReceive();
        createBtnExtract();
    }

    private void createBtnMain() {
        btnMain = new JButton("Principal");
        add(btnMain);
        btnMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.showMainPanel();
            }
        });
    }

    private void createBtnPay() {
        btnPay = new JButton("Pagar");
        add(btnPay);
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.showPayPanel();
            };
        });
    }

    private void createBtnToReceive() {
        btnToReceive = new JButton("Receber");
        add(btnToReceive);
        btnToReceive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.showToReceivePanel();
            }
        });
    }

    private void createBtnExtract() {
        btnExtract = new JButton("Extrato");
        add(btnExtract);
        btnExtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.showCashFlowPanel();
            }
        });
    }
}

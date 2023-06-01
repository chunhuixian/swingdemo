package com.plugin.chatgpt.ui.window;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;


public class NexSendListener implements ActionListener, KeyListener {
    private final MainPanel mainPanel;
    private static boolean enterKeyEffect = true;


    public NexSendListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.doActionPerformedNex();
    }

    public void doActionPerformedNex() {
        String text = this.mainPanel.getSearchTextArea().getTextArea().getText();
        System.out.println();
//        if (text != null && !text.equals("")) {
//            this.setEnterKeyFalse();
//
//            try {
//
//            } catch (Exception var4) {
//                this.mainPanel.showInfo("获取登录二维码失败，请再试一次。");
//                this.setEnterKeyTrue();
//                return;
//            }
//
//            this.mainPanel.loadingPanel();
//            (new Thread(() -> {
//                this.mainPanel.showResult(text, this);
//            })).start();
//        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10 && enterKeyEffect) {
            if (e.isShiftDown() || e.isControlDown() || e.isAltDown() || e.isAltGraphDown() || e.isMetaDown()) {
                return;
            }

            e.consume();
            this.doActionPerformedNex();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

//    public void setEnterKeyTrue() {
//        enterKeyEffect = true;
//        JButton button = this.mainPanel.getButton();
//        button.setEnabled(true);
//    }
//
//    public void setEnterKeyFalse() {
//        enterKeyEffect = false;
//        JButton button = this.mainPanel.getButton();
//        button.setEnabled(false);
//    }
}
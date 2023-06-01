package com.plugin.chatgpt.ui.window;

import com.intellij.find.SearchTextArea;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.OnePixelSplitter;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;
import com.intellij.util.ui.JBInsets;
import com.intellij.util.ui.UIUtil;
import com.plugin.chatgpt.constant.ConfigConstants;
import com.plugin.chatgpt.util.LocaleUtil;
import com.plugin.chatgpt.util.NexHttpUtil;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainPanel {
    private final JPanel mainPanel;
    private final SearchTextArea searchTextArea;
//    private final JButton button;
    private final OnePixelSplitter splitter;
    private JPanel centerJPanel = new JPanel(new BorderLayout());
    private JPanel southJPanel = new JPanel(new BorderLayout());
    private final ImageIcon loadingImageIcon = new ImageIcon(NexHttpUtil.class.getResource("/icons/loading.gif"));
    private static NexSendListener listener;

    public static NexSendListener getListener() {
        return listener;
    }

    public MainPanel() {
        listener = new NexSendListener(this);
        this.splitter = new OnePixelSplitter(true, 0.1F);
        this.splitter.setDividerWidth(2);
        JBTextArea jbTextArea = new JBTextArea();
        jbTextArea.setLineWrap(true);
        jbTextArea.setWrapStyleWord(true);
        this.searchTextArea = new SearchTextArea(jbTextArea, true, true);
        this.searchTextArea.getTextArea().addKeyListener(listener);
        this.searchTextArea.setPreferredSize(new Dimension(this.searchTextArea.getWidth(), 100));
//        this.button = new JButton("Send", IconLoader.getIcon("/icons/send.svg", MainPanel.class));
//        this.button.addActionListener(listener);
        JPanel top = new JPanel(new BorderLayout());
        top.add(this.searchTextArea, "Center");
//        top.add(this.button, "East");
        top.setBorder(UIUtil.getTextFieldBorder());
        this.mainPanel = new JPanel(new BorderLayout());
        this.mainPanel.add(this.centerJPanel, "Center");
        this.mainPanel.add(this.southJPanel, "South");
        this.splitter.setFirstComponent(top);
        this.splitter.setSecondComponent(this.mainPanel);
//        this.showWelcome();
        this.donatePanel();
    }

    public SearchTextArea getSearchTextArea() {
        return this.searchTextArea;
    }

    public JPanel init() {
        return splitter;
    }

//    public JButton getButton() {
//        return this.button;
//    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public void loadingPanel() {
        this.centerJPanel.removeAll();
        this.centerJPanel.add(new JLabel("Loading...", this.loadingImageIcon, 0));
        this.centerJPanel.doLayout();
    }

    public void donatePanel() {
        if (LocaleUtil.isChina()) {
            this.southJPanel.add(new JLabel("<html><a href=''>捐赠</a></html>", 0));
            this.goWebsite(this.southJPanel, ConfigConstants.DONATE_URL);
        } else {
            this.southJPanel.add(new JLabel("<html><a href=''>Donate</a></html>", 0));
            this.goWebsite(this.southJPanel, ConfigConstants.DONATE_URL);
        }

    }

//    public void showInfo(String text) {
//        this.centerJPanel.removeAll();
//        this.centerJPanel.add(new JLabel(text, 0), "Center");
//        this.centerJPanel.doLayout();
//    }

//    public void showResult(String text, NexSendListener nexSendListener) {
//        try {
//            JBScrollPane resultPane = new JBScrollPane();
//            JTextArea answer = new JTextArea();
//            answer.setLineWrap(true);
//            answer.setWrapStyleWord(true);
//            answer.setMargin(new JBInsets(0, 15, 0, 15));
//            resultPane.setViewportView(answer);
//            NexHttpUtil.showResult(text, this.centerJPanel, resultPane, answer);
//            nexSendListener.setEnterKeyTrue();
//        } catch (Exception var8) {
//            this.showInfo("系统繁忙，请稍后再试");
//        } finally {
//            this.button.setEnabled(true);
//        }
//
//    }

//    public void showWelcome() {
//        JLabel welcomeJPanel = new JLabel(ConfigConstants.HOME_TITLE, 0);
//        this.centerJPanel.add(welcomeJPanel, "Center");
//        this.goWebsite(welcomeJPanel, ConfigConstants.HOME_URL);
//    }
//
    private void goWebsite(JComponent website, final String url) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception var3) {
                }

            }
        });
    }
}
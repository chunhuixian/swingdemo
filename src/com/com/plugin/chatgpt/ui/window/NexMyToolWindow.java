package com.com.plugin.chatgpt.ui.window;

import com.plugin.chatgpt.ui.window.MainPanel;

import javax.swing.*;

public class NexMyToolWindow {
    public NexMyToolWindow() {
    }

    public JPanel getNexContent() {
        return new MainPanel().init();
    }
}

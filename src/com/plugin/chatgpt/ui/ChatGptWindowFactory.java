package com.plugin.chatgpt.ui;

import com.com.plugin.chatgpt.ui.window.NexMyToolWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class ChatGptWindowFactory implements ToolWindowFactory {
    public ChatGptWindowFactory() {
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

        NexMyToolWindow noteListWindow = new NexMyToolWindow();
        ContentFactory instance = ContentFactory.SERVICE.getInstance();
        Content content = instance.createContent(noteListWindow.getNexContent(), "Search", false);
        toolWindow.getContentManager().addContent(content);
    }
}
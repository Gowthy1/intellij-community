// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.find.editorHeaderActions;

import com.intellij.find.SearchSession;
import com.intellij.ide.lightEdit.LightEditCompatible;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ex.CustomComponentAction;
import com.intellij.openapi.project.DumbAwareAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class StatusTextAction extends DumbAwareAction implements CustomComponentAction, LightEditCompatible {
  @Override
  public void update(@NotNull AnActionEvent e) {
    SearchSession search = e.getData(SearchSession.KEY);
    String statusText = search == null ? "" : search.getComponent().getStatusText();
    JLabel label = (JLabel)e.getPresentation().getClientProperty(COMPONENT_KEY);
    if (label != null) {
      label.setText(statusText);
    }
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
  }

  @NotNull
  @Override
  public JComponent createCustomComponent(@NotNull Presentation presentation, @NotNull String place) {
    JLabel label = new JLabel();
    //noinspection HardCodedStringLiteral
    label.setText("9888 results");
    label.setPreferredSize(label.getPreferredSize());
    label.setText(null);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    return label;
  }
}

package com.liang;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import org.apache.http.util.TextUtils;

import java.awt.*;
import java.util.concurrent.CompletableFuture;

/**
 * @author liangyehao
 */
public class MyTranslationAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        try {
            if (null == mEditor) {
                return;
            }
            SelectionModel model = mEditor.getSelectionModel();
            final String selectedText = model.getSelectedText();
            if (TextUtils.isEmpty(selectedText)) {
                return;
            }
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> HttpUtils.sendGet(selectedText, "UTF-8"));
            showPopupBalloon(mEditor,future.get());
        } catch (Exception ex) {
            ex.printStackTrace();
            showPopupBalloon(mEditor,"fail... please try again later...");
        }
    }

    private void showPopupBalloon(final Editor editor, final String result) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                JBPopupFactory factory = JBPopupFactory.getInstance();
                factory.createHtmlTextBalloonBuilder(result, null, new JBColor(new Color(186, 238, 186), new Color(73, 117, 73)), null)
                        .setFadeoutTime(5000)
                        .createBalloon()
                        .show(factory.guessBestPopupLocation(editor), Balloon.Position.below);
            }
        });
    }
}

package com.ftinc.plugin.generator.sectionblock;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;

/**
 * Created by drew.heavner on 3/4/15.
 */
public class GenerateSectionBlockComment extends AnAction {

    private static final String SECTION_COMMENT =
            "/***********************************************************************************************\n" +
            "     *\n" +
            "     * SECTION\n" +
            "     *\n" +
            "     */";

    @Override
    public void actionPerformed(AnActionEvent e) {

        // Get the offset in the current editor
        DataContext dataContext = e.getDataContext();
        Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
        final Document document = editor.getDocument();
        final int offset = editor.getCaretModel().getOffset();

        // Insert the block comment at the cursor position
        new WriteCommandAction(e.getProject()){
            @Override
            protected void run(Result result) throws Throwable {
                document.insertString(offset, SECTION_COMMENT);
            }
        }.execute();

    }

}

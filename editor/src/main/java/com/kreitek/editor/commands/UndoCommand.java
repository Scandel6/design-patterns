package com.kreitek.editor.commands;

import com.kreitek.editor.Document;
import com.kreitek.editor.interfaces.Command;

public class UndoCommand implements Command {
    @Override
    public void execute(Document document) {
        document.pop();
    }
}

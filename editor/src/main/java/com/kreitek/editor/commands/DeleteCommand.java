package com.kreitek.editor.commands;

import com.kreitek.editor.Document;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(Document document) {
        ArrayList <String> temp = (ArrayList<String>) document.peek().clone();
        temp.remove(lineNumber);
        document.add(temp);
    }
}

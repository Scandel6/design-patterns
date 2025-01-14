package com.kreitek.editor.commands;

import com.kreitek.editor.Document;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;

    public UpdateCommand(String text, int lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(Document document) {
        ArrayList <String> newDocumentSnapshot = (ArrayList<String>) document.peek().clone();
        if (newDocumentSnapshot.size() > lineNumber)
            newDocumentSnapshot.set(lineNumber, text);
        else
            newDocumentSnapshot.add(text);
        document.add(newDocumentSnapshot);
    }
}

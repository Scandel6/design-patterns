package com.kreitek.editor.commands;

import com.kreitek.editor.Document;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(Document document) {
        ArrayList <String> newDocumentSnapshot = (ArrayList<String>) document.peek().clone();
        newDocumentSnapshot.add(text);
        document.add(newDocumentSnapshot);
    }
}

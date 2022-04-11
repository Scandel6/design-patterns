package com.kreitek.editor.interfaces;

import com.kreitek.editor.Document;

public interface Command {
    void execute(Document document);
}

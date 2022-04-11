package com.kreitek.editor.editors;

import java.util.ArrayList;

public class ConsoleEditor extends Editor {

    @Override
    protected void showDocumentLines() {
        ArrayList<String> textLines = document.peek();
        if (textLines.size() > 0){
            setTextColor(TEXT_YELLOW);
            printLnToConsole("START DOCUMENT ==>");
            for (int index = 0; index < textLines.size(); index++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(index);
                stringBuilder.append("] ");
                stringBuilder.append(textLines.get(index));
                printLnToConsole(stringBuilder.toString());
            }
            printLnToConsole("<== END DOCUMENT");
            setTextColor(TEXT_RESET);
        }
    }

}

package com.kreitek.editor.editors;

import java.util.ArrayList;

public class JsonEditor extends Editor{
    @Override
    protected void showDocumentLines() {
        ArrayList<String> textLines = document.peek();
        if (textLines.size() > 0){
            printToConsole("{\n");
            printLnToConsole("\t\"doc\":[");
            for (int index = 0; index < textLines.size(); index++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\t\t");
                stringBuilder.append("{\"line\":\"");
                stringBuilder.append(index);
                stringBuilder.append("\",\"text\":\"");
                stringBuilder.append(textLines.get(index));
                stringBuilder.append("\"}");
                if(index != textLines.size()-1)
                    stringBuilder.append(",");
                printLnToConsole(stringBuilder.toString());
            }
            printLnToConsole("\t]");
            printLnToConsole("}");
            setTextColor(TEXT_RESET);
        }
    }
}

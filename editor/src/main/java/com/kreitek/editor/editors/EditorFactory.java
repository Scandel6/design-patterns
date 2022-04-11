package com.kreitek.editor.editors;

import com.kreitek.editor.exceptions.EditorException;

public class EditorFactory {
    public Editor getEditor(String[]args) throws EditorException {
        if(args.length>0){
            switch (args[0]){
                case "text": return new ConsoleEditor();
                case "json": return new JsonEditor();
            }
        }
        throw new EditorException();
    }
}

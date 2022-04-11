package com.kreitek.editor;

import com.kreitek.editor.editors.EditorFactory;
import com.kreitek.editor.editors.Editor;
import com.kreitek.editor.exceptions.EditorException;

public class Application {

    public static void main(String[] args) {
        EditorFactory editorFactory = new EditorFactory();
        Editor editor;
        try {
            editor = editorFactory.getEditor(args);
            editor.run();
        }catch (Exception | EditorException e){
            System.out.println("Incorrect document type");
        }
    }

}

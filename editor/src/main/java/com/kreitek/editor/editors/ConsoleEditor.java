package com.kreitek.editor.editors;

import com.kreitek.editor.Document;
import com.kreitek.editor.commands.CommandFactory;
import com.kreitek.editor.exceptions.BadCommandException;
import com.kreitek.editor.exceptions.ExitException;
import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.interfaces.Editor;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleEditor implements Editor {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    private final CommandFactory commandFactory = new CommandFactory();
    private Document document;

    public ConsoleEditor (){
        this.document = new Document();
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                Command command = commandFactory.getCommand(commandLine);
                command.execute(document);
            } catch (BadCommandException e) {
                printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            }
            showDocumentLines(document);
            showHelp();
        }
    }

    private void showDocumentLines(Document document) {
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

    private String waitForNewCommand() {
        printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    private void showHelp() {
        printLnToConsole("To add new line -> a \"your text\"");
        printLnToConsole("To update line  -> u [line number] \"your text\"");
        printLnToConsole("To delete line  -> d [line number]");
    }

    private void printErrorToConsole(String message) {
        setTextColor(TEXT_RED);
        printToConsole(message);
        setTextColor(TEXT_RESET);
    }

    private void setTextColor(String color) {
        System.out.println(color);
    }

    private void printLnToConsole(String message) {
        System.out.println(message);
    }

    private void printToConsole(String message) {
        System.out.print(message);
    }

}

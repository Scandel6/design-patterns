package com.kreitek.editor.editors;

import com.kreitek.editor.Document;
import com.kreitek.editor.commands.CommandFactory;
import com.kreitek.editor.exceptions.BadCommandException;
import com.kreitek.editor.exceptions.ExitException;
import com.kreitek.editor.interfaces.Command;

import java.util.Scanner;

public abstract class Editor {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    protected final CommandFactory commandFactory = new CommandFactory();
    protected Document document = new Document();

    protected abstract void showDocumentLines();

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
            showDocumentLines();
            showHelp();
        }
    }

    private String waitForNewCommand() {
        printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    private void showHelp() {
        printLnToConsole("To add new line   -> a \"your text\"");
        printLnToConsole("To update line    -> u [line number] \"your text\"");
        printLnToConsole("To delete line    -> d [line number]");
        printLnToConsole("To undo last edit -> undo");
    }

    protected void setTextColor(String color) {
        System.out.println(color);
    }

    protected void printLnToConsole(String message) {
        System.out.println(message);
    }

    protected void printToConsole(String message) {
        System.out.print(message);
    }

    protected void printErrorToConsole(String message) {
        setTextColor(TEXT_RED);
        printToConsole(message);
        setTextColor(TEXT_RESET);
    }
}

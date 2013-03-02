package org.gvsig.tools.undo.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.gvsig.tools.undo.RedoException;
import org.gvsig.tools.undo.UndoException;
import org.gvsig.tools.undo.command.Command;

public class CompoundCommand extends AbstractCommand {

    private List commands = new ArrayList();

    public CompoundCommand(String description) {
        super(description);
    }

    public boolean isEmpty() {
        return commands.size() == 0;
    }

    public void undo() throws UndoException {
        for (int i = commands.size() - 1; i >= 0; i--) {
            ((AbstractCommand) commands.get(i)).undo();
        }
    }

    public void redo() throws RedoException {
        for (int i = 0; i < commands.size(); i++) {
            ((AbstractCommand) commands.get(i)).redo();
        }
    }

    public void add(Command c) {
        commands.add(c);
    }
    
    public int getType() {
        if (isEmpty()) {
            return UPDATE;
        } else {
            int adds = getCount(INSERT);
            int dels = getCount(DELETE);
            if (adds > 0 && dels == 0) {
                return INSERT;
            } else {
                if (adds == 0 && dels > 0) {
                    return DELETE;
                } else {
                    /*
                     * mix or other thing
                     */
                    return UPDATE;
                }
            }
        }
    }

    /**
     * count commands of given type
     * 
     * @param insert
     * @return
     */
    private int getCount(int ty) {
        if (commands == null || commands.size() == 0) {
            return 0;
        } else {
            int resp = 0;
            for (int i=0; i<commands.size(); i++) {
                if (((Command) commands.get(i)).getType() == ty) {
                    resp++;
                }
            }
            return resp;
        }
    }
}
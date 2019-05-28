package br.udesc.ppr.haruichiban.control.command;

import java.util.ArrayList;
import java.util.List;

public class BoardCommandInvoker {

    private List<BoardCommand> commands = new ArrayList<>();

    public void add(BoardCommand comm) {
        commands.add(comm);
    }
    
    public void execute(){
        for (BoardCommand command : commands) {
            command.execute();
        }
        commands.clear();
    }

}

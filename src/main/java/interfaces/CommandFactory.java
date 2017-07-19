package interfaces;

import ru.itstep.studyshell.Command;

public interface CommandFactory {

    //command - command from console(ls, echo etc)
    Command create(String command);
}

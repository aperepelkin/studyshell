package Work2017;

import java.util.ArrayList;
import java.util.List;

public class CommandRepository {
	private static CommandRepository instance;
	private List<CommandFactory> factories = new ArrayList<CommandFactory>();

	private CommandRepository() {
		factories.add(new ListDirectoryCommandFactory());
	}

	public static CommandRepository getInstance() {
		if (instance == null)
			instance = new CommandRepository();
		return instance;
	}

	public Command create(String command) {
		for (CommandFactory factory : factories) {
			Command result = factory.create(command);
			if (result != null)
				return result;
		}
		return null;
	}
}
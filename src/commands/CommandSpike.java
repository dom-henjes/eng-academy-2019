package commands;

public class CommandSpike implements Command {

	@Override
	public String handle() {
		return "spike says hello";
	}

	@Override
	public String commandName() {
		return "spike";
	}

}

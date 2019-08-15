package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import commands.Command;
import commands.CommandConnect;
import commands.CommandInsertEmployee;
import commands.CommandEmployeeDepartment;
import commands.CommandSpike;
import model.Connector;

public class App {

	private List<Command> commands = new ArrayList();
	
	public App() {
		commands.add(new CommandSpike());
		commands.add(new CommandConnect());
		commands.add(new CommandInsertEmployee());
		commands.add(new CommandEmployeeDepartment());
	
		System.out.println("Please enter an option");
		
		Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter command: ");
	    boolean running = true;

	    while(running){

	        String input = scanner.nextLine();
	        
	        if (input.equals("quit")) {
	        	System.exit(0);
	        }
	        
	        for (Command command : commands) {
	        	if (command.commandName().equals(input)) {
	        		System.out.println(command.handle());
	        		break;
	        	}
	        }
	    }
	    
	    scanner.close();
	}
	
	public static void main(String[] args) {
		new App();
	}

}

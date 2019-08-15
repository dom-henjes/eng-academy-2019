package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import commands.Command;
import commands.CommandConnect;
import commands.CommandDisplayDepartments;
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
		commands.add(new CommandDisplayDepartments());
//		commands.add(new CommandEmployeeDepartment());
	
		Scanner scanner = new Scanner(System.in);
		
	    boolean running = true;
	    
	    try {
	    while(running){

	    	System.out.println("\nPlease enter an option or quit to exit. Commands:");
			for (Command command : commands) {
				System.out.print(command.commandName() +  ", ");
			}
			
			System.out.println("");
			
	    	
	        String input = scanner.nextLine();
	        
	        if (input.equals("quit")) {
	        	running = false;
	        	System.out.println("Bye!");
	        	System.exit(0);
	        }
	        
	        boolean commandFound = false;
	        
	        for (Command command : commands) {
	        	if (command.commandName().toUpperCase().equals(input.toUpperCase())) {
	        		System.out.println(command.handle());
	        		commandFound = true;
	        		break;
	        	}
	        }
	        
	        if (!commandFound) {
	        	System.out.println("Error: That is not a valid command\n");
	        }
	    }
	    } catch (Exception e) {
	    	System.out.println("Error: " + e.getMessage());
	    }
	    
	    scanner.close();
	}
	
	public static void main(String[] args) {
		new App();
	}

}

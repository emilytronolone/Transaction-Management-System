/**
This class contains a method used to run the entirety of the program.
It goes through every possible command and checks if it is valid.
It utilizes all other classes (besides RunProject2).
@author Devin Gulati, Emily Tronolone
*/
//import java.text.DecimalFormat;
import java.util.Scanner;

public class TransactionManager {

    /**
     * Houses the main loop for all transaction processes
     */
    public void run(){
        AccountDatabase database = new AccountDatabase();
        Scanner scanner = new Scanner(System.in); // initializes scanner to read from console
        scanner.useDelimiter("\n");
        System.out.println("Transaction process starts.....");
        String command = scanner.nextLine();
        while (!command.equals("Q")) { //reads from the scanner until the Quit command is read
            command = " " + command;
            String[] tokens = command.split("[ |\t]+"); //splits each line of input into an array of Strings split by " "
            switch (tokens[1]) { // first element of this array should always be the command
                case "OC":{
                    if(tokens.length != 7){
                        System.out.println("Invalid input");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);
                        String[] date_tokens = tokens[5].split("/");
                        Date date = new Date(Integer.parseInt(date_tokens[0]), Integer.parseInt(date_tokens[1]), Integer.parseInt(date_tokens[2]));

                        if(!date.isValid()){
                            System.out.println(date.toString() + " is not a valid date!");
                            break;
                        }

                        Checking account = new Checking(holder, Double.parseDouble(tokens[4]), date,Boolean.parseBoolean(tokens[6]));

                        if(!database.add(account)){
                            System.out.println("Account is already in the database");
                        }else{
                            System.out.println("Account opened and added to the database");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }

                    break;
                }
                case "OS":{
                    if(tokens.length != 7){
                        System.out.println("Invalid input");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);
                        String[] date_tokens = tokens[5].split("/");
                        Date date = new Date(Integer.parseInt(date_tokens[0]), Integer.parseInt(date_tokens[1]), Integer.parseInt(date_tokens[2]));

                        if(!date.isValid()){
                            System.out.println(date.toString() + " is not a valid date!");
                            break;
                        }

                        Savings account = new Savings(holder, Double.parseDouble(tokens[4]), date,Boolean.parseBoolean(tokens[6]));

                        if(!database.add(account)){
                            System.out.println("Account is already in the database");
                        }else{
                            System.out.println("Account opened and added to the database");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }

                    break;
                }
                case "OM":{
                    if(tokens.length != 6){
                        System.out.println("Invalid input");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);
                        String[] date_tokens = tokens[5].split("/");
                        Date date = new Date(Integer.parseInt(date_tokens[0]), Integer.parseInt(date_tokens[1]), Integer.parseInt(date_tokens[2]));

                        if(!date.isValid()){
                            System.out.println(date.toString() + " is not a valid date!");
                            break;
                        }

                        MoneyMarket account = new MoneyMarket(holder, Double.parseDouble(tokens[4]), date);

                        if(!database.add(account)){
                            System.out.println("Account is already in the database");
                        }else{
                            System.out.println("Account opened and added to the database");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }

                    break;
                }

                case "CC":{
                    if(tokens.length != 4){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                    	System.out.println("Account does not exist.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        Checking account = new Checking(holder, -1, null, false);

                        if(!database.remove(account)){
                            System.out.println("Account does not exist.");
                        }else{
                            System.out.println("Account opened and added to the database");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }
                case "CS":{
                    if(tokens.length != 4){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                    	System.out.println("Account does not exist.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        Savings account = new Savings(holder, -1, null, false);

                        if(!database.remove(account)){
                            System.out.println("Account does not exist.");
                        }else{
                            System.out.println("Account opened and added to the database");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }
                case "CM":{
                    if(tokens.length != 4){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                    	System.out.println("Account does not exist.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        MoneyMarket account = new MoneyMarket(holder, -1, null);

                        if(!database.remove(account)){
                            System.out.println("Account does not exist.");
                        }else{
                            System.out.println("Account opened and added to the database");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }

                case "DC":{
                    if(tokens.length != 5){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                        System.out.println("Database is empty.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        Checking account = new Checking(holder, -1, null, false);
                        Double amount = Double.parseDouble(tokens[4]);

                        if(!database.deposit(account, amount)){
                            System.out.println("Account does not exist.");
                        }else{
                            System.out.println();
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }
                case "DS":{
                    if(tokens.length != 5){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                        System.out.println("Database is empty.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        Savings account = new Savings(holder, -1, null, false);
                        Double amount = Double.parseDouble(tokens[4]);

                        if(!database.deposit(account, amount)){
                            System.out.println("Account does not exist.");
                        }else{
                            System.out.println();
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }
                case "DM":{
                    if(tokens.length != 5){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                        System.out.println("Database is empty.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        MoneyMarket account = new MoneyMarket(holder, -1, null);
                        Double amount = Double.parseDouble(tokens[4]);

                        if(!database.deposit(account, amount)){
                            System.out.println("Account does not exist.");
                        }else{
                            System.out.println();
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }


                case "WC":{
                    if(tokens.length != 5){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                        System.out.println("Database is empty.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        Checking account = new Checking(holder, -1, null, false);
                        Double amount = Double.parseDouble(tokens[4]);

                        int withdrawal = database.withdrawal(account, amount);
                        if(withdrawal == -1){
                            System.out.println("Account does not exist.");
                        }else if (withdrawal == 0){
                            System.out.println(amount + " withdrawn from account");
                        }else{
                            System.out.println("Insufficient funds");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }
                case "WS":{
                    if(tokens.length != 5){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                        System.out.println("Database is empty.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        Savings account = new Savings(holder, -1, null, false);
                        Double amount = Double.parseDouble(tokens[4]);

                        int withdrawal = database.withdrawal(account, amount);
                        if(withdrawal == -1){
                            System.out.println("Account does not exist.");
                        }else if (withdrawal == 0){
                            System.out.println(amount + " withdrawn from account");
                        }else{
                            System.out.println("Insufficient funds");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }
                case "WM":{
                    if(tokens.length != 5){
                        System.out.println("Invalid input");
                        break;
                    }

                    if(database.getSize() == 0){
                        System.out.println("Database is empty.");
                        break;
                    }

                    try{
                        Profile holder = new Profile(tokens[2], tokens[3]);

                        MoneyMarket account = new MoneyMarket(holder, -1, null);
                        Double amount = Double.parseDouble(tokens[4]);

                        int withdrawal = database.withdrawal(account, amount);
                        if(withdrawal == -1){
                            System.out.println("Account does not exist.");
                        }else if (withdrawal == 0){
                            System.out.println(amount + " withdrawn from account");
                        }else{
                            System.out.println("Insufficient funds");
                        }
                    }catch (Exception e){
                        System.out.println("Input data type mismatch");
                        break;
                    }


                    break;
                }

                case "PA":{
                	if (database.getSize() < 1) {
                    	System.out.println("Database is empty.");
                        break;
                    }
                	if(tokens.length != 3){
                        System.out.println("Invalid input");
                        break;
                	}
                    database.printAccounts();
                }
                case "PD":{
                	if (database.getSize() < 1) {
                    	System.out.println("Database is empty.");
                        break;
                    }
                	if(tokens.length != 3){
                        System.out.println("Invalid input");
                        break;
                	}
                    database.printByDateOpen();
                }
                case "PN":{
                	if (database.getSize() < 1) {
                    	System.out.println("Database is empty.");
                        break;
                    }
                	if(tokens.length != 3){
                        System.out.println("Invalid input");
                        break;
                	}
                    database.printByLastName();
                }

                default:{
                    System.out.println("Command '" + tokens[1] + "' isn't supported");
                    break;
                }
            }
            command = scanner.nextLine();
        }
        System.out.println("Transaction processing completed");
        scanner.close();
		System.exit(0);
    }
}
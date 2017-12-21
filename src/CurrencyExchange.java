//Name: Julia Aiello 
//UF ID: 9193-9605
//Section: 0394
//Project Number: 3
//Brief description of file contents: Create a currency exchange program using different methods.


import java.util.Scanner; 


public class CurrencyExchange {
private static double balance = 0;
    public static double getBalance() { 
        return balance;
    }
    private static boolean updateBalance(double newBalance) {
    	
        balance = Math.round(newBalance * 100) / 100.0;
        if (balance >= 0) {
            return true;
        } 
        else { 
            return false;
        } 
    } 
	
	//double [] currencyValues = {1.00, 0.89, 0.78, 66.53, 1.31, 1.31, 1.37, 0.97, 4.12, 101.64, 6.67}; 
	//static String [] currencyNames = {"U.S Dollars", "Euros", "British Pounds", "Indian Rupees", "Australian Dollars", "Canadian Dollars", "Singapore Dollars", "Swiss Francs", 
			//"Malaysian Ringgits", "Japanese Yens", "Chinese Yuan Renminbis"}; 
	
	public static void main(String[] args) {
		double balance = 0; 
		Scanner input = new Scanner(System.in); 
		
		System.out.println("Welcome to Currency Exchange 2.0 "); 
		printConversionTable(); 
		System.out.println("\nCurrent rates are as follows: ");
		int options = mainMenuOptionSelector(input); 
		//int currencyType = currencyMenuOptionSelector(input); 
		
		double amount; 
		boolean isConvertToUSD = true; 
		boolean isDeposit; 
		
		int currencyType; 
		while (!(options == 4)) { 
			if (options == 1) { 
			System.out.println("Your current balance is: " + getBalance());	 
			
		}
		
		
			if (options == 2) { 
				currencyType = currencyMenuOptionSelector(input);  
				System.out.println("Please enter the deposit amount: ");
				amount = input.nextDouble();  
				boolean depositSuccess = deposit(amount, currencyType); 
				
				if (depositSuccess) { 
					System.out.println(logTransaction(amount, currencyType, depositSuccess));
					double balanceDeposit = getBalance() + convertCurrency(amount, currencyType, true); 
					updateBalance(balanceDeposit); 
					//System.out.print(logTransaction(amount, currencyType, isDeposit));
					//System.out.print(" "+ currencyNames[currencyType-1]);
					
		}
				else 
					System.out.println("Logging Error."); 
	}
		
		if (options == 3) {
			currencyType = currencyMenuOptionSelector(input); 
			System.out.println("Please enter the withdrawal amount: ");
			amount = input.nextDouble(); 
			boolean withDrawalSuccess = withdraw(amount, currencyType); 
		
			if (withDrawalSuccess) {
				System.out.println(logTransaction(amount, currencyType, false));
				double balanceWithdraw = getBalance() - convertCurrency(amount, currencyType, true); 
				updateBalance(balanceWithdraw); 
				//System.out.print(logTransaction(amount, currencyType, isDeposit));
				//System.out.print(" "+ currencyNames[currencyType-1]); 
			} 
			
			else { 
				if (amount <= 0) { 
					System.out.println("Logging error.");
					
				}
				
				if (amount > getBalance()) { 
					System.out.println("Error. Insufficient funds.");
				}
			}
			
		}
		
		options = mainMenuOptionSelector(input); 
		
		
	}
		if (balance == 0) { 
			System.out.println("Your remaining balance is 0.0 U.S. Dollars.");
		}
		
		else { 
			System.out.println(logTransaction(getBalance(), 1, false));
			balance -= getBalance(); 
		}
		
		System.out.println("Goodbye");
		
		} 


	
	public static void printConversionTable() { 
		

		double[] currencyValues = {1.00, 0.89, 0.78, 66.53, 1.31, 1.31, 1.37, 0.97, 4.12, 101.64, 6.67}; 
		String[] currencyNames = {"1 - U.S Dollar - ","2 - Euro - ", "3 - British Pound - ", "4 - Indian Rupee - ", "5 - Australian Dollar - ", "6 - Canadian Dollar - ", 
				"7 - Singapore Dollar - ", "8 - Swiss Franc - ", "9 - Malaysian Ringgit - ", "10 - Japanese Yan - ", "11 - Chinese Yuan Renminbi - "
		}; 
		
		for (int i = 0; i <= currencyValues.length - 1; i++) { 
			System.out.println(currencyNames[i] + currencyValues[i]); 
		
			
		}
		
	} 
	

	public static int mainMenuOptionSelector(Scanner input) {
		
		System.out.println("\nPlease select an option from the list below: ");
		System.out.println("1. Check the balance of your account");
		System.out.println("2. Make a deposit");
		System.out.println("3. Withdraw an amount in a specific currency");
		System.out.println("4. End your session (and withdraw all remaining currency in U.S. dollars)");
		
		int mainMenuOptionSelector = input.nextInt();	
		
		while ((mainMenuOptionSelector > 4) || (mainMenuOptionSelector < 1)) { 
			
		System.out.println("Logging Error");
		System.out.println("\nPlease select an option from the list below: ");
		System.out.println("1. Check the balance of your account");
		System.out.println("2. Make a deposit");
		System.out.println("3. Withdraw an amount in a specific currency");			
		System.out.println("4. End your session (and withdraw all remaining currency in U.S. dollars)");
		
		mainMenuOptionSelector = input.nextInt();
		
		}
			
		return mainMenuOptionSelector; 
	}
		
	
	
	public static int currencyMenuOptionSelector(Scanner input) { 
		
		System.out.println("\nPlease select the currency type:");
		int currencyList[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}; 
		String currencyNames [] = {". U.S Dollars", ". Euros", ". British Pounds", ". Indian Rupees", ". Australian Dollars", ". Canadian Dolllars", ". Singapore Dollars", 
				". Swiss Francs", ". Malaysian Ringgits", ". Japanese Yen", ". Chinese Yuan Renminbi"}; 
		int j; 
		for (j = 0; j <= currencyList.length - 1; j++) { 
			System.out.println(currencyList[j] + currencyNames[j]); 
		
		}
		
		int currencyMenuOptionSelector = input.nextInt(); 
		
		while (currencyMenuOptionSelector < 1 || currencyMenuOptionSelector > 11) {
			System.out.println("Logging Error");
			System.out.println("Please select the currency type: "); 
			System.out.println("1. U.S Dollars"); 
			System.out.println("2. Euros"); 
			System.out.println("3. British Pounds"); 
			System.out.println("4. Indian Rupees"); 
			System.out.println("5. Australian Dollars"); 
			System.out.println("6. Canadian Dolllars"); 
			System.out.println("7. Singapore Dollars"); 
			System.out.println("8. Swiss Francs"); 
			System.out.println("9. Malaysian Ringgits"); 
			System.out.println("10. Japanese Yen"); 
			System.out.println("11. Chinese Yuan Renminbi"); 
			
			currencyMenuOptionSelector = input.nextInt(); 
			
			
		}
		
		
		return currencyMenuOptionSelector;  
	}
	
	public static double convertCurrency(double amount, int currencyType, boolean isConvertToUSD) { 
		
		double [] currencyValues = {1.00, 0.89, 0.78, 66.53, 1.31, 1.31, 1.37, 0.97, 4.12, 101.64, 6.67}; 
		//String [] currencyTypes = {"U.S Dollar", "Euro", "British Pound", "Indian Rupee", "Australian Dollar", "Canadian Dollar", "Singapore Dollar", "Swiss Franc", 
				//"Malaysian Ringgit", "Japanese Yen", "Chinese Yuan Renminbi"}; 
		
		
		double convertCurrency; 
		
		if (currencyType == 1) { 
			isConvertToUSD = true ;
			convertCurrency = (amount) / (currencyValues[currencyType]); 
				
			}
		else { 
			convertCurrency = (amount) * (currencyValues[currencyType]); 
		}
		return convertCurrency; 
		}
		
	
	
	public static boolean deposit(double amount, int currencyType) { 
		boolean deposit;  
		while (currencyType > 11 || currencyType <1) { 
			deposit = false; 
			System.out.println("Logging Error" );
			
			
		}
		
		if (deposit = true) { 
			
		
		updateBalance(balance); 
		
		
		} 
		
		return deposit; 
	}
	
	public static boolean withdraw (double amount, int currencyType) { 
		boolean withdraw; 
		while (currencyType < 1 && currencyType > 11) {
			withdraw = false; 
			System.out.print("Logging Error"); 
			// conversion 
		}
		withdraw = true; 
		convertCurrency(amount, currencyType, false); 
		
		return withdraw; 
	}
	
	
	
	public static String logTransaction(double amount, int currencyType, boolean isDeposit) { 
		String logTransaction; 
		if (isDeposit == true) {
			logTransaction = "\nYou successfully deposited " + amount;
			
		}
		
		else { 
			logTransaction = "\nYou successfully withdrew " + amount; 
		}
		
		return logTransaction; 
	}
	
}

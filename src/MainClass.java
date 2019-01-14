
import java.util.ArrayList;




import java.util.Scanner;

/**
 * 
 * @author Daniel Han
 * PD 7
 */

public class MainClass //you need a break (the last line of every case)
{
	/**
	 * 
	 * @param str - a String (could be numeric)
	 * @return - returns whether or not the string is numeric. If it isn't numeric, an error is returned.
	 */
	private static boolean isNumeric (String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		int OVER_DRAFT_FEE = 15;
		double RATE = 0.0025;
		double TRANSACTION_FEE = 1.5;
		int MIN_BAL = 300;
		int MIN_BAL_FEE = 10;
		int FREE_TRANS = 10;
		String method;
		Scanner in = new Scanner(System.in);
		
		double balance = 0;
		String initialBal = "";
		double initialBalDouble = 0;
		boolean contRunning = true;
		
		while(contRunning)
		{
		
		System.out.println("Do you want to 'a' add an account, 'b' make a transaction, or 'x' terminate this program?");
		method = in.nextLine();
		
		while(!method.equals("a") && !method.equals("b") && !method.equals("x"))
		{
			System.out.println("Invalid. Please try again");
			method = in.next();
			in.nextLine();
		}
		switch(method)
		{
			case "a": 
			{
				System.out.println("Would you like to create 'c' a Checking account or 's' a Savings account?");
				String checkingSavings = in.next();
				in.nextLine();
				while(!checkingSavings.equals("c") && !checkingSavings.equals("C") && !checkingSavings.equals("s") && !checkingSavings.equals("S"))
				{
					System.out.println("Invalid. Please try again");
					checkingSavings = in.next();
					in.nextLine();
					
				}
			
					switch(checkingSavings)
					{
					case "c":
					{
						balance = 0;
						System.out.println("What is your name?: ");
						String name = in.nextLine();
						System.out.println("Do you want to make an initial deposit?: (type y/n)");
						String choice = in.nextLine();
						if(!choice.equals("y") && !choice.equals("n") && !choice.equals("Y") && !choice.equals("N"))
						{
							System.out.println("Invalid response, please try again (y/n)");
							choice = in.nextLine();
						}
						else if (choice.equals("y") || choice.equals("Y"))
						{
							System.out.println("How much would you like to deposit?:");
							initialBal = in.nextLine();
							isNumeric(initialBal);
							while(!isNumeric(initialBal))
							{
								System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
								initialBal = in.nextLine();
							}
							double initialBalance = Double.parseDouble(initialBal);
							balance = initialBalance + balance;
						}
						else
						{
							balance = 0;
						}
						CheckingAccount accountchecking = new CheckingAccount(name, balance, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANS);
						accounts.add(accountchecking);
						
						break;
					}
					case "s":
					{
						System.out.println("What is your name?: ");
						String name = in.nextLine();
						System.out.println("Do you want to make an initial deposit?: (type y/n): ");
						String choice = in.nextLine();
						if(!choice.equals("y") && !choice.equals("n") && !choice.equals("Y") && !choice.equals("N"))
						{
							System.out.println("Invalid response, please try again (y/n)");
							choice = in.nextLine();
						}
						if(choice.equals("y") || choice.equals("Y"))
						{
							System.out.println("How much would you like to deposit?:");
							initialBal = in.nextLine();
							
							isNumeric(initialBal);
							while(!isNumeric(initialBal))
							{
								System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
								initialBal = in.nextLine();
							}
							double initialBalance = Double.parseDouble(initialBal);
							
							balance = initialBalance + balance;
						}
						else if (choice.equals("n") || choice.equals("N"))
						{
							initialBal="0";
							
							isNumeric(initialBal);
							while(!isNumeric(initialBal))
							{
								System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
								initialBal = in.nextLine();
							}
							
							double initialBalance = Double.parseDouble(initialBal);
							
							balance = initialBalance + balance;
						}
						SavingsAccount accountsavings = new SavingsAccount(name, balance, RATE, MIN_BAL, MIN_BAL_FEE);
						accounts.add(accountsavings);
						
						break;
					}
			
					}
					break;
			}
				case "b":
				{
				
					System.out.println("Would you like to make a (w) withdrawal, (d) deposit, (t) transfer, or (n) get account numbers?: ");
					String response = in.nextLine();
					
					switch (response)
					{
					case "w":

					{
						{
							System.out.println("What is your bank account number?: ");
							String account = in.nextLine();
							
							while(!isNumeric(account))
							{
								System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
								account = in.nextLine();
							}
							if(isNumeric(account))
							{
								for(BankAccount test : accounts)
								{
									if(test.getAccountNumber() == Integer.parseInt(account))
									{
										System.out.print("How much would you like to withdraw?: ");
										double amount = in.nextDouble();
										try
										{
											test.withdraw(amount);
											break;
										}
										catch (IllegalArgumentException e)
										{
											System.out.println("Transaction not authorized, please try again:");
											amount = in.nextDouble();
										}
									}
									else
									{
										System.out.println("Invalid account number. Please try again:");
										account = in.next();
									}
						
							}
								break;
						}
						break;
					}
						
						}
					
					case "d":
					
						{
							{
								System.out.println("What is your bank account number?: ");
								String account = in.nextLine();
								
								while(!isNumeric(account))
								{
									System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
									account = in.nextLine();
								}
								if(isNumeric(account))
								{
									for(BankAccount test : accounts)
									{
										if(test.getAccountNumber() == Integer.parseInt(account))
										{
											System.out.print("How much would you like to deposit?: ");
											double amount = in.nextDouble();
											try
											{
												test.deposit(amount);
												break;
											}
											catch (IllegalArgumentException e)
											{
												System.out.println("Transaction not authorized, please try again:");
												amount = in.nextDouble();
											}
										}
										else
										{
											System.out.println("Invalid account number. Please try again:");
											account = in.next();
										}
							
								}
									break;
							}
							break;
						}
							}
					case "t":
					{
						System.out.println("What is your bank account number?: ");
						String accountone = in.nextLine();
						isNumeric(accountone);
						while(!isNumeric(accountone))
						{
							System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
							accountone = in.nextLine();
						}
						System.out.println("What is the other bank account number?: ");
						String accounttwo = in.nextLine();
						isNumeric(accounttwo);
						while(!isNumeric(accounttwo))
						{
							System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
							accounttwo = in.nextLine();
						}
						System.out.println("How much would you like to transfer?: ");
						String amount = in.nextLine();
						isNumeric(amount);
						while(!isNumeric(amount))
						{
							System.out.println("Your transaction was not authorized.  Please enter a numerical value: ");
							amount = in.nextLine();
						}
						double amt = Double.parseDouble(amount);
						BankAccount accOther= null;
						for (int i = 0; i < accounts.size(); i++)
						{
							if (amt == (accounts.get(i).getAccountNumber()))
							{
								BankAccount accNum = accounts.get(i);
								accOther = accounts.get(i);
							}
						}
						BankAccount firstAcc = null;
						for (int x = 0; x < accounts.size(); x++)
						{
							if (amt ==(accounts.get(x).getAccountNumber()))
							{
								BankAccount accNum = accounts.get(x);
								firstAcc = accounts.get(x);
							}						
						}
						
						try
						{
							firstAcc.transfer(accOther, amt);
						}
						catch (IllegalArgumentException e)
						{
							System.out.println("Transaction not authorized.");
						}
						break;
				}
					
					case "n":
					{
						{
							
								System.out.println("What is your name: ");
								String name = in.nextLine();
								
								for (int i = 0; i<accounts.size(); i++)
								{
									if (name.equals(accounts.get(i).getName()))
									{
										BankAccount account=accounts.get(i);
										System.out.println("The account numbers under your name are: ");
										System.out.println(account.toString());
										
									if (account instanceof CheckingAccount)
										{
											System.out.println("It is a checking account");
										}
									else
										{
											System.out.println("It is a savings account");
										}
										
									}
									break;
								}
								break;
							}
						
						}
					
					
						default:
						{
							while((!response.equals("w"))&&(!response.equals("d"))&&(!response.equals("t"))&&(!response.equals("n"))) 	
							{
								System.out.println("Would you like to make a withdrawal, deposit, transfer, or get account numbers (w/d/t/n)?: ");
								response = in.nextLine();
							}
							break;
						}
					}
					
					}
				
					
				 
			case "x":
			{
				System.out.println("Terminated");
				contRunning = false;
				break;
			}
		
			
		}
		
	}	
	

	
	}
}
/**
 * Bank Account Project
 * @author danielhan
 * PD. 7
 */
public abstract class BankAccount
{
	//instance variables
	private String name;
	private static int nextacctNum;
	private int acctNum;
	private double balance;
	
	//constructors
	/**
	 * 
	 * @param n - bank account holder's name
	 * 
	 */
	public BankAccount (String n)
	{
		
		acctNum = nextacctNum;
		//balance = 0;
		acctNum++;
		name = n;
		
	}
	/**
	 * 
	 * @param n - bank account holder's name
	 * @param b - total balance in the bank account
	 */
	public BankAccount (String n, double b)
	{
		
		acctNum = nextacctNum;
		acctNum++;
		name = n;
		balance = b;
	}
	//methods
	/**
	 * deposits money to balance
	 * @param amt - amount of money
	 */
	public void deposit(double amt)
	{
		balance = balance += amt;
	}
	/**
	 * withdraws money from balance
	 * @param amt - amount of money
	 */
	public void withdraw (double amt)
	{
		balance = balance -= amt;
	}
	/**
	 * 
	 * @return - returns name of the account
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 
	 * @return - returns balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 *  to be implemented in checking and savings account classes
	 */
	public abstract void endOfMonthUpdate();
	
	/**
	 * takes money out of one account and deposits it in another
	 * @param other - the bank account that receives the money
	 * @param amt - the amount to be transferred
	 */
	public void transfer(BankAccount other, double amt)
	{
		withdraw(amt);
		other.deposit(amt);
	}
	/**
	 * 
	 * @return - returns bank account number
	 */
	public double getAccountNumber()
	{
		return acctNum;
	}
	/**
	 * prints an account's number, name, and balance
	 */
	public String toString()
	{
		return acctNum + "\t" + name + "\t" + "$" + balance;
	}
}



/**
 * 
 * @author Daniel Han
 * Pd. 7
 */

public class SavingsAccount extends BankAccount
{
	private double intRate;
	final double MIN_BAL;
	final double MIN_BAL_FEE;
	/**
	 * 
	 * @param n - name of the account holder
	 * @param b - the balance of the account
	 * @param r - the interest rate
	 * @param mb - the minimum balance of an account
	 * @param mbf - the minimum balance fee
	 */
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super (n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * 
	 * @param n - name of the account holder
	 * @param r - the interest rate
	 * @param mb - the minimum balance of an account
	 * @param mbf - the minimum balance fee
	 */
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super (n);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * deposits the amount into the account
	 */
	public void deposit (double amt)
	{
		if (amt < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			super.deposit(amt);
		}
	}
	/**
	 * withdraws the amount from the account
	 */
	public void withdraw (double amt)
	{
		if (amt>getBalance())
		{
			throw new IllegalArgumentException();
		}
		if (amt<0)
		{
			throw new IllegalArgumentException();
		}
		super.withdraw(amt);
		if (getBalance() < MIN_BAL)
		{
			super.withdraw(MIN_BAL_FEE);
		}
	}
	/**
	 * transfers an amount of money from one bank account to the another
	 */
	public void transfer (BankAccount other, double amt)
	{
		if (!getName().equals(other.getName()))
		{
			throw new IllegalArgumentException();
		}
		if (amt>getBalance())
		{
			throw new IllegalArgumentException();
		}
		if (amt<0)
		{
			throw new IllegalArgumentException();
		}
		super.transfer(other, amt);
	}
	/**
	 * adds the total interest to the balance
	 */
	public void addInterest()
	{
		super.deposit((intRate) * getBalance());
	}
	/** 
	 * adds the total interest
	 */
	public void endOfMonthUpdate()
	{
		addInterest();
	}
}
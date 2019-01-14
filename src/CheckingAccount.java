/**
 * 
 * @author Daniel Han
 * PD 7
 */
public class CheckingAccount extends BankAccount
{
	final double OVER_DRAFT_FEE;
	final double TRANSACTION_FEE;
	final double FREE_TRANS;
	private int numTransactions; 
/**
 * 
 * @param n - bank account holder's name
 * @param b - account balance
 * @param odf - account's over draft fee
 * @param tf - account's transaction fee
 * @param freeTrans - number of free transactions the account has
 */
public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
{
	super (n, b);
	OVER_DRAFT_FEE = odf;
	TRANSACTION_FEE = tf;
	FREE_TRANS = freeTrans;
}
/**
 * 
 * @param n - bank account holder's name
 * @param odf - account's over draft fee
 * @param tf - account's transaction fee
 * @param freeTrans - number of free transactions the account has
 */
public CheckingAccount(String n, double odf, double tf, int freeTrans)
{
	super (n);
	OVER_DRAFT_FEE = odf;
	TRANSACTION_FEE = tf;
	FREE_TRANS = freeTrans;
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
		numTransactions++;
		
		if (numTransactions > FREE_TRANS)
		{
			super.withdraw(TRANSACTION_FEE);
		}
	}
}
/**
 * withdraws the amount from the account
 */
public void withdraw (double amt)
{
	if (amt < 0 || getBalance() < 0)
	{
		throw new IllegalArgumentException();
	}
	else
	{
		super.withdraw(amt);
		numTransactions++;
		
		if (numTransactions > FREE_TRANS)
		{
			super.withdraw(TRANSACTION_FEE);
		}
		if (getBalance() < 0)
		{
			super.withdraw(OVER_DRAFT_FEE);
		}
		
	}
}
/**
 * transfers an amount of money from one bank account to the another
 */
public void transfer (BankAccount other, double amt)
{
	if (getName().equals(other.getName()) && getBalance() >= amt)
	{
		super.transfer(other,amt);
	}
	else
	{
		
		throw new IllegalArgumentException();
	}
}
/**
 * updates the number of transactions
 */
public void endOfMonthUpdate()
{
	numTransactions = 0;
}
}
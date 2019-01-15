/**
 * 
 * @author danielhan
 * PD. 7
 */
public abstract class BaseTwoFormatter implements NumberFormatter
{
	public String format(int n) 
	{
			String value = "";
		
	        while (n != 0) 
	        {
	        int x = (n % 2);
	        value = x + value;
	        n = n / 2;
	       
	        }
	        return value;
	}
}
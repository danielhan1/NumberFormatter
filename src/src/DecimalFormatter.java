/**
 * 
 * @author danielhan
 * PD. 7
 */
public class DecimalFormatter implements NumberFormatter
{
	public String format (int n)
	{
		String number = "";
		String value = String.valueOf(number);
		int length = value.length();
		int extra = length %3;
		int limit = 3;
		
			for (int i = length; i >= 3; i = i-3)
			{
				if (length %3 == 0)
				{
					if (i == limit)
					{
						number = value.substring(i-3, i) + n;
					}
					else
					{
						number = "." + value.substring(i-3, i) + n;

					}
				}
				else
				{
					number = "." + value.substring(i-3, i) + n;

				}
			}
		
		if (extra == 1)
		{
			number = value.substring(0,1) + n;
		}
		else if (extra == 2) 
		{
			number = value.substring(0,2) + n;
		}
				
		return number;
	}
}

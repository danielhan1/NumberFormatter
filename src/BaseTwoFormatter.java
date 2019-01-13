
public abstract class BaseTwoFormatter implements NumberFormatter
{
	public void basetwo(int number) {
	    int binary = 0, p = 1;
	        while (number != 0) {
	        binary = binary + p * (number % 2);
	        number = number / 2;
	        p = p * 10;
	    }
	    System.out.println(binary);
	}
}
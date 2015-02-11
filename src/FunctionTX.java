public class FunctionTX{
	public static String returnDate(String d)
		{
			if(d.length()<4)
			{
			return d;
			}
			else
			{
				return d.substring(0, 4);
			}
		}
}
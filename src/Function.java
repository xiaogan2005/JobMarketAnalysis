public class Function{
	public static String returnDate(String d)
		{
//			String date = d;
//			String[] new_date = date.split(" ");
/*			
			int l = new_date.length;
			for(int i=0;i<l;i++)
			{
				System.out.println(new_date[i]);
			}
*///			String[] year_month = new_date[0].split("/");
/*
			int ll = year_month.length;
			System.out.println(ll);
			System.out.println(year_month[0]);
			System.out.println(year_month[1]);
			System.out.println(year_month[2]);
/*			for(int i=0;i<ll;i++)
			{
				System.out.println(year_month[i]);
			}
*/			
//			return year_month[2]+year_month[0];
			return d.substring(7, 11) + d.substring(1,3);
		}
}
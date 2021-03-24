package app.components;

import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Util {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static NumberFormat nf = NumberFormat.getInstance(new Locale("pt","BR"));

	static {	
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setGroupingUsed(false);
	}
	
	public static String applyMoneyMask(double value) {
		return nf.format(value);
	}
	
	public static boolean isValidDate(String aDate)
	{	try
		{	if(aDate.length() != 10) return false;
		
			Integer.parseInt(aDate.substring(0,2));
			if (!aDate.substring(2,3).equals("/")) return false; 
			Integer.parseInt(aDate.substring(3,5));
			if (!aDate.substring(5,6).equals("/")) return false; 
			Integer.parseInt(aDate.substring(6,10));
		
			sdf.setLenient(false);
			sdf.parse(aDate);
			return true; 
		}
		catch(Exception e)
		{	return false;
		} 
	}

	public static Date strToDate(String aDate){	
		String dia = aDate.substring(0,2);
		String mes = aDate.substring(3,5);
		String ano = aDate.substring(6,10);

		return java.sql.Date.valueOf(ano + "-" + mes + "-" + dia);
	}

	public static String dateToStr(Date aDate){	
		return sdf.format(aDate);
	}

	public static double removeMoneyMask(String valor)
		throws NumberFormatException {	
		if (valor == null || "".equals(valor)) {	
			return 0;
		} else {	
			return Double.parseDouble(valor);
		}		
	}
	
}

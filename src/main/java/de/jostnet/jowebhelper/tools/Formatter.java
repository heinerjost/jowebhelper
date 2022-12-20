package de.jostnet.jowebhelper.tools;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formatter
{

	public static final DecimalFormat currency = new DecimalFormat(
			"###,###,###,###,##0.00");

	public static final DecimalFormat currencyinternat = new DecimalFormat(
			"###,###,###,###,##0.00", DecimalFormatSymbols.getInstance(Locale.US));

	public static final DateTimeFormatter datumMJJJJ = DateTimeFormatter
			.ofPattern("M.yyyy");

	public static final DateTimeFormatter datumJJJJ = DateTimeFormatter
			.ofPattern("yyyy");

	public static final String datumTMJJJJ_S = "d.M.yyyy";

	public static final DateTimeFormatter datumTMJJJJ = DateTimeFormatter
			.ofPattern(datumTMJJJJ_S);

	public static final String datumTTMMJJJJ_S = "dd.MM.yyyy";

	public static final DateTimeFormatter datumTTMMJJJJ = DateTimeFormatter
			.ofPattern(datumTTMMJJJJ_S);

	public static String getTTMMJJJJWithNullHandling(LocalDate date)
	{
		if (date == null)
		{
			return "";
		}
		return datumTTMMJJJJ.format(date);
	}

	public static final DateTimeFormatter datumJJJJMMTT = DateTimeFormatter
			.ofPattern("yyyy-MM-dd");

	public static final DateTimeFormatter datumTTMMM = DateTimeFormatter
			.ofPattern("dd. MMM");

	public static final DateTimeFormatter datumMMMMJJJJ = DateTimeFormatter
			.ofPattern("MMMM yyyy");

	public static final DateTimeFormatter datumMMMJJJJ = DateTimeFormatter
			.ofPattern("MMM yyyy");

	public static final DateTimeFormatter datumQJJJJ = DateTimeFormatter
			.ofPattern("Q.yyyy");

	public static final DateTimeFormatter uhrzeitHHMM = DateTimeFormatter
			.ofPattern("HH:mm");

	public static final DateTimeFormatter datumJJJJMMTTHHMMSS = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static final DecimalFormat intnumber = new DecimalFormat(
			"###,###,###,###");

	public static final DecimalFormat intnumbershort = new DecimalFormat("####");

	static
	{
		currency.setParseBigDecimal(true);
	}

}

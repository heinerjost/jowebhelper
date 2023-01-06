package de.jostnet.jowebhelper.tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class DateTool
{

	public static final String format(DateTimeFormatter formatter, LocalDate date,
			String nullvalue)
	{
		if (date != null)
		{
			return formatter.format(date);
		}
		else
		{
			return nullvalue;
		}
	}

	public static final LocalDate parse(DateTimeFormatter formatter,
			String datestring)
	{
		try
		{
			return parseWithException(formatter, datestring);
		}
		catch (DateTimeParseException e)
		{
			return null;
		}
	}

	public static final LocalDate parseWithException(DateTimeFormatter formatter,
			String datestring) throws DateTimeParseException
	{
		if (datestring == null || datestring.length() == 0)
		{
			return null;
		}
		return LocalDate.parse(datestring, formatter);
	}

	public static final LocalDateTime parseLocalDateTimeWithException(
			DateTimeFormatter formatter, String datestring)
			throws DateTimeParseException
	{
		if (datestring == null || datestring.length() == 0)
		{
			return null;
		}
		return LocalDateTime.parse(datestring, formatter);
	}

	public static final int getWeekNumber(LocalDate datum)
	{
		TemporalField woy = WeekFields.of(Locale.getDefault())
				.weekOfWeekBasedYear();
		return datum.get(woy);
	}

	public static int getLfdJahr()
	{
		return LocalDate.now().getYear();
	}

	public static int getVorjahr()
	{
		return getLfdJahr() - 1;
	}

	public static int getFolgejahr()
	{
		return getLfdJahr() + 1;
	}

	public static int getLfdMonat()
	{
		return LocalDate.now().getMonthValue();
	}

	public static int getVorMonat()
	{
		return LocalDate.now().minusMonths(1).getMonthValue();
	}

	public static int getFolgeMonat()
	{
		return LocalDate.now().plusMonths(1).getMonthValue();
	}

	public static LocalDate getLfdJahr0101()
	{
		return LocalDate.of(getLfdJahr(), 1, 1);
	}

	public static LocalDate getLfdJahr3112()
	{
		return LocalDate.of(getLfdJahr(), 12, 31);
	}

	public static LocalDate getVorjahr0101()
	{
		return LocalDate.of(getVorjahr(), 1, 1);
	}

	public static LocalDate getFolgejahr0101()
	{
		return LocalDate.of(getFolgejahr(), 1, 1);
	}

}

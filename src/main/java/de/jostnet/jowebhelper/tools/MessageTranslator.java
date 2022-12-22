package de.jostnet.jowebhelper.tools;

import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

public class MessageTranslator
{
	public static final String get(Exception e)
	{
		if (e instanceof DataIntegrityViolationException)
		{
			return dataIntegrityViolation((DataIntegrityViolationException) e);
		}
		return e.getMessage();
	}

	private static final String
			dataIntegrityViolation(DataIntegrityViolationException e)
	{
		Throwable thr = e.getCause();
		if (thr instanceof ConstraintViolationException)
		{
			return constraintViolation((ConstraintViolationException) thr);
		}
		if (thr instanceof PropertyValueException)
		{
			return propertyValueException((PropertyValueException) thr);
		}
		return null;
	}

	private static final String
			constraintViolation(ConstraintViolationException e)
	{
		Throwable thr = e.getCause();
		if (thr instanceof SQLIntegrityConstraintViolationException)
		{
			String duplientry = "Duplicate entry ";
			SQLIntegrityConstraintViolationException sqle = (SQLIntegrityConstraintViolationException) thr;
			if (sqle.getErrorCode() == 1062)
			{
				if (sqle.getMessage().contains(
						"for key 'tagesordnungspunkt.KY_tagesordnungspunkt_sitzung_gliederung'"))
				{
					return "Gliederung für diese Sitzung bereits vorhanden";
				}
				else if (sqle.getMessage().contains(duplientry))
				{
					int pos1 = sqle.getMessage().indexOf(duplientry)
							+ duplientry.length();
					int pos2 = sqle.getMessage().indexOf("' for key '") + 1;
					return "Datensatz bereits vorhanden: "
							+ sqle.getMessage().substring(pos1, pos2);
				}
				else
				{
					return e.getMessage();
				}
			}
			if (sqle.getErrorCode() == 1451)
			{
				return "Datensatz kann nicht gelöscht oder geändert werden wegen Abhängigkeit zur Tabelle "
						+ getReferencedTable(sqle.getMessage());
			}
			System.out.println(
					((SQLIntegrityConstraintViolationException) thr).getErrorCode());
			return thr.getMessage();
		}
		return null;
	}

	private static final String propertyValueException(PropertyValueException e)
	{
		return String.format("%s ist leer", e.getPropertyName());
	}

	private static String getReferencedTable(String message)
	{
		String str = "a foreign key constraint fails (";
		int pos1 = message.indexOf(str) + str.length();
		int pos2 = message.indexOf(".", pos1) + 1;
		int pos3 = message.indexOf(",", pos2);

		String referencedTable = message.substring(pos2, pos3);
		return referencedTable;
	}

}

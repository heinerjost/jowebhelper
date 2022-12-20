package de.jostnet.jowebhelper.controls;

import java.util.List;
import java.util.Locale;

import com.vaadin.flow.component.datepicker.DatePicker;

public class JoDatePicker extends DatePicker
{
	private static final long serialVersionUID = 1L;

	public JoDatePicker(String label)
	{
		super(label);
		DatePicker.DatePickerI18n germanI18n = new DatePicker.DatePickerI18n();
		germanI18n.setMonthNames(
				List.of("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
						"August", "September", "Oktober", "November", "Dezember"));
		germanI18n.setWeekdays(List.of("Sonntag", "Montag", "Dienstag", "Mittwoch",
				"Donnerstag", "Freitag", "Samstag"));
		germanI18n
				.setWeekdaysShort(List.of("So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"));
		// germanI18n.setWeek("Woche");
		germanI18n.setToday("Heute");
		germanI18n.setCancel("Abbrechen");
		this.setI18n(germanI18n);
		this.setLocale(Locale.GERMAN);

	}

}

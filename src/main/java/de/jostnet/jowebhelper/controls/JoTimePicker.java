package de.jostnet.jowebhelper.controls;

import java.util.Locale;

import com.vaadin.flow.component.timepicker.TimePicker;

public class JoTimePicker extends TimePicker
{
	private static final long serialVersionUID = 1L;

	public JoTimePicker(String label)
	{
		super(label);
		this.setLocale(Locale.GERMAN);
	}

}

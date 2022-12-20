package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class SaveAsButton extends Button
{

	private static final long serialVersionUID = 1L;

	public SaveAsButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super("Speichern als", getIcn(), clickListener);
	}

	public static Icon getIcn()
	{
		return VaadinIcon.CHECK_SQUARE.create();
	}

}

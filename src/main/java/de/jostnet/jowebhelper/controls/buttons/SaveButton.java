package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class SaveButton extends Button
{

	private static final long serialVersionUID = 1L;

	public SaveButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super("speichern", new Icon(VaadinIcon.CHECK), clickListener);
		getElement().getThemeList().add("primary");
	}

	public SaveButton(String text,
			ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(text, new Icon(VaadinIcon.CHECK), clickListener);
		getElement().getThemeList().add("primary");
	}

}

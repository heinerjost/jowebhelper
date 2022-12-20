package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

public class JaButton extends Button
{

	private static final long serialVersionUID = 1L;

	public JaButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super("ja", VaadinIcon.CHECK.create(), clickListener);
	}

}

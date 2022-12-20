package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

public class NeinButton extends Button
{

	private static final long serialVersionUID = 1L;

	public NeinButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super("nein", VaadinIcon.CLOSE_SMALL.create(), clickListener);
	}

}

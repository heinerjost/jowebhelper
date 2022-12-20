package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

public class LeftArrowButton extends Button
{

	private static final long serialVersionUID = 1L;

	public LeftArrowButton(
			ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(VaadinIcon.ARROW_CIRCLE_LEFT.create(), clickListener);
	}

}

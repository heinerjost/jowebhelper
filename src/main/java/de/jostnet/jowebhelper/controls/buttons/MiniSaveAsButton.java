package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class MiniSaveAsButton extends Button
{

	private static final long serialVersionUID = 1L;

	public MiniSaveAsButton(
			ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(getIcn(), clickListener);
	}

	public static Icon getIcn()
	{
		return VaadinIcon.CHECK_SQUARE.create();
	}

}

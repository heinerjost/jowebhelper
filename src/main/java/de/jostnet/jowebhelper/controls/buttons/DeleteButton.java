package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

public class DeleteButton extends Button
{

	private static final long serialVersionUID = 1L;

	public DeleteButton(boolean withText,
			ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(withText ? "löschen" : "", VaadinIcon.TRASH.create(), clickListener);
		getElement().getThemeList().add("error");
	}

}

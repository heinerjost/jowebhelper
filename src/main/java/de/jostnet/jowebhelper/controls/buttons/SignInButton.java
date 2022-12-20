package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class SignInButton extends Button
{

	private static final long serialVersionUID = 1L;

	public SignInButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super("Anmelden", new Icon(VaadinIcon.SIGN_IN), clickListener);
	}

}

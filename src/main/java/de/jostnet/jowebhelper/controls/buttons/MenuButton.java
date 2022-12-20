package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;

public class MenuButton extends Button
{

	private static final long serialVersionUID = 1L;

	public MenuButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(VaadinIcon.MENU.create(), clickListener);
	}

	public MenuButton(VaadinIcon icon, String text,
			ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(text, icon.create(), clickListener);
		// setHeight("40px");
		setWidth("250px");
		addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.MATERIAL_OUTLINED);
		addClassName("menu");
	}

}

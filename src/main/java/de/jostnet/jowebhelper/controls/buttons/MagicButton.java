package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * Zauberstab
 *
 */
public class MagicButton extends Button
{

	private static final long serialVersionUID = 1L;

	public MagicButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(VaadinIcon.MAGIC.create(), clickListener);
	}

}

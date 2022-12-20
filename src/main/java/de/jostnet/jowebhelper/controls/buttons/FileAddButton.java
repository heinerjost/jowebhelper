package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class FileAddButton extends Button
{

	private static final long serialVersionUID = 1L;

	public FileAddButton(ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(getIcn(), clickListener);
	}

	public FileAddButton(String text,
			ComponentEventListener<ClickEvent<Button>> clickListener)
	{
		super(text, getIcn(), clickListener);
	}

	public static final Icon getIcn()
	{
		return VaadinIcon.FILE_ADD.create();
	}

}

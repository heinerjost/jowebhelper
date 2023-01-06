package de.jostnet.jowebhelper.controls;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class JoMenuBar extends HorizontalLayout
{
	private static final long serialVersionUID = 1L;

	private MenuBar menuBar = new MenuBar();

	public JoMenuBar(String title)
	{
		super();

		H2 viewTitle = new H2(title);
		viewTitle.addClassNames(LumoUtility.FontSize.LARGE,
				LumoUtility.Margin.NONE);

		add(viewTitle);

		menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY,
				MenuBarVariant.LUMO_END_ALIGNED);
		add(menuBar);
		setWidthFull();

		setJustifyContentMode(JustifyContentMode.BETWEEN);
		setAlignItems(Alignment.CENTER);
	}

	public MenuItem addItem(String text,
			ComponentEventListener<ClickEvent<MenuItem>> clickListener)
	{
		return menuBar.addItem(text, clickListener);
	}

	public MenuItem addItem(Component component)
	{
		return menuBar.addItem(component);
	}

	public MenuItem addItem(String text)
	{
		return menuBar.addItem(text);
	}

}

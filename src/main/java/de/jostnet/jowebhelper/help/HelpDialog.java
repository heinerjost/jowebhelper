package de.jostnet.jowebhelper.help;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.Scroller.ScrollDirection;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelpDialog extends Dialog
{
	private static final long serialVersionUID = 1L;

	private Map<String, String> labelClass = new HashMap<>();

	private VerticalLayout menu = new VerticalLayout();

	private VerticalLayout content = new VerticalLayout();

	private HorizontalLayout layout = new HorizontalLayout();

	public HelpDialog()
	{
		setMaxWidth("1000px");

		setDraggable(true);
		setHeaderTitle("Hilfe");
		setResizable(true);

		layout.setHeightFull();

		menu.setMargin(false);
		menu.setSpacing(false);
		menu.setPadding(false);

		menu.setWidth("350px");
		menu.setMaxWidth("350px");

		Scroller menuScroller = new Scroller(menu);
		menuScroller.setScrollDirection(ScrollDirection.VERTICAL);
		layout.add(menuScroller);
		content.setWidthFull();

		layout.add(content);
		add(layout);
	}

	public void show(Class<? extends AbstractHelp> help, String param)
	{
		content.removeAll();
		try
		{
			AbstractHelp h = help.getDeclaredConstructor(this.getClass())
					.newInstance(this);
			if (param != null)
			{
				h.setParameter(param);
			}
			h.setWidth("650px");
			content.add(h);
			highlightButton(help);
		}
		catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e)
		{
			log.error("Fehler", e);
		}
		if (!isOpened())
		{
			open();
		}
	}

	public void addItem(Class<? extends AbstractHelp> help, String title)
	{
		labelClass.put(help.getSimpleName(), title);
		Button button = new Button(title);
		button.addThemeVariants(ButtonVariant.LUMO_SMALL,
				ButtonVariant.LUMO_TERTIARY);
		button.addClickListener(e -> show(help, null));
		menu.add(button);
	}

	private void highlightButton(Class<? extends AbstractHelp> clazz)
	{
		String title = labelClass.get(clazz.getSimpleName());
		menu.getChildren().filter(c ->
		{
			return c instanceof Button;
		}).forEach(child ->
		{
			Button button = (Button) child;
			if (button.getText().equals(title))
			{
				button.removeThemeVariants(ButtonVariant.LUMO_TERTIARY);
				button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			}
			else
			{
				button.removeThemeVariants(ButtonVariant.LUMO_PRIMARY);
				button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
			}
		});

	}
}

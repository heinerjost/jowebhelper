package de.jostnet.jowebhelper.help;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.Scroller.ScrollDirection;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.jostnet.jowebhelper.data.AbstractSession;
import de.jostnet.jowebhelper.interfaces.IBenutzer;
import de.jostnet.jowebhelper.interfaces.IMandant;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class HelpDialog<MANDANT extends IMandant,
		BENUTZER extends IBenutzer<MANDANT>> extends Dialog
{
	private static final long serialVersionUID = 1L;

	private Map<String, String> labelClass = new HashMap<>();

	private VerticalLayout menu = new VerticalLayout();

	private VerticalLayout content = new VerticalLayout();

	private HorizontalLayout layout = new HorizontalLayout();

	private Button back;

	private Button forw;

	@Setter
	@Getter
	private AbstractSession<MANDANT, BENUTZER> session;

	public HelpDialog()
	{
		setMaxWidth("1500px");
		setWidth("90%");

		setDraggable(true);
		setHeaderTitle("Hilfe");
		setResizable(true);

		HorizontalLayout historybuttons = new HorizontalLayout();
		historybuttons.setMargin(false);
		historybuttons.setPadding(false);
		historybuttons.setSpacing(false);

		back = new Button(VaadinIcon.ANGLE_LEFT.create());
		back.setHeight("30px");
		back.addClickListener(e ->
		{
			Class<? extends AbstractHelp<MANDANT, BENUTZER>> clazz = session
					.goHistoryBack();
			show(clazz, null, true);
		});
		historybuttons.add(back);

		forw = new Button(VaadinIcon.ANGLE_RIGHT.create());
		forw.setHeight("30px");
		forw.addClickListener(e ->
		{
			Class<? extends AbstractHelp<MANDANT, BENUTZER>> clazz = session
					.goHistoryForward();
			show(clazz, null, true);
		});
		historybuttons.add(forw);
		add(historybuttons);

		layout.setHeightFull();

		menu.setMargin(false);
		menu.setSpacing(false);
		menu.setPadding(false);

		menu.setWidthFull();

		Scroller menuScroller = new Scroller(menu);
		menuScroller.setMinWidth("300px");
		menuScroller.setScrollDirection(ScrollDirection.VERTICAL);
		layout.add(menuScroller);

		Scroller contentScroller = new Scroller(content);
		contentScroller.setScrollDirection(ScrollDirection.VERTICAL);
		content.setWidthFull();
		contentScroller.setWidthFull();
		layout.add(contentScroller);

		add(layout);
	}

	public void show(Class<? extends AbstractHelp<MANDANT, BENUTZER>> help,
			String param, boolean firstlast)
	{
		if (!firstlast)
		{
			session.addToHistory(help);
		}
		content.removeAll();
		try
		{
			AbstractHelp<MANDANT, BENUTZER> h = help
					.getDeclaredConstructor(this.getClass()).newInstance(this);
			if (param != null)
			{
				h.setParameter(param);
			}
			h.setWidthFull();
			content.add(h);
			highlightButton(help);
			back.setEnabled(!session.isHistoryFirst());
			forw.setEnabled(!session.isHistoryLast());
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

	public void addItem(Class<? extends AbstractHelp<MANDANT, BENUTZER>> help,
			String title)
	{
		labelClass.put(help.getSimpleName(), title);
		Button button = new Button(title);
		button.addThemeVariants(ButtonVariant.LUMO_SMALL,
				ButtonVariant.LUMO_TERTIARY);
		button.addClickListener(e -> show(help, null, false));
		menu.add(button);
	}

	private void
			highlightButton(Class<? extends AbstractHelp<MANDANT, BENUTZER>> clazz)
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

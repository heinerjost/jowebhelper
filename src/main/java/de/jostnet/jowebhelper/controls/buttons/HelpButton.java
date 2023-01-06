package de.jostnet.jowebhelper.controls.buttons;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RouteConfiguration;

public class HelpButton extends Button
{

	private static final long serialVersionUID = 1L;

	public HelpButton(Class<? extends Component> component)
	{
		super("Hilfe", getIcn());
		addClickListener(e -> UI.getCurrent().getPage().open(
				RouteConfiguration.forApplicationScope().getUrl(component), "blank_"));
		addClickShortcut(Key.F1);
		addClickShortcut(Key.F1, KeyModifier.ALT_GRAPH);

	}

	public static Icon getIcn()
	{
		return VaadinIcon.QUESTION_CIRCLE_O.create();
	}

}

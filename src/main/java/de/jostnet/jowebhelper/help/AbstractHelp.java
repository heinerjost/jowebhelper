package de.jostnet.jowebhelper.help;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.AnchorTarget;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class AbstractHelp extends VerticalLayout
{

	private static final long serialVersionUID = 1L;

	private HelpDialog helpDialog;

	public AbstractHelp(HelpDialog helpDialog)
	{
		this.helpDialog = helpDialog;
	}

	public void helpSuperHeader(String header)
	{
		add(new H1(header));
	}

	public void helpMainHeader(String header)
	{
		add(new H2(header));
	}

	public void helpSubHeader(String header)
	{
		add(new H3(header));
	}

	public void helpSubHeader(Component... components)
	{
		add(new H3(components));
	}

	public void helpComponent(Component component)
	{
		add(component);
	}

	public void helpParagraph(String paragraph)
	{
		add(new Paragraph(paragraph));
	}

	public void helpParagraph(Component... components)
	{
		add(new Paragraph(components));
	}

	public void helpOl(String... strings)
	{
		OrderedList ol = new OrderedList();
		for (String st : strings)
		{
			ol.add(new ListItem(st));
		}
		add(ol);
	}

	public void helpOl(ListItem... items)
	{
		add(new OrderedList(items));
	}

	public void helpIcon(Icon icon)
	{
		add(icon);
	}

	public void helpSucheHinweis()
	{
		helpMainHeader("Suche");
		Paragraph p = new Paragraph();
		p.add("Es gelten die allgemeinen Regeln für die ");
		// p.add(helpLink("Suche", SucheHilfe.class));
		p.add(".");
		helpComponent(p);
	}

	public void writeWirdErgaenzt()
	{
		helpParagraph("Wird ergänzt!");
	}

	public Button helpLink(String label, Class<? extends AbstractHelp> component)
	{
		Button button = new Button(label);
		button.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
				ButtonVariant.LUMO_SMALL);
		button.addClickListener(e -> helpDialog.show(component));
		return button;
	}

	public Anchor helpExternalLink(String label, String url)
	{
		Anchor link = new Anchor(url, label, AnchorTarget.BLANK);
		return link;
	}

	public Image helpImage(String url, String alt)
	{
		return new Image("images/help/" + url, alt);
	}

}

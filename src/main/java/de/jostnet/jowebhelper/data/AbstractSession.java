package de.jostnet.jowebhelper.data;

import java.util.ArrayList;
import java.util.List;

import de.jostnet.jowebhelper.help.AbstractHelp;
import de.jostnet.jowebhelper.interfaces.IBenutzer;
import de.jostnet.jowebhelper.interfaces.IMandant;
import de.jostnet.jowebhelper.security.AbstractAuthenticatedUser;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractSession<MANDANT extends IMandant,
		BENUTZER extends IBenutzer<MANDANT>>
{
	@Getter
	@Setter
	private AbstractAuthenticatedUser<MANDANT, BENUTZER> authenticatedUser;

	public AbstractSession(
			AbstractAuthenticatedUser<MANDANT, BENUTZER> authenticatedUser)
	{
		this.authenticatedUser = authenticatedUser;
	}

	/**
	 * Für Testzwecke kann der Benutzer direkt übergeben werden.
	 */
	@Setter
	private BENUTZER benutzer;

	public BENUTZER getBenutzer()
	{
		if (authenticatedUser != null)
		{
			return getAuthenticatedUser().get().get();
		}
		else
		{
			return benutzer;
		}
	}

	public MANDANT getMandant()
	{
		return getBenutzer().getMandant();
	}

	private List<Class<
			? extends AbstractHelp<MANDANT, BENUTZER>>> history = new ArrayList<>();

	private int historypos = 0;

	public void
			addToHistory(Class<? extends AbstractHelp<MANDANT, BENUTZER>> element)
	{
		history.add(element);
		historypos++;
		history.stream().forEach(e -> System.out.println(e.getSimpleName()));
		System.out.println(historypos);
	}

	public Class<? extends AbstractHelp<MANDANT, BENUTZER>> goHistoryBack()
	{
		historypos--;
		return history.get(historypos - 1);
	}

	public Class<? extends AbstractHelp<MANDANT, BENUTZER>> goHistoryForward()
	{
		historypos++;
		return history.get(historypos - 1);
	}

	public boolean isHistoryFirst()
	{
		return historypos <= 1;
	}

	public boolean isHistoryLast()
	{
		return historypos == history.size();
	}
}

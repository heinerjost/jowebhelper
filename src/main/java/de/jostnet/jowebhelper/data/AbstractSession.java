package de.jostnet.jowebhelper.data;

import de.jostnet.jowebhelper.interfaces.IBenutzer;
import de.jostnet.jowebhelper.interfaces.IMandant;
import de.jostnet.jowebhelper.security.AbstractAuthenticatedUser;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractSession<MANDANT extends IMandant, BENUTZER extends IBenutzer<MANDANT>>
{
	@Getter
	@Setter
	private AbstractAuthenticatedUser<MANDANT, BENUTZER> authenticatedUser;

	/**
	 * Für Testzwecke kann der Benutzer direkt übergeben werden.
	 */
	@Setter
	private IBenutzer<MANDANT> benutzer;

	public IBenutzer<MANDANT> getBenutzer()
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

}

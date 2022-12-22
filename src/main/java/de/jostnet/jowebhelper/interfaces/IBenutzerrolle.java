package de.jostnet.jowebhelper.interfaces;

public interface IBenutzerrolle<MANDANT extends IMandant>
{
	public void setBenutzer(IBenutzer<MANDANT> benutzer);

	public IBenutzer<MANDANT> getBenutzer();

	public void setRolle(String rolle);

	public String getRolle();

}

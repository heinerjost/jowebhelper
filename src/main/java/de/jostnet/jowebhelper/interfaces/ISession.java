package de.jostnet.jowebhelper.interfaces;

public interface ISession<MANDANT extends IMandant, BENUTZER extends IBenutzer<MANDANT>>
{
	public MANDANT getMandant();
	
	public void setMandant(MANDANT mandant);
	
	public BENUTZER getBenutzer();
	
	public void setBenutzer(BENUTZER benutzer);
}

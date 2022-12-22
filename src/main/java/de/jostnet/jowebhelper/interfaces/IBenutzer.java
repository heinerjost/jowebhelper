package de.jostnet.jowebhelper.interfaces;

import java.util.Set;

import de.jostnet.jowebhelper.enums.Geschlecht;

public interface IBenutzer<MANDANT extends IMandant>
{
	public void setMandant(MANDANT mandant);

	public MANDANT getMandant();

	public void setEmail(String email);

	public String getEmail();

	public void setName(String name);

	public String getName();

	public void setVorname(String vorname);

	public String getVorname();

	public void setGeschlecht(Geschlecht geschlecht);

	public Geschlecht getGeschlecht();

	public void setHashedpassword(String hashedpassword);

	public String getHashedpassword();

	public void setRollen(Set<IBenutzerrolle<MANDANT>> rollen);

	public Set<IBenutzerrolle<MANDANT>> getRollen();

}

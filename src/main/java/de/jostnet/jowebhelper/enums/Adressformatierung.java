package de.jostnet.jowebhelper.enums;

public enum Adressformatierung
{
	POS("PLZ, Ort, Staat"), OPS("Ort, PLZ, Staat");

	private String text;

	Adressformatierung(String text)
	{
		this.text = text;
	}

	public String getKey()
	{
		return this.name();
	}

	public String getText()
	{
		return text;
	}

	@Override
	public String toString()
	{
		return text;
	}

}

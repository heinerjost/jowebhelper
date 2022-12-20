package de.jostnet.jowebhelper.data;

import de.jostnet.jowebhelper.enums.Adressformatierung;
import lombok.Getter;
import lombok.Setter;

/**
 * https://www.deutschepost.de/de/b/briefe-ins-ausland/laenderkuerzel-laendercode.html#
 * Was ist aus den Ländercodes geworden?
 * 
 * Die Angabe der Länderkürzel vor der Postleitzahl bei der Adressangabe auf
 * Briefen und Paketen wurde offiziell am 1. September 1999 abgeschafft.
 * 
 * Aufgrund der automatisierten Anschriftenerkennung führte die Vielzahl der
 * weltweit unterschiedlich verwendeten Ländercodes häufig zu Problemen bei der
 * Sortierung und damit zu Verzögerung und Verärgerung bei den Kunden. Die
 * Angabe des Bestimmungslandes unter der Ortsangabe ist ausreichend.
 * 
 * Damit Ihre Briefe ins Ausland reibungslos zugestellt werden können, verwenden
 * Sie also kein Länderkürzel und beachten bitte folgende Hinweise zur Angabe
 * des Ziellandes:
 * 
 * Position: in der letzten Zeile der Anschrift Schreibweise: in Großbuchstaben
 * ausgeschrieben, keine Länderkürzel Sprache: Deutsch, Französisch oder
 * Englisch
 */
public class Staat
{
	public Staat(String bezeichnung, String kuerzel2, String kuerzel3,
			int schluessel)
	{
		this.bezeichnung = bezeichnung;
		this.kuerzel2 = kuerzel2;
		this.kuerzel3 = kuerzel3;
		this.schluessel = schluessel;
	}

	public Staat(String bezeichnung, String kuerzel2, String kuerzel3,
			int schluessel, Adressformatierung adressformatierung)
	{
		this.bezeichnung = bezeichnung;
		this.kuerzel2 = kuerzel2;
		this.kuerzel3 = kuerzel3;
		this.adressformatierung = adressformatierung;
	}

	@Getter
	@Setter
	private String bezeichnung;

	@Getter
	@Setter
	private String kuerzel2;

	@Getter
	@Setter
	private String kuerzel3;

	@Getter
	@Setter
	private Adressformatierung adressformatierung;

	@Getter
	@Setter
	private int schluessel;

}

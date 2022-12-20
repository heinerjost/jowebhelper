package de.jostnet.data;

import org.junit.jupiter.api.Test;

import de.jostnet.jowebhelper.data.Staaten;

public class StaatenTest
{
	@Test
	public void test01()
	{
		Staaten.getStaaten().forEach(staat ->
		{
			System.out.println(staat.getBezeichnung());
		});
	}

}

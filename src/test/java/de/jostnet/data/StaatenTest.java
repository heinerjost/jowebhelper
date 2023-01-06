package de.jostnet.data;

import org.junit.jupiter.api.Test;

import de.jostnet.jowebhelper.data.Staaten;

class StaatenTest
{
	@Test
	void test01()
	{
		Staaten.getStaaten().forEach(staat ->
		{
			System.out.println(staat.getBezeichnung());
		});
	}

	@Test
	void test02()
	{
		System.out.println(Staaten.getBySchluessel(0).getBezeichnung());
	}

}

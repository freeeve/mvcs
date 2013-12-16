package mvcs.java.embedded.test;

import static org.junit.Assert.*;

import java.util.List;

import mvcs.java.embedded.HelloCypher;

import org.junit.Test;



public class HelloCypherTest {

	@Test
	public void helloCypherTest ()
	{
		final HelloCypher hc = new HelloCypher ();
		final List<String> results = hc.hello();
		String JnBrymn = null;
		String technige= null;
		if (results.size() > 0)
		{
			JnBrymn = results.get(0);
			technige =  results.get(1);
		}
		
		assertEquals("JnBrymn", JnBrymn);
		assertEquals("technige", technige);
		
	}
}

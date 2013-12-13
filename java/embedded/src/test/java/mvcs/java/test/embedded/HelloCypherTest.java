package mvcs.java.test.embedded;

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
		final String JnBrymn =  results.get(0);
		final String technige =  results.get(1);
		
		assertEquals("JnBrymn", JnBrymn);
		assertEquals("technige", technige);
		
		/*if res[0] != "JnBrymn" || res[1] != "technige" {
				t.Fatal("doesn't match!", res)
			}*/
	}
}

package mvcs.java.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.neo4j.cypher.javacompat.ExecutionEngine;

public class HelloCypherUtils {

	private static final String DATA_CQL_RESOURCE = "data.cql";
	
	public static void loadGraph (final ExecutionEngine engine)
	{
		final InputStream is = HelloCypherUtils.class.getClassLoader().getResourceAsStream(DATA_CQL_RESOURCE);
		if (is == null)
		{
			System.out.println(" Resource not found ");
		}
		else
		{
			final InputStreamReader isr = new InputStreamReader(is);			
			final BufferedReader br = new BufferedReader(isr);
			
			try
			{
				final StringBuffer query = new StringBuffer ();
				String line = br.readLine();			
				while (line != null)
				{					
					query.append(line);
					line = br.readLine();
				}
				
				br.close();
				engine.execute(query.toString());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}

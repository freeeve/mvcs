package mvcs.java.embedded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.cypher.CypherException;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class HelloCypher {

	private static final String DATA_CQL_RESOURCE = "data.cql";
	private static final String PARAM_VALUE_WEFREEMA = "wefreema";
	private static final String PARAMETER_NAME = "parameter_name";
	private static final String COLUMN_AS_FRIEND = "friend";
	private static final String CYPHER_HELLO_QUERY = "match (n:User)-[:FOLLOWS]->(m:User) where n.screenName = {parameter_name} return m.screenName as friend order by friend";
	private static final String TEST_DB = "./test.db";
	private GraphDatabaseService db ;
	private ExecutionEngine engine;

	public HelloCypher ()
	{
		this.buildDB();
		this.loadGraph();
	}
	
	public List<String> hello () throws CypherException
	{
		final List<String> results = new ArrayList<String> ();				
				
		final Map<String,Object> params = new HashMap<String,Object> ();
		params.put(PARAMETER_NAME, PARAM_VALUE_WEFREEMA);
		final ExecutionResult result = engine.execute( CYPHER_HELLO_QUERY,params);	
		
	    for (Map<String, Object> map : result) {
	    	results.add((String)map.get(COLUMN_AS_FRIEND)); 
		}
		
		return results;
	}
	
	private void buildDB ()
	{
		db = new GraphDatabaseFactory().newEmbeddedDatabase( TEST_DB );
		Runtime.getRuntime().addShutdownHook(new Thread (){public void run (){db.shutdown();}});
		engine = new ExecutionEngine( db );		
	}
	
	private void loadGraph ()
	{
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(DATA_CQL_RESOURCE);
		if (is == null)System.out.println(" Resource not found ");
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);
		
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

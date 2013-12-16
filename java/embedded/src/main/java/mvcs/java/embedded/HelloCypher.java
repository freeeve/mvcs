package mvcs.java.embedded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mvcs.java.commons.AbstractHelloCypher;
import mvcs.java.commons.HelloCypherUtils;

import org.neo4j.cypher.CypherException;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;

import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class HelloCypher extends AbstractHelloCypher{

	
	
	private static final String TEST_DB = "./test.db";
	
	private ExecutionEngine engine;

	public HelloCypher ()
	{
		super();
		
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
	
	protected void buildDB ()
	{
		db = new GraphDatabaseFactory().newEmbeddedDatabase( TEST_DB );
		Runtime.getRuntime().addShutdownHook(new Thread (){public void run (){db.shutdown();}});
		engine = new ExecutionEngine( db );	
		HelloCypherUtils.loadGraph(engine);
	}
	
	
	
	
}

package mvcs.java.embedded;

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

	private static final String PARAM_VALUE_WEFREEMA = "wefreema";
	private static final String PARAMETER_NAME = "parameter_name";
	private static final String COLUMN_AS_FRIEND = "friend";
	private static final String CYPHER_HELLO_QUERY = "match (n:User)-[:FOLLOWS]->(m:User) where n.screenName = {parameter_name} return m.screenName as friend order by friend";
	private static final String TEST_DB = "./test.db";

	public HelloCypher ()
	{
	}
	
	public List<String> hello () throws CypherException
	{
		final List<String> results = new ArrayList<String> ();
		
		final GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase( TEST_DB );
		Runtime.getRuntime().addShutdownHook(new Thread (){public void run (){db.shutdown();}});
		
		final ExecutionEngine engine = new ExecutionEngine( db );		
				
		final Map<String,Object> params = new HashMap<String,Object> ();
		params.put(PARAMETER_NAME, PARAM_VALUE_WEFREEMA);
		final ExecutionResult result = engine.execute( CYPHER_HELLO_QUERY,params);	
	    for (Map<String, Object> map : result) {
	    	results.add((String)map.get(COLUMN_AS_FRIEND));
		}
		
		return results;
	}
}

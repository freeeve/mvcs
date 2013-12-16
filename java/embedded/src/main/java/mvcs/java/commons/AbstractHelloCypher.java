package mvcs.java.commons;

import java.util.List;

import org.neo4j.cypher.CypherException;
import org.neo4j.graphdb.GraphDatabaseService;

public abstract class AbstractHelloCypher {

	protected GraphDatabaseService db ;
	public static final String PARAM_VALUE_WEFREEMA = "wefreema";
	public static final String PARAMETER_NAME = "parameter_name";
	public static final String COLUMN_AS_FRIEND = "friend";
	public static final String CYPHER_HELLO_QUERY = "match (n:User)-[:FOLLOWS]->(m:User) where n.screenName = {parameter_name} return m.screenName as friend order by friend";
	
	public AbstractHelloCypher ()
	{
		this.buildDB();
	}
	
	public abstract List<String> hello () throws CypherException;
	protected abstract void buildDB ();
}

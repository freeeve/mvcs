from py2neo import neo4j

def hello_cypher():
  graph_db = neo4j.GraphDatabaseService()
  query_str = """match (n:User)-[:FOLLOWS]->(m:User)
          where n.screenName = {screenName}
          return m.screenName as friend
          order by friend"""
  query = neo4j.CypherQuery(graph_db, query_str)
  results = query.execute(screenName="wefreema")
  arr = []
  for i,r in enumerate(results.data):
    arr += r
  return arr

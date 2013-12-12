merge (u:User {screenName:"wefreema"})
merge (u)-[:FOLLOWS]->(j:User {screenName:"JnBrymn"})
merge (u)-[:FOLLOWS]->(n:User {screenName:"technige"});

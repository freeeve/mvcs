# minimum viable cypher snippets
The goal of this repo is to keep a folder for each language and each Neo4j Cypher-supporting driver, along with a sample Cypher "hello world" program. Tested with the latest Neo4j!

a baby dataset for our hello Cypher query:
```
merge (u:User {screenName:"wefreema"}) 
merge (u)-[:FOLLOWS]->(j:User {screenName:"JnBrymn"}) 
merge (u)-[:FOLLOWS]->(n:User {screenName:"technige"});
```

driver list - sorted alphabetically by language and then driver name:

## clojure
[neocons](/clojure/neocons/)
## java 

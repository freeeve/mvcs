# minimum viable cypher snippets
The goal of this repo is to keep a folder for each language and each Neo4j Cypher-supporting driver, along with a sample Cypher "hello world" program. Tested with the latest Neo4j!

[![Build Status](https://travis-ci.org/wfreeman/mvcs.png?branch=master)](https://travis-ci.org/wfreeman/mvcs)

a baby dataset for our hello Cypher query:
```
merge (u:User {screenName:"wefreema"}) 
merge (u)-[:FOLLOWS]->(j:User {screenName:"JnBrymn"}) 
merge (u)-[:FOLLOWS]->(n:User {screenName:"technige"});
```

driver list - sorted alphabetically by language and then driver name:

### clojure
[neocons](/clojure/neocons/)
### java 
### go
[cq](/go/cq/)
### node.js
[phillipkueng.node-neo4j](/node.js/phillipkueng.node-neo4j/)  
[thingdom.node-neo4j](/node.js/thingdom.node-neo4j/)  
### python
[py2neo](/python/py2neo/)
### scala
[AnormCypher](/scala/anormcypher/)

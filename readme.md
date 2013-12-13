# minimum viable cypher snippets
The goal of this repo is to keep a folder for each language and each Neo4j Cypher-supporting driver, along with a sample Cypher "hello world" program. Tested with the latest Neo4j!

[![Build Status](https://travis-ci.org/wfreeman/mvcs.png?branch=master)](https://travis-ci.org/wfreeman/mvcs)

I don't profess to be an expert in all of these languages. Please, if you have a more idiomatic hello Cypher test, submit a PR. Ideally, make sure it runs in the .travis.yml as well. 

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
[philippkueng.node-neo4j](/node.js/philippkueng.node-neo4j/)  
[thingdom.node-neo4j](/node.js/thingdom.node-neo4j/)  
### python
[py2neo](/python/py2neo/)
### scala
[AnormCypher](/scala/anormcypher/)

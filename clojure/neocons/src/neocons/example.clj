(ns neocons.example
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.cypher :as cy]))

(defn hello-cypher
  "Execute some Cypher!"
  []
  (nr/connect! "http://localhost:7474/db/data/")
  (cy/tquery "MATCH (n:User)-[:FOLLOWS]->(friend) 
              WHERE n.screenName = {screenName} 
              RETURN friend.screenName
              ORDER BY friend.screenName" 
             {:screenName "wefreema"}))

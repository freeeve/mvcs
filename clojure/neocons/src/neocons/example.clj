(ns neocons.example
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.cypher :as cy]))

(defn -main
  "Execute some Cypher!"
  []
  (nr/connect! "http://localhost:7474/db/data/")
  (println (cy/tquery "MATCH (n:User)-[:FOLLOWS]->(friend) WHERE n.screenName = {screenName} RETURN friend.screenName" {:screenName "wefreema"})))

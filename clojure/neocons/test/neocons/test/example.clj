(ns neocons.test.example
   (:use [clojure.test]
         [neocons.example])) 

(deftest test-hello-cypher
  (is (hello-cypher) ({:screenName "JnBrymn"} {:screenName "technige"})))

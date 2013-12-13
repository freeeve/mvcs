package anormcypher.example

import org.scalatest._

class HelloCypherSpec  extends FlatSpec with Matchers {
  "HelloCypher" should "be able to run a cypher query" in {
    Example.helloCypher.toList should be (List("JnBrymn", "technige"))
  } 
}

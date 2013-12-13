package anormcypher.example

import org.anormcypher._

object Example {
  def helloCypher:Stream[String] = 
    Cypher("""
      match (n:User)-[:FOLLOWS]->(m:User)
      where n.screenName = {screenName}
      return m.screenName as friend
      order by friend
    """).on("screenName" -> "wefreema")().map(row =>
      row[String]("friend")
    )
}

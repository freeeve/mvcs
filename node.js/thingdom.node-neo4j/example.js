var neo4j = require('neo4j');
var db = new neo4j.GraphDatabase('http://localhost:7474');

var helloCypher = function(cb) {
  var query = "MATCH (n:User)-[:FOLLOWS]->(friend) "+
              "WHERE n.screenName = {screenName} "+
              "RETURN friend.screenName "+
              "ORDER BY friend.screenName ";
  db.query(query, {screenName:"wefreema"}, function(err, res) {
    if(err) {
      console.log(err);
    }
    cb(res);
  });
}

module.exports.helloCypher = helloCypher;

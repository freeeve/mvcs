var neo4j = require('node-neo4j');
var db = new neo4j('http://localhost:7474');

var helloCypher = function(cb) {
  var query = "MATCH (n:User)-[:FOLLOWS]->(friend) "+
              "WHERE n.screenName = {screenName} "+
              "RETURN friend.screenName "+
              "ORDER BY friend.screenName ";
  db.cypherQuery(query, {screenName:"wefreema"}, function(err, res) {
    if(err) {
      console.log(err);
    }
    cb(res.data);
  });
}

module.exports.helloCypher = helloCypher;

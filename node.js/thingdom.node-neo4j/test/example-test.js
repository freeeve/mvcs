var example = require("../example")
var assert = require("assert")

describe('helloCypher', function(){
  it('should get my friends', function(done){
    example.helloCypher(function(friends) {
      assert.equal(friends[0]["friend.screenName"], "JnBrymn");
      assert.equal(friends[1]["friend.screenName"], "technige");
      done();
    });
  })
})

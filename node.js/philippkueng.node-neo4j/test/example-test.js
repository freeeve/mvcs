var example = require("../example")
var assert = require("assert")

describe('helloCypher', function(){
  it('should get my friends', function(done){
    example.helloCypher(function(friends) {
      assert.equal(friends[0], "JnBrymn");
      assert.equal(friends[1], "technige");
      done();
    });
  })
})

package main

import (
	"testing"
)

func TestHelloCypher(t *testing.T) {
	res := HelloCypher()
	if res[0] != "JnBrymn" || res[1] != "technige" {
		t.Fatal("doesn't match!", res)
	}
}

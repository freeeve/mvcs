package main

import (
	"testing"
)

func TestHelloCypher(t *testing.T) {
	if HelloCypher() != []string{"JnBrymn", "technige"} {
		t.Fatal("doesn't match!")
	}
}

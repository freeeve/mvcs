package main

import (
	"database/sql"
	"log"

	_ "github.com/wfreeman/cq"
)

func HelloCypher() []string {
	db, err := sql.Open("neo4j-cypher", "http://localhost:7474")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	stmt, err := db.Prepare(`
     match (n:User)-[:FOLLOWS]->(m:User)
     where n.screenName = {0}
     return m.screenName as friend
     order friend
   `)
	if err != nil {
		log.Fatal(err)
	}
	defer stmt.Close()

	rows, err := stmt.Query("wefreema")
	if err != nil {
		log.Fatal(err)
	}
	defer rows.Close()

	var friend string
	results := []string{}
	for rows.Next() {
		err := rows.Scan(&friend)
		if err != nil {
			log.Fatal(err)
		}
		results = append(results, friend)
	}
	return results
}

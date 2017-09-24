# reimagined-disco
The point of this project is to play with the in memory database, Hazelcast.

## Setup
`mvn clean install`

## Get Request for FictionalCharacter
`http://localhost:1234/character/{id}`

## Post new FictionalCharacters
`http://localhost:1234/character/add`
`{ "name": "value", "role": "value" }`
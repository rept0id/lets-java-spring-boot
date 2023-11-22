# lets-java-springboot

![java-17](https://img.shields.io/badge/java-17-f39f37)

## Prepare

You may wish to install docker. For debian-based :
```
sudo apt-get install docker docker-compose
```

Then, simply verify your Java version :
```
java --version
```

It must be 17, at the very least, for this project.

In the event it's not 17, you might consider employing SDKMAN for effortlessly toggling between Java versions!

Refer to my note here for guidance on how to switch to Java 17 -> [note](https://github.com/rept0id/notes/blob/main/Shared/sdkman-java17.md).

## Run
Move to the folder you downloaded this project and run :
```
sudo make build-run
```

The default port of this application is 8081, so you'll be able to find it at :
```
http://localhost:8081
```

## Stop

Dont forget to stop the application once you dont need it anymore !
```
sudo make stop
```
## Tests

### Java Tests :

TODO : Writte Java Tests

### Curl Tests :

-> *Assuming this application runs on port 8081* :

#### Matches :

Create a new match (**POST**):
```
curl -X POST -H "Content-Type: application/json" -d '{
    "description": "Sample Match",
    "matchDate": "2023-10-20",
    "matchTime": "12:00",
    "teamA": "Team A",
    "teamB": "Team B",
    "sport": "FOOTBALL"
}' http://localhost:8081/match
```


List all matches (**GET**):
```
curl -X GET http://localhost:8081/match
```

Get a specific match by ID (**GET**):

-> Replace <match_id>` (see "List all matches (GET)")
```
curl -X GET http://localhost:8081/match/<match_id>
```


Update an existing match (PUT):

-> Replace `<match_id>` (see "List all matches (GET)")
```
curl -X PUT -H "Content-Type: application/json" -d '{
    "description": "Updated Match Description"
}' http://localhost:8081/match/<match_id>
```


Delete a match by ID (DELETE):

-> Replace `<match_id>` (see "List all matches (GET)")
```
curl -X DELETE http://localhost:8081/match/<match_id>
```

#### Matches Odds :

Create a new match odd (**POST**):
```
curl -X POST -H "Content-Type: application/json" -d '{
    "match": {"id": 1},
    "specifier": "Spec A",
    "odd": 2.5
}' http://localhost:8081/match-odd
```


List all match odds (**GET**):
```
curl -X GET http://localhost:8081/match-odd
```

Retrieve a specific match odd by ID (**GET**):

-> Replace `<match_odd_id>` (see "List all match odds (GET)")
```
curl -X GET http://localhost:8081/match-odd/<match_odd_id>
```


Update an existing match odd (PUT):

-> Replace `<match_odd_id>` (see "List all match odds (GET)")
```
curl -X PUT -H "Content-Type: application/json" -d '{
    "specifier": "Updated Spec A"
}' http://localhost:8081/match-odd/<match_odd_id>
```


Delete a match odd by ID (DELETE):

-> Replace `<match_odd_id>` (see "List all match odds (GET)")
```
curl -X DELETE http://localhost:8081/match-odd/<match_odd_id>
```

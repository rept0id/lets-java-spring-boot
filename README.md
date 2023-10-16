# LetsJavaSpringBoot

![java-17](https://img.shields.io/badge/java-11-f39f37)

## Prepare

You may wish to install docker. For debian-based :
```
sudo apt-get install docker
```
Also, you will also need docker-composer. To install :
```
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer
```

## Run
Move to the folder you downloaded this project and run :
```
sudo make build-run
```

The default port of this application is 8081, so you'll be able to find it at :
```
http://localhost:8081
```

At the end, just check you java version

```
java --version
```

If it's not 17, you may wish to use [sdkman](https://sdkman.io/) for easily switching between java versions!

See my note here on how to use sdkman to switch to java 17 -> [note](https://github.com/rept0id/notes/blob/main/Shared/sdkman-java17.md)


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

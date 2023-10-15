#!/bin/bash

sudo docker-compose down 


INIT_FILE=".runme_init"
if [ ! -e "$INIT_FILE" ]; then
    echo "This code will only run the first time."

	sleep 10
	
        sudo docker-compose up -d --build --force-recreate
	
	sleep 10

    touch "$INIT_FILE"
else
    echo "The initialization file '$INIT_FILE' exists. This part of the script will not run."
    
    sudo docker-compose up -d
fi

echo "App will run on:"
echo $(sudo docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' letsjavaspringboot_app_1)":8080"
echo "Copy or keep the address noted."
echo "Dont forget to type 'sudo docker-compose down' later to shut down this docker if you dont need it anymore. :)"

sleep 5
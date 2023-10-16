build:
	sudo ./mvnw clean package -DskipTests;

build-run:
	sudo docker-compose down;
	sudo ./mvnw clean package -DskipTests;
	sudo docker-compose build;
	echo "Dont forget to run 'make stop' after, in order to stop server";
	sudo docker-compose up;

stop:
	sudo docker-compose down;


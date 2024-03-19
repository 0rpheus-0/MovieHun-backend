build:
	./mvnw package

localDeploy: build
	docker compose build

up: localDeploy
	docker compose up

localDeploy:
	docker compose build

up: localDeploy
	docker compose up

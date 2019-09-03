set -x

mvn package

docker build -t spring-poc-openjdk:latest .
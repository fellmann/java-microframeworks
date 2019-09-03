set -x

mvn package

cp target/full.jar docker/openjdk/full.jar

docker build -t spark-poc-openjdk:latest docker/openjdk
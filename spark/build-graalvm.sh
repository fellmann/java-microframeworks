set -x

mvn package

cp target/full.jar docker/graalvm/full.jar

docker build -t spark-poc-graalvm:latest docker/graalvm
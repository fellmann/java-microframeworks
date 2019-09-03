set -x

# To update native image configuration using native-image-agent, run:
# docker run --rm -it -p 4567:4567 -v $(pwd):/work -w /work oracle/graalvm-ce:19.1.1 sh -c "gu install native-image && java -agentlib:native-image-agent=config-output-dir=/work/config-dir/ -jar target/full.jar -Djava.awt.graphicsenv=sun.java2d.HeadlessGraphicsEnvironment"

mvn package

docker run --rm -it -v $(pwd):/work -w /work oracle/graalvm-ce:19.1.1 sh -c "gu install native-image && native-image -jar /work/target/full.jar --no-server -H:ResourceConfigurationFiles=config-dir/resource-config.json -H:ReflectionConfigurationFiles=config-dir/reflect-config.json --initialize-at-build-time=org.eclipse.jetty.server.HttpOutput --initialize-at-build-time=org.eclipse.jetty --initialize-at-build-time=org.slf4j  --initialize-at-build-time=javax.servlet -H:+AddAllCharsets --static"

cp full docker/native-image/full

docker build -t spark-poc-native-image:latest docker/native-image
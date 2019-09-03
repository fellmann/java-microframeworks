set -x

docker run --rm -it -p 4567:4567 -v $(pwd)/target:/work oracle/graalvm-ce:19.1.1 java -jar /work/full.jar
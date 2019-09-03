set -x

echo "Run 'npm install' and 'npm install -g serverless' first!"

mvn package

serverless deploy

set -x

npm run build

docker build -t express-poc:latest .
def call() {
    sh 'docker build --label maintainer=cloudwithvarjosh@gmail.com -t "$REPO:$TAG" .'
    docker push $DOCKER_IMAGE:$TAG
    docker tag $DOCKER_IMAGE:$TAG $DOCKER_IMAGE:latest
    docker push $DOCKER_IMAGE:lates

}

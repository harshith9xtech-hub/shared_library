def call() {
    sh '''docker build --label maintainer=harshith.shivamoggi@gmail.com -t "$REPO:$TAG" .
          docker tag $REPO:$TAG $DOCKER_IMAGE:$TAG
          docker push $DOCKER_IMAGE:$TAG
          docker tag $DOCKER_IMAGE:$TAG $DOCKER_IMAGE:latest
          docker push $DOCKER_IMAGE:latest
      '''

}

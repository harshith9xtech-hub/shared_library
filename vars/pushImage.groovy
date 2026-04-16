def call() {
    sh """
        docker push ${env.DOCKER_IMAGE}:${env.TAG}
    """
}

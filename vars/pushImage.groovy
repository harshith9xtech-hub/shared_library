def call() {
    if (!env.DOCKER_IMAGE || !env.TAG) {
        error "DOCKER_IMAGE or TAG is not set"
    }

    sh """
        echo "Pushing image: ${env.DOCKER_IMAGE}:${env.TAG}"
        docker push ${env.DOCKER_IMAGE}:${env.TAG}
    """
}

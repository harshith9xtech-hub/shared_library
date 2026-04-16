def call() {
    script {
        sh """
            docker push ${env.DOCKER_IMAGE}:${env.TAG}
        """
    }
}

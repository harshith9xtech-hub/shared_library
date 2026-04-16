def call(Map config = [:]) {
    script {
        withCredentials([usernamePassword(
            credentialsId: config.credentialsId,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            sh """
                echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
            """
        }
    }
}

def call(Map config = [:]) {

    if (!config.credentialsId) {
        error("credentialsId is required for dockerLogin")
    }

    def registry = config.registry ?: ''

    withCredentials([usernamePassword(
        credentialsId: config.credentialsId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        if (registry) {
            sh """
                echo \$DOCKER_PASS | docker login ${registry} -u \$DOCKER_USER --password-stdin
            """
        } else {
            sh """
                echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
            """
        }
    }
}

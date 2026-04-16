def call() {
    withCredentials([usernamePassword(
        credentialsId: 'docker-hub-creds',
        usernameVariable: 'USER',
        passwordVariable: 'PASS'
    )]) {
        sh """
            echo $PASS | docker login -u $USER --password-stdin
        """
    }
}

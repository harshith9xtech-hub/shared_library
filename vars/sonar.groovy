def call() {
    withSonarQubeEnv('sonar') {
        withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
            sh """
               sonar-scanner \
               -Dsonar.projectKey=test-python \
               -Dsonar.sources=. \
               -Dsonar.host.url=http://localhost:9000 \
               -Dsonar.login=sqp_450196e311232642eb7ce5ec7e3e2dc42a7ef95c
            """
        }
    }
}

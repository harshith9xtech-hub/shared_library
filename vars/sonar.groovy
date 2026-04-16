def call() {
    def scannerHome = tool 'sonar-scanner'

    withSonarQubeEnv('sonar') {
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=test-python \
            -Dsonar.sources=.
        """
    }
}

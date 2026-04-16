def call() {
    sh """
        docker run --rm \
        -v /var/run/docker.sock:/var/run/docker.sock \
        aquasec/trivy image \
        --scanners vuln \
        --severity HIGH,CRITICAL \
        --exit-code 1 \
        ${DOCKER_IMAGE}:${TAG}
    """
}

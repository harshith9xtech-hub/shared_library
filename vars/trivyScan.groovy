def call() {
    sh """
        docker run --rm \
        -v /var/run/docker.sock:/var/run/docker.sock \
        ghcr.io/aquasecurity/trivy:latest image \
        --scanners vuln \
        --severity HIGH,CRITICAL \
        --exit-code 0 \
        ${DOCKER_IMAGE}:${TAG}
    """
}

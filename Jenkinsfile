pipeline{
    agent any
    environment {
        DOCKERHUB_USER = 'vanos007'
        IMAGE_NAME = "calc-spe"
        IMAGE_TAG = "latest"
        DOCKER_IMAGE = "${DOCKERHUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
    }
    stages{
        stage('checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/Abhinav-Kumar012/calculator_spe_mini_proj.git'
            }
        }
        stage('test'){
            steps{
                dir('calc'){
                    sh './mvnw clean test'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}", ".")
                }
            }
        }
        stage('Push to DockerHub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-creds') {
                        docker.image("${DOCKERHUB_IMAGE}").push()
                    }
                }
            }
        }
    }
}
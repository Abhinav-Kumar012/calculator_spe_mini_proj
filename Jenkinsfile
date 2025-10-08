pipeline{
    agent any
    triggers {
        githubPush()  
    }
    environment {
        DOCKERHUB_USER = 'vanos007'
        IMAGE_NAME = "calc-spe"
        IMAGE_TAG = "latest"
        DOCKER_IMAGE = "${DOCKERHUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
        ANSIBLE_HOME = "/var/lib/jenkins/.local/bin"
        DOCKERFILE = "Dockerfile.native"
        EMAIL_ID_TO_SEND = "osvanilla30@gmail.com"
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
        stage('Build Docker Image'){
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}", "-f ${DOCKERFILE} .")
                }
            }
        }
        stage('Push to DockerHub'){
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-creds') {
                        docker.image("${DOCKER_IMAGE}").push()
                    }
                }
            }
        }
        stage('Use ansible to deploy'){
            steps{
                dir('ansible'){
                    withEnv(["PATH=${ANSIBLE_HOME}:${env.PATH}"]) {
                        sh 'ansible-playbook -i inventory.ini deploy.yml'
                    }
                }
            }
        }
    }
    post{
        success{
            echo "successfully executed the pipeline"
            mail(
                to : "${EMAIL_ID_TO_SEND}",
                subject: "successfully executed the pipeline in ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body : """
                Build successful. Please check the console output.
                Job: ${env.JOB_NAME}
                Build Number: ${env.BUILD_NUMBER}
                URL : ${env.BUILD_URL}
                """
            )
        }
        failure{
            echo "failed to execute the pipeline"
            mail(
                to : "${EMAIL_ID_TO_SEND}",
                subject: "failed to execute the pipeline in ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body : """
                Build failed. Please check the console output.
                Job: ${env.JOB_NAME}
                Build Number: ${env.BUILD_NUMBER}
                URL : ${env.BUILD_URL}
                """
            )
        }
        cleanup{
            cleanWs()
        }
    }
}
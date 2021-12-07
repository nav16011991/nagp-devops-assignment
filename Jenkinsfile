pipeline {
    agent any
    stages {
        stage("Tools initialization") {
            steps {
                sh "mvn --version"
                sh "java -version"
                sh "docker --version"
            }
        }
        stage("Checkout Code") {
            steps {
                checkout scm
            }
        }
        stage("Check Code Health") {
           steps {
               sh "mvn clean compile"
            }
        }
        stage("Run Test cases") {
           steps {
               sh "mvn clean test"
            }
        }

        stage('Build and push image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_credentials') {

                        def customImage = docker.build("naveenbhardwaj/nagp-devops-assignment")

                        /* Push the container to the custom Registry */
                        customImage.push()
                    }
                }
            }
        }

    }
 }



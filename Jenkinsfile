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
                node {
                    checkout scm

                    docker.withRegistry('https://registry.example.com', 'credentials-id') {

                        def customImage = docker.build("my-image:${env.BUILD_ID}")

                        /* Push the container to the custom Registry */
                        customImage.push()
                    }
                }
            }
        }

    }
 }



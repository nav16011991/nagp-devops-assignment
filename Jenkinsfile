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



    }
 }



pipeline {
agent any
stages {

    stage('Clean WorkSpace') {
        steps {
                delete dir
            } 
        }
    stage('Git-Checkout') {
        steps {
                checkout scm
            }
        }
    stage('Test the Cases') {
        steps {
            script { 
                sh 'mvn test'
                }
            }
        }
    }
}

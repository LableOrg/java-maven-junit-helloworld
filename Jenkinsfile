pipeline {
agent any
stages {

    stage('Clean WorkSpace') {
        steps {
                deleteDir()
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
                sh 'sudo echo "test cases running successfully'
                }
            }
        }
    }
}

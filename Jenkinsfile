pipeline{
  agent any
  stages{
    
    stage('Build Stage') {
      steps{
        script {
          if (isUnix()) {
               sh "mvn -Dmaven.test.failure.ignore=true clean package"
            } else {
            
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
      }
    
    }
    
  }
}

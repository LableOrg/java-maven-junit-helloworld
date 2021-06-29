pipeline{
  agent any
  stages{
    stage('Compile Stage'){
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
    
    stage('Build Stage') {
      steps{
        
    echo 'Windows command compile'
    }
    
  }
}


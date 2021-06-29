pipeline{
  agent any
  stages{
    stage('Compile Stage'){
      steps{
        parallel(
          linux: {
            sh "mvn -Dmaven.test.failure.ignore=true clean package"
          },
           windows: {
                       bat "mvn -Dmaven.test.failure.ignore=true clean package"
                    }
         )
        
        
      
      }
    }
    
    stage('Build Stage') {
      steps{
        
    echo 'Windows command compile'
    }
    
  }
}

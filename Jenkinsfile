pipeline{
  agent any
  stages{
    stage('Compile Stage'){
      steps{
        script {
          if (isUnix()) {
               sh "mvn -Dmaven.test.failure.ignore=true clean package"
            } else {
            
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        
     }
      post{
      success {
                 //   junit '**/target/surefire-reports/TEST-*.xml'
                   // archiveArtifacts 'target/*.jar'
        //post
        
        
        
        slackSend( baseUrl: 'https://hooks.slack.com/services/', channel: 'jenkinsmsg', color: 'good', 
       message:"Build Success - ${env.JOB_NAME} JOB: *${env.BUILD_NUMBER}*.For More Info- <${env.BUILD_URL}|Check build>",
       teamDomain: 'Cybage Mentorship Program', 
       tokenCredentialId: 'Jenkinsslack',
       username: 'shreyag@cybage.com')
                }
      
      
      
      failure{
        slackSend( baseUrl: 'https://hooks.slack.com/services/', channel: 'jenkinsmsg', color: 'danger', 
       message:"Build Success - ${env.JOB_NAME} JOB: *${env.BUILD_NUMBER}*.For More Info- <${env.BUILD_URL}|Check build>",
       teamDomain: 'Cybage Mentorship Program', 
       tokenCredentialId: 'Jenkinsslack',
       username: 'shreyag@cybage.com')
        
      }

      
      
      }
   
      
    
  }
}

}

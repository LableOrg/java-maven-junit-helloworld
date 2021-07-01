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
    
    stage('Slack Notification') {
      steps{
     slackSend baseUrl: 'https://hooks.slack.com/services/', channel: 'jenkinsmsg', color: 'good', 
      BuildStarted: '${env.JOB_NAME} ${env.BUILD_NUMBER}',
       teamDomain: ' Cybage Mentorship Program', 
       tokenCredentialId: 'Jenkinsslack',
       username: 'shreyag@cybage.com'
      }
      
    
  }
}

}

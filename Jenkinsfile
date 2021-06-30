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
      slackSend baseUrl: 'https://hooks.slack.com/services/', 
        channel: 'jenkinsmsg', 
        color: 'good', 
        iconEmoji: 'happy', 
        message: 'Welcome to Jenkins and slack through pipeline', 
        teamDomain: 'Cybage Mentorship Program', 
        tokenCredentialId: 'Jenkinsslack', 
        username: 'shreyag@cybage.com'
      }
      
    
  }
}

}

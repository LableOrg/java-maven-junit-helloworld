import java.text.SimpleDateFormat

node(){
    
    def currentWorkspace = pwd()
    def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
    def buildTimeStamp = dateFormat.format(new Date())
    def GIT_COMMIT_ID
      
    stage('Checkout') {
        container('jnlp') {
            GIT_COMMIT_ID = checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
            doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
            userRemoteConfigs: [[credentialsId: 'jenkins-papajohns', 
            url: 'https://github.com/ekta-papajohns/java-maven-junit-helloworld.git/']]]).GIT_COMMIT
        }
    }
  
    echo "buildTimeStamp is: ${buildTimeStamp}" 
    echo "GIT_COMMIT_ID is: ${GIT_COMMIT_ID}"
    echo "currentworkspace is: ${currentWorkspace}"

    stage('Build'){
        container('maven'){
	try {
          BUILD_ID = sh(returnStdout: true, script: 'echo "`git rev-parse --verify HEAD`"')
          sh 'mvn -f pom.xml clean org.jacoco:jacoco-maven-plugin:0.8.0::prepare-agent install'
		currentBuild.result = 'SUCCESS'
	}catch (Exception err){
		currentBuild.result = 'FAILURE'
        }
	}
    }
    
    /*stage('SonarAnalysis'){
        withSonarQubeEnv {
            container('maven'){
                sh 'mvn -f pom.xml sonar:sonar -Dsonar.projectName=Mapping-Project-Common -Dsonar.projectKey=Mapping-Project-Common'
            }
        }
    }
    
    stage('Dependency Check'){
        dependencyCheckAnalyzer datadir: '', hintsFile: '', includeCsvReports: false, 
        includeHtmlReports: true, includeJsonReports: true, includeVulnReports: true, 
        isAutoupdateDisabled: false, outdir: '', scanpath: '', skipOnScmChange: false, 
        skipOnUpstreamChange: false, suppressionFile: '', zipExtensions: ''
    }
    
    stage('Notification'){
        dependencyCheckPublisher canComputeNew: false, canRunOnFailed: true, 
        defaultEncoding: '', healthy: '', pattern: '', shouldDetectModules: true, 
        unHealthy: ''
    }

    stage('Nexus Upload'){
        container('jnlp'){            
            sh "ls -l ${currentWorkspace}/Common/target/"
            echo "currentworkspace is: ${currentWorkspace}"
            nexusArtifactUploader artifacts: [[artifactId:'common', 
            classifier: '', 
            file: '/home/jenkins/workspace/Mapping-Project-Common/Common/target/common-0.0.2.jar', 
            type: 'jar']], 
            credentialsId: 'Nexus_Access', 
            groupId: 'com.papajohns.mapping', 
            nexusUrl: '35.229.73.196/', 
            nexusVersion: 'nexus3', 
            protocol: 'http', 
            repository: 'pji-local', 
            version: '0.0.2'
        }
    }
    
    stage('GCR image upload'){
        withCredentials([file(credentialsId: 'jenkins-devops', variable: 'FILE')]) {
                    echo "currentworkspace is: ${currentWorkspace}"
                    sh """
                    gcloud auth activate-service-account --key-file=\"${env.FILE}\"
                    cp ${currentWorkspace}/Common/target/common-0.0.2.jar .
                    
                    docker build -t gcr.io/cicd-infrastructure-196017/mapping/common:${GIT_COMMIT_ID} ${currentWorkspace}/Common/
                    docker tag gcr.io/cicd-infrastructure-196017/mapping/common:${GIT_COMMIT_ID} gcr.io/cicd-infrastructure-196017/mapping/common:${buildTimeStamp}
                    gcloud docker -- push gcr.io/cicd-infrastructure-196017/mapping/common
                    """
        }
    }
}*/
    
    stage ('Call test job') {
      	if (currentBuild.result == 'SUCCESS') {
		//build job: 'deploy-nonprod-qa-order-domain-api', parameters: [[$class: 'StringParameterValue', name: 'GIT_COMMIT_ID_LATEST', value: GIT_COMMIT_ID ], [$class: 'StringParameterValue', name: 'PrevBuildstatus', value: currentBuild.result]]
          build job: 'pull-request-builder-test'
      	}	
    }
}

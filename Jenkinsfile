def getDeploymentEnvironment() {
    if (env.BRANCH_NAME.startsWith('PR-')) {
        return 'development'
    } else if (env.BRANCH_NAME == 'master') {
        return 'production'
    }

    return env.BRANCH_NAME
}

pipeline{
	agent any

	stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
                echo 'Cleeanup done'
		    def = ${getDeploymentEnvironment()}
		    echo "the present branch is: ${def}"
            }
        }  

        stage('Checkout')
        {
        	steps{
        			checkout scm
        	}
        }
    }
}

pipeline {
    agent any

    tools {
        gradle "gradle"
        git "Default"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'gradle build -x test'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'gradle test'
            }
        }
    }

    post {
        failure {
            mail to: 'boris.brcina@iso-gruppe.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}

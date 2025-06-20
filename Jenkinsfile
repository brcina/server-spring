pipeline {
    agent any

    tools {
        gradle "gradle"
        git "Default"
        jdk "jdk17"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'gradle clean build -x test'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'gradle test'
            }
        }
        stage('Quality') {
          steps {
                withSonarQubeEnv('sonar-local') {
                   sh 'gradle sonar'
                }
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }

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

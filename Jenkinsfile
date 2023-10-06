pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout source code from version control
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Run Gradle build
                script {
                    def gradleHome = tool 'Gradle' // Assumes you configured Gradle as a tool in Jenkins
                    sh "${gradleHome}/bin/gradle clean build"
                }
            }
        }
    }
    
    post {
        success {
            echo "Build successful! Add deployment steps here."
        }
        failure {
            echo "Build failed. Take necessary actions."
        }
    }
}

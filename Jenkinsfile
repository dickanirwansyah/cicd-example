pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }

    stages {
        stage ('Build') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/dickanirwansyah/cicd-example']])
                bat './gradlew assemble'
            }
        }
        stage ('Unit Test') {
            steps {
                bat './gradlew test'
            }
        }
        stage ('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t dickanirwansyah1996/service-job .'
                }
            }
        }
        stage ('Deploy to Docker Container') {
            steps {
                script {
                    bat 'docker run --publish 9898:9898 dickanirwansyah1996/service-job'
                }
            }
        }
    }
}
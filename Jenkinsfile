pipeline {
    agent any
    tools{
        maven 'maven-3.9.5'
    }
    stages{
        stage('Build Maven'){
            steps{
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BhaskarNelapogula7/SampleSpringRestApp']])
               bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t bhaskarnelapogula/dockerrest:1.0 .'
                }
            }
        }
        stage('Create Docker container') {
            steps {
                script {
                    bat "docker run -d --name my-rest-container -p 8082:2023 bhaskarnelapogula/dockerrest:1.0"
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                     withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhubpwd')]) {
                     bat "docker login -u bhaskarnelapogula -p ${dockerhubpwd}"
                    }
                     bat "docker push bhaskarnelapogula/dockerrest:1.0"
                }
            }
        }
    }
}

pipeline {
    agent any

    tools {
        maven 'Maven 3.8.7'
        jdk 'openjdk-17'
    }

    stages {
        stage("build") {

            steps {
                dir("java/boardgamechooser") {
                    echo 'Building BoardGameChooser application'
                    sh 'pwd'
                    sh 'ls'
                    sh 'mvn clean install -DskipTests=true'
                }
            }
        }

        stage("Unit tests") {
            steps {
                dir("java/boardgamechooser") {
                    echo 'Running unit tests on BoardGameChooser'
                    sh 'mvn test'
                }
            }
        }

        stage("deploy") {
            steps {
                echo 'Deploying BoardGameChooser'
            }
        }
    }
}

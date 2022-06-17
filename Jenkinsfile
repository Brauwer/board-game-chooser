pipeline {
  agent any

  tools {
    maven 'Maven 3.8.6'
    jdk 'JDK18'
  }

  stages {
    stage("build") {
      steps {
        echo 'Building BoardGameChooser application'
        dir('cd java/boardgamechooser/')
        sh 'mvn clean install -DskipTests=true'
      }
    }

    stage("Unit tests") {
        steps {
            echo 'Running unit tests on BoardGameChooser'
            dir('cd java/boardgamechooser/')
            sh 'mvn test'
        }
    }

    stage("deploy") {
      steps {
        echo 'Deploying BoardGameChooser'
      }
    }
  }
}

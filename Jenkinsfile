pipeline {
  agent any
    stages {
      stage('Get Source Code') {
         steps
            {
                echo 'Running tests from Jenkins pipeline'
            }
        }
      stage('Build code'){
         steps
            {
                 bat 'mvn compile'
            }
        }
       stage('Run Test'){
          steps
            {
                 bat 'mvn test'
            }
        }
    }
}

def gv

pipeline {
  
  agent any
  tools {
    maven 'M2_HOME' 
  }
  stages {
    stage("init") {
      steps {
         script {
           gv = load "script.groovy"
         }
       }
     }
    stage("MVN CLEAN") {      
      steps {
        script {
          gv.mvnclean()    
      }
    }
  }
    stage("MVN COMPILE") {
      steps {
        script {
          gv.mvncompile()
      }
    }
  }
    stage("MVN SONARQUBE") {
      steps {
        script {
          gv.mvnsonarqube()
      }
    }
  }
   stage('JUNIT-MOCKITO'){
     steps{
      echo 'hello world'
  }
 }
  stage('NEXUS') {
    steps{
      script {
        gv.deploynexus
      }
    }
   }
  }
}

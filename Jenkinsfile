def gv

pipeline {
  
  agent any
  tools {
    maven 
  }
  stages {
    stage("init") {
      steps {
         script {
           gv = load "script.groovy"
         }
       }
     }
    stage("build jar") {
      
      steps {
        script {
          gv.buildJar()    
      }
    }
  }
 }
}

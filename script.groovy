def mvnclean() {
  echo "cleaning the application..."
  sh'mvn clean'
}
def mvncompile() {
  echo "compiling the application..."
  sh'mvn compile'
}
def mvnsonarqube() {
  echo "Analyzing the application..."
  sh'mvn admin:sonar -Dsonar.login=myAuthenticationToken'
}


  return this

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
  sh'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
}
//def junitmockito(){
  


  return this

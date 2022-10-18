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

def JunitMockito() {
  echo "Testing the application..."
  sh'mvn test'
  
}
def deploynexus() {
echo "Deploy to nexus..."
 sh'mvn deploy -DskipTests'
}


  return this

def mvnclean() {
  echo "cleaning the application..."
  sh'mvn clean'
}
def mvncompile() {
  echo "compiling the application..."
  sh'mvn compile'
}
def mvnsonarqube() {
  echo ".. the application..."
  sh'mvn clean install'
}


  return this

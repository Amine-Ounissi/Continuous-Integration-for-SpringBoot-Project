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
def buildJar() {
  echo "building the application..."
  sh'mvn clean package'
}
def buildImage() {
  echo "building the docker image..."
  withCredentials([usernamePassword(credentialsId: 'Docker-hub-repo', passwordVariable: 'PASS', usernameVariable:'USER')]) {
      sh 'docker build -t amineounissi/my-repo:achat.$IMAGE_NAME .'
      sh "docker login -u $USER -p $PASS"
      sh 'docker push amineounissi/my-repo:achat.$IMAGE_NAME'           
   }   
}

def deployDocker() {
  echo "running docker-compose..."
  sh'docker-compose up'
}

  return this

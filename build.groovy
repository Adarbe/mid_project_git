pipeline{
  agent{
    node("jenkins-slave")
    }
   stages{
    stage("scm checkout"){
     steps{
      cleanWs()
      git branch:"master", url:"git@github.com:tanya102/python-Projects-for-beginners-.git"
      }
    }	 
   stage("Docker build & push") {
    steps{
      app = docker.build( "credit card validator.ipynb:${commithash}_${BUILD_NUMBER}", " --no-cache .")
       app.run("-p 80:8083")
       curl -L {"http://localhost:8083"}
       app.push()
       sh( script: "docker rmi ${app.id}")
       }
   }
 }
}

node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/nishadmehendale/Spring-Boot-Freestyle'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
   }
   stage('Results') {
      archive 'target/*.jar'
   }
   
   stage('Pushing to Atrifcatory'){
      sh"cd / --"
      sh"curl -X PUT -u admin:Capgemini@123 -T ./var/lib/docker/volumes/jenkins_home/_data/workspace/Spring' 'Demo/target/BalanceSheetApp-0.0.1-SNAPSHOT.jar 'http://ec2-54-201-29-152.us-west-2.compute.amazonaws.com:8081/artifactory/libs-release-local/nishad/Balance.jar'"
   }
}

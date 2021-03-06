import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "Hannibal"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
       "org.apache.hadoop" % "hadoop-core" % "0.20.2-cdh3u4",
       "org.apache.hbase" % "hbase" % "0.90.6-cdh3u4",
       "org.mockito" % "mockito-core" % "1.9.0" % "test",
       "org.mockito" % "mockito-all" % "1.9.0" % "test"
    )

    val appResolvers = Seq(
      "Cloudera Public Repository" at "http://repository.cloudera.com/artifactory/cloudera-repos/",
      "Mockito Core" at "http://repo2.maven.org/maven2/org/mockito/mockito-core",
      "Mockito All" at "http://repo2.maven.org/maven2/org/mockito/mockito-all"
    ) 
    
    val projectSettings = Seq( 
      ivyXML :=
    		<dependencies>
    			<exclude module="thrift"/>
    		</dependencies>
    ) 

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
        resolvers ++= appResolvers  
    )

    override lazy val settings = super.settings ++ projectSettings
}

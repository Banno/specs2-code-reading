import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val t8ReleasesRepo = "Banno Releases Repo" at "http://10.3.0.26:8081/nexus/content/repositories/releases/"
  val t8ExternalRepo = "Banno External Repo" at "http://10.3.0.26:8081/nexus/content/groups/external/"
  val bannoPlugin    = "com.banno" % "banno-sbt-plugin" % "1.0.20"
}

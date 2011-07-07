import sbt._

class Project(info: ProjectInfo) extends DefaultBannoProject(info) with Specs2TestDeps with BannoAkkaProject {
  override lazy val specs2Version = "1.4"
}

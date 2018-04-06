plugins {
  `kotlin-dsl`
  id("nebula.resolution-rules") version "5.1.1"
  `maven-publish`
}

repositories {
  google()
  mavenCentral()
  jcenter()
}

dependencies {
  compile("com.android.tools.build:gradle:3.1.0")
  resolutionRules("com.netflix.nebula:gradle-resolution-rules:0.52.0")
}

val sourcesJar by tasks.creating(Jar::class) {
  dependsOn(JavaPlugin.CLASSES_TASK_NAME)
  classifier = "sources"
  from(java.sourceSets["main"].allSource)
}

val javadocJar by tasks.creating(Jar::class) {
  dependsOn(JavaPlugin.JAVADOC_TASK_NAME)
  classifier = "javadoc"
  from(java.docsDir)
}

group = "com.omricat"
version = "0.1"

publishing {
  (publications) {
    "mavenJava".invoke(MavenPublication::class) {
      from(components["java"])
      artifact(sourcesJar)
      artifact(javadocJar)
    }
  }
}

import org.codehaus.gant.GantBinding

/*
 * Hooks an event handler to the CompileStart event to run the Scala compiler on Java and Scala sources.
 * It also updates source and class paths for the groovyc compiler with scala sources and libraries and optionally
 * copies Scala runtime libraries to the project's lib folder.
 *
 * Scala sources may be placed and combined in any way with Java sources in and across both /src/java and /src/scala.
 * All the Groovy sources including Grails-specific ones, like domain classes, controllers and such,
 * are directly visible inside the Scala sources, as well as all Groovy sources can use all Scala
 * or Java classes.
 */
Ant.property(environment: "env")

/**
 * Hooks to the compile grails event
 */
eventCompileStart = {GantBinding compileBinding ->
  if (compilingScalaPlugin()) {
    return
  }

  ant.path(id: "scala.compile.classpath") {
    path(refid: "grails.compile.classpath")
  }

  ant.taskdef(name: 'generateGroovyStubsForScala', classname: 'org.codehaus.groovy.grails.cli.GenerateStubsTask')
  ant.taskdef(name: 'scalac', classname: 'scala.tools.ant.Scalac', classpathref: "scala.compile.classpath")
    

  try {
    def scalaSrcEncoding = buildConfig.scala?.src?.encoding ?: 'UTF-8'

    println "[scalaPlugin] Compiling Scala sources from plugins to $pluginClassesDirPath"
    ant.mkdir(dir: pluginClassesDirPath)
    ant.scalac(destdir: pluginClassesDirPath,
            classpathref: "scala.compile.classpath",
            encoding: scalaSrcEncoding) {
        
      pluginSettings.pluginInfosMap.each { name, pluginInfo ->
        File pluginPath = getPluginDirForName(pluginInfo.name).file
        def newFile = new File("${pluginPath.path}/src/java")
        if (newFile.directory) {
          src(path: "${newFile.path}")
        }
        newFile = new File("${pluginPath.path}/src/scala")
        if (newFile.directory) {
          src(path: "${newFile.path}")
        }
      }
    }

    println "[scalaPlugin] Compiling Scala sources to $classesDirPath"
    ant.mkdir(dir: classesDirPath)
    ant.scalac(destdir: classesDirPath,
        classpathref: "scala.compile.classpath",
        encoding: scalaSrcEncoding) {
            if(new File("${basedir}/src/java").exists()) {
                src(path: "${basedir}/src/java")
            }
            if(new File("${basedir}/src/scala").exists()) {
                src(path: "${basedir}/src/scala")
            }
    }

  } catch (Exception e) {
    Ant.fail(message: "Could not compile Scala sources: " + e.class.simpleName + ": " + e.message)
  }
}

/**
 * Detects whether we're compiling the scala plugin itself
 */
private boolean compilingScalaPlugin() { getPluginDirForName("scala") == null }

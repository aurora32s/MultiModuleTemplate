pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MultiModuleTemplate"
include(":app")
// feature
include(":feature:sample")

// core
include(":core:ui")
include(":core:network")
include(":core:database")
include(":core:datastore")
include(":core:data")
include(":core:domain")
include(":core:common")

# resume-builder-lib

## Установка через Gradle

Чтобы использовать библиотеку, добавьте следующие строки в файл `build.gradle` модуля, где нужен определенный пакет:

```gradle

    repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/eg0rmaffin/resume-builder-client-lib")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.token") ?: System.getenv("TOKEN")
        }
    }
}

implementation 'app.resumebuilder:resume-builder-client-lib:0.0.2-SNAPSHOT'


```

Вам понадобится аккаунт github и read-token, который лежит в mattermost. 


## Установка переменных

Создайте в User/.gradle файл gradle.properties и установите переменные gpr.user и gpr.token
# resume-builder-lib

## Установка через Gradle

Чтобы использовать библиотеку, добавьте следующие строки в файл `build.gradle` вашего проекта:

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
//тут берите свежую версию. Открываете packages и смотрите какая сейчас версия пакета. В этом примере мы импортируем client-model

```

Вам понадобится аккаунт github и read-token, который лежит в mattermost. 



## Установка переменных

Создайте в своем локальном User/.gradle файл gradle.properties и установите переменные `gpr.user` и `gpr.token`. Рид токен возьмите в маттермосте.

## Обновление и добавление новых библиотек

Если вы контрибутор, выполняете пуш и библиотека будет автоматически билдиться и публиковаться. Чтобы пользователи получили свежий пакет, в файле `build.gradle` нужного модуля обновляете версию на следующую, тогда пакет обновится и новая версия будет доступна для скачивания. В случае добавления новой библиотеки обновляете также и корневой файлик `settings.gradle`. В `build.gradle` нового модуля по аналогии добавляете publish таску. Будет создан и доступен новый пакет.

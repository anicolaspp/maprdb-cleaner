#!/usr/bin/env bash

java -cp "/opt/mapr/lib/*:/Users/nperez/IdeaProjects/maprdb-cleaner/target/scala-2.11/maprdb-cleaner-1.0.0.jar:." -Djava.library.path=/opt/mapr/lib com.github.anicolaspp.maprdbcleaner.App "$@"

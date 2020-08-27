#!/usr/bin/env sh
cd ..
sbt assembly
cd docker
mv ../target/scala-2.13/app-assembly.jar .
java $* -jar ./app-assembly.jar

#docker build -t scala-app ./
#docker run scala-app:latest

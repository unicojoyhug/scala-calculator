#!/usr/bin/env sh
cd ..
sbt assembly
cd docker
mv ../target/scala-2.13/app-assembly.jar .
chmod 777 app-assembly.jar
docker build -t scala-app ./
docker run scala-app:latest

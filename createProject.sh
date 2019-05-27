#!/bin/bash

root="/opt/tomcat/apache-tomcat-9.0.20/webapps/projects"
project_name=$1
mkdir $root/$project_name
mkdir $root/$project_name/WEB-INF
sudo cp -r $root/../ROOT/WEB-INF/web.xml $root/$project_name/WEB-INF
sudo mkdir $root/$project_name/WEB-INF/classes
sudo mkdir $root/$project_name/WEB-INF/lib

# Pull base image
FROM ubuntu:14.04

# Install java-8
RUN \
 echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
 apt-get update && \
 apt-get install -y software-properties-common && \
 add-apt-repository -y ppa:webupd8team/java && \
 apt-get update && \
 apt-get install -y oracle-java8-installer && \
 rm -rf /var/lib/apt/lists/* && \
 rm -rf /var/cache/oracle-jdk8-installer

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# Install tomcat-8
RUN apt-get update && \
    apt-get install -yq --no-install-recommends wget pwgen ca-certificates && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV TOMCAT_MAJOR_VERSION 8
ENV TOMCAT_MINOR_VERSION 8.0.11
ENV CATALINA_HOME /tomcat

# INSTALL TOMCAT
RUN wget -q https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_MINOR_VERSION}/bin/apache-tomcat-${TOMCAT_MINOR_VERSION}.tar.gz && \
    wget -qO- https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_MINOR_VERSION}/bin/apache-tomcat-${TOMCAT_MINOR_VERSION}.tar.gz.md5 | md5sum -c - && \
    tar zxf apache-tomcat-*.tar.gz && \
    rm apache-tomcat-*.tar.gz && \
    mv apache-tomcat* tomcat
FROM ubuntu:22.04

RUN apt-get update && \
    apt-get install -y openjdk-8-jdk

RUN apt-get update && \
    apt-get install -y curl unzip zip && \
    apt-get clean

RUN curl -s "https://get.sdkman.io" | bash

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install kotlin"
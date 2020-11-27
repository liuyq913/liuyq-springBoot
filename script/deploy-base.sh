#!/usr/bin/env bash

workDir=$(cd $(dirname $0); pwd)
cd ${workDir}/../liuyq-springBoot-base

mvn clean
mvn -DskipTests=true deploy -pl liuyq-springBoot-lcn,liuyq-springBoot-utils,liuyq-springBoot-zk,liuyq-sringBoot-redis -Pdev
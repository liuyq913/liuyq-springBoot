#!/usr/bin/env bash

workDir=$(cd $(dirname $0); pwd)
cd ${workDir}/..

mvn clean compile -Dmaven.test.skip=true

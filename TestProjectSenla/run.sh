#!/bin/bash

javac -d out $(find src -name "*.java")
if [ $? -eq 0 ]; then
    java -cp out Main
else
    echo "Компиляция не получилась!"
fi


#!/bin/bash

git add .
git commit -m "Scripted auto-commit on change ($(date +'%Y-%m-%d %T')) by gitwatch.sh"
git push origin master

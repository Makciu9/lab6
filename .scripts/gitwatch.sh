#!/bin/bash

fswatch -e ".git" -0 /Users/makcuzlov/lab5 | xargs -0 -n 1 bash /Users/makcuzlov/lab6/.scripts/commit-all.sh

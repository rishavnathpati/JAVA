#!/bin/bash

directory=$(pwd)

# Use find to locate all .class files in the directory and its subdirectories, and delete them
find "$directory" -name "*.class" -type f -delete

# Let the user know the operation is complete
echo "All .class files in $directory and its subdirectories have been deleted."
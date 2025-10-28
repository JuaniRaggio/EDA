#!/bin/bash

for file_name in $@; do
    pptx2md "$file_name"
    cat out.md > "${file_name%.pptx}.md"
done


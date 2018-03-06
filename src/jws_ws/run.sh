#! /bin/bash

IM="nginx:1.13-alpine"

LV="$(pwd)"
CV="/usr/share/nginx/html"

docker run --rm --name myserver \
    -v $LV:$CV:ro -p 8080:80 -d $IM

#!/usr/bin/env bash

echo "please input your name！"
read name
echo "hello, $name"

a=10
b=20

c=`expr $a + $b`
echo "hello: $c"
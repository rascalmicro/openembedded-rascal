#!/bin/sh

HOSTNAME="`sed -ne 's/^[^:]*:[^:]*:[^:]*:[^:]*:\([^:]*\):.*/\1/p' /proc/cmdline`"

if [ -z "$HOSTNAME" ]
then
    HOSTNAME="rascal"
fi  
    
echo "$HOSTNAME" > /etc/hostname

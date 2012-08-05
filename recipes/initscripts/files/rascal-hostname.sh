#!/bin/sh

# Explanation of the sed command below
# 
# sed -ne s/thing1/thing2/p /path/to/file means:
#    "Search the file for thing1, replace it with thing2,
#    and only print the lines that you changed."
# [^:]* means zero or more characters from the set "not colons"
# \(something\) means "save this for later"
# \1 means "retrieve the first thing you saved"
#
# Overall, the command means:
#    "Search /proc/cmdline for 5 colons after ip=,
#    and print what's between colons 4 and 5."

HOSTNAME="`sed -ne 's/^.*ip=[^:]*:[^:]*:[^:]*:[^:]*:\([^:]*\):.*/\1/p' /proc/cmdline`"

if [ -z "$HOSTNAME" ]
then
    HOSTNAME="rascal"
fi  
    
echo "$HOSTNAME" > /etc/hostname

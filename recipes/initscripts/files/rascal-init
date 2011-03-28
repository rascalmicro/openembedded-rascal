#!/bin/sh

# void log_msg(char*)
log_msg()
{
    /usr/bin/logger -s $1
}

#
# Busybox's chpasswd applet should do this for us, but
# it fails on root so we use this function instead
#
# int change_pw(char* username, char* pw_hash)
change_pw()
{
    local USER_NAME=$1
    local NEW_PW_HASH=$2

    local PASSWD_FILE=/etc/passwd
    local TEMP_FILE=/etc/passwd.tmp

    rm -f $TEMP_FILE
    while IFS=: read -r f1 f2 f3 f4 f5 f6 f7
    do
        if [ $f1 = $USER_NAME ]; then
            f2=$NEW_PW_HASH
        fi
        echo "$f1:$f2:$f3:$f4:$f5:$f6:$f7" >> $TEMP_FILE
    done < $PASSWD_FILE

    # Comment this out for dry-run
    mv $TEMP_FILE $PASSWD_FILE
}

log_msg "Initializing Rascal"

#
# If root's password is blank, set it to board-specific default
#
PASSWD_FILE=/etc/passwd
IS_BLANK=0
DEF_PW_HASH=XnugPeUjnLedI

while IFS=: read -r f1 f2 f3 f4 f5 f6 f7
do
    if [ $f1 = "root" ]; then
        if [ -z $f2 ]; then
            IS_BLANK=1
        fi
        break
    fi
done < $PASSWD_FILE

if [ $IS_BLANK != 0 ]; then
    log_msg "Root's password was blank. It is now set to the default password for this board."
    change_pw root $DEF_PW_HASH
else
    log_msg "Root's password is not blank -- good job."
fi

exit 0

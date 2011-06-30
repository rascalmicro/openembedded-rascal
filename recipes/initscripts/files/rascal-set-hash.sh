#!/bin/sh

# void log_msg(char*)
log_msg()
{
    local MSG=$1
    /usr/bin/logger -s -- $MSG
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
BACKUP_PW_HASH=LosSvlkIAcGLk    # "rascalmicro"
PW_HASH="`sed -ne 's/^.* pwhash=\(.\{13\}\)/\1/p' /proc/cmdline`"

if [ -z "$PW_HASH" ]; then
    PW_HASH=$BACKUP_PW_HASH
fi

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
    log_msg "Root's password was blank."
    change_pw root $PW_HASH
    if [ "$PW_HASH" == "$BACKUP_PW_HASH" ]; then
        log_msg "The root hash was not found in kernel command line."
        log_msg "A hardcoded default hash has been used instead."
        log_msg "This is *bad*. You should reset the root password immediately."
    else
        log_msg "The root password is now set to the default for this board."
        log_msg "Ask milo@rascalmicro.com for the password if you've lost it."
    fi
    log_msg "For reference, the hash used is $PW_HASH."
else
    log_msg "Root's password is not blank; good job."
    log_msg "You are part of the solution."
fi

exit 0

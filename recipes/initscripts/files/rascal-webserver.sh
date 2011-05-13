#!/bin/sh

PATH=/sbin:/bin:/usr/bin
BASE_DIR="/home/root/helloworld"
WEBSERVER="/home/root/rascal/bin/paster"
WEBSERVER_CONFIG="/home/root/helloworld/development.ini"

test -d $BASE_DIR || exit 0
test -f $WEBSERVER || exit 0
test -f $WEBSERVER_CONFIG || exit 0

cd $BASE_DIR

case "$1" in
start)
    echo "Starting Rascal webserver..."
    $WEBSERVER serve --daemon $WEBSERVER_CONFIG start
    echo "done"
    ;;
restart)
    echo "Restarting Rascal webserver..."
    $WEBSERVER serve --daemon $WEBSERVER_CONFIG restart
    echo "done"
    ;;
stop)
    echo "Stopping Rascal webserver..."
    $WEBSERVER serve --daemon $WEBSERVER_CONFIG stop
    echo "done"
    ;;
*)
    echo "Bad argument supplied to rascal-webserver script."
    echo "Usage: /etc/init.d/rascal-webserver {start|stop|restart}"
    exit 1
esac

exit 0

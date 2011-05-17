#!/bin/sh

PATH=/sbin:/bin:/usr/bin:/usr/sbin
WEBSERVER="/usr/sbin/nginx"
WEBSERVER_CONFIG="/etc/nginx/nginx.conf"
APPSERVER="/usr/sbin/uwsgi"
APPSERVER_CONFIG="/etc/uwsgi.ini"

test -f $WEBSERVER || exit 0
test -f $WEBSERVER_CONFIG || exit 0
test -f $APPSERVER || exit 0
test -f $APPSERVER_CONFIG || exit 0

case "$1" in
start)
    echo "Starting Rascal webserver..."
    $WEBSERVER -c $WEBSERVER_CONFIG
    $APPSERVER --ini $APPSERVER_CONFIG
    echo "done"
    ;;
reload)
    echo "Reloading Rascal webserver..."
    $WEBSERVER -c $WEBSERVER_CONFIG -s reload
    echo "done"
    ;;
stop)
    echo "Stopping Rascal webserver..."
    $WEBSERVER -s stop
    echo "done"
    ;;
*)
    echo "Bad argument supplied to rascal-webserver script."
    echo "Usage: /etc/init.d/rascal-webserver {start|stop|reload}"
    exit 1
esac

exit 0

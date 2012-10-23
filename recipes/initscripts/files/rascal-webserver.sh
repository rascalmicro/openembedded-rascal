#!/bin/sh

PATH=/sbin:/bin:/usr/bin:/usr/sbin
WEBSERVER="/usr/sbin/nginx"
WEBSERVER_CONFIG="/etc/nginx/nginx.conf"
APPSERVER="/usr/sbin/uwsgi"
APPSERVER_CONFIG_DIR="/etc/uwsgi/"

test -f $WEBSERVER || exit 0
test -f $WEBSERVER_CONFIG || exit 0
test -f $APPSERVER || exit 0
test -d $APPSERVER_CONFIG_DIR || exit 0

case "$1" in
start)
    echo "Starting Rascal webserver..."
    $WEBSERVER -c $WEBSERVER_CONFIG
    $APPSERVER --emperor $APPSERVER_CONFIG_DIR --daemonize /var/log/uwsgi/emperor.log
    echo "done"
    ;;
reload|restart)
    echo "Reloading Rascal webserver..."
    $WEBSERVER -c $WEBSERVER_CONFIG -s reload
    echo "done"
    echo "Reloading Python appserver..."
    for file in $APPSERVER_CONFIG_DIR*
    do
        echo "Reloading app from $file"
        touch $file
    done
    echo "done"
    ;;
stop)
    echo "Stopping Rascal webserver..."
    $WEBSERVER -s stop
    ps | awk  '/uwsgi/ && !/awk/ {print $1}'| xargs kill -9
    echo "done"
    ;;
*)
    echo "Bad command passed to Rascal webserver boot script."
    echo "Correct usage: /etc/init.d/rascal-webserver.sh {start|stop|reload}"
    exit 1
esac

exit 0

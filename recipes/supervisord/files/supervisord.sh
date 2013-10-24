#! /bin/sh
#
# Written by Miquel van Smoorenburg <miquels@cistron.nl>
# Modified for Debian GNU/Linux
# by Ian Murdock <imurdock@gnu.ai.mit.edu>
# Modified for resetbutton by Juan Menendez <juanmb@pulseingenieria.com>

PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin
DESC="Supervisor"
NAME=supervisord
DAEMON=/usr/bin/$NAME
PIDFILE=/var/run/$NAME.pid
DAEMON_ARGS="--pidfile ${PIDFILE} --config /etc/$NAME.conf"
SUPERVISORCTL=/usr/bin/supervisorctl

test -x $DAEMON || exit 0

set -e

do_start()
{
	# Return
	#   0 if daemon has been started
	#   1 if daemon was already running
	#   2 if daemon could not be started
	[ -e $PIDFILE ] && return 1

        start-stop-daemon --start --quiet --pidfile $PIDFILE --exec $DAEMON -- \
		$DAEMON_ARGS || return 2
}

do_stop()
{
	# Return
	#   0 if daemon has been stopped
	#   1 if daemon was already stopped
	#   2 if daemon could not be stopped
	#   other if a failure occurred
	[ -e $PIDFILE ] || return 1

	# Stop all processes under supervisord control.
	$SUPERVISORCTL stop all

	start-stop-daemon --stop --quiet --retry=TERM/30/KILL/5 --pidfile $PIDFILE --name $NAME
	RETVAL="$?"
	[ "$RETVAL" = 2 ] && return 2
	# Wait for children to finish too if this is a daemon that forks
	# and if the daemon is only ever run from this initscript.
	# If the above conditions are not satisfied then add some other code
	# that waits for the process to drop all resources that could be
	# needed by services started subsequently.  A last resort is to
	# sleep for some time.
	start-stop-daemon --stop --quiet --oknodo --retry=0/30/KILL/5 --exec $DAEMON
	[ "$?" = 2 ] && return 2
	# Many daemons don't delete their pidfiles when they exit.
	rm -f $PIDFILE
	return "$RETVAL"
}

case "$1" in
  start)
        echo -n "Starting $DESC: $NAME"
	do_start
        echo "."
        ;;
  stop)
        echo -n "Stopping $DESC: $NAME"
	do_stop
        echo "."
        ;;
  restart)
        echo -n "Restarting $DESC: $NAME"
	do_stop
	do_start
        echo "done."
        ;;
  *)
        N=/etc/init.d/$NAME
        echo "Usage: $N {start|stop|restart}" >&2
        exit 1
        ;;
esac

exit 0

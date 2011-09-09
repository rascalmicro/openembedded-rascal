#!/usr/bin/env python

import daemon

from pytronics import analogger

with daemon.DaemonContext():
    analogger()

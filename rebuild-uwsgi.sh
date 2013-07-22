#!/bin/sh

rm oe_sources/uwsgi-1.2.3.tar.gz*
bitbake -c clean uwsgi
cog.py -r recipes/uwsgi/uwsgi_1.2.3.bb
bitbake -D -b uwsgi_1.2.3.bb

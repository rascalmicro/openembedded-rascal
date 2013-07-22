DESCRIPTION = "Networking library that uses greenlet to provide synchronous API on top of libevent event loop"

SECTION = "devel/python"
HOMEPAGE = "http://www.gevent.org"
LICENSE = "MIT"
DEPENDS = "libevent"
RDEPENDS_${PN} = "\
	python-pprint \
	python-greenlet"

PR = "r1"

SRC_URI = "http://pypi.python.org/packages/source/g/gevent/gevent-${PV}.tar.gz"
S = "${WORKDIR}/gevent-${PV}"

inherit setuptools

FILES_${PN}-dbg += "${libdir}/python2.*/site-packages/gevent/.debug"

SRC_URI[md5sum] = "ca9dcaa7880762d8ebbc266b11252960"
SRC_URI[sha256sum] = "54b8d26300ce408c0916a3e63ef6cd3e6aca76230833558deb7de15196ed955e"


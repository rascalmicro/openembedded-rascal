DESCRIPTION = "Networking library that uses greenlet to provide synchronous API on top of libevent event loop"

SECTION = "devel/python"
HOMEPAGE = "http://www.gevent.org"
LICENSE = "MIT"
DEPENDS = "libevent python-cython"
RDEPENDS_${PN} = "\
	python-pprint \
	python-greenlet"

PR = "r1"

SRC_URI = "http://rascalmicro.com/sources/gevent-${PV}.tar.gz"
S = "${WORKDIR}/gevent-${PV}"

CYTHON = ${WORKDIR}/tmp/work/i686-linux/python-cython-native-0.15.1-r3/Cython-0.15.1/bin/cython

inherit setuptools

FILES_${PN}-dbg += "${libdir}/python2.*/site-packages/gevent/.debug"

SRC_URI[md5sum] = "e1bce8e15c7ebb08788978c0f4860f9d"
SRC_URI[sha256sum] = "f74bfe36e969e53b5e83ef06f7bee0b867147a38a762abb325cb7ad7b299c584"


DESCRIPTION = "Lightweight in-process concurrent programming"

SECTION = "devel/python"
HOMEPAGE = "https://github.com/python-greenlet/greenlet"
LICENSE = "MIT"
PR = "r1"

SRC_URI = "http://pypi.python.org/packages/source/g/greenlet/greenlet-${PV}.zip"
S = "${WORKDIR}/greenlet-${PV}"

inherit distutils

FILES_${PN}-dbg += "${libdir}/python2.*/site-packages/.debug"

SRC_URI[md5sum] = "87887570082caadc08fb1f8671dbed71"
SRC_URI[sha256sum] = "3f52af03bf8a89045fc159c6a76d5642349b30fb41c3df1a22b12bbd3920b1ee"


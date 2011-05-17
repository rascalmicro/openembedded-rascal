DESCRIPTION = "WSGI utility library for Python"
HOMEPAGE = "http://werkzeug.pocoo.org"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "werkzeug"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "0.6.2"
SRC_URI = "git://github.com/mitsuhiko/werkzeug.git;protocol=git;branch=master"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

SRC_URI[md5sum] = "dda6be061c9158ee4371c27b34e6b521"
SRC_URI[sha256sum] = "f749c0eb77ee7fec24d09770e71a3503e5444066bc872a1e91bb08001a7f7cc1"

DESCRIPTION = "WSGI utility library for Python"
HOMEPAGE = "http://werkzeug.pocoo.org"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "werkzeug"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "0.9.1"
SRC_URI = "git://github.com/mitsuhiko/werkzeug.git;protocol=git;branch=master"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

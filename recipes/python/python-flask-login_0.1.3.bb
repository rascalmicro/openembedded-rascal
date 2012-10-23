DESCRIPTION = "User session management for Flask"
HOMEPAGE = "http://packages.python.org/Flask-Login/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
SRCNAME = "Flask-Login"
PR = "r0"

S = "${WORKDIR}/${SRCNAME}-${PV}"
SRC_URI = "http://pypi.python.org/packages/source/F/Flask-Login/Flask-Login-${PV}.tar.gz"

inherit setuptools

RDEPENDS_${PN} = "\
  python-flask \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

SRC_URI[md5sum] = "8a9234d5e957f439cde270d026037363"
SRC_URI[sha256sum] = "8a1b309fc306875305bd4d2b95733a3e5527b637b0d1f9af3984d140f6284acf"

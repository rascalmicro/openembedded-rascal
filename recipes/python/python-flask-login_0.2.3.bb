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

SRC_URI[md5sum] = "566d1b13f2273d7bc35b04151539fa7d"
SRC_URI[sha256sum] = "c829d659cb7095601b2bc17ba3d7649deec78889eaa79e7613dcdfb9936c5830"

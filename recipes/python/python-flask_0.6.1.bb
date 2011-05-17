DESCRIPTION = "Web microframework for Python based on Werkzeug, Jinja 2 and good intentions"
HOMEPAGE = "http://flask.pocoo.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "flask"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "0.6.1"
SRC_URI = "git://github.com/mitsuhiko/flask.git;protocol=git;branch=master"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
  python-jinja2 \
  python-werkzeug \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

SRC_URI[md5sum] = "7af56e33fb6a35db2818c20e604c8698"
SRC_URI[sha256sum] = "fe0e31bf71a1fc1d2e0786052855c94cd9ee43546d3e15ff98ccee0c5bc21f70"

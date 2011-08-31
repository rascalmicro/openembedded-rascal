DESCRIPTION = "Web microframework for Python based on Werkzeug, Jinja 2 and good intentions"
HOMEPAGE = "http://flask.pocoo.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "flask"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "0.7.2"
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

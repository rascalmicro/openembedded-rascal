DESCRIPTION = "uWSGI is a WSGI web server for Python web applications"
HOMEPAGE = "http://projects.unbit.it/uwsgi/wiki"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"
SRCNAME = "uwsgi"
PR = "r0"

#SRC_URI = "http://goelzer.com/uwsgi/uwsgi-1.2.3.tar.gz \
SRC_URI = "http://projects.unbit.it/downloads/uwsgi-${PV}.tar.gz \
           file://editor.ini \
           file://public.ini \
           file://arm-timer-syscall.patch"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS = "libxml2"

RDEPENDS_${PN} = "\
  python-core \
"

do_compile_prepend() {
    export BUILD_SYS=${BUILD_SYS}
    export HOST_SYS=${HOST_SYS}
    export STAGING_INCDIR=${STAGING_INCDIR}
    export STAGING_LIBDIR=${STAGING_LIBDIR}
}

do_compile() {
# build with -D to see this output:
#    echo "******************************* ${PV} ********************************** "
    python uwsgiconfig.py --build
}

do_install() {
    echo ${S}
    install -m 0755 -d ${D}${sbindir}
    install -m 0755 ${S}/uwsgi ${D}${sbindir}
    install -m 0755 -d ${D}${sysconfdir}
    install -m 0755 -d ${D}${sysconfdir}/uwsgi
    install -m 0644 ${WORKDIR}/editor.ini ${D}${sysconfdir}/uwsgi
    install -m 0644 ${WORKDIR}/public.ini ${D}${sysconfdir}/uwsgi
    install -m 0755 ${S}/uwsgi/uwsgidecorators.py ${D}${PYTHON_SITEPACKAGES_DIR}
}

SRC_URI[md5sum] = "6090367c826216f59848677a79fb7129"
SRC_URI[sha256sum] = "1f9f6047468272708241780597014ed00d93919a384e81b30e65167fb2c2e129"
#SRC_URI[md5sum] = "a6f43569b46e11ff625f5f03d966fe57"
#SRC_URI[sha256sum] = "4433693fdbeda20b418e1eea5a494aa1db4965cd6b9a521a26b227c27d95b79c"

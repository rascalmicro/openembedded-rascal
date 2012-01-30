DESCRIPTION = "uWSGI is a WSGI web server for Python web applications"
HOMEPAGE = "http://projects.unbit.it/uwsgi/wiki"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"
SRCNAME = "uwsgi"
PR = "r0"

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
}

SRC_URI[md5sum] = "fafecf7dc86a36f003d2fadaa44483f1"
SRC_URI[sha256sum] = "1f9da496dd8556644513208640c302aa38a4fe8cabe476ca3ed0b7c2b5b0ed73"

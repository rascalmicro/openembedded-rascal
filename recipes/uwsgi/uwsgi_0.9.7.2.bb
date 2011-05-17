DESCRIPTION = "uWSGI is a WSGI web server for Python web applications"
HOMEPAGE = "http://projects.unbit.it/uwsgi/wiki"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"
SRCNAME = "uwsgi"
PR = "r0"

SRC_URI = "http://projects.unbit.it/downloads/uwsgi-${PV}.tar.gz \
           file://uwsgi.ini"

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
    install -m 0644 ${WORKDIR}/uwsgi.ini ${D}${sysconfdir}
}

SRC_URI[md5sum] = "9bdf8ed5c8b32ace085dbd0f9488f880"
SRC_URI[sha256sum] = "6eccf3c7ead324c6af9a6196f0d4faf4c8472ca3b728a01a0070b472b0784bba"

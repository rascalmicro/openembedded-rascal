DESCRIPTION = "uWSGI is a WSGI web server for Python web applications"
HOMEPAGE = "http://projects.unbit.it/uwsgi/wiki"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPLv2"
SRCNAME = "uwsgi"
PR = "r0"

SRCREV = "anthrax-rc2"

SRC_URI = "git://github.com/rascalmicro/uwsgi.git;protocol=git;branch=interrupts \
           file://editor.ini \
           file://public.ini \
           file://emperor.log \
           file://editor.log \
           file://public.log \
           file://arm-timer-syscall.patch"

S = "${WORKDIR}/git"

FILES_${PN} += ${libdir}/python2.6

DEPENDS = "libxml2 openldap"

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
    install -m 0755 -d ${D}${libdir}/python2.6
    install -m 0755 ${S}/uwsgidecorators.py ${D}${libdir}/python2.6

    install -m 0755 -d ${D}${localstatedir}/log/uwsgi
    install -m 0644 ${WORKDIR}/emperor.log ${D}${localstatedir}/log/uwsgi
    install -m 0644 ${WORKDIR}/editor.log ${D}${localstatedir}/log/uwsgi
    install -m 0644 ${WORKDIR}/public.log ${D}${localstatedir}/log/uwsgi
}

SRC_URI[md5sum] = "6090367c826216f59848677a79fb7129"
SRC_URI[sha256sum] = "1f9f6047468272708241780597014ed00d93919a384e81b30e65167fb2c2e129"

DESCRIPTION = "Nginx is a free, open-source, high-performance HTTP server and reverse proxy, as well as an IMAP/POP3 proxy server."
HOMEPAGE = "http://wiki.nginx.org"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://nginx.org/download/nginx-${PV}.tar.gz \
           file://allow-cross.patch"

DEPENDS = "libpcre"

do_configure() {
    export cross_compiling="yes"
    ${S}/configure --with-cc=${HOST_PREFIX}gcc --sbin-path=${sbindir}/nginx --error-log-path=${localstatedir}/log/nginx/error --conf-path=${sysconfdir}/nginx/nginx.conf
}

do_install() {
    oe_runmake DESTDIR=${D} install
}

do_package_qa() {
    :
}

SRC_URI[md5sum] = "5751c920c266ea5bb5fc38af77e9c71c"
SRC_URI[sha256sum] = "3de3d6caeed56751c24ebc5cfb03475620b9eb0fa999c766a01d44dca674c001"

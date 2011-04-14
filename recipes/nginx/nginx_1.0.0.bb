DESCRIPTION = "NNginx is a free, open-source, high-performance HTTP server and reverse proxy, as well as an IMAP/POP3 proxy server."
HOMEPAGE = "http://wiki.nginx.org"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "nginx"
PR = "r27"

SRC_URI = "http://nginx.org/download/nginx-${PV}.tar.gz \
           file://allow-cross.patch"

S = "${WORKDIR}/${PN}-${PV}"

do_configure() {
    export cross_compiling="yes"
    ${S}/configure --with-cc=/home/user/openembedded-rascal/tmp/sysroots/i686-linux/usr/armv5te/bin/arm-angstrom-linux-gnueabi-gcc --without-http_rewrite_module --sbin-path=${S}/usr/sbin --error-log-path=/var/log/nginx/error --conf-path=/etc/nginx/nginx.conf
}

do_install() {
    make DESTDIR=${S} install
}

do_package() {

}

SRC_URI[md5sum] = "5751c920c266ea5bb5fc38af77e9c71c"
SRC_URI[sha256sum] = "3de3d6caeed56751c24ebc5cfb03475620b9eb0fa999c766a01d44dca674c001"

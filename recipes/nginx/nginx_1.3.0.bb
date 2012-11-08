DESCRIPTION = "Nginx is a free, open-source, high-performance HTTP server and reverse proxy, as well as an IMAP/POP3 proxy server."
HOMEPAGE = "http://wiki.nginx.org"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://nginx.org/download/nginx-${PV}.tar.gz \
           file://allow-cross.patch \
           file://nginx \
           file://rascal-conf.patch"

DEPENDS = "libpcre logrotate"

do_configure() {
    export cross_compiling="yes"
    ${S}/configure \
    --with-cc="${HOST_PREFIX}gcc -Wl,--hash-style=gnu" \
    --sbin-path=${sbindir}/nginx \
    --pid-path=${localstatedir}/run/nginx.pid \
    --lock-path=${localstatedir}/lock/nginx.lock \
    --error-log-path=${localstatedir}/log/nginx/error \
    --conf-path=${sysconfdir}/nginx/nginx.conf \
    --http-log-path=${localstatedir}/log/nginx/access \
    --http-client-body-temp-path=${localstatedir}/lib/nginx/client_body_temp \
    --http-proxy-temp-path=${localstatedir}/lib/nginx/proxy_temp \
    --http-fastcgi-temp-path=${localstatedir}/lib/nginx/fastcgi_temp \
    --http-uwsgi-temp-path=${localstatedir}/lib/nginx/uwsgi_temp \
    --http-scgi-temp-path=${localstatedir}/lib/nginx/scgi_temp
}

do_install() {
    install -d ${D}${localstatedir}/lib/nginx
    install -d ${D}${localstatedir}/log/nginx
#    install -m 0755 -d ${D}${sysconfdir}
#    install -m 0644 ${WORKDIR}/nginx ${D}${sysconfdir}/logrotate
    oe_runmake DESTDIR=${D} install
}

SRC_URI[md5sum] = "b02e171c4a088aa9a5ab387943ce08eb"
SRC_URI[sha256sum] = "e95d4e5f840afe0e85f95689a10ffa8acaf5a4a1372fe285b175fbc807a5f409"

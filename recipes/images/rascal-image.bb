require recipes/images/minimal-image.bb

IMAGE_INSTALL += "\
        gcc \
        git \
        i2c-tools \
        iperf \
        lighttpd \
        lighttpd-module-access \
        lighttpd-module-accesslog \
        lighttpd-module-dirlisting \
        lighttpd-module-indexfile \
        lighttpd-module-staticfile \
        nano \
        python \
        python-modules \
        python-pyserial \
        ruby \
        usbutils \
        usb-gadget-mode \
        vim \
    "

export IMAGE_BASENAME = "rascal-image"

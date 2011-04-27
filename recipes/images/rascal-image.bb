require recipes/images/minimal-image.bb

IMAGE_INSTALL += "\
        binutils \
        cpp \
        cpp-symlinks \
        gcc \
        gcc-symlinks \
        git \
        i2c-tools \
        iperf \
        libgcc-dev \
        libxml2 \
        nano \
        nginx \
        python \
        python-daemon \
        python-flask \
        python-jinja2 \
        python-modules \
        python-pyserial \
        python-rascal \
        python-werkzeug \
        ruby \
        usbutils \
        usb-gadget-mode \
        uwsgi \
        vim \
    "

export IMAGE_BASENAME = "rascal-image"

for pin in 68 69 70 71 72 73 74 75 96 97 98 107
do
    echo $pin > /sys/class/gpio/export
    echo out > /sys/class/gpio/gpio$pin/direction
done

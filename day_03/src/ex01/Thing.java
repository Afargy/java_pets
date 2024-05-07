package ex01;

class Thing implements Runnable {
    private Integer times = 0;
    private String name = null;
    private Object monitor = null;

    Thing(String name, Integer times, Object monitor) {
        this.name = name;
        this.times = times;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < this.times; ++i) {
            try {
                synchronized (monitor) {
                    if (this.name.equals("Egg")) {
                        System.out.println(this.name);
                        monitor.notify();
                        monitor.wait();
                    } else {
                        monitor.wait();
                        System.out.println(this.name);
                        monitor.notify();
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

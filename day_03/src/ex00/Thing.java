package ex00;

class Thing implements Runnable {
    private Integer times = 0;
    private String name = null;

    Thing(String name, Integer times) {
        this.name = name;
        this.times = times;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < this.times; ++i) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(name);
        }
    }

}

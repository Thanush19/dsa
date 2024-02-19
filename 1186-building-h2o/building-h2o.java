public class H2O {

    private final Semaphore oxygen = new Semaphore(0);
    private final Semaphore hydrogen = new Semaphore(2);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        releaseHydrogen.run();
        if (hydrogen.availablePermits() == 0) oxygen.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        releaseOxygen.run();
        hydrogen.release(2);
    }
}
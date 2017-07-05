package com.comarch.jm;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class ExtendedJUnitTestRunner extends BlockJUnit4ClassRunner {

    public ExtendedJUnitTestRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        System.out.println("------------");
        super.run(notifier);
        System.out.println("------------");
    }

}

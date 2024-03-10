package ooconcepts.dependencyinjection;


public class Container {
    private LambdaInterface lambdaInterface;

    public Container(LambdaInterface lambdaInterface) {
        this.lambdaInterface = lambdaInterface;
    }

    public void executeLambda() {
        lambdaInterface.execute();
    }
}

package Prototype.deep;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable,Cloneable {
    private final static long serialVersionUID = 1l;

    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

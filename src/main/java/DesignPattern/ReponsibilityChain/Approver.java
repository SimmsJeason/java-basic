package ReponsibilityChain;

public abstract class Approver {
    Approver approver;//下一个处理者
    String name ;

    public Approver(String name) {
        this.name = name;
    }

    //设置下一个处理者
    public void setApprover(Approver approver){
        this.approver = approver;
    }

    //处理审批请求的方法，处理是子类完成，因此该方法做成抽象方法
    public abstract void progressRequest(PurchaseRequest request);
}

package ReponsibilityChain;

public class SchoolMasterApprover  extends Approver{
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void progressRequest(PurchaseRequest request) {

        if(request.getPrice() > 30000){
            System.out.println("请求编号为：" + request.getId() + "被 " + this.name + " 处理");
        }else{
            approver.progressRequest(request);
        }
    }
}

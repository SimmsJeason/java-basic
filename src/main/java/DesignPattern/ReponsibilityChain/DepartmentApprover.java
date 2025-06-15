package ReponsibilityChain;

public class DepartmentApprover  extends Approver{

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void progressRequest(PurchaseRequest request) {

        if(request.getPrice() <= 5000){
            System.out.println("请求编号为：" + request.getId() + "被 " + this.name + " 处理");
        }else{
            approver.progressRequest(request);
        }
    }
}

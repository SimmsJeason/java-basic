package ReponsibilityChain;

public class CollegeApprover extends Approver{

    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void progressRequest(PurchaseRequest request) {

        if(request.getPrice() > 5000 && request.getPrice() <= 10000){
            System.out.println("请求编号为：" + request.getId() + "被 " + this.name + " 处理");
        }else{
            approver.progressRequest(request);
        }
    }
}

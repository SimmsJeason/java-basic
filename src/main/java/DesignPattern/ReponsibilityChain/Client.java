package ReponsibilityChain;

import Iterator.Department;

public class Client {
    public static void main(String[] args) {

        DepartmentApprover departmentApprover = new DepartmentApprover("系主任");
        CollegeApprover collegeApprover = new CollegeApprover("院主任");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("校长");

        //设置职责链关系
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        //设置闭环
        schoolMasterApprover.setApprover(departmentApprover);

        PurchaseRequest request = new PurchaseRequest(1, 1, 3000);
        //PurchaseRequest request = new PurchaseRequest(1, 1, 40000);

        //departmentApprover.progressRequest(request);

        schoolMasterApprover.progressRequest(request);
    }
}

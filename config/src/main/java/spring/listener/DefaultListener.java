package spring.listener;

import lombok.SneakyThrows;
import spring.exception.CustomException;
import spring.util.ApplicationContextUtil;

import java.util.Arrays;

public class DefaultListener  /*implements ExecutionListener,TaskListener*/ {

    /*@SneakyThrows
    @Override
    public void notify(DelegateTask delegateTask) {
        RuntimeService runtimeServiceimpl= (RuntimeService) ApplicationContextUtil.getInstance().getApplicationContext().getBean(RuntimeService.class);
        String assignee= (String) runtimeServiceimpl.getVariable(delegateTask.getExecutionId(), "assignee");
        System.out.println("============TaskListener start============");
        System.out.println("设定流程处理人为"+assignee);
        delegateTask.setAssignee(assignee);



        //添加检查角色是否正确的过滤。
        //在那个获取下一节点处理人的接口那也要检查一次。
        // 下一个节点的问题。在节点开始之前检查节点是否正确匹配
        //那个获取一一个节点的接口那里也要检查一个

        String taskDefinitionKey = delegateTask.getTaskDefinitionKey();
        String eventName = delegateTask.getEventName();
        System.out.println("事件名称:" + eventName);
        System.out.println("taskDefinitionKey:" + taskDefinitionKey);
        System.out.println("============TaskListener end============");
        if(delegateTask.getAssignee()==null||"".equals(delegateTask.getAssignee())){
            //throw  new CustomException("流程节点处理人为空！");
        }

        //流程触发事件

        System.out.println("############################################################");
        System.out.println("流程触发事件"+ delegateTask.getFormKey());
    }

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String assigneeList = String.valueOf(delegateExecution.getVariable("assigneeList"));
        if(assigneeList != null){
            // 根据逗号分割并以数组形式重新设置进去
            delegateExecution.setVariable("assigneeList", Arrays.asList(assigneeList.split(",")));
        }
    }*/
}

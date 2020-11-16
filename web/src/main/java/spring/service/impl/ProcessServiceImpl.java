package spring.service.impl;

/*import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;*/
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcessServiceImpl /*implements ProcessService*/ {


    /*@Resource
    TaskService taskServiceImpl;

    @Resource
    RepositoryService repositoryServiceImpl;

    @Resource
    RuntimeService runtimeServiceImpl;

    @Resource
    HistoryService historyServiceImpl;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    ProcessEngine processEngine;


    @Resource
    SysActivitiTaskService sysActivitiTaskServiceImpl;

    @Resource
    PublicService publicServiceImpl;

    @Override
    public List<Map<String, Object>> getNextNode(String taskId, String modelId, String businessKey) {
        NextNode nextNode = new DefaultNextNode(); //如果formKey中有class要做镜像处理
        return nextNode.notify(taskId, modelId, businessKey);



        *//*boolean isCloseprocess=false;
        Map<String, Object> map=new HashMap<>();
        try{
            if(processInstanceId==null||"".equals(processInstanceId)){
                //流程还没有开始  需要模型定义模板部署id  来获取下一个节点    // 还有获取下一级处理人
                ProcessInstance processInstance=runtimeServiceImpl.startProcessInstanceByKey(processInstanceKey);
                processInstanceId=processInstance.getProcessInstanceId();
                isCloseprocess=true;
            }

            //流程已经开始  流程id 给我， 然后根据**获取下一级处理人
            List<Task> tasks = taskServiceImpl.createTaskQuery().processInstanceId(processInstanceId).list();
            String nextId = "";
            for (Task task : tasks) {
                RepositoryService rs = repositoryServiceImpl;
                // 2、然后根据当前任务获取当前流程的流程定义，然后根据流程定义获得所有的节点：
                ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl) rs)
                        .getDeployedProcessDefinition(task.getProcessDefinitionId());
                List<ActivityImpl> activitiList = def.getActivities(); // rs是指RepositoryService的实例
                // 3、根据任务获取当前流程执行ID，执行实例以及当前流程节点的ID：
                String excId = task.getExecutionId();
                RuntimeService runtimeService = runtimeServiceImpl;
                ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(excId)
                        .singleResult();
                String activitiId = execution.getActivityId();
                // 4、然后循环activitiList
                // 并判断出当前流程所处节点，然后得到当前节点实例，根据节点实例获取所有从当前节点出发的路径，然后根据路径获得下一个节点实例：
                for (ActivityImpl activityImpl : activitiList) {
                    String id = activityImpl.getId();
                    if (activitiId.equals(id)) {
                        List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();// 获取从某个节点出来的所有线路
                        Map<String, Object> map1=new HashMap<>();
                        map1.put("key",activityImpl.getId());
                        map1.put("value",activityImpl.getProperty("name"));
                        map.put("thisNode",map1);
                        System.out.println("当前任务：" +activityImpl.getProperty("name") );
                        map1=new HashMap<>();
                        Map<String, Object> map2;
                        for (PvmTransition tr : outTransitions) {
                            map2=new HashMap<>();

                            PvmActivity ac = tr.getDestination(); // 获取线路的终点节点
                            System.out.println("下一步任务任务：" + ac.getProperty("name"));

                            map2.put("key",ac.getId());
                            map2.put("value",ac.getProperty("name"));
                            TaskDefinition taskDefinition = ((UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).getTaskDefinition();
                            Expression assigneeExpression = taskDefinition.getAssigneeExpression();
                            map2.put("user",assigneeExpression);

                            map1.put((String) ac.getProperty("name"),map2);

                            nextId = ac.getId();
                        }
                        map.put("nextNode",map1);
                        break;
                    }
                }
            }
            return map;
        }catch (CustomException ce){
            throw ce;
        }finally {
            if(isCloseprocess){
                runtimeServiceImpl.deleteProcessInstance(processInstanceId,"查询下一级节点");
            }
        }*//*
    }

    *//**
     * @param taskId        任务id
     * @param modelId       模型id
     * @param assignee      下一节点处理人
     * @param nextNode      下一节点
     * @param comformInfo   表单信息
     * @param businessKey   表单id
     * @param opinion       意见
     * @param serialNumber  流水号
     * @param urgencyDegree 紧急程度
     * @return
     * @throws Exception
     *//*
    @Override
    public Map<String, Object> completeTask(String taskId, String modelId, String assignee, String nextNode, String comformInfo, String comformId ,String businessKey
            , String opinion, String serialNumber, String urgencyDegree) throws Exception {
        Map<String, Object> map = null;
        SysUser sysUser = null;
        Model model = repositoryServiceImpl.getModel(modelId);
        System.out.println("模型id" + model.getId());
        System.out.println("模型名称" + model.getName());
        Task task = null;
        Map<String, String> params = null;
        try {
            sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("user");
        } catch (Exception e) {
            e.printStackTrace();
            sysUser = new SysUser();
        }
        try {
            synchronized (this.getClass()) {
                if (businessKey == null || "".equals(businessKey)) {
                    businessKey = IdWorker.getIdWorkerNext().toString();
                    if(!(comformInfo==null||"".equals(comformInfo))){
                        if (publicServiceImpl.insertComfromTable(comformInfo, null, businessKey) <= 0) {
                            throw new CustomException(CustomException.EXCEPTION_MASSAGE);
                        }
                    }

                } else {
                    if(!(comformInfo==null||"".equals(comformInfo))){
                        if (publicServiceImpl.updateComfromTable(comformInfo, null) <= 0) {
                            throw new CustomException(CustomException.EXCEPTION_MASSAGE);
                        }
                    }
                }
                if (StringUtils.isEmpty(taskId)) {//开启流程
                    //开启前检查一下日志里面有没有业务id未该业务id的数据
                    if (StringUtils.isEmpty(businessKey)) {
                        throw new CustomException("业务ID不能为空！");
                    }

                    SysActivitiTask sysActivitiTask = new SysActivitiTask();
                    sysActivitiTask.setBusinessKey(businessKey);
                    List<SysActivitiTask> sysActivitiTasks = sysActivitiTaskServiceImpl.selectListByPage(sysActivitiTask);

                    if (sysActivitiTasks == null || sysActivitiTasks.size() <= 0) {
                        //这里可以判断该用户是否有权限添加流程
                        Map<String, Object> variables = new HashMap<>();
                        variables.put("assignee", sysUser.getId());
                        //根据modelId获取processDefinitionId
                        String processDefinitionId = repositoryServiceImpl.createProcessDefinitionQuery().deploymentId(model.getDeploymentId()).singleResult().getId();
                        ProcessInstance processInstance = runtimeServiceImpl.startProcessInstanceById(processDefinitionId, businessKey, variables);
                        //得到第一个流程
                        List<Task> list = taskServiceImpl.createTaskQuery().processDefinitionId(processInstance.getProcessDefinitionId()).processInstanceBusinessKey(businessKey).orderByTaskCreateTime().desc().list();
                        //这里要完成第一个任务
                        System.out.println(list);
                        task = list.get(0);

                        try {
                            params = JSONObject.parseObject(task.getFormKey(), new TypeReference<Map<String, String>>() {
                            });
                        } catch (Exception e) {
                            throw new Exception("流程FormKey配置不正确");
                        }
                        //同步修改对应的数据

                        sysActivitiTaskServiceImpl.insert(new SysActivitiTask(IdWorker.getIdWorkerNext().toString(), null, null, null, null, IdWorker.getIdWorkerNext().toString()
                                , serialNumber, urgencyDegree, task.getId(), runtimeServiceImpl.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getBusinessKey()
                                , params.get("disposeCollege"), params.get("disposeDept"), params.get("disposeRole"), params.get("disposeUnit"), params.get("disposeBy1"), null, null
                                , null, null, model.getName(), model.getId(), task.getName(), "角色任务", "003", sysUser.getId(), sysUser.getAccountname(), new Date()
                                , null, null, params.get("ccCollege"), params.get("ccDept"), params.get("ccRole"), params.get("ccUnit"), params.get("ccBy1")
                                , params.get("ccUserId"), params.get("ccUserName"), null));
                        taskId = task.getId();
                    }
                }
            }
            task = taskServiceImpl.createTaskQuery().taskId(taskId).singleResult();
            //这里可以判断一下该用户是否有权限完成这个任务

            //根据任务ID去完成任务
            Map<String, Object> variables = new HashMap<>();
            variables.put("assignee", assignee);//int
            variables.put("nextNode", nextNode);
            taskServiceImpl.complete(taskId, variables);

            //办理人
            //办理人姓名
            //流程状态
            //意见
            //代办人 代办以后再处理
            //代办人姓名
            SysActivitiTask sysActivitiTask = new SysActivitiTask();
            sysActivitiTask.setTaskId(taskId);
            sysActivitiTask = sysActivitiTaskServiceImpl.selectOne(sysActivitiTask);
            sysActivitiTask.setDisposeUserId(sysUser.getId());
            sysActivitiTask.setDisposeUserName(sysUser.getAccountname());
            sysActivitiTask.setActivitiStatus("005");
            sysActivitiTask.setContent(opinion);
            sysActivitiTaskServiceImpl.updateByPrimaryKeySelective(sysActivitiTask);

            task = taskServiceImpl.createTaskQuery().processInstanceBusinessKey(businessKey).orderByTaskCreateTime().desc().singleResult();
            if (task != null) {
                System.out.println("当前节点处理人，抄送人信息" + task.getFormKey());
                System.out.println("获取上一节点处理人");
                try {
                    params = JSONObject.parseObject(task.getFormKey(), new TypeReference<Map<String, String>>() {
                    });
                } catch (Exception e) {
                    throw new Exception("流程FormKey配置不正确");
                }
                sysActivitiTaskServiceImpl.insert(new SysActivitiTask(IdWorker.getIdWorkerNext().toString(), null, null, null, null, IdWorker.getIdWorkerNext().toString()
                        , serialNumber, urgencyDegree, task.getId(), runtimeServiceImpl.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult().getBusinessKey()
                        , params.get("disposeCollege"), params.get("disposeDept"), params.get("disposeRole"), params.get("disposeUnit"), params.get("disposeBy1"), null, null
                        , null, null, model.getName(), model.getId(), task.getName(), "角色任务", "003", sysActivitiTask.getInitiateUserId(), sysActivitiTask.getInitiateUserName(), sysActivitiTask.getInitiateDate()
                        , sysUser.getId(), sysUser.getAccountname(), params.get("ccCollege"), params.get("ccDept"), params.get("ccRole"), params.get("ccUnit"), params.get("ccBy1")
                        , params.get("ccUserId"), params.get("ccUserName"), null));
            } else {

                //把数据状态改成审结
            }
            return newHashmap(taskId, modelId, assignee, nextNode, comformInfo,comformId, businessKey, serialNumber, urgencyDegree);
        } catch (CustomException ce) {
            throw ce;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Map getprocessImageDate(String taskId) {
        Map<String, Object> map = new HashMap();
        Task task = taskServiceImpl.createTaskQuery() // 创建任务查询
                .taskId(taskId) // 根据任务id查询
                .singleResult();
        String processDefinitionId = task.getProcessDefinitionId(); // 获取流程定义id
        ProcessDefinition processDefinition = repositoryServiceImpl.createProcessDefinitionQuery() // 创建流程定义查询
                .processDefinitionId(processDefinitionId) // 根据流程定义id查询
                .singleResult();
        map.put("deploymentId", processDefinition.getDeploymentId()); // 部署id
        map.put("diagramResourceName", processDefinition.getDiagramResourceName()); // 图片资源文件名称
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryServiceImpl.getProcessDefinition(processDefinitionId);
        String processInstanceId = task.getProcessInstanceId(); // 获取流程实例id
        ProcessInstance pi = runtimeServiceImpl.createProcessInstanceQuery() // 根据流程实例id获取流程实例
                .processInstanceId(processInstanceId)
                .singleResult();
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(pi.getActivityId()); // 根据活动id获取活动实例
        map.put("x", activityImpl.getX()); // x坐标
        map.put("y", activityImpl.getY()); // y坐标
        map.put("width", activityImpl.getWidth()); // 宽度
        map.put("height", activityImpl.getHeight()); // 高度
        return map;
    }

    @Override
    public InputStream getProcessImage(String taskId) {
        //获得流程实例
        Task task = taskServiceImpl.createTaskQuery() // 创建任务查询
                .taskId(taskId) // 根据任务id查询
                .singleResult();
        String processDefinitionId = task.getProcessDefinitionId(); // 获取流程定义id
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryServiceImpl.getProcessDefinition(processDefinitionId);
        String processInstanceId = task.getProcessInstanceId(); // 获取流程实例id

        ProcessInstance processInstance = runtimeServiceImpl.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        processDefinitionId = StringUtils.EMPTY;
        if (processInstance == null) {
            //查询已经结束的流程实例
            HistoricProcessInstance processInstanceHistory = historyServiceImpl.createHistoricProcessInstanceQuery()
                    .processInstanceId(processInstanceId).singleResult();
            if (processInstanceHistory == null)
                return null;
            else
                processDefinitionId = processInstanceHistory.getProcessDefinitionId();
        } else {
            processDefinitionId = processInstance.getProcessDefinitionId();
        }

        //使用宋体
        String fontName = "宋体";
        //获取BPMN模型对象
        BpmnModel model = repositoryServiceImpl.getBpmnModel(processDefinitionId);
        //获取流程实例当前的节点，需要高亮显示
        List<String> currentActs = Collections.EMPTY_LIST;
        if (processInstance != null)
            currentActs = runtimeServiceImpl.getActiveActivityIds(processInstance.getId());

        return processEngine.getProcessEngineConfiguration()
                .getProcessDiagramGenerator()
                .generateDiagram(model, "png", currentActs, new ArrayList<String>(),
                        fontName, fontName, fontName, null, 1.0);
    }

    public Map<String, Object> newHashmap(String taskId, String modelId, String assignee, String nextNode, String comformInfo,String comformId, String businessKey, String serialNumber, String urgencyDegree) {
        Map<String, Object> map = new HashMap<>();
        map = new HashMap<>();
        map.put("taskId", taskId);
        map.put("assignee", assignee);
        map.put("nextNode", nextNode);
        map.put("comformInfo", comformInfo);
        map.put("comformId", comformId);
        map.put("businessKey", businessKey);
        map.put("modelId", modelId);
        map.put("serialNumber", serialNumber);
        map.put("urgencyDegree", urgencyDegree);
        return map;
    }


    *//**
     * 流程撤回操作
     *//*
    public void execute(String taskId, String businessKey) {
        try {
            // 取得当前任务
            HistoricTaskInstance currTask = historyServiceImpl
                    .createHistoricTaskInstanceQuery().taskId(taskId)
                    .singleResult();
            //根据流程id查询代办任务中流程信息
            Task task = taskServiceImpl.createTaskQuery().processInstanceId(currTask.getProcessInstanceId()).singleResult();
            //查询下一个节点是否已经审批

            SysActivitiTask sysActivitiTask = new SysActivitiTask();
            sysActivitiTask.setBusinessKey(businessKey);
            List<SysActivitiTask> sysActivitiTasks = sysActivitiTaskServiceImpl.selectListByPage(sysActivitiTask);
            boolean bool = true;
            for (int i = 0; i < sysActivitiTasks.size(); i++) {
                if (taskId.equals(sysActivitiTasks.get(i).getTaskId())) {
                    if (sysActivitiTasks.size() - i == 2) {
                        bool = false;
                    }
                }
            }
            if (true) {
                //System.out.println("下一节点信息已被审批，无法撤回流程。");
            }
            //取回流程接点 当前任务id 取回任务id
            callBackProcess(task.getId(), currTask.getId());
            //删除历史流程走向记录
            historyServiceImpl.deleteHistoricTaskInstance(currTask.getId());
            historyServiceImpl.deleteHistoricTaskInstance(task.getId());
            //System.out.println("流程取回成功");
        } catch (Exception e) {
            //System.out.println("流程取回失败，未知错误.");
        }
    }

    *//**
     * 驳回流程
     *
     * @throws Exception
     *//*
    public void backProcess() throws Exception {
        String taskId = "";//当前任务ID
        String activityId = "";//驳回节点ID
        Map<String, Object> variables = new HashMap<>();//流程存储参数

        if (org.springframework.util.StringUtils.isEmpty(activityId)) {
            throw new Exception("驳回目标节点ID为空！");
        }

        // 查找所有并行任务节点，同时驳回
        List<Task> taskList = findTaskListByKey(findProcessInstanceByTaskId(
                taskId).getId(), findTaskById(taskId).getTaskDefinitionKey());
        for (Task task : taskList) {
            commitProcess(task.getId(), variables, activityId);
        }
    }


    *//**
     * 取回流程
     *
     * @param taskId     当前任务ID
     * @param activityId 取回节点ID
     * @throws Exception
     *//*


    public void callBackProcess(String taskId, String activityId)
            throws Exception {
        if (org.springframework.util.StringUtils.isEmpty(activityId)) {
            throw new Exception("目标节点ID为空！");
        }

        // 查找所有并行任务节点，同时取回
        List<Task> taskList = findTaskListByKey(findProcessInstanceByTaskId(
                taskId).getId(), findTaskById(taskId).getTaskDefinitionKey());
        for (Task task : taskList) {
            commitProcess(task.getId(), null, activityId);
        }
    }


    *//**
     * 清空指定活动节点流向
     *
     * @param activityImpl 活动节点
     * @return 节点流向集合
     *//*


    private List<PvmTransition> clearTransition(ActivityImpl activityImpl) {
        // 存储当前节点所有流向临时变量
        List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();
        // 获取当前节点所有流向，存储到临时变量，然后清空
        List<PvmTransition> pvmTransitionList = activityImpl
                .getOutgoingTransitions();
        for (PvmTransition pvmTransition : pvmTransitionList) {
            oriPvmTransitionList.add(pvmTransition);
        }
        pvmTransitionList.clear();

        return oriPvmTransitionList;
    }


    *//**
     * 提交流程/流程转向
     *
     * @param taskId     当前任务ID
     * @param variables  流程变量
     * @param activityId 流程转向执行任务节点ID<br>
     *                   此参数为空，默认为提交操作
     * @throws Exception
     *//*


    private void commitProcess(String taskId, Map<String, Object> variables,
                               String activityId) throws Exception {
        if (variables == null) {
            variables = new HashMap<String, Object>();
        }
        // 跳转节点为空，默认提交操作
        if (org.springframework.util.StringUtils.isEmpty(activityId)) {
            taskServiceImpl.complete(taskId, variables);
        } else {// 流程转向操作
            turnTransition(taskId, activityId, variables);
        }
    }


    *//**
     * 中止流程(特权人直接审批通过等)
     *
     * @param taskId
     *//*


    public void endProcess(String taskId) throws Exception {
        ActivityImpl endActivity = findActivitiImpl(taskId, "end");
        commitProcess(taskId, null, endActivity.getId());
    }


    *//**
     * 根据流入任务集合，查询最近一次的流入任务节点
     *
     * @param processInstance 流程实例
     * @param tempList        流入任务集合
     * @return
     *//*
    private ActivityImpl filterNewestActivity(ProcessInstance processInstance,
                                              List<ActivityImpl> tempList) {
        while (tempList.size() > 0) {
            ActivityImpl activity_1 = tempList.get(0);
            HistoricActivityInstance activityInstance_1 = findHistoricUserTask(
                    processInstance, activity_1.getId());
            if (activityInstance_1 == null) {
                tempList.remove(activity_1);
                continue;
            }

            if (tempList.size() > 1) {
                ActivityImpl activity_2 = tempList.get(1);
                HistoricActivityInstance activityInstance_2 = findHistoricUserTask(
                        processInstance, activity_2.getId());
                if (activityInstance_2 == null) {
                    tempList.remove(activity_2);
                    continue;
                }

                if (activityInstance_1.getEndTime().before(
                        activityInstance_2.getEndTime())) {
                    tempList.remove(activity_1);
                } else {
                    tempList.remove(activity_2);
                }
            } else {
                break;
            }
        }
        if (tempList.size() > 0) {
            return tempList.get(0);
        }
        return null;
    }


    *//**
     * 根据任务ID和节点ID获取活动节点 <br>
     *
     * @param taskId     任务ID
     * @param activityId 活动节点ID <br>
     *                   如果为null或""，则默认查询当前活动节点 <br>
     *                   如果为"end"，则查询结束节点 <br>
     * @return
     * @throws Exception
     *//*


    private ActivityImpl findActivitiImpl(String taskId, String activityId)
            throws Exception {
        // 取得流程定义
        ProcessDefinitionEntity processDefinition = findProcessDefinitionEntityByTaskId(taskId);

        // 获取当前活动节点ID
        if (org.springframework.util.StringUtils.isEmpty(activityId)) {
            activityId = findTaskById(taskId).getTaskDefinitionKey();
        } else {
            HistoricTaskInstance currTask = historyServiceImpl
                    .createHistoricTaskInstanceQuery().taskId(activityId)
                    .singleResult();
            activityId = currTask.getTaskDefinitionKey();
        }

        // 根据流程定义，获取该流程实例的结束节点
        if (activityId.toUpperCase().equals("END")) {
            for (ActivityImpl activityImpl : processDefinition.getActivities()) {
                List<PvmTransition> pvmTransitionList = activityImpl
                        .getOutgoingTransitions();
                if (pvmTransitionList.isEmpty()) {
                    return activityImpl;
                }
            }
        }

        // 根据节点ID，获取对应的活动节点
        ActivityImpl activityImpl = ((ProcessDefinitionImpl) processDefinition)
                .findActivity(activityId);

        return activityImpl;
    }


    *//**
     * 根据当前任务ID，查询可以驳回的任务节点
     *
     * @param taskId 当前任务ID
     *//*


    public List<ActivityImpl> findBackAvtivity(String taskId) throws Exception {
        List<ActivityImpl> rtnList = iteratorBackActivity(taskId, findActivitiImpl(taskId,
                null), new ArrayList<ActivityImpl>(),
                new ArrayList<ActivityImpl>());
        return reverList(rtnList);
    }

    *//**
     * 查询指定任务节点的最新记录
     *
     * @param processInstance 流程实例
     * @param activityId
     * @return
     *//*


    private HistoricActivityInstance findHistoricUserTask(
            ProcessInstance processInstance, String activityId) {
        HistoricActivityInstance rtnVal = null;
        // 查询当前流程实例审批结束的历史节点
        List<HistoricActivityInstance> historicActivityInstances = historyServiceImpl
                .createHistoricActivityInstanceQuery().activityType("userTask")
                .processInstanceId(processInstance.getId()).activityId(
                        activityId).finished()
                .orderByHistoricActivityInstanceEndTime().desc().list();
        if (historicActivityInstances.size() > 0) {
            rtnVal = historicActivityInstances.get(0);
        }

        return rtnVal;
    }

    *//**
     * 根据当前节点，查询输出流向是否为并行终点，如果为并行终点，则拼装对应的并行起点ID
     *
     * @param activityImpl 当前节点
     * @return
     *//*


    private String findParallelGatewayId(ActivityImpl activityImpl) {
        List<PvmTransition> incomingTransitions = activityImpl
                .getOutgoingTransitions();
        for (PvmTransition pvmTransition : incomingTransitions) {
            TransitionImpl transitionImpl = (TransitionImpl) pvmTransition;
            activityImpl = transitionImpl.getDestination();
            String type = (String) activityImpl.getProperty("type");
            if ("parallelGateway".equals(type)) {// 并行路线
                String gatewayId = activityImpl.getId();
                String gatewayType = gatewayId.substring(gatewayId
                        .lastIndexOf("_") + 1);
                if ("END".equals(gatewayType.toUpperCase())) {
                    return gatewayId.substring(0, gatewayId.lastIndexOf("_"))
                            + "_start";
                }
            }
        }
        return null;
    }

    *//**
     * 根据任务ID获取流程定义
     *
     * @param taskId 任务ID
     * @return
     * @throws Exception
     *//*


    public ProcessDefinitionEntity findProcessDefinitionEntityByTaskId(
            String taskId) throws Exception {
        // 取得流程定义
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryServiceImpl)
                .getDeployedProcessDefinition(findTaskById(taskId)
                        .getProcessDefinitionId());

        if (processDefinition == null) {
            throw new Exception("流程定义未找到!");
        }

        return processDefinition;
    }

    *//**
     * 根据任务ID获取对应的流程实例
     *
     * @param taskId 任务ID
     * @return
     * @throws Exception
     *//*
    public ProcessInstance findProcessInstanceByTaskId(String taskId)
            throws Exception {
        // 找到流程实例
        ProcessInstance processInstance = runtimeServiceImpl
                .createProcessInstanceQuery().processInstanceId(
                        findTaskById(taskId).getProcessInstanceId())
                .singleResult();
        if (processInstance == null) {
            throw new Exception("流程实例未找到!");
        }
        return processInstance;
    }

    *//**
     * 根据任务ID获得任务实例
     *
     * @param taskId 任务ID
     * @return
     * @throws Exception
     *//*
    private TaskEntity findTaskById(String taskId) throws Exception {
        TaskEntity task = (TaskEntity) taskServiceImpl.createTaskQuery().taskId(
                taskId).singleResult();
        if (task == null) {
            throw new Exception("任务实例未找到!");
        }
        return task;
    }


    *//**
     * 根据流程实例ID和任务key值查询所有同级任务集合
     *
     * @param processInstanceId
     * @param key
     * @return
     *//*
    private List<Task> findTaskListByKey(String processInstanceId, String key) {
        return taskServiceImpl.createTaskQuery().processInstanceId(processInstanceId).taskDefinitionKey(key).list();
    }


    *//**
     * 迭代循环流程树结构，查询当前节点可驳回的任务节点
     *
     * @param taskId       当前任务ID
     * @param currActivity 当前活动节点
     * @param rtnList      存储回退节点集合
     * @param tempList     临时存储节点集合（存储一次迭代过程中的同级userTask节点）
     * @return 回退节点集合
     *//*
    private List<ActivityImpl> iteratorBackActivity(String taskId,
                                                    ActivityImpl currActivity, List<ActivityImpl> rtnList,
                                                    List<ActivityImpl> tempList) throws Exception {
        // 查询流程定义，生成流程树结构
        ProcessInstance processInstance = findProcessInstanceByTaskId(taskId);

        // 当前节点的流入来源
        List<PvmTransition> incomingTransitions = currActivity
                .getIncomingTransitions();
        // 条件分支节点集合，userTask节点遍历完毕，迭代遍历此集合，查询条件分支对应的userTask节点
        List<ActivityImpl> exclusiveGateways = new ArrayList<ActivityImpl>();
        // 并行节点集合，userTask节点遍历完毕，迭代遍历此集合，查询并行节点对应的userTask节点
        List<ActivityImpl> parallelGateways = new ArrayList<ActivityImpl>();
        // 遍历当前节点所有流入路径
        for (PvmTransition pvmTransition : incomingTransitions) {
            TransitionImpl transitionImpl = (TransitionImpl) pvmTransition;
            ActivityImpl activityImpl = transitionImpl.getSource();
            String type = (String) activityImpl.getProperty("type");
            *//**
             * 并行节点配置要求：<br>
             * 必须成对出现，且要求分别配置节点ID为:XXX_start(开始)，XXX_end(结束)
             *//*
            if ("parallelGateway".equals(type)) {// 并行路线
                String gatewayId = activityImpl.getId();
                String gatewayType = gatewayId.substring(gatewayId
                        .lastIndexOf("_") + 1);
                if ("START".equals(gatewayType.toUpperCase())) {// 并行起点，停止递归
                    return rtnList;
                } else {// 并行终点，临时存储此节点，本次循环结束，迭代集合，查询对应的userTask节点
                    parallelGateways.add(activityImpl);
                }
            } else if ("startEvent".equals(type)) {// 开始节点，停止递归
                return rtnList;
            } else if ("userTask".equals(type)) {// 用户任务
                tempList.add(activityImpl);
            } else if ("exclusiveGateway".equals(type)) {// 分支路线，临时存储此节点，本次循环结束，迭代集合，查询对应的userTask节点
                currActivity = transitionImpl.getSource();
                exclusiveGateways.add(currActivity);
            }
        }

        *//**
         * 迭代条件分支集合，查询对应的userTask节点
         *//*
        for (ActivityImpl activityImpl : exclusiveGateways) {
            iteratorBackActivity(taskId, activityImpl, rtnList, tempList);
        }

        *//**
         * 迭代并行集合，查询对应的userTask节点
         *//*
        for (ActivityImpl activityImpl : parallelGateways) {
            iteratorBackActivity(taskId, activityImpl, rtnList, tempList);
        }

        *//**
         * 根据同级userTask集合，过滤最近发生的节点
         *//*
        currActivity = filterNewestActivity(processInstance, tempList);
        if (currActivity != null) {
            // 查询当前节点的流向是否为并行终点，并获取并行起点ID
            String id = findParallelGatewayId(currActivity);
            if (org.springframework.util.StringUtils.isEmpty(id)) {// 并行起点ID为空，此节点流向不是并行终点，符合驳回条件，存储此节点
                rtnList.add(currActivity);
            } else {// 根据并行起点ID查询当前节点，然后迭代查询其对应的userTask任务节点
                currActivity = findActivitiImpl(taskId, id);
            }

            // 清空本次迭代临时集合
            tempList.clear();
            // 执行下次迭代
            iteratorBackActivity(taskId, currActivity, rtnList, tempList);
        }
        return rtnList;
    }


    *//**
     * 还原指定活动节点流向
     *
     * @param activityImpl         活动节点
     * @param oriPvmTransitionList 原有节点流向集合
     *//*
    private void restoreTransition(ActivityImpl activityImpl,
                                   List<PvmTransition> oriPvmTransitionList) {
        // 清空现有流向
        List<PvmTransition> pvmTransitionList = activityImpl
                .getOutgoingTransitions();
        pvmTransitionList.clear();
        // 还原以前流向
        for (PvmTransition pvmTransition : oriPvmTransitionList) {
            pvmTransitionList.add(pvmTransition);
        }
    }

    *//**
     * 反向排序list集合，便于驳回节点按顺序显示
     *
     * @param list
     * @return
     *//*
    private List<ActivityImpl> reverList(List<ActivityImpl> list) {
        List<ActivityImpl> rtnList = new ArrayList<ActivityImpl>();
        // 由于迭代出现重复数据，排除重复
        for (int i = list.size(); i > 0; i--) {
            if (!rtnList.contains(list.get(i - 1)))
                rtnList.add(list.get(i - 1));
        }
        return rtnList;
    }

    *//**
     * 转办流程
     *
     * @param taskId   当前任务节点ID
     * @param userCode 被转办人Code
     *//*
    public void transferAssignee(String taskId, String userCode) {
        taskServiceImpl.setAssignee(taskId, userCode);
    }

    *//**
     * 流程转向操作
     *
     * @param taskId     当前任务ID
     * @param activityId 目标节点任务ID
     * @param variables  流程变量
     * @throws Exception
     *//*
    private void turnTransition(String taskId, String activityId,
                                Map<String, Object> variables) throws Exception {
        // 当前节点
        ActivityImpl currActivity = findActivitiImpl(taskId, null);
        // 清空当前流向
        List<PvmTransition> oriPvmTransitionList = clearTransition(currActivity);

        // 创建新流向
        TransitionImpl newTransition = currActivity.createOutgoingTransition();
        // 目标节点
        ActivityImpl pointActivity = findActivitiImpl(taskId, activityId);
        // 设置新流向的目标节点
        newTransition.setDestination(pointActivity);

        // 执行转向任务
        taskServiceImpl.complete(taskId, variables);
        // 删除目标节点新流入
        pointActivity.getIncomingTransitions().remove(newTransition);

        // 还原以前流向
        restoreTransition(currActivity, oriPvmTransitionList);
    }*/


}

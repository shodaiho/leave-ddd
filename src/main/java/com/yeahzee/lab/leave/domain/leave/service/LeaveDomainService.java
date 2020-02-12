package com.yeahzee.lab.leave.domain.leave.service;

import com.yeahzee.lab.leave.domain.leave.ILeaveDomainService;
import com.yeahzee.lab.leave.domain.leave.event.ILeaveEventPublisher;
import com.yeahzee.lab.leave.domain.leave.event.LeaveCreatedEvent;
import com.yeahzee.lab.leave.domain.leave.repository.ILeaveRepository;

/**
 * 领域服务
 *
 * 1. 领域服务放在聚合内，实现领域服务接口
 * 2. 领域服务必须有对应的聚合根
 * 3. 领域服务命名规范：{聚合根名称}DomainService
 * 4. 聚合内数据存储操作，放在领域服务内，而非聚合根内
 * 5. 领域事件的发布，放在领域服务内，而非聚合根内
 * 6. 聚合内数据的生命周期维护，放在聚合根内，聚合根只是处理内存数据
 */
public class LeaveDomainService implements ILeaveDomainService {

    ILeaveEventPublisher eventPublisher;
    ILeaveRepository leaveRepository;

    @Override
    public Integer createLeave() {
        this.leaveRepository.save();
        this.eventPublisher.publish(new LeaveCreatedEvent());
        return 1;
    }
}
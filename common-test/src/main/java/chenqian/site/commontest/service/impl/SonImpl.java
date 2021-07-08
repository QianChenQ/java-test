/**
 * Created on [2021/3/15 20:39] by cq
 * <p>
 * 项目名称: java-test
 * <p>
 * 本程序版权属于福建慧政通信息科技有限公司所有。
 * 任何组织和个人未经福建慧政通信息科技有限公司许可与授权,不得擅自传播、复制、更改该程序的内容。
 * 本程序受版权法和国际条约的保护。如未经授权而擅自复制或传播本程序(或其中任何部分),
 * 将受到严厉的刑事及民事制裁，并将在法律许可的范围内受到最大可能的起诉!
 * <p>
 * ©2019 福建慧政通信息科技有限公司
 */
package chenqian.site.commontest.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 功能简介:.
 * *
 */
@Service
public class SonImpl {

    @Resource
    private FatherImpl fatherImpl;

    @Resource
    private GatherFatherImpl gatherFatherImpl;
}

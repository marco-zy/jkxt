package com.mybatis;

import com.mybatis.mapper.EmpMapper;
import com.mybatis.mapper.MissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisHeimaApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private MissionMapper missionMapper;

//    @Test
//    public void testDel(){
//        empMapper.delete(18);
//    }
//
//    @Test
//    public void testIns(){
//        Emp emp = new Emp();
//        emp.setUsername("tom1");
//        emp.setName("汤姆1");
//        emp.setImage("1.jpg");
//        emp.setGender((short)1);
//        emp.setJob((short)1);
//        emp.setEntrydate(LocalDate.of(2000,1,1));
//        emp.setCreateTime(LocalDateTime.now());
//        emp.setUpdateTime(LocalDateTime.now());
//        emp.setDeptId(1);
//        //调用添加方法
//        empMapper.insert(emp);
//
//    }
//
//    @Test
//    public void testSelectById(){
//        Emp emp = empMapper.selectById(3);
//        System.out.println(emp);
//    }
//
//    @Test
//    public void testSelectbyParam(){
//        //注意类型转换问题
//        short gender = 1;
////        LocalDate begin = LocalDate.parse("2010-08-16");
////        LocalDate end = LocalDate.parse("2023-01-01");
//        List<Emp> list = empMapper.list("金",gender,LocalDate.parse("2000-01-01"),LocalDate.parse("2023-01-01"));
//        for (Emp emp:list
//             ) {
//            System.out.println(emp);
//        }
//    }
//
//    @Test
//    public void testSelectByIdpro(){
//        Emp emp = empMapper.selectById(3);
//        System.out.println(emp);
//    }
//
//////missionTest
////    @Test
////    public void MissSelectById(){
////        Mission mission = missionMapper.selectById(1);
////        System.out.println(mission);
////    }
//
//    @Test
//    public void MissInsert(){
//
////        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
////        LocalDateTime parse = LocalDateTime.parse("2020-04-03 14:57:41",df);
//
//        Short status=1;
//        Mission mission=new Mission();
//        mission.setMissionNo("2");
//        mission.setProjectId("2");
//        mission.setMissionName("2");
//        mission.setCreateDepartment("2");
//        mission.setExecutor("haha");
//        mission.setExecuteTime(LocalDateTime.now().toString());
//        mission.setFinishTime(LocalDateTime.now().toString());
//        //mission.setStatus(status);
//        mission.setDeviceId("1");
//
//        int count = missionMapper.insert(mission);
//        System.out.println("插入了"+count+"条数据");
//        System.out.println("被插入数据的id为"+mission.getId());
//    }
//
//
//    @Test
//    public void MissSelectDevById() {
//
//        System.out.println(missionMapper.selDevById(1));
//
//    }
//
//    @Test
//    public void MissDeleteById() { }
//
//
//    @Test
//    public void MissUpdateStatus(){
//        Short status = 22;
//        //missionMapper.updateStatus(2, status);
//    }
//
//
//    @Test
//    public void MissSelectByName(){
//
//        List<Mission> list = missionMapper.selectByName("2");
//        for (Mission mission:list)
//        {
//            System.out.println(mission);
//        }
//    }
//

}

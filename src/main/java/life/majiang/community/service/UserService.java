package life.majiang.community.service;

import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 如果Mapper层能够完成任务的话就不用引入Service层，如果逻辑太复杂则引入Service层处理
 * @author Sam
 * @create 2024-06-04 3:46 PM
 */

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public void createOrUpdate(User user) {
    UserExample userExample = new UserExample();
    userExample.createCriteria()
            .andAccountIdEqualTo(user.getAccountId());
    List<User> users = userMapper.selectByExample(userExample);
    if(users.size() == 0) {
      // 插入
      user.setGmtCreate(System.currentTimeMillis());
      user.setGmtModified(user.getGmtCreate());
      userMapper.insert(user);
    } else {
      // 更新
      User dbUser = users.get(0);
      User updateUser = new User();
      updateUser.setGmtModified(System.currentTimeMillis());
      updateUser.setAvatarUrl(user.getAvatarUrl());
      updateUser.setName(user.getName());
      updateUser.setToken(user.getToken());
      UserExample example = new UserExample();
      example.createCriteria()
              .andIdEqualTo(dbUser.getId());
      userMapper.updateByExampleSelective(updateUser, example);
    }
  }
}

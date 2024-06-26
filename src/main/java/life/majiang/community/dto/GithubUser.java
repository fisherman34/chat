package life.majiang.community.dto;

import lombok.Data;

/**
 * @author Sam
 * @create 2024-05-02 11:52 PM
 */

@Data
public class GithubUser {
  private String name;
  private Long id;
  private String bio;
  private String avatarUrl;
}

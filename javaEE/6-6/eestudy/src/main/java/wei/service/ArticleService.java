package wei.service;

import wei.mapper.ArticleMapper;
import wei.model.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public Article queryById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> queryByUserId(Integer userId) {
        return articleMapper.queryByUserId(userId);
    }
}

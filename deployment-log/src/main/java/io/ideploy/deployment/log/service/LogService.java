package io.ideploy.deployment.log.service;

import com.alibaba.fastjson.JSONObject;
import io.ideploy.deployment.common.enums.LogType;
import io.ideploy.deployment.common.util.RedisLogKey;
import io.ideploy.deployment.common.util.redis.Redis;
import io.ideploy.deployment.common.vo.ServerCollectLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能: 日志处理服务类
 * <p>
 * 详细: 处理日志的的相关业务
 *
 * @author jingyesi   17/1/24
 */
@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    @Autowired
    private Redis redis;

    /**
     * 收集服务器发布执行的shell 日志
     * @param id
     * @param logType
     * @param content
     * @return
     */
    public boolean collectDeployLog(int id, short logType, String content){
        try {
            ServerCollectLog serverShellLog = new ServerCollectLog(id, logType, content);
            if (logType == LogType.SERVER_DEPLOY_LOG.getType()) {
                /** deployment:history:" + historyId + ":server:log" (每台服务器的启动过程的日志) **/
                collectServerDeployLog(serverShellLog);
            }
            /** deployment:server_deploy_log (存储服务器发布日志记录的key)**/
            redis.rpush(RedisLogKey.getServerDeploymentKey(), JSONObject.toJSONString(serverShellLog));

            return true;
        }catch (Exception e){
            logger.error("收集日志失败 | msg:{}", e.getMessage(), e);
            return false;
        }
    }

    private void collectServerDeployLog(ServerCollectLog log) {

        String deployStepRedisKey = RedisLogKey.getDeployServerLogKey(log.getId());

        redis.rpush(deployStepRedisKey, log.getContent());
    }
}

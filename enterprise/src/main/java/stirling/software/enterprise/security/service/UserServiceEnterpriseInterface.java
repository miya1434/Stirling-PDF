package stirling.software.enterprise.security.service;

import stirling.software.common.service.UserServiceInterface;

public interface UserServiceEnterpriseInterface extends UserServiceInterface {
    String getApiKeyForUser(String username);

    String getCurrentUsername();

    long getTotalUsersCount();
}

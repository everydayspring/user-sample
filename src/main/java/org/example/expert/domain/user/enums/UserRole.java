package org.example.expert.domain.user.enums;

import java.util.Arrays;

import org.example.expert.domain.common.exception.InvalidRequestException;

public enum UserRole {
    ADMIN,
    USER;

    // 권한을 반환하는 메서드 추가
    public String getAuthority() {
        return "ROLE_" + this.name();
    }

    public static UserRole of(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new InvalidRequestException("유효하지 않은 UserRole"));
    }
}

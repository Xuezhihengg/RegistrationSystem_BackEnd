package com.example.entity.dto.response_entity;

import com.example.entity.SignUp;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SignUpListWithPageInfo {
    private List<SignUpListItem> signUpList;
    private long totalPages;
}

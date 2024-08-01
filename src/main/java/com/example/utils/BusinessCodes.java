package com.example.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessCodes {
    Other_Error("39999", "发生了一些未知错误。"),
    Parameter_Verification_Failed("40001", "Parameter verification failed. "),
    AuthenticationFailed("40002", "Authentication failed. "),
    Get_Batch_Failed("40003", "获取批次失败。"),
    Create_New_Batch_Failed("40004", "创建新批次失败"),
    Fetch_Exams_By_BatchId_Failed("40005", "获取指定批次全部考试信息失败"),
    Get_Personnel_Failed("40006", "获取指定工号的人员信息失败"),
    Get_Examination_Failed("40007", "获取指定考试信息失败"),
    Upload_File_Failed("40008", "上传文件失败"),
    Get_SignUp_List_Failed("40009", "获取报名列表失败"),
    Auth_Info_Failed("40010","获取登录信息失败");

    private final String code;
    private final String message;
}


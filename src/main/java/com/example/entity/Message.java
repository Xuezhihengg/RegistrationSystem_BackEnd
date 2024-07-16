package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 消息列表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-16
 */
@Getter
@Setter
@TableName("Message")
@Schema(name = "Message", description = "消息列表")
public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "消息编号")
    @TableId("message_id")
    private String messageId;

    @Schema(description = "消息接收者")
    @TableField("to_personnel_id")
    private String toPersonnelId;

    @Schema(description = "消息发送者")
    @TableField("from_personnel_id")
    private String fromPersonnelId;

    @Schema(description = "消息类型")
    @TableField("type")
    private String type;

    @Schema(description = "关联考试")
    @TableField("exam_id")
    private String examId;
}

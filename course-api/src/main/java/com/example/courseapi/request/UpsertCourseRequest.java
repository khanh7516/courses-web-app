package com.example.courseapi.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpsertCourseRequest {

    private Integer id;
    @NotBlank(message = "Không được để trống!!!")
    private String name;
    @Size(min = 2, message = "độ dài > 2 ký tự")
    @NotBlank(message = "Không được để trống!!!")
    private String description;
    @NotBlank(message = "Không được để trống!!!")
    private String type;
    private List<String> topics;
    private String thumbnail;
    @NotNull(message = "Không được để trống!!!")
    private Integer userId;
}
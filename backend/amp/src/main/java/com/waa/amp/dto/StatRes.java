package com.waa.amp.dto;

import java.util.Map;
import java.util.Set;

public record StatRes(Map<String, Long> jobByState,
                      Map<String, Long> jobByCity,
                      Map<String, Long> studentByCity,
                      Map<String, Long> studentByState,
                      Map<String, Set<String>> tagInLocation) {
}

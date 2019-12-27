package com.ananops.core.registry.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The class Register dto.
 *
 * @author ananops.net @gmail.com
 */
@Data
@AllArgsConstructor
public class RegisterDto {

	private String app;

	private String host;

	private CoordinatorRegistryCenter coordinatorRegistryCenter;

}

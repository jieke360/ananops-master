
package com.ananops.base.enums;


/**
 * The class Error code enum.
 *
 * @author ananops.net @gmail.com
 */
public enum ErrorCodeEnum {

	//9998 维修维护数据中心
	/**
	 * MDMC 9998084 error code enum.
	 */

	MDMC9998084(9998084,"当前状态不允许服务商审批"),
	/**
	 * MDMC 9998085 error code enum.
	 */
	MDMC9998085(9998085,"当前状态不允许服务商接单"),
	/**
	 * MDMC 9998086 error code enum.
	 */
	MDMC9998086(9998086,"当前状态不允许服务商拒单"),
	/**
	 * MDMC 9998087 error code enum.
	 */
	MDMC9998087(9998087,"当前状态不允许工程师拒单"),
	/**
	 * MDMC 9998088 error code enum.
	 */
	MDMC9998088(9998088,"更新巡检任务子项失败"),
	/**
	 * MDMC 9998089 error code enum.
	 */
	MDMC9998089(9998089,"没有此角色"),
	/**
	 * MDMC 9998090 error code enum.
	 */
	MDMC9998090(9998090,"没有处于此状态的任务子项"),
	/**
	 * MDMC 9998091 error code enum.
	 */
	MDMC9998091(9998091,"没有处于此状态的任务"),
	/**
	 * MDMC 9998092 error code enum.
	 */
	MDMC9998092(9998092,"修改巡检任务状态失败"),
	/**
	 * MDMC 9998093 error code enum.
	 */
	MDMC9998093(9998093,"更新巡检任务失败"),
	/**
	 * MDMC 9998094 error code enum.
	 */
	MDMC9998094(9998094,"任务子项不存在此状态"),
	/**
	 * MDMC 9998095 error code enum.
	 */
	MDMC9998095(9998095,"任务不存在此状态"),
	/**
	 * MDMC 9998096 error code enum.
	 */
	MDMC9998096(9998096,"当前备品备件订单不存在"),
	/**
	 * MDMC 9998097 error code enum.
	 */
	MDMC9998097(9998097,"当前任务子项不存在,itemId=%s"),
	/**
	 * MDMC 9998098 error code enum.
	 */
	MDMC9998098(9998098,"当前任务不存在,taskId=%s"),
	/**
	 * MDMC 9998099 error code enum.
	 */
	MDMC9998099(9998099,"不能重复评论"),
	/**
	 * MDMC 99980100 error code enum.
	 */
	MDMC99980100(9998100, "参数异常"),
	/**
	 * MDMC 99980401 error code enum.
	 */
	MDMC99980401(99980401, "无访问权限"),
	/**
	 * MDMC 000500 error code enum.
	 */
	MDMC99980500(500, "未知异常"),
	/**
	 * MDMC 000403 error code enum.
	 */
	MDMC99980403(9998403, "无权访问"),
	/**
	 * MDMC 000404 error code enum.
	 */
	MDMC9998404(9998404, "找不到指定资源"),
	/**
	 * MDMC 99980001 error code enum.
	 */
	MDMC99980001(99980001, "注解使用错误"),
	/**
	 * MDMC 99980002 error code enum.
	 */
	MDMC99980002(99980002, "微服务不在线,或者网络超时"),
	/**
	 * MDMC 99980003 error code enum.
	 */
	MDMC99980003(99980003,"用户id不能为空"),

	/**
	 * MDMC 99980004 error code enum.
	 */
	MDMC99980004(99980004,"任务id不能为空"),


	/**
	 * MDMC 99980005 error code enum.
	 */
	MDMC99980005(99980005,"故障类型和故障位置内容不能为空"),

	/**
	 * MDMC 99980006 error code enum.
	 */
	MDMC99980006(99980006,"找不到发送消息的对象"),

	/**
	 * gl 9999084 error code enum.
	 */
	
	GL9999084(9999084,"当前状态不允许服务商审批"),
	/**
	 * GL 9999085 error code enum.
	 */
	GL9999085(9999085,"当前状态不允许服务商接单"),
	/**
	 * GL 9999086 error code enum.
	 */
	GL9999086(9999086,"当前状态不允许服务商拒单"),
	/**
	 * GL 9999087 error code enum.
	 */
	GL9999087(9999087,"当前状态不允许工程师拒单"),
	/**
	 * GL 9999088 error code enum.
	 */
	GL9999088(9999088,"更新巡检任务子项失败"),
	/**
	 * GL 9999089 error code enum.
	 */
	GL9999089(9999089,"没有此角色"),
	/**
	 * GL 9999090 error code enum.
	 */
	GL9999090(9999090,"没有处于此状态的任务子项"),
	/**
	 * GL 9999091 error code enum.
	 */
	GL9999091(9999091,"没有处于此状态的任务"),
	/**
	 * GL 9999092 error code enum.
	 */
	GL9999092(9999092,"修改巡检任务状态失败"),
	/**
	 * GL 9999093 error code enum.
	 */
	GL9999093(9999093,"更新巡检任务失败"),
	/**
	 * GL 9999094 error code enum.
	 */
	GL9999094(9999094,"任务子项不存在此状态"),
	/**
	 * GL 9999095 error code enum.
	 */
	GL9999095(9999095,"任务不存在此状态"),
	/**
	 * GL 9999096 error code enum.
	 */
	GL9999096(9999096,"当前备品备件订单不存在"),
	/**
	 * GL 9999097 error code enum.
	 */
	GL9999097(9999097,"当前任务子项不存在"),
	/**
	 * GL 9999098 error code enum.
	 */
	GL9999098(9999098,"当前任务不存在"),
	/**
	 * GL 9999099 error code enum.
	 */
	GL9999099(9999099,"不能重复评论"),
	/**
	 * GL 99990100 error code enum.
	 */
	GL99990100(9999100, "参数异常"),
	/**
	 * GL 99990401 error code enum.
	 */
	GL99990401(99990401, "无访问权限"),
	/**
	 * GL 000500 error code enum.
	 */
	GL99990500(500, "未知异常"),
	/**
	 * GL 000403 error code enum.
	 */
	GL99990403(9999403, "无权访问"),
	/**
	 * GL 000404 error code enum.
	 */
	GL9999404(9999404, "找不到指定资源"),
	/**
	 * GL 99990001 error code enum.
	 */
	GL99990001(99990001, "注解使用错误"),
	/**
	 * GL 99990002 error code enum.
	 */
	GL99990002(99990002, "微服务不在线,或者网络超时"),
	/**
	 * GL 99990003 error code enum.
	 */
	GL99990003(99990003,"用户id不能为空"),

	/**
	 * GL 99990004 error code enum.
	 */
	GL99990004(99990004,"任务id不能为空"),


	/**
	 * GL 99990004 error code enum.
	 */
	GL99990005(99990005,"故障类型和故障位置内容不能为空"),

	/**
	 * GL 99990006 error code enum.
	 */
	GL99990006(99990006,"该项目未绑定巡检单模板，需用户管理员配置项目巡检单，projectId=%s"),

	/**
	 * Uac 10010001 error code enum.
	 */
//	 1001 用户中心
	UAC10010001(10010001, "会话超时,请刷新页面重试"),
	/**
	 * Uac 10010002 error code enum.
	 */
	UAC10010002(10010002, "TOKEN解析失败"),
	/**
	 * Uac 10010003 error code enum.
	 */
	UAC10010003(10010003, "操作频率过快, 您的帐号已被冻结"),
	/**
	 * Uac 10011001 error code enum.
	 */
	UAC10011001(10011001, "用户Id不能为空"),
	/**
	 * Uac 10011002 error code enum.
	 */
	UAC10011002(10011002, "找不到用户,loginName=%s"),
	/**
	 * Uac 10011003 error code enum.
	 */
	UAC10011003(10011003, "找不到用户,userId=%s"),
	/**
	 * Uac 10011004 error code enum.
	 */
	UAC10011004(10011004, "找不到用户,email=%s"),
	/**
	 * Uac 10011006 error code enum.
	 */
	UAC10011006(10012006, "手机号不能为空"),
	/**
	 * Uac 10011007 error code enum.
	 */
	UAC10011007(10011007, "登录名不能为空"),
	/**
	 * Uac 10011008 error code enum.
	 */
	UAC10011008(10011008, "新密码不能为空"),
	/**
	 * Uac 10011009 error code enum.
	 */
	UAC10011009(10011009, "确认密码不能为空"),
	/**
	 * Uac 10011010 error code enum.
	 */
	UAC10011010(10011010, "两次密码不一致"),
	/**
	 * Uac 10011011 error code enum.
	 */
	UAC10011011(10011011, "用户不存在, userId=%s"),
	/**
	 * Uac 10011012 error code enum.
	 */
	UAC10011012(10011012, "登录名已存在"),
	/**
	 * Uac 10011013 error code enum.
	 */
	UAC10011013(10011013, "手机号已存在"),
	/**
	 * Uac 10011014 error code enum.
	 */
	UAC10011014(10011014, "密码不能为空"),
	/**
	 * Uac 10011016 error code enum.
	 */
	UAC10011016(10011016, "用户名或密码错误"),
	/**
	 * Uac 10011017 error code enum.
	 */
	UAC10011017(10011017, "验证类型错误"),
	/**
	 * Uac 10011018 error code enum.
	 */
	UAC10011018(10011018, "邮箱不能为空"),
	/**
	 * Uac 10011019 error code enum.
	 */
	UAC10011019(10011019, "邮箱已存在"),
	/**
	 * Uac 10011020 error code enum.
	 */
	UAC10011020(10011020, "短信模板不能为空"),
	/**
	 * Uac 10011021 error code enum.
	 */
	UAC10011021(10011021, "发送短信验证码对象转换为json字符串失败"),
	/**
	 * Uac 10011022 error code enum.
	 */
	UAC10011022(10011022, "发送短信验证码失败"),
	/**
	 * Uac 10011023 error code enum.
	 */
	UAC10011023(10011023, "越权操作"),
	/**
	 * Uac 10011024 error code enum.
	 */
	UAC10011024(10011024, "找不到绑定的用户, userId=%s"),
	/**
	 * Uac 10011025 error code enum.
	 */
	UAC10011025(10011025, "用户已存在, loginName=%s"),
	/**
	 * Uac 10011026 error code enum.
	 */
	UAC10011026(10011026, "更新用户失败, userId=%s"),
	/**
	 * Uac 10011027 error code enum.
	 */
	UAC10011027(10011027, "找不到用户,mobile=%s"),
	/**
	 * Uac 10011028 error code enum.
	 */
	UAC10011028(10011028, "链接已失效"),
	/**
	 * Uac 10011029 error code enum.
	 */
	UAC10011029(10011029, "重置密码失败"),
	/**
	 * Uac 10011030 error code enum.
	 */
	UAC10011030(10011030, "激活失败, 链接已过期"),
	/**
	 * Uac 10011031 error code enum.
	 */
	UAC10011031(10011031, "验证码超时, 请重新发送验证码"),
	/**
	 * Uac 10011032 error code enum.
	 */
	UAC10011032(10011032, "邮箱不存在, loginName=%s,email=%s"),
	/**
	 * Uac 10011033 error code enum.
	 */
	UAC10011033(10011033, "清空该用户常用菜单失败"),
	/**
	 * Uac 10011034 error code enum.
	 */
	UAC10011034(10011034, "不允许操作admin用户"),
	/**
	 * Uac 10011035 error code enum.
	 */
	UAC10011035(10011035, "原始密码输入错误"),
	/**
	 * Uac 10011036 error code enum.
	 */
	UAC10011036(10011036, "新密码和原始密码不能相同"),
	/**
	 * Uac 10011037 error code enum.
	 */
	UAC10011037(10011037, "修改用户失败,userId=%s"),
	/**
	 * Uac 10011038 error code enum.
	 */
	UAC10011038(10011038, "激活用户失败,userId=%s"),
	/**
	 * Uac 10011039 error code enum.
	 */
	UAC10011039(10011039, "验证token失败"),
	/**
	 * Uac 10011040 error code enum.
	 */
	UAC10011040(10011040, "解析header失败"),
	/**
	 * Uac 10011041 error code enum.
	 */
	UAC10011041(10011041, "页面已过期,请重新登录"),
	/**
	 * Uac 10011042 error code enum.
	 */
	UAC10011042(10011042, "Cookie转码异常"),
	/**
	 * Uac 10012001 error code enum.
	 */
	UAC10012001(10012001, "角色ID不能为空"),
	/**
	 * Uac 10012002 error code enum.
	 */
	UAC10012002(10012002, "拥有的角色不允许禁用"),
	/**
	 * Uac 10012003 error code enum.
	 */
	UAC10012003(10012003, "系统角色不能删除"),
	/**
	 * Uac 10012004 error code enum.
	 */
	UAC10012004(10012004, "超级角色Id不能为空"),

	/**
	 * Uac 10012005 error code enum.
	 */
	UAC10012005(10012005, "找不到角色信息,roleId=%s"),
	/**
	 * Uac 10012006 error code enum.
	 */
	UAC10012006(10012006, "删除角色失败, roleId=%s"),
	/**
	 * Uac 10012007 error code enum.
	 */
	UAC10012007(10012007, "批量删除角色失败, roleId=%s"),
	/**
	 * Uac 10012008 error code enum.
	 */
	UAC10012008(10012008, "找不到绑定的角色, roleId=%s"),


	/**
	 * Uac 10013001 error code enum.
	 */
	UAC10013001(10013001, "父菜单不存在,menuId=%s"),
	/**
	 * Uac 10013002 error code enum.
	 */
	UAC10013002(10013002, "更新上级菜单失败,menuId=%s"),
	/**
	 * Uac 10013003 error code enum.
	 */
	UAC10013003(10013003, "菜单不存在,menuId=%s"),
	/**
	 * Uac 10013004 error code enum.
	 */
	UAC10013004(10013004, "启用菜单失败,menuId=%s"),
	/**
	 * Uac 10013005 error code enum.
	 */
	UAC10013005(10013005, "禁用菜单失败,menuId=%s"),
	/**
	 * Uac 10013006 error code enum.
	 */
	UAC10013006(10013006, "更新菜单状态失败,menuId=%s"),
	/**
	 * Uac 10013007 error code enum.
	 */
	UAC10013007(10013007, "根菜单不能禁用"),
	/**
	 * Uac 10013008 error code enum.
	 */
	UAC10013008(10013008, "删除菜单失败, menuId=%s"),
	/**
	 * Uac 10013009 error code enum.
	 */
	UAC10013009(10013009, "请先分配菜单"),
	/**
	 * Uac 10013010 error code enum.
	 */
	UAC10013010(10013010, "选择菜单不是根目录,menuId=%s"),


	/**
	 * Uac 10014001 error code enum.
	 */
	UAC10014001(10014001, "找不到权限信息, actionId=%s"),
	/**
	 * Uac 10014002 error code enum.
	 */
	UAC10014002(10014002, "删除失败, actionId=%s"),
	/**
	 * Uac 10014003 error code enum.
	 */
	UAC10014003(10014003, "保存权限信息失败"),
	/**
	 * Uac 10015001 error code enum.
	 */
	UAC10015001(10015001, "找不到组织信息,groupId=%s"),
	/**
	 * Uac 10015002 error code enum.
	 */
	UAC10015002(10015002, "组织状态不存在"),
	/**
	 * Uac 10015003 error code enum.
	 */
	UAC10015003(10015003, "操作越权, 启用子节点, 必须先启用父节点"),
	/**
	 * Uac 10015004 error code enum.
	 */
	UAC10015004(10015004, "找不到组织信息,groupId=%s"),
	/**
	 * Uac 10015006 error code enum.
	 */
	UAC10015006(10015006, "更新组织信息失败,groupId=%s"),
	/**
	 * Uac 10015007 error code enum.
	 */
	UAC10015007(10015007, "该组织下还存在子节点，不能将其删除, Pid=%s"),
	/**
	 * Uac 10015008 error code enum.
	 */
	UAC10015008(10015008, "该组织下绑定的用户，不能将其删除, groupId=%s"),
	/**
	 * Uac 10015009 error code enum.
	 */
	UAC10015009(10015009, "找不到上级组织, groupId=%s"),
	/**
	 * Uac 10015010 error code enum.
	 */
	UAC10015010(10015010, "组织ID不能为空, groupId=%s"),
	/**
	 * Uac 10015011 error code enum.
	 */
	UAC10015011(10015011, "组织名称不能为空, groupName=%s"),
	/**
	 * Uac 10015012 error code enum.
	 */
	UAC10015012(10015012, "组织类型不能为空, groupType=%s"),

	UAC10015013(10015013, "更新权限信息失败, apiId=%s"),



	/**
	 * Mdc 10021001 error code enum.
	 */
// 1002 数据中心
	MDC10021001(10021001, "获取地址信息失败"),
	/**
	 * Mdc 10021002 error code enum.
	 */
	MDC10021002(10021002, "找不到该地址信息"),
	/**
	 * Mdc 10021003 error code enum.
	 */
	MDC10021003(10021003, "获取商品信息失败"),
	/**
	 * Mdc 10021004 error code enum.
	 */
	MDC10021004(10021004, "找不到该商品信息,productId=%s"),
	/**
	 * Mdc 10021015 error code enum.
	 */
	MDC10021015(10021015, "商品不是在线售卖状态, productId=%s"),
	/**
	 * Mdc 10021016 error code enum.
	 */
	MDC10021016(10021016, "商品库存不足, productId=%s"),
	/**
	 * Mdc 10021017 error code enum.
	 */
	MDC10021017(10021017, "产品已下架或者删除, productId=%s"),
	/**
	 * Mdc 10021018 error code enum.
	 */
	MDC10021018(10021018, "找不到数据字典信息, dictId=%s"),
	/**
	 * Mdc 10021019 error code enum.
	 */
	MDC10021019(10021019, "更新字典状态失败, dictId=%s"),
	/**
	 * Mdc 10021020 error code enum.
	 */
	MDC10021020(10021020, "上级数据字典不存在, dictId=%s"),
	/**
	 * Mdc 10021021 error code enum.
	 */
	MDC10021021(10021021, "商品ID不能为空"),
	/**
	 * Mdc 10021024 error code enum.
	 */
	MDC10021028(10021024, "商品编码不能为空"),

	/**
	 * Mdc 10023001 error code enum.
	 */
	MDC10023001(10023001, "找不到商品分类信息, categoryId=%s"),

	/**
	 * Mdc 10023002 error code enum.
	 */
	MDC10023002(10023002, "上级商品分类不存在, categoryId=%s"),

	/**
	 * Mdc 10023003 error code enum.
	 */
	MDC10023003(10023003, "更新商品分类状态失败, categoryId=%s"),
	/**
	 * Mdc 10021022 error code enum.
	 */
	MDC10021022(10021022, "更新商品信息失败, productId=%s"),
	/**
	 * Mdc 10021023 error code enum.
	 */
	MDC10021023(10021023, "删除商品信息失败, productId=%s"),

	MDC10021024(10021024,"不存在此字典库，dictId=%s"),

	MDC10021025(10021025,"不存在此字典项，dictItemId=%s"),

	MDC10021026(10021026,"字典库id不能是空"),

	MDC10021027(10021027,"字典项id不能是空"),

	MDC10021029(10021029,"字典库类型为系统类型，不允许删除！"),

	MDC10021030(10021030,"字典项类型为系统类型，不支持删除！"),

	MDC10021031(10021031,"字典库类型为系统类型，不允许更改！"),

	MDC10021032(10021032,"字典项类型为系统类型，不允许更改！"),

	MDC10021033(10021033,"字典库名称不能是空"),

	MDC10021034(10021034,"字典项名称不能是空"),

	MDC10021035(10021035,"字典项编码不能是空"),

	MDC10021036(10021036,"字典项排序码不能是空"),

	MDC10021037(10021037,"该动态表单模板不存在，templateId=%s"),

	MDC10021038(10021038,"该项目已绑定动态表单模板，templateId=%s"),

	MDC10021039(10021039,"查询模板使用关联的项目ID不能为空，projectId=%s"),

	MDC10021040(10021040,"该项目未绑定动态表单模板，projectId=%s"),
	/**
	 * Omc 10031001 error code enum.
	 */
// 1003 订单中心
	OMC10031001(10031001, "购物车为空, userId=%s"),
	/**
	 * Omc 10031002 error code enum.
	 */
	OMC10031002(10031002, "生成订单失败"),
	/**
	 * Omc 10031003 error code enum.
	 */
	OMC10031003(10031003, "该用户此订单不存在"),
	/**
	 * Omc 10031004 error code enum.
	 */
	OMC10031004(10031004, "已付款, 无法取消订单"),
	/**
	 * Omc 10031005 error code enum.
	 */
	OMC10031005(10031005, "找不到订单信息, orderNo=%s"),
	/**
	 * Omc 10031006 error code enum.
	 */
	OMC10031006(10031006, "清空购物车失败"),
	/**
	 * Omc 10031007 error code enum.
	 */
	OMC10031007(10031007, "不存在默认地址"),
	/**
	 * Omc 10031008 error code enum.
	 */
	OMC10031008(10031008, "更新默认地址失败, addressId=%s"),
	/**
	 * Omc 10031009 error code enum.
	 */
	OMC10031009(10031009, "批量插入订单明细失败"),
	/**
	 * Omc 10031010 error code enum.
	 */
	OMC10031010(10031010, "非安安运维平台的订单, 回调忽略"),
	/**
	 * Omc 10031011 error code enum.
	 */
	OMC10031011(10031011, "支付宝重复调用"),
	/**
	 * Omc 10031012 error code enum.
	 */
	OMC10031012(10031012, "上传失败"),
	/**
	 * Omc 10031013 error code enum.
	 */
	OMC10031013(10031013, "获取附件地址失败"),
	/**
	 * Omc 10031014 error code enum.
	 */
	OMC10031014(10031014, "更新购物车数据失败, cartId=%s"),
	/**
	 * Omc 10031016 error code enum.
	 */
	OMC10031016(10031016, "更新购物车数据失败, cartId=%s"),
	/**
	 * Opc 10040001 error code enum.
	 */
// 1004 对接中心
	OPC10040001(10040001, "根据IP定位失败"),
	/**
	 * Opc 10040002 error code enum.
	 */
	OPC10040002(10040002, "上传文件失败"),
	/**
	 * Opc 10040003 error code enum.
	 */
	OPC10040003(10040003, "文件类型不符"),
	/**
	 * Opc 10040004 error code enum.
	 */
	OPC10040004(10040004, "发送短信失败"),
	/**
	 * Opc 10040005 error code enum.
	 */
	OPC10040005(10040005, "生成邮件消息体失败"),
	/**
	 * Opc 10040006 error code enum.
	 */
	OPC10040006(10040006, "获取模板信息失败"),
	/**
	 * Opc 10040007 error code enum.
	 */
	OPC10040007(10040007, "更新附件失败, id=%s"),
	/**
	 * Opc 10040008 error code enum.
	 */
	OPC10040008(10040008, "找不到该附件信息, id=%s"),
	/**
	 * Opc 10040009 error code enum.
	 */
	OPC10040009(10040009, "上传图片失败"),
	/**
	 * Tpc 10050001 error code enum.
	 */
	OPC10040010(10040010, "文件名不能为空"),
	/**
	 * Opc 10040011 error code enum.
	 */
	OPC10040011(10040011, "今日流量已用尽, 请明天再试"),
	/**
	 * Tpc 10050001 error code enum.
	 */
// 1005 任务中心
	TPC10050001(10050001, "消息的消费Topic不能为空"),
	/**
	 * Tpc 10050002 error code enum.
	 */
	TPC10050002(10050002, "根据消息key查找的消息为空"),
	/**
	 * Tpc 10050003 error code enum.
	 */
	TPC10050003(10050003, "删除消息失败,messageKey=%s"),
	/**
	 * Tpc 10050004 error code enum.
	 */
	TPC10050004(10050004, "消息中心接口异常,message=%s, messageKey=%s"),
	/**
	 * Tpc 10050005 error code enum.
	 */
	TPC10050005(10050005, "目标接口参数不能为空"),
	/**
	 * Tpc 10050006 error code enum.
	 */
	TPC10050006(10050006, "根据任务Id查找的消息为空"),

	/**
	 * Tpc 10050007 error code enum.
	 */
	TPC10050007(10050007, "消息数据不能为空"),
	/**
	 * Tpc 10050008 error code enum.
	 */
	TPC10050008(10050008, "消息体不能为空,messageKey=%s"),
	/**
	 * Tpc 10050009 error code enum.
	 */
	TPC10050009(10050009, "消息KEY不能为空"),
	/**
	 * Tpc 100500010 error code enum.
	 */
	TPC100500010(10050010, "Topic=%s, 无消费者订阅"),
	/**
	 * Tpc 100500011 error code enum.
	 */
	TPC100500011(10050011, "Mq编码转换异常, MessageKey=%s"),
	/**
	 * Tpc 100500012 error code enum.
	 */
	TPC100500012(10050012, "发送MQ失败, MessageKey=%s"),
	/**
	 * Tpc 100500013 error code enum.
	 */
	TPC100500013(10050013, "延迟级别错误, Topic=%s, MessageKey=%s"),
	/**
	 * Tpc 100500014 error code enum.
	 */
	TPC100500014(10050014, "MQ重试三次,仍然发送失败, Topic=%s, MessageKey=%s"),
	/**
	 * Tpc 100500015 error code enum.
	 */
	TPC100500015(10050015, "消息PID不能为空, messageKey=%s"),
	/**
	 * Tpc 100500016 error code enum
	 */
	TPC100500016(10050016,"consumer创建失败"),
	/**
	 * Tpc 100500017 error code enum
	 */
	TPC100500017(10050017,"producer创建失败"),
	/**
	 * Tpc 100500018 error code enum
	 */
	TPC100500018(10050018,"topic创建失败"),
	/**
	 * Tpc 100500019 error code enum
	 */
	TPC100500019(10050019,"topic绑定tag失败"),
	/**
	 * Tpc 100500020 error code enum
	 */
	TPC100500020(10050020,"无此消费者"),
	/**
	 * Tpc 100500021 error code enum
	 */
	TPC100500021(10050021,"无此topic"),

	//1008 项目管理
	/**
	 *
	 */
	PMC10081000(10081000, "删除失败, Id=%s"),

	/**
	 * Pmc 10081001 error code enum.
	 */
	PMC10081001(10081001, "更新项目信息失败, projectId=%s"),
	/**
	 * Pmc 10021002 error code enum.
	 */
	PMC10081002(10081002, "删除项目失败, projectId=%s"),

	/**
	 * Pmc 10021003 error code enum.
	 */
	PMC10081003(10081003, "该项目无合同信息, contactId=%s"),

	/**
	 * Pmc 10021011 error code enum.
	 */
	PMC10081011(10081011, "更新合同信息失败, contactId=%s"),

	/**
	 * Pmc 10021012 error code enum.
	 */
	PMC10081012(10081012, "删除合同失败, contactId=%s"),

	/**
	 * Pmc 10021021 error code enum.
	 */
	PMC10081021(10081021, "更新巡检任务失败失败, taskId=%s"),

	/**
	 * Pmc 10021022 error code enum.
	 */
	PMC10081022(10081022, "删除巡检任务失败失败, taskId=%s"),

	/**
	 * Pmc 10021023 error code enum.
	 */
	PMC10081023(10081023, "该巡检任务无项目信息, projectId=%s"),

	/**
	 * Pmc 10021024 error code enum.
	 */
	PMC10081024(10081024, "该巡检巡检详情无巡检任务信息, InspectTaskId=%s"),

	/**
	 * Pmc 10021025 error code enum.
	 */
	PMC10081025(10081025, "更新失败, InspectDetailId=%s"),

	/**
	 * Pmc 10021026 error code enum.
	 */
	PMC10081026(10081026, "公司组织Id不能为空"),

	/**
	 * Pmc 10021027 error code enum.
	 */
	PMC10081027(10081027, "该合同下包含项目，请先删除关联项目, contractId=%s"),

	//报警管理 1009
	/**
	 * Amc 10091011 error code enum.
	 */
	AMC10091011(10091011, "更新报警信息失败, alarmId=%s"),



	/**
	 * 服务商管理
	 *
	 * Spc 100850010 error code enum.
	 */
	SPC100850010(100850010, "企业统一信用代码不能为空"),
	/**
	 * Spc 100850011 error code enum.
	 */
	SPC100850011(100850011, "企业法人姓名不能为空"),
	/**
	 * Spc 100850012 error code enum.
	 */
	SPC100850012(100850012, "企业基本开户行账号不能为空"),
	/**
	 * Spc 100850013 error code enum.
	 */
	SPC100850013(100850013, "企业基本开户行影印件未上传"),
	/**
	 * Spc 100850014 error code enum.
	 */
	SPC100850014(100850014, "企业营业执照类型不能为空"),
	/**
	 * Spc 100850015 error code enum.
	 */
	SPC100850015(100850015, "企业营业执照有效期不能为空"),
	/**
	 * Spc 100850016 error code enum.
	 */
	SPC100850016(100850016, "企业营业执照影印件未上传"),
	/**
	 * Spc 100850017 error code enum.
	 */
	SPC100850017(100850017, "工程师姓名不能为空"),
	/**
	 * Spc 100850018 error code enum.
	 */
	SPC100850018(100850018, "工程师身份证号码不能为空"),
	/**
	 * Spc 100850019 error code enum.
	 */
	SPC100850019(100850019, "无此审批操作"),
	/**
	 * Spc 100850020 error code enum.
	 */
	SPC100850020(100850020, "服务商ID不能为空"),
	/**
	 * Spc 100850021 error code enum.
	 */
	SPC100850021(100850021, "该工程师不存在，engineerId=%s"),
	/**
	 * Spc 100850022 error code enum.
	 */
	SPC100850022(100850022, "工程师Id不能为空，engineerId=%s"),

	/**
	 * Imc 10090000 error code enum
	 */

	IMC10090000(10090000,"巡检任务子项的附件id获取失败"),

	IMC10090001(10090001,"未传入巡检任务Id"),

	IMC10090002(10090002,"未传入巡检任务子项的Id"),

	IMC10090003(10090003,"未传入巡检任务的状态"),

	IMC10090004(10090004,"未传入巡检任务子项的状态"),

	IMC10090005(10090005,"查无此图"),

	IMC10090006(10090006,"找不到当前巡检任务对应的发起人"),

	IMC10090007(10090007,"消息发送失败"),

	IMC10090008(10090008,"userId或role为空"),

	
	RDC100000000(10000000, "新建备品备件订单失败，数据库操作异常"),
	
	RDC100000001(10000001, "序列化参数异常，请检查参数配置"),
	
	RDC100000002(10000002, "未授权审核此备品备件订单"),

	RDC100000003(10000003, "该备品备件订单申请正在审核中，请勿重复提交"),

	RDC100000004(10000004, "备品备件订单处理异常，请稍后重试"),

	/**
	 * WebSocket error code enum
	 */
	WEBSOCKET10100000(10100000,"消息体为空"),

	WEBSOCKET10100001(10100001,"消息推送失败"),

	WEBSOCKET10100002(10100002,"查无此消息"),


	;
	private int code;
	private String msg;

	/**
	 * Msg string.
	 *
	 * @return the string
	 */
	public String msg() {
		return msg;
	}

	/**
	 * Code int.
	 *
	 * @return the int
	 */
	public int code() {
		return code;
	}

	ErrorCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * Gets enum.
	 *
	 * @param code the code
	 *
	 * @return the enum
	 */
	public static ErrorCodeEnum getEnum(int code) {
		for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
			if (ele.code() == code) {
				return ele;
			}
		}
		return null;
	}
}

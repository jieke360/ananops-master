package com.ananops.provider.service.hystrix;

import com.ananops.provider.model.dto.oss.*;
import com.ananops.provider.service.OpcOssFeignApi;
import com.ananops.wrapper.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The class Opc oss feign api hystrix.
 *
 * @author ananops.net@gmail.com
 */
@Component
public class OpcOssFeignApiHystrix implements OpcOssFeignApi {
	@Override
	public Wrapper<OptUploadFileRespDto> uploadFile(final OptUploadFileReqDto optUploadFileReqDto) {
		return null;
	}

	@Override
	public Wrapper<String> getFileUrl(final OptGetUrlRequest optGetUrlRequest) {
		return null;
	}

	@Override
	public Wrapper<List<ElementImgUrlDto>> listFileUrl(final OptBatchGetUrlRequest urlRequest) {
		return null;
	}

	@Override
	public Wrapper<OptUploadFileRespDto> handleFileUpload(final MultipartFile file) {
		return null;
	}

	@Override
	public void deleteExpireFile() {

	}
}

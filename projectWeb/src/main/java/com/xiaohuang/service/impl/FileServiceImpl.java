package com.xiaohuang.service.impl;

import com.xiaohuang.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@PropertySource(value = "classpath:/image.properties", encoding = "UTF-8")
public class FileServiceImpl implements FileService {
	private static Set<String> typeSet = new HashSet<>();
	@Value("${image.localDirPath}")
	private String localDirPath; // 图片的存储地址
	static {
		typeSet.add(".jpg");
		typeSet.add(".png");
		typeSet.add(".gif");
	}

	@Override
	public Map<String,Object> uploadImage(MultipartFile file) {
		String fileName = file.getOriginalFilename().toLowerCase();
		Map<String,Object> map=new HashMap<>();
		Map<String,Object> map2=new HashMap<>();
		/*if (!fileName.matches("^.+\\.(jpg|png|gif)$")) {//检验后缀
			 map.put("code",-1);
		        map.put("msg","图片后缀不正确，请修改为jpg|png|gif");
		        return map;
		}*/
		int index = fileName.lastIndexOf(".");
		if (index==-1) {
			 map.put("code",-1);
		        map.put("msg","图片后缀不正确");
		        return map;
		}
		String fileType = fileName.substring(index);//后缀
		if (!typeSet.contains(fileType)) {
			map.put("code",-1);
	        map.put("msg","图片后缀不正确，请修改为jpg|png|gif");
	        return map;
		}
		if(file.getSize()/1024>=20000){
              map.put("code",-1);
			  map.put("msg","图片大小不能超过20000kb");
			   return map;
         }
		try {
			BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
			int width=bufferedImage.getWidth();
			int height=bufferedImage.getHeight();
			if (width==0||height==0) {//校验是否为图片对象
				 map.put("code",-1);
			        map.put("msg","请传入正确格式的图片");
			        return map;
			}
			
			String dateDirPath=new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
			String fileDirPath=localDirPath+dateDirPath;//文件存储目录
			File fileDir=new File(fileDirPath);
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			
			String uuid = UUID.randomUUID().toString().replace("-", "");
			
			String newFileName=uuid+fileType;//文件新名称
			
			//实现文件上传
			File realFile=new File(fileDirPath+newFileName);
			file.transferTo(realFile);
			map.put("code",0);
            map.put("msg","");
            map.put("data",map2);
            map2.put("src",dateDirPath+newFileName);
            return map;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code",-1);
	        map.put("msg","上传失败");
	        return map;
		}
	}

}

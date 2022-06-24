package com.leandrainacio.cadastroplanetas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.leandrainacio.cadastroplanetas.entity.LuaEntity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class LuaService {

	public List<LuaEntity> buscaLuaPorIdPlaneta(Long id) {
		String urlBase = "http://localhost:8082/luas";
		String urlRequest = urlBase+"/"+id;
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(urlRequest).build();
		Response response;
		
		try {
			response = client.newCall(request).execute();
			String jsonResposta = response.body().string();
			
			
			Gson gson = new Gson();
			List<LuaEntity> luaEntity = gson.fromJson(jsonResposta,  ArrayList.class);
			
			return luaEntity;
			
		}catch(Exception e) {
			return null ;
		}
	}
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.jiyuan.http;



/**
 * Client
 */
public class Client {
    /**
     * 发送请求
     *
     * @param aliRequest request对象
     * @return Response
     * @throws Exception
     */
    public static Response execute(AliRequest aliRequest) throws Exception {
//        switch (aliRequest.getMethod()) {
//            case GET:
//                return HttpUtil.httpGet(aliRequest.getHost(), aliRequest.getPath(),
//                		aliRequest.getTimeout(),
//                		aliRequest.getHeaders(),
//                		aliRequest.getQuerys(),
//                		aliRequest.getSignHeaderPrefixList(),
//                		aliRequest.getAppKey(), aliRequest.getAppSecret());
//            case POST_FORM:
//                return HttpUtil.httpPost(aliRequest.getHost(), aliRequest.getPath(),
//                		aliRequest.getTimeout(),
//                		aliRequest.getHeaders(),
//                		aliRequest.getQuerys(),
//                		aliRequest.getBodys(),
//                		aliRequest.getSignHeaderPrefixList(),
//                		aliRequest.getAppKey(), aliRequest.getAppSecret());
//            case POST_STRING:
//                return HttpUtil.httpPost(aliRequest.getHost(), aliRequest.getPath(),
//                		aliRequest.getTimeout(),
//                		aliRequest.getHeaders(),
//                		aliRequest.getQuerys(),
//                		aliRequest.getStringBody(),
//                		aliRequest.getSignHeaderPrefixList(),
//                		aliRequest.getAppKey(), aliRequest.getAppSecret());
//            case POST_BYTES:
//                return HttpUtil.httpPost(aliRequest.getHost(), aliRequest.getPath(),
//                		aliRequest.getTimeout(),
//                		aliRequest.getHeaders(),
//                		aliRequest.getQuerys(),
//                		aliRequest.getBytesBody(),
//                		aliRequest.getSignHeaderPrefixList(),
//                		aliRequest.getAppKey(), aliRequest.getAppSecret());
//            case PUT_STRING:
//                return HttpUtil.httpPut(aliRequest.getHost(), aliRequest.getPath(),
//                		aliRequest.getTimeout(),
//                		aliRequest.getHeaders(),
//                		aliRequest.getQuerys(),
//                		aliRequest.getStringBody(),
//                		aliRequest.getSignHeaderPrefixList(),
//                		aliRequest.getAppKey(), aliRequest.getAppSecret());
//            case PUT_BYTES:
//                return HttpUtil.httpPut(aliRequest.getHost(), aliRequest.getPath(),
//                		aliRequest.getTimeout(),
//                		aliRequest.getHeaders(),
//                		aliRequest.getQuerys(),
//                		aliRequest.getBytesBody(),
//                		aliRequest.getSignHeaderPrefixList(),
//                		aliRequest.getAppKey(), aliRequest.getAppSecret());
//            case DELETE:
//                return HttpUtil.httpDelete(aliRequest.getHost(), aliRequest.getPath(),
//                		aliRequest.getTimeout(),
//                		aliRequest.getHeaders(),
//                		aliRequest.getQuerys(),
//                		aliRequest.getSignHeaderPrefixList(),
//                		aliRequest.getAppKey(), aliRequest.getAppSecret());
//            default:
//                throw new IllegalArgumentException(String.format("unsupported method:%s", aliRequest.getMethod()));
//        }
		return null;
    }
}

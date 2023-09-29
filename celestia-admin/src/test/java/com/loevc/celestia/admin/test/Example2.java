//package com.loevc.celestia.admin.test;
//
//import cn.hutool.core.date.DateUtil;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Semaphore;
//
///**
// * @Author Loevc
// * @Email Loevc1024@gmail.com
// * @Date 2023/9/12 9:15
// * @Description TODO
// * @Version 1.0
// */
//public class Example2 {
//    ReportExportApplyFor reportExportApplyFor = reportExportCenterService.saveReportExportApplyFor(param);
//    String tenantId = TenantContextHolder.getTenantId();
//    SecurityContext context = SecurityContextHolder.getContext();
//
//    String fileName = DateUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss") + Long.toString(System.currentTimeMillis()).substring(Long.toString(System.currentTimeMillis()).length()-3) + ".xlsx";
//    ExcelWriter excelWriter = EasyExcel.write(fileName, ExportOrderInfoByOrderListVO.class).build();
//    ExecutorService executorService = ThreadPoolUtil.getExecutorService();
//
//		param.setCurrent(MallReportCenterConstants.DEFAULT_EXPORT_START_PAGE);
//		param.setSize(MallReportCenterConstants.DEFAULT_EXPORT_SINGLE_PAGE);
//    // TODO 调整sql ，仅做必要的连表 ，其他数据使用填充的方式
//    IPage<ExportOrderInfoByOrderListVO> page = orderInfoService.exportByOrderV2(param);
//    // TODO 获取总页数 筛选后的字段  以及游标
//    long pages = page.getPages();
//    // 创建 CountDownLatch 对象
//    CountDownLatch countDownLatch = new CountDownLatch((int)pages);
//
//    // init semaphore array
//    Semaphore[] semaphoresFirst = new Semaphore[(int) pages];
//		for (int i = semaphoresFirst.length - 1; i >= 0; i--) {
//        semaphoresFirst[i] = new Semaphore(1);
//    }
//    Semaphore[] semaphoresSecond = new Semaphore[(int) pages];
//		for (int i = semaphoresSecond.length - 1; i >= 0; i--) {
//        semaphoresSecond[i] = new Semaphore(1);
//    }
//
//    Map<Integer, List<ExportOrderInfoByOrderListVO>> map = new ConcurrentHashMap<>();
//
//		for (int i = 1; i <= pages; i++) {
//        int finalI = i;
//        atomicLong.incrementAndGet();
//        executorService.submit(() -> {
//            try {
//
//                TenantContextHolder.setTenantId(tenantId);
//                SecurityContextHolder.setContext(context);
//                // 获取数据源
//                param.setCurrent(finalI);
//
//                semaphoresFirst[finalI-1].acquire();
//                IPage<ExportOrderInfoByOrderListVO> pageData = null;
//                semaphoresFirst[finalI - 1].acquire();
//                try {
//                    if (finalI != 1){
//                        semaphoresFirst[finalI - 2].acquire();
//                    }
//                    pageData = orderInfoService.exportByOrderV2(param);
//                } catch (Exception e) {
//                    log.error("acquire lock failed",e);
//                    reportExportCenterService.exportQuickFailed(reportExportApplyFor);
//                }finally {
//                    semaphoresFirst[finalI - 1].release();
//                }
//                List<ExportOrderInfoByOrderListVO> data = getExportOrderWideV2(pageData);
//
//
////					map.put(finalI,data);
//
//
//                // TODO write excel method1
//                semaphoresSecond[finalI - 1].acquire();
//                try {
//                    if (finalI != 1){
//                        semaphoresSecond[finalI - 2].acquire();
//                    }
//                    synchronized (excelWriter) {
//                        WriteSheet writeSheet = EasyExcel.writerSheet(finalI).build();
//                        // TODO 写入指定的行
//                        excelWriter.write(data, writeSheet);
//                    }
//                } catch (Exception e){
//                    log.error("write excel failed",e);
//                    reportExportCenterService.exportQuickFailed(reportExportApplyFor);
//                } finally {
//                    semaphoresSecond[finalI - 1].release();
//                }
//
//					/*// 写入数据
//					synchronized (excelWriter) {
//						WriteSheet writeSheet = EasyExcel.writerSheet(finalI).build();
//						// TODO 写入指定的行
//						excelWriter.write(data, writeSheet);
//					}*/
//
//            } catch (Exception e) {
//                // 异常处理
//                log.error("thread pool exception", e);
//                log.info("{},页",finalI);
//                reportExportCenterService.exportQuickFailed(reportExportApplyFor);
//            } finally {
//                // 计数器减一
//                countDownLatch.countDown();
//            }
//        });
//
//
//    }
//
//		try {
//        countDownLatch.await();
//
//        // TODO write excel method2
////			for (int i = 1; i < map.size()+1; i++) {
////
////				WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
////				// TODO 写入指定的行
////				excelWriter.write(map.get(i), writeSheet);
////			}
//
//    } catch (InterruptedException e) {
//        log.error("thread pool exception", e);
//        reportExportCenterService.exportQuickFailed(reportExportApplyFor);
//    } finally {
//        excelWriter.finish();
//        // 关闭线程池
//        // TODO 判断一下线程池中是否还有活跃线程 在关闭 或者不关闭
////			executorService.shutdown();
//    }
//
//		reportExportCenterService.uploadExcelOss(reportExportApplyFor, fileName);
//}

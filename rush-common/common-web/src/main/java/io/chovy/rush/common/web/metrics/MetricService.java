package io.chovy.rush.common.web.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.FunctionTimer;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.LongTaskTimer;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.TimeGauge;
import io.micrometer.core.instrument.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/** metric服务类 */
public class MetricService {

    private MeterRegistry meterRegistry;

    public MetricService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    /**
     * 创建Counter类型metric
     *
     * @param name metric名称
     * @param tags 标签 key/value形式
     * @return
     */
    public Counter registerCounterMetric(String name, String... tags) {
        return Metrics.counter(name, tags);
    }

    /**
     * 创建Gauge类型metric
     *
     * @param name metric名称
     * @param atomicInteger atomicInteger实例
     * @param tags 标签 key/value形式
     * @return
     */
    public AtomicInteger registerGaugeMetric(
            String name, AtomicInteger atomicInteger, String... tags) {
        Gauge.builder(name, atomicInteger, AtomicInteger::get).tags(tags).register(meterRegistry);
        return atomicInteger;
    }

    /**
     * 创建Histogram类型metric
     *
     * @param name metric名称
     * @param bucket 桶
     * @param tags 标签 key/value形式
     * @return
     */
    public DistributionSummary registerHistogramMetric(String name, long[] bucket, String... tags) {
        return DistributionSummary.builder(name).tags(tags).sla(bucket).register(meterRegistry);
    }

    /**
     * 创建Summary类型metric
     *
     * @param name metric名称
     * @param percentiles 百分位
     * @param tags 标签 key/value形式
     * @return
     */
    public DistributionSummary registerSummaryMetric(
            String name, double[] percentiles, String... tags) {
        return DistributionSummary.builder(name)
                .tags(tags)
                .publishPercentiles(percentiles)
                .register(meterRegistry);
    }

    /**
     * 创建Timer类型metric
     *
     * @param name metric名称
     * @param tags 标签 key/value形式
     * @return
     */
    public Timer registerTimerMetric(String name, String... tags) {
        return Metrics.timer(name, tags);
    }

    /**
     * 用于记录长时间执行的任务的持续时间
     *
     * @param name metric名称
     * @param tags key/value形式
     * @return
     */
    public LongTaskTimer registerLongTaskTimerMetric(String name, String... tags) {
        return Metrics.more().longTaskTimer(name, tags);
    }

    /**
     * FunctionCounter与counter作用类似
     *
     * @param name metric名称
     * @param atomicInteger atomicInteger实例
     * @param tags 标签 key/value形式
     * @return
     */
    public AtomicInteger registerFunctionCounterMetric(
            String name, AtomicInteger atomicInteger, String... tags) {
        FunctionCounter.builder(name, atomicInteger, AtomicInteger::get)
                .tags(tags)
                .register(meterRegistry);
        return atomicInteger;
    }

    /**
     * FunctionTimer
     *
     * @param name metric名称
     * @param atomicInteger
     * @param totalTime
     * @param totalCount
     * @param timeUnit
     * @param tags
     */
    public void registerFunctionTimer(
            String name,
            AtomicInteger atomicInteger,
            AtomicLong totalCount,
            AtomicLong totalTime,
            TimeUnit timeUnit,
            String... tags) {
        FunctionTimer.builder(
                        name,
                        atomicInteger,
                        value -> totalCount.get(),
                        value -> totalTime.get(),
                        timeUnit)
                .tags(tags)
                .register(meterRegistry);
    }

    /**
     * TimeGauge
     *
     * @param name metric名称
     * @param atomicInteger
     * @param timeUnit
     * @param tags
     */
    public void registerTimeGauge(
            String name, AtomicInteger atomicInteger, TimeUnit timeUnit, String... tags) {
        TimeGauge.builder(name, atomicInteger, timeUnit, AtomicInteger::get)
                .tags(tags)
                .register(meterRegistry);
    }
}

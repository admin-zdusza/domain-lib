package pl.zdusza;

import org.junit.Test;
import pl.zdusza.time.Clock;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeriodTest {

    private final Clock clock = new Clock(Instant.parse("2019-01-01T00:31:00.000Z"));

    public PeriodTest() {
    }

    private Instant[] firstHour() {
        return new Instant[]{Instant.parse("2018-12-31T22:00:00Z"),
                Instant.parse("2018-12-31T22:01:00Z"),
                Instant.parse("2018-12-31T22:02:00Z"),
                Instant.parse("2018-12-31T22:03:00Z"),
                Instant.parse("2018-12-31T22:04:00Z"),
                Instant.parse("2018-12-31T22:05:00Z"),
                Instant.parse("2018-12-31T22:06:00Z"),
                Instant.parse("2018-12-31T22:07:00Z"),
                Instant.parse("2018-12-31T22:08:00Z"),
                Instant.parse("2018-12-31T22:09:00Z"),
                Instant.parse("2018-12-31T22:10:00Z"),
                Instant.parse("2018-12-31T22:11:00Z"),
                Instant.parse("2018-12-31T22:12:00Z"),
                Instant.parse("2018-12-31T22:13:00Z"),
                Instant.parse("2018-12-31T22:14:00Z"),
                Instant.parse("2018-12-31T22:15:00Z"),
                Instant.parse("2018-12-31T22:16:00Z"),
                Instant.parse("2018-12-31T22:17:00Z"),
                Instant.parse("2018-12-31T22:18:00Z"),
                Instant.parse("2018-12-31T22:19:00Z"),
                Instant.parse("2018-12-31T22:20:00Z"),
                Instant.parse("2018-12-31T22:21:00Z"),
                Instant.parse("2018-12-31T22:22:00Z"),
                Instant.parse("2018-12-31T22:23:00Z"),
                Instant.parse("2018-12-31T22:24:00Z"),
                Instant.parse("2018-12-31T22:25:00Z"),
                Instant.parse("2018-12-31T22:26:00Z"),
                Instant.parse("2018-12-31T22:27:00Z"),
                Instant.parse("2018-12-31T22:28:00Z"),
                Instant.parse("2018-12-31T22:29:00Z"),
                Instant.parse("2018-12-31T22:30:00Z"),
                Instant.parse("2018-12-31T22:31:00Z"),
                Instant.parse("2018-12-31T22:32:00Z"),
                Instant.parse("2018-12-31T22:33:00Z"),
                Instant.parse("2018-12-31T22:34:00Z"),
                Instant.parse("2018-12-31T22:35:00Z"),
                Instant.parse("2018-12-31T22:36:00Z"),
                Instant.parse("2018-12-31T22:37:00Z"),
                Instant.parse("2018-12-31T22:38:00Z"),
                Instant.parse("2018-12-31T22:39:00Z"),
                Instant.parse("2018-12-31T22:40:00Z"),
                Instant.parse("2018-12-31T22:41:00Z"),
                Instant.parse("2018-12-31T22:42:00Z"),
                Instant.parse("2018-12-31T22:43:00Z"),
                Instant.parse("2018-12-31T22:44:00Z"),
                Instant.parse("2018-12-31T22:45:00Z"),
                Instant.parse("2018-12-31T22:46:00Z"),
                Instant.parse("2018-12-31T22:47:00Z"),
                Instant.parse("2018-12-31T22:48:00Z"),
                Instant.parse("2018-12-31T22:49:00Z"),
                Instant.parse("2018-12-31T22:50:00Z"),
                Instant.parse("2018-12-31T22:51:00Z"),
                Instant.parse("2018-12-31T22:52:00Z"),
                Instant.parse("2018-12-31T22:53:00Z"),
                Instant.parse("2018-12-31T22:54:00Z"),
                Instant.parse("2018-12-31T22:55:00Z"),
                Instant.parse("2018-12-31T22:56:00Z"),
                Instant.parse("2018-12-31T22:57:00Z"),
                Instant.parse("2018-12-31T22:58:00Z"),
                Instant.parse("2018-12-31T22:59:00Z")
        };
    }

    @Test
    public final void testShouldEvaluateLast2HStart() {
        assertEquals(Instant.parse("2018-12-31T22:00:00.000Z"), Period.LAST_2_H.getStart(clock));
        Instant[] firstHour = firstHour();
        final Instant[] rest = {
                Instant.parse("2018-12-31T23:00:00Z"),
                Instant.parse("2018-12-31T23:01:00Z"),
                Instant.parse("2018-12-31T23:02:00Z"),
                Instant.parse("2018-12-31T23:03:00Z"),
                Instant.parse("2018-12-31T23:04:00Z"),
                Instant.parse("2018-12-31T23:05:00Z"),
                Instant.parse("2018-12-31T23:06:00Z"),
                Instant.parse("2018-12-31T23:07:00Z"),
                Instant.parse("2018-12-31T23:08:00Z"),
                Instant.parse("2018-12-31T23:09:00Z"),
                Instant.parse("2018-12-31T23:10:00Z"),
                Instant.parse("2018-12-31T23:11:00Z"),
                Instant.parse("2018-12-31T23:12:00Z"),
                Instant.parse("2018-12-31T23:13:00Z"),
                Instant.parse("2018-12-31T23:14:00Z"),
                Instant.parse("2018-12-31T23:15:00Z"),
                Instant.parse("2018-12-31T23:16:00Z"),
                Instant.parse("2018-12-31T23:17:00Z"),
                Instant.parse("2018-12-31T23:18:00Z"),
                Instant.parse("2018-12-31T23:19:00Z"),
                Instant.parse("2018-12-31T23:20:00Z"),
                Instant.parse("2018-12-31T23:21:00Z"),
                Instant.parse("2018-12-31T23:22:00Z"),
                Instant.parse("2018-12-31T23:23:00Z"),
                Instant.parse("2018-12-31T23:24:00Z"),
                Instant.parse("2018-12-31T23:25:00Z"),
                Instant.parse("2018-12-31T23:26:00Z"),
                Instant.parse("2018-12-31T23:27:00Z"),
                Instant.parse("2018-12-31T23:28:00Z"),
                Instant.parse("2018-12-31T23:29:00Z"),
                Instant.parse("2018-12-31T23:30:00Z"),
                Instant.parse("2018-12-31T23:31:00Z"),
                Instant.parse("2018-12-31T23:32:00Z"),
                Instant.parse("2018-12-31T23:33:00Z"),
                Instant.parse("2018-12-31T23:34:00Z"),
                Instant.parse("2018-12-31T23:35:00Z"),
                Instant.parse("2018-12-31T23:36:00Z"),
                Instant.parse("2018-12-31T23:37:00Z"),
                Instant.parse("2018-12-31T23:38:00Z"),
                Instant.parse("2018-12-31T23:39:00Z"),
                Instant.parse("2018-12-31T23:40:00Z"),
                Instant.parse("2018-12-31T23:41:00Z"),
                Instant.parse("2018-12-31T23:42:00Z"),
                Instant.parse("2018-12-31T23:43:00Z"),
                Instant.parse("2018-12-31T23:44:00Z"),
                Instant.parse("2018-12-31T23:45:00Z"),
                Instant.parse("2018-12-31T23:46:00Z"),
                Instant.parse("2018-12-31T23:47:00Z"),
                Instant.parse("2018-12-31T23:48:00Z"),
                Instant.parse("2018-12-31T23:49:00Z"),
                Instant.parse("2018-12-31T23:50:00Z"),
                Instant.parse("2018-12-31T23:51:00Z"),
                Instant.parse("2018-12-31T23:52:00Z"),
                Instant.parse("2018-12-31T23:53:00Z"),
                Instant.parse("2018-12-31T23:54:00Z"),
                Instant.parse("2018-12-31T23:55:00Z"),
                Instant.parse("2018-12-31T23:56:00Z"),
                Instant.parse("2018-12-31T23:57:00Z"),
                Instant.parse("2018-12-31T23:58:00Z"),
                Instant.parse("2018-12-31T23:59:00Z"),
                Instant.parse("2019-01-01T00:00:00Z"),
                Instant.parse("2019-01-01T00:01:00Z"),
                Instant.parse("2019-01-01T00:02:00Z"),
                Instant.parse("2019-01-01T00:03:00Z"),
                Instant.parse("2019-01-01T00:04:00Z"),
                Instant.parse("2019-01-01T00:05:00Z"),
                Instant.parse("2019-01-01T00:06:00Z"),
                Instant.parse("2019-01-01T00:07:00Z"),
                Instant.parse("2019-01-01T00:08:00Z"),
                Instant.parse("2019-01-01T00:09:00Z"),
                Instant.parse("2019-01-01T00:10:00Z"),
                Instant.parse("2019-01-01T00:11:00Z"),
                Instant.parse("2019-01-01T00:12:00Z"),
                Instant.parse("2019-01-01T00:13:00Z"),
                Instant.parse("2019-01-01T00:14:00Z"),
                Instant.parse("2019-01-01T00:15:00Z"),
                Instant.parse("2019-01-01T00:16:00Z"),
                Instant.parse("2019-01-01T00:17:00Z"),
                Instant.parse("2019-01-01T00:18:00Z"),
                Instant.parse("2019-01-01T00:19:00Z"),
                Instant.parse("2019-01-01T00:20:00Z"),
                Instant.parse("2019-01-01T00:21:00Z"),
                Instant.parse("2019-01-01T00:22:00Z"),
                Instant.parse("2019-01-01T00:23:00Z"),
                Instant.parse("2019-01-01T00:24:00Z"),
                Instant.parse("2019-01-01T00:25:00Z"),
                Instant.parse("2019-01-01T00:26:00Z"),
                Instant.parse("2019-01-01T00:27:00Z"),
                Instant.parse("2019-01-01T00:28:00Z"),
                Instant.parse("2019-01-01T00:29:00Z"),
                Instant.parse("2019-01-01T00:30:00Z"),
                Instant.parse("2019-01-01T00:31:00Z")
        };
        final List<Instant> expected = new ArrayList<>(Arrays.asList(firstHour));
        expected.addAll(Arrays.asList(rest));
        assertEquals(expected, Period.LAST_2_H.getDates(clock));
    }

    @Test
    public final void testShouldEvaluateLast2DStart() {
        assertEquals(Instant.parse("2018-12-29T23:00:00.000Z"), Period.LAST_2_D.getStart(clock));
        final Instant[] expected = {
                Instant.parse("2018-12-29T23:00:00Z"),
                Instant.parse("2018-12-30T00:00:00Z"),
                Instant.parse("2018-12-30T01:00:00Z"),
                Instant.parse("2018-12-30T02:00:00Z"),
                Instant.parse("2018-12-30T03:00:00Z"),
                Instant.parse("2018-12-30T04:00:00Z"),
                Instant.parse("2018-12-30T05:00:00Z"),
                Instant.parse("2018-12-30T06:00:00Z"),
                Instant.parse("2018-12-30T07:00:00Z"),
                Instant.parse("2018-12-30T08:00:00Z"),
                Instant.parse("2018-12-30T09:00:00Z"),
                Instant.parse("2018-12-30T10:00:00Z"),
                Instant.parse("2018-12-30T11:00:00Z"),
                Instant.parse("2018-12-30T12:00:00Z"),
                Instant.parse("2018-12-30T13:00:00Z"),
                Instant.parse("2018-12-30T14:00:00Z"),
                Instant.parse("2018-12-30T15:00:00Z"),
                Instant.parse("2018-12-30T16:00:00Z"),
                Instant.parse("2018-12-30T17:00:00Z"),
                Instant.parse("2018-12-30T18:00:00Z"),
                Instant.parse("2018-12-30T19:00:00Z"),
                Instant.parse("2018-12-30T20:00:00Z"),
                Instant.parse("2018-12-30T21:00:00Z"),
                Instant.parse("2018-12-30T22:00:00Z"),
                Instant.parse("2018-12-30T23:00:00Z"),
                Instant.parse("2018-12-31T00:00:00Z"),
                Instant.parse("2018-12-31T01:00:00Z"),
                Instant.parse("2018-12-31T02:00:00Z"),
                Instant.parse("2018-12-31T03:00:00Z"),
                Instant.parse("2018-12-31T04:00:00Z"),
                Instant.parse("2018-12-31T05:00:00Z"),
                Instant.parse("2018-12-31T06:00:00Z"),
                Instant.parse("2018-12-31T07:00:00Z"),
                Instant.parse("2018-12-31T08:00:00Z"),
                Instant.parse("2018-12-31T09:00:00Z"),
                Instant.parse("2018-12-31T10:00:00Z"),
                Instant.parse("2018-12-31T11:00:00Z"),
                Instant.parse("2018-12-31T12:00:00Z"),
                Instant.parse("2018-12-31T13:00:00Z"),
                Instant.parse("2018-12-31T14:00:00Z"),
                Instant.parse("2018-12-31T15:00:00Z"),
                Instant.parse("2018-12-31T16:00:00Z"),
                Instant.parse("2018-12-31T17:00:00Z"),
                Instant.parse("2018-12-31T18:00:00Z"),
                Instant.parse("2018-12-31T19:00:00Z"),
                Instant.parse("2018-12-31T20:00:00Z"),
                Instant.parse("2018-12-31T21:00:00Z"),
                Instant.parse("2018-12-31T22:00:00Z"),
                Instant.parse("2018-12-31T23:00:00Z"),
                Instant.parse("2019-01-01T00:00:00Z")
        };
        assertEquals(Arrays.asList(expected), Period.LAST_2_D.getDates(clock));
    }

    @Test
    public final void testShouldEvaluateLast2MStart() {
        assertEquals(Instant.parse("2018-10-31T23:00:00.000Z"), Period.LAST_2_M.getStart(clock));
        final Instant[] expected = {
                Instant.parse("2018-10-31T23:00:00Z"),
                Instant.parse("2018-11-01T23:00:00Z"),
                Instant.parse("2018-11-02T23:00:00Z"),
                Instant.parse("2018-11-03T23:00:00Z"),
                Instant.parse("2018-11-04T23:00:00Z"),
                Instant.parse("2018-11-05T23:00:00Z"),
                Instant.parse("2018-11-06T23:00:00Z"),
                Instant.parse("2018-11-07T23:00:00Z"),
                Instant.parse("2018-11-08T23:00:00Z"),
                Instant.parse("2018-11-09T23:00:00Z"),
                Instant.parse("2018-11-10T23:00:00Z"),
                Instant.parse("2018-11-11T23:00:00Z"),
                Instant.parse("2018-11-12T23:00:00Z"),
                Instant.parse("2018-11-13T23:00:00Z"),
                Instant.parse("2018-11-14T23:00:00Z"),
                Instant.parse("2018-11-15T23:00:00Z"),
                Instant.parse("2018-11-16T23:00:00Z"),
                Instant.parse("2018-11-17T23:00:00Z"),
                Instant.parse("2018-11-18T23:00:00Z"),
                Instant.parse("2018-11-19T23:00:00Z"),
                Instant.parse("2018-11-20T23:00:00Z"),
                Instant.parse("2018-11-21T23:00:00Z"),
                Instant.parse("2018-11-22T23:00:00Z"),
                Instant.parse("2018-11-23T23:00:00Z"),
                Instant.parse("2018-11-24T23:00:00Z"),
                Instant.parse("2018-11-25T23:00:00Z"),
                Instant.parse("2018-11-26T23:00:00Z"),
                Instant.parse("2018-11-27T23:00:00Z"),
                Instant.parse("2018-11-28T23:00:00Z"),
                Instant.parse("2018-11-29T23:00:00Z"),
                Instant.parse("2018-11-30T23:00:00Z"),
                Instant.parse("2018-12-01T23:00:00Z"),
                Instant.parse("2018-12-02T23:00:00Z"),
                Instant.parse("2018-12-03T23:00:00Z"),
                Instant.parse("2018-12-04T23:00:00Z"),
                Instant.parse("2018-12-05T23:00:00Z"),
                Instant.parse("2018-12-06T23:00:00Z"),
                Instant.parse("2018-12-07T23:00:00Z"),
                Instant.parse("2018-12-08T23:00:00Z"),
                Instant.parse("2018-12-09T23:00:00Z"),
                Instant.parse("2018-12-10T23:00:00Z"),
                Instant.parse("2018-12-11T23:00:00Z"),
                Instant.parse("2018-12-12T23:00:00Z"),
                Instant.parse("2018-12-13T23:00:00Z"),
                Instant.parse("2018-12-14T23:00:00Z"),
                Instant.parse("2018-12-15T23:00:00Z"),
                Instant.parse("2018-12-16T23:00:00Z"),
                Instant.parse("2018-12-17T23:00:00Z"),
                Instant.parse("2018-12-18T23:00:00Z"),
                Instant.parse("2018-12-19T23:00:00Z"),
                Instant.parse("2018-12-20T23:00:00Z"),
                Instant.parse("2018-12-21T23:00:00Z"),
                Instant.parse("2018-12-22T23:00:00Z"),
                Instant.parse("2018-12-23T23:00:00Z"),
                Instant.parse("2018-12-24T23:00:00Z"),
                Instant.parse("2018-12-25T23:00:00Z"),
                Instant.parse("2018-12-26T23:00:00Z"),
                Instant.parse("2018-12-27T23:00:00Z"),
                Instant.parse("2018-12-28T23:00:00Z"),
                Instant.parse("2018-12-29T23:00:00Z"),
                Instant.parse("2018-12-30T23:00:00Z"),
                Instant.parse("2018-12-31T23:00:00Z")
        };
        assertEquals(Arrays.asList(expected), Period.LAST_2_M.getDates(clock));
    }

    @Test
    public final void testShouldEvaluateLast12WStart() {
        assertEquals(Instant.parse("2018-10-07T22:00:00.000Z"), Period.LAST_12_W.getStart(clock));
        assertEquals(Instant.parse("2018-10-07T22:00:00.000Z"),
                Period.LAST_12_W.getStart(new Clock(Instant.parse("2018-12-30T23:00:00.000Z"))));
        final Instant[] expected = {
                Instant.parse("2018-10-07T22:00:00Z"),
                Instant.parse("2018-10-14T22:00:00Z"),
                Instant.parse("2018-10-21T22:00:00Z"),
                Instant.parse("2018-10-28T23:00:00Z"),
                Instant.parse("2018-11-04T23:00:00Z"),
                Instant.parse("2018-11-11T23:00:00Z"),
                Instant.parse("2018-11-18T23:00:00Z"),
                Instant.parse("2018-11-25T23:00:00Z"),
                Instant.parse("2018-12-02T23:00:00Z"),
                Instant.parse("2018-12-09T23:00:00Z"),
                Instant.parse("2018-12-16T23:00:00Z"),
                Instant.parse("2018-12-23T23:00:00Z"),
                Instant.parse("2018-12-30T23:00:00Z")
        };
        assertEquals(Arrays.asList(expected), Period.LAST_12_W.getDates(clock));
    }

    @Test
    public final void testShouldEvaluateLast2YStart() {
        assertEquals(Instant.parse("2016-12-31T23:00:00.000Z"), Period.LAST_2_Y.getStart(clock));
        final Instant[] expected = {
                Instant.parse("2016-12-31T23:00:00Z"),
                Instant.parse("2017-01-31T23:00:00Z"),
                Instant.parse("2017-02-28T23:00:00Z"),
                Instant.parse("2017-03-31T22:00:00Z"),
                Instant.parse("2017-04-30T22:00:00Z"),
                Instant.parse("2017-05-31T22:00:00Z"),
                Instant.parse("2017-06-30T22:00:00Z"),
                Instant.parse("2017-07-31T22:00:00Z"),
                Instant.parse("2017-08-31T22:00:00Z"),
                Instant.parse("2017-09-30T22:00:00Z"),
                Instant.parse("2017-10-31T23:00:00Z"),
                Instant.parse("2017-11-30T23:00:00Z"),
                Instant.parse("2017-12-31T23:00:00Z"),
                Instant.parse("2018-01-31T23:00:00Z"),
                Instant.parse("2018-02-28T23:00:00Z"),
                Instant.parse("2018-03-31T22:00:00Z"),
                Instant.parse("2018-04-30T22:00:00Z"),
                Instant.parse("2018-05-31T22:00:00Z"),
                Instant.parse("2018-06-30T22:00:00Z"),
                Instant.parse("2018-07-31T22:00:00Z"),
                Instant.parse("2018-08-31T22:00:00Z"),
                Instant.parse("2018-09-30T22:00:00Z"),
                Instant.parse("2018-10-31T23:00:00Z"),
                Instant.parse("2018-11-30T23:00:00Z"),
                Instant.parse("2018-12-31T23:00:00Z"),
        };
        assertEquals(Arrays.asList(expected), Period.LAST_2_Y.getDates(clock));
    }

    @Test
    public final void testShouldEvaluateLast12YStart() {
        assertEquals(Instant.parse("2006-12-31T23:00:00.000Z"), Period.LAST_12_Y.getStart(clock));
        final Instant[] expected = {
                Instant.parse("2006-12-31T23:00:00Z"),
                Instant.parse("2007-12-31T23:00:00Z"),
                Instant.parse("2008-12-31T23:00:00Z"),
                Instant.parse("2009-12-31T23:00:00Z"),
                Instant.parse("2010-12-31T23:00:00Z"),
                Instant.parse("2011-12-31T23:00:00Z"),
                Instant.parse("2012-12-31T23:00:00Z"),
                Instant.parse("2013-12-31T23:00:00Z"),
                Instant.parse("2014-12-31T23:00:00Z"),
                Instant.parse("2015-12-31T23:00:00Z"),
                Instant.parse("2016-12-31T23:00:00Z"),
                Instant.parse("2017-12-31T23:00:00Z"),
                Instant.parse("2018-12-31T23:00:00Z")
        };
        assertEquals(Arrays.asList(expected), Period.LAST_12_Y.getDates(clock));
    }
}


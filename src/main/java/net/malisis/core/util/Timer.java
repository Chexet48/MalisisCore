/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Ordinastie
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.malisis.core.util;

/**
 * @author Ordinastie
 *
 */
public class Timer
{
	private long start;

	public Timer()
	{
		start();
	}

	public Timer(long start)
	{
		setStart(start);
	}

	public void start()
	{
		setStart(System.currentTimeMillis());
	}

	public void setStart(long start)
	{
		if (start < 0)
			setRelativeStart(start);
		else
			this.start = start;
	}

	public void setRelativeStart(long start)
	{
		setStart(System.currentTimeMillis() + start);
	}

	public long getStart()
	{
		return start;
	}

	public long elapsedTime()
	{
		return System.currentTimeMillis() - start;
	}

	public long elapsedTick()
	{
		return timeToTick(System.currentTimeMillis() - start);
	}

	public static long timeToTick(long time)
	{
		return time * 20 / 1000;
	}

	public static long tickToTime(long ticks)
	{
		return ticks * 1000 / 20;
	}

	@Override
	public String toString()
	{
		int elapsed = (int) (elapsedTime() / 1000);
		int minutes = (elapsed % 3600) / 60;
		int seconds = elapsed % 60;

		return String.format("%02d:%02d", minutes, seconds);
	}

}

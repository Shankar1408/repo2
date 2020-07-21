package com.testcase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import comThomes.Base;

public class ListenerUtil implements ITestListener {
	Base b = new Base();

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		try {
			b.getScreenshotPass(result.getName());
			System.out.println(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void onTestFailure(ITestResult result) {
		try {
			b.getScreenshotFail(result.getName());
			System.out.println(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}

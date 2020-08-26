package com.kotlin.uitestingsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing). Test*
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }

    @Test
    fun verifyText(){
        onView(withId(R.id.helloWorld)).check(matches(withText("Hello World!")))
    }

    @Test
    fun verifyChangedText(){
        onView(withId(R.id.edit_text_t)).perform(typeText("testttttttgtygfutygutgtgtgtygtgyguguygugugut"), closeSoftKeyboard())
        onView(withId(R.id.image)).perform(click())
        onView(withId(R.id.app_hello_text)).check(matches(withText("testttttttgtygfutygutgtgtgtygtgyguguygugugut")))
    }

}

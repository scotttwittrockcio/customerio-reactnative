package io.customer.reactnative.sdk

import android.app.Application
import android.content.Context
import io.customer.messaginginapp.MessagingInAppModuleConfig
import io.customer.messaginginapp.ModuleMessagingInApp
import io.customer.messaginginapp.type.InAppEventListener
import io.customer.messagingpush.MessagingPushModuleConfig
import io.customer.messagingpush.ModuleMessagingPushFCM
import io.customer.messagingpush.config.PushClickBehavior
import io.customer.reactnative.sdk.constant.Keys
import io.customer.reactnative.sdk.extension.*
import io.customer.sdk.CustomerIO
import io.customer.sdk.data.store.Client

// TODO: Remove this file or modify as required
// Once confirmed that this class is no longer required
// by any of the other files in this module.
/**
 * Static property holder for ReactNative package to overcome SDK
 * initialization challenges
 */
/*
object CustomerIOReactNativeInstance {
    @Throws(IllegalArgumentException::class)
    internal fun initialize(
        context: Context,
        environment: Map<String, Any?>,
        configuration: Map<String, Any?>?,
        packageConfig: Map<String, Any?>?,
        inAppEventListener: InAppEventListener,
    ): CustomerIO {
        val siteId = environment.getString(Keys.Environment.SITE_ID)
        val apiKey = environment.getString(Keys.Environment.API_KEY)
        val region = environment.getProperty<String>(
            Keys.Environment.REGION
        )?.takeIfNotBlank().toRegion()
        val enableInApp = configuration?.getProperty<Boolean>(
            Keys.Config.ENABLE_IN_APP
        ) ?: false

        return CustomerIO.Builder(
            siteId = siteId,
            apiKey = apiKey,
            region = region,
            appContext = context.applicationContext as Application,
        ).apply {
            setClient(client = getUserAgentClient(packageConfig = packageConfig))
            setupConfig(configuration)
            addCustomerIOModule(module = configureModuleMessagingPushFCM(configuration))
            if (enableInApp) {
                addCustomerIOModule(
                    module = configureModuleMessagingInApp(inAppEventListener = inAppEventListener),
                )
            }
        }.build()
    }

    private fun getUserAgentClient(packageConfig: Map<String, Any?>?): Client {
        val sourceSDK = packageConfig?.getProperty<String>(
            Keys.PackageConfig.SOURCE_SDK
        )?.takeIfNotBlank()
        val sourceSDKVersion = packageConfig?.getProperty<String>(
            Keys.PackageConfig.SOURCE_SDK_VERSION
        )?.takeIfNotBlank() ?: packageConfig?.getProperty<String>(
            Keys.PackageConfig.SOURCE_SDK_VERSION_COMPAT
        )?.takeIfNotBlank() ?: "n/a"
        return when {
            sourceSDK?.equals(
                other = "expo", ignoreCase = true,
            ) == true -> Client.Expo(sdkVersion = sourceSDKVersion)

            else -> Client.ReactNative(sdkVersion = sourceSDKVersion)
        }
    }

    private fun CustomerIO.Builder.setupConfig(config: Map<String, Any?>?): CustomerIO.Builder {
        if (config == null) return this

        val logLevel = config.getProperty<Double>(Keys.Config.LOG_LEVEL).toCIOLogLevel()
        setLogLevel(level = logLevel)
        config.getProperty<String>(Keys.Config.TRACKING_API_URL)?.takeIfNotBlank()?.let { value ->
            setTrackingApiURL(value)
        }
        config.getProperty<Boolean>(Keys.Config.AUTO_TRACK_DEVICE_ATTRIBUTES)?.let { value ->
            autoTrackDeviceAttributes(shouldTrackDeviceAttributes = value)
        }
        config.getProperty<Double>(Keys.Config.BACKGROUND_QUEUE_MIN_NUMBER_OF_TASKS)?.let { value ->
            setBackgroundQueueMinNumberOfTasks(backgroundQueueMinNumberOfTasks = value.toInt())
        }
        config.getProperty<Double>(Keys.Config.BACKGROUND_QUEUE_SECONDS_DELAY)?.let { value ->
            setBackgroundQueueSecondsDelay(backgroundQueueSecondsDelay = value)
        }
        return this
    }

    private fun configureModuleMessagingPushFCM(config: Map<String, Any?>?): ModuleMessagingPushFCM {
        return ModuleMessagingPushFCM(
            config = MessagingPushModuleConfig.Builder().apply {
                config?.getProperty<Boolean>(Keys.Config.AUTO_TRACK_PUSH_EVENTS)?.let { value ->
                    setAutoTrackPushEvents(autoTrackPushEvents = value)
                }
                config?.getProperty<String>(Keys.Config.PUSH_CLICK_BEHAVIOR)
                    ?.takeIfNotBlank()
                    ?.let { value ->
                        val behavior = kotlin.runCatching {
                            enumValueOf<PushClickBehavior>(value)
                        }.getOrNull()
                        if (behavior != null) {
                            setPushClickBehavior(pushClickBehavior = behavior)
                        }
                    }
            }.build(),
        )
    }

    private fun configureModuleMessagingInApp(
        inAppEventListener: InAppEventListener,
    ) = ModuleMessagingInApp(
        config = MessagingInAppModuleConfig.Builder().apply {
            setEventListener(inAppEventListener)
        }.build(),
    )
}*/

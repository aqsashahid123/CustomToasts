"# CustomToasts" 
Can be used to generate toast with less effort.
 
 
 Toasts with your custom layout:
 
 ToastCreater.createToastWithCustomLayout(context,"Generate Toast :)",
                   Gravity.BOTTOM,"#000000",R.layout.custom_toast,R.id.root,R.id.customToastText,true)
	
 
 Dependencies:
 	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
 	dependencies {
	        implementation 'com.github.aqsashahid123:CustomToasts:Tag'
	}

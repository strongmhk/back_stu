from django.urls import path

from accountapp.views import hello_world, AccountCreateView

app_name = "accountapp"  # "127.0.0.1:8000/account/hello_world"을 호출할 필요없이 "accountapp:hello_world"로 치환해줌


urlpatterns = [
    path('hello_world/', hello_world, name='hello_world'),
    path('create/', AccountCreateView.as_view(), name='create'),
]

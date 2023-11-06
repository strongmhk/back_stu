from django.shortcuts import render
from django.urls import reverse_lazy
from django.utils.decorators import method_decorator
from django.views.generic import CreateView, UpdateView

from profileapp.decorators import profile_ownership_required
from profileapp.forms import ProfileCreationForm
from profileapp.models import Profile


# Create your views here.


class ProfileCreateView(CreateView):
    model = Profile
    context_object_name = 'target_profile'
    form_class = ProfileCreationForm
    success_url = reverse_lazy('accountapp:hello_world')
    template_name = 'profileapp/create.html'

    def form_valid(self, form): # ProfileCreationForm으로 부터 전송된 image, nickname 필드 등이 form이라는 변수에 저장됨
        temp_profile = form.save(commit=False) # temp_profile는 실제 DB에 저장을 하지는 않고 임시 대기중인 데이터임
        temp_profile.user = self.request.user # 임시 데이터에 현재 프로필 생성을 요청한 유저의 정보를 넣음
        temp_profile.save() # DB에 데이터 저장

        return super().form_valid(form)


@method_decorator(profile_ownership_required, 'get')
@method_decorator(profile_ownership_required, 'post')
class ProfileUpdateView(UpdateView):
    model = Profile
    context_object_name = 'target_profile'
    form_class = ProfileCreationForm
    success_url = reverse_lazy('accountapp:hello_world')
    template_name = 'profileapp/update.html'
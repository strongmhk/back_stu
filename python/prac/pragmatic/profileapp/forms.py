from django.forms import ModelForm

from profileapp.models import Profile


class ProfileCreationForm(ModelForm):
    class Meta:
        model = Profile
        fiels = ['image', 'nickname', 'message'] # user는 서버에서 따로 처리

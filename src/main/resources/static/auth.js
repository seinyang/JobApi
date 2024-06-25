(function() {
    const token = localStorage.getItem('token');
    if (!token) {
        // 토큰이 없으면 로그인 페이지로 리다이렉트
        window.location.href = '/login';
    } else {
        fetch('http://localhost:8080/api/jobs/validateToken', {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer ' + token
            }
        }).then(response => {
            if (!response.ok) {
                window.location.href = '/login';
            }
        }).catch(() => {
            window.location.href = '/login';
        });
    }
})();
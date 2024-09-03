document.getElementById('openFormBtn').addEventListener('click', function() {
    document.getElementById('formModal').style.display = 'block';
});

document.getElementsByClassName('closeBtn')[0].addEventListener('click', function() {
    document.getElementById('formModal').style.display = 'none';
});

document.getElementById('cancelBtn').addEventListener('click', function() {
    document.getElementById('formModal').style.display = 'none';
});

document.getElementById('donthiForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const tiento = document.getElementById('tiento').value;
    const startnumber = document.getElementById('startnumber').value;

    let preview = '';
    for (let i = 0; i < 10; i++) {
        preview += `${tiento}${parseInt(startnumber) + i}\n`;
    }

    document.getElementById('preview').value = preview;

    alert('Đã tạo thành công số phách!');
});

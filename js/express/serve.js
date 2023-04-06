//npm install express 터미널에 입력해서 모듈 설치
//npm install ejs
//npm install mysql

const express = require('express');
const app = express();
const dbconfig = require('./config/dbconfig.json') // dbconfig라는 객체에 dbconfig.json에 입력해둔 정보를 가져와 저장

const mysql      = require('mysql');
const connection = mysql.createConnection({
  host     : dbconfig.host,
  user     : dbconfig.user,
  password : dbconfig.password,
  database : dbconfig.database
});


const pool = mysql.createPool({
  connectionLimit: 100, 
  host : dbconfig.host,
  user : dbconfig.user,
  password : dbconfig.password,
  database : dbconfig.database
})

const server = app.listen(3000, () => {
  console.log('Start Server : localhost:3000');
});


app.get('/', function (req, res) {
  res.render('index.html');
});

app.set('views', __dirname + '/views'); // __dirname은 현재 디렉토리 이름을 의미함 
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);



app.get('/about', function (req, res) {
  res.render('about.html');
});



app.get('/db', function (req, res) {
  pool.getConnection(function(err, connection) {
    if (err) throw err; // not connected!

    // Use the connection
    connection.query('SELECT * FROM users', function (error, results, fields) {
      res.send(JSON.stringify(results));
      console.log('results', results);
      // When done with the connection, release it.
      connection.release();

      // Handle error after the release.
      if (error) throw error;

      // Don't use the connection here, it has been returned to the pool.
    });
  });
});


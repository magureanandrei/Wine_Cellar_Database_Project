import psycopg2
import pyodbc

SSMS_CONN = "DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost;DATABASE=WineCellar;UID=abcd;PWD=1234;TrustServerCertificate=yes;"

ssms_conn = pyodbc.connect(SSMS_CONN)
pg_conn = psycopg2.connect(
    dbname="WineCellar",
    user="postgres",
    password="1234",
    host="localhost",
    port="5432"
)
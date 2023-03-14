# import Package
from fastapi import FastAPI
import uvicorn
from pydantic import BaseModel
from starlette.responses import JSONResponse

import pickle
import numpy as np
import pandas as pd

# Request Body
class Item(BaseModel) :
    petalLength : float
    petalWidth : float
    sepalLength : float
    sepalWidth : float

app = FastAPI()

@app.post(path="/items", status_code=201)
def myiris(item : Item) :
    # pickle 파일 로딩
    with open('data.pickle', 'rb') as f:
        model = pickle.load(f)

        dicted = dict(item)

        sepalLength = dicted['sepalLength']
        sepalWidth = dicted['sepalWidth']
        petalLength = dicted['petalLength']
        petalWidth = dicted['petalWidth']

        arr = np.array([[ sepalLength, sepalWidth, petalLength, petalWidth ]])

        target = ['setosa', 'virsicolor', 'virginica'] # 분류에 대한 정답
        pred = model.predict(arr)

        result = {"predict_result" : target[pred[0]]}
        print("=======예측 결과 =======>", result)

    return JSONResponse(result)

if __name__ == '__main__' :
    uvicorn.run(app, host="127.0.0.1", port=8000)

    
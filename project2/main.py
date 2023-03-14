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
    rain : float
    clodc : float
    hotc : float
    holiday : str

app = FastAPI()

@app.post(path="/chicken", status_code=201)
def mychicken(item : Item) :
    # pickle 파일 로딩
    with open('chicken3.pkl', 'rb') as f:
        model = pickle.load(f)

        dicted = dict(item)

        rain = dicted['강수량(mm)']
        clodc = dicted['최저기온']
        hotc = dicted['최고기온']
        holiday = dicted['요일']

        arr = np.array([[ rain, clodc, hotc, holiday ]])

        pred = model.predict(arr)
        prediction = pred.tolist()
        predict2 = pred/250
        prediction2 = predict2.tolist()
        data5 = [rain, clodc, hotc, holiday, pred, predict2]
    
        new_data2 = {'강수량(mm)':rain, '최저기온':clodc, '최고기온':hotc, '요일':holiday, 'prediction':prediction[0], 'prediction2':prediction2[0]}

        result = {"predict_result" : data5}
        print("=======예측 결과 =======>", result)

    return JSONResponse(result)

if __name__ == '__main__' :
    uvicorn.run(app, host="127.0.0.1", port=8000)

    
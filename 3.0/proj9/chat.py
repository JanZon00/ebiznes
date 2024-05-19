import replicate
import os

os.environ["REPLICATE_API_TOKEN"] = "r8_c8QYnAlrK9ZBCH14IPvJMtMWYDyHOgd2tgGvW"
prompt_input = "Napisz mi cyfry od 1 do 10 po francusku"

output = replicate.run('a16z-infra/llama13b-v2-chat:df7690f1994d94e96ad9d568eac121aecf50684a0b0963b25a41cc40061269e5',
                        input={"prompt": f"{prompt_input}", "temperature":0.1, "top_p":0.9, "max_length":200, "repetition_penalty":1})

response = ""

for item in output:
    response += item

print(response)

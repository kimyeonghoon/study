import re
import json

markdown_text = """
1. **AWS Organizations**
   - 여러 AWS 계정의 중앙집중식 관리 및 거버넌스
   - 조직 및 계정 구조를 통한 자원 및 정책 관리
   - 보안, 규정 준수 및 예산 관리에 유용
"""

# 마크다운 내용을 JSON으로 변환
def convert_markdown_to_json(md_text):
    json_data = []
    items = md_text.split('\n\n')  # 각 항목을 분리
    for item in items:
        lines = item.split('\n')
        title = re.sub(r'^\d+\.\s\*\*(.*)\*\*$', r'\1', lines[0]).strip()
        # 하이픈 앞의 모든 공백을 포괄하도록 정규 표현식 수정
        details = [re.sub(r'^\s*-\s*(.*)$', r'\1', line).strip() for line in lines[1:] if line.strip().startswith('-')]
        json_data.append({"title": title or "", "details": details or []})
    return json.dumps(json_data, indent=2, ensure_ascii=False)

# 변환 실행
converted_json = convert_markdown_to_json(markdown_text)
print(converted_json)
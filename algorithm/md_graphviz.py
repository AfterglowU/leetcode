import os, sys
import re
import subprocess

'''
命名规范:
    md_dot_code: markdown 中带有 "```dot" 开头和 "```" 结尾的代码段
    dot_code   : dot 代码本体
'''

if __name__ == "__main__":

    # Move to the directory of this file
    path = os.path.abspath(sys.argv[0])
    dir = os.path.split(path)[0]
    os.chdir(dir)

    # 待处理文件池
    files = []
    if len(sys.argv) < 2:
        sys.exit('No src file.')
    else:
        # 处理指定文件
        files += sys.argv[1:]

    # 预定义正则表达式
    # regex_md_dot_code.findall() 返回的元组中第 2 项是 dot 代码本体
    regex_md_dot_code = re.compile(r'(```(graphviz|dot)\s)((.|\s)+?)(\s```)')
    regex_dot_code_idx = 2

    for file in files:
        (filename, extname) = os.path.splitext(os.path.basename(file))
        # 跳过非 markdown 文件
        if not extname == '.md':
            continue
        with open(file, 'r', encoding='utf-8') as fin:
            # 依次将所有 graphviz 代码段转换为 png 图像
            for (i, md_dot_code) in enumerate(regex_md_dot_code.findall(fin.read())):
                # 获取 dot 代码本体
                dot_code = md_dot_code[regex_dot_code_idx]
                out_gv = './%s_dot_%i.gv' % (filename, i)
                out_png = './%s_dot_%i.png' % (filename, i)
                fout =  open(out_gv, 'w')
                print(dot_code, file=fout)
                fout.close()
                subprocess.run(['dot', out_gv, '-Tpng', '-Gdpi=300', '-o', out_png], cwd=dir)
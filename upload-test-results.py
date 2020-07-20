import requests
import glob
import argparse
import json
from pathlib import Path


import os
import os.path

def getCoverage (dir, coveragePattern):
    for root, dirs, files in os.walk(dir):
        for file in files:        
            if file.find(coveragePattern) != -1:        
                print("--- Coverage: " + os.path.join(root, file))
                return os.path.join(root, file)
    return ""
    

def findAllCoverage (coveragePattern):
    res = []
    for root, dirs, files in os.walk("/home/vsts/work/_temp/"):
        for file in files:                    
            if file.find(coveragePattern) != -1:
                res.append(os.path.join(root, file))
    return res


def readFileContent (filePath):
    f=open(filePath)
    content=f.read()
    f.close()
    return content

#parse arguments
parser = argparse.ArgumentParser()
parser.add_argument("--file", "-f", help="Test file pattern")
parser.add_argument("--coverage", "-c", help="Coverage file pattern")
parser.add_argument("--org", "-o", help="Organisation")
parser.add_argument("--project", "-p", help="Project name")
parser.add_argument("--build", "-b", help="Build id")
parser.add_argument("--branch", "-br", help="Branch name")


args = parser.parse_args()

print("Find all coverage files")
coverageFiles = findAllCoverage(args.coverage)
print("Found {} coverage files".format(len(coverageFiles)))
covCount = 0

for root, dirs, files in os.walk("."):
    for file in files:        
        if file.find(args.file) != -1:                                   
            print("Reading test results file:" +  os.path.join(root, file))            
            print(root.split("/")[1])
            testRunId = root.split("/")[1]
                        
            url = "https://test-hub-api.azurewebsites.net/api/{}/projects/{}/runs/{}".format(args.org, args.project, args.build)
            # url = "https://localhost:44355/api/{}/projects/{}/runs/{}".format(args.org, args.project, args.build)
            print("Uploading to: " + url)
                                    
            toUpload = dict(file=readFileContent(os.path.join(root, file)))
            
            #coverPath = getCoverage(root, args.coverage) 
            if covCount > 0:
                coverPath = coverageFiles[covCount]             
                covCount = covCount+1
                if coverPath != "":
                    print("Uploading coverage from : " +coverPath)
                    toUpload["coverage"]= readFileContent(coverPath)

            # get branch name
            print("Branch name is {}".format(args.branch))             
            
            response = requests.put(url,
                         files=toUpload,
                         data={'branch': args.branch },
                         verify=False)
                                    
            if response.status_code != 200:
                #exit(1)
                print("Failed to upload file")
                print(response.text)
            else:
                print("File uploaded successufully.")
                print(response.text)



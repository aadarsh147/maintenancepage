1. upload jar file 'demo-1.0.0.jar' located under target folder to s3 bucket
2. upload your under maintenance html page to same bucket
3. Create cloudformation stack with serverless.yml, pass bucket name and html page name as parameter
3. attach lambda to your target group
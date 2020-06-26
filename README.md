# groceries-server
Spring Boot based backend for Groceries Server

# Useful stuff for forking a Git repo

- For setting up your fork and your remotes. Follow this: https://help.github.com/en/enterprise/2.13/user/articles/fork-a-repo#:~:text=A%20fork%20is%20a%20copy,point%20for%20your%20own%20idea.

## To fetch latest from upstream master and apply it to your fork
- git checkout master
- git pull upstream master
- git push
- git checkout <feature>
- git rebase master
  - if any conflicts, fix them then add the fixed files
  - then do git rebase --continue
 - git push --force-with-lease

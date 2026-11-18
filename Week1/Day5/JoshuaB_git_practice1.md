Commands used:
Task 1:
1. `git init`, `git config --local user.name Joshua`, `git config --local user.email legodudejb@gmail.com`
2. `git add README.md`, `git commit -m "Add README"`
3. `git add cart.txt`, `git commit -m "Add cart module"`
4. `git log --oneline`, `git status`

Taks 2:
1. `git restore cart.txt`
2. `echo "secrets.env" > .gitignore`, `echo "*.log" >> .gitignore`
3. `git add cart.txt`, `git restore --staged cart.txt`
4. `git commit --amend -m "Add payment"`

Task 3:
1. `git checkout -b feature/wishlist`
2. `git switch main`, `git merge feature/wishlist`
3. `git checkout -b feature/reviews`, `git switch main`
4. `git merge features/reviews --no-ff`
5. `git branch -d feature/wishlist`, `git branch-d feature/reviews`

Task 4:
1. `git add price.txt`, `git commit -m "Add price"`
2. `git checkout -b feature/discount`, `git commit -am "Reduce price"`
3. `git switch main`, `git commit -am "Increase price"`
4. `git merge feature/discount`
5. `git merge --abort`
6. `git merge feature/discount`, `git add price.txt`, `git merge --continue`


Task 5:
1. `git add cart.txt`
2. `git stash push -m "WIP cart"`
3. `git checkout -b hotfix/login`, `git commit -am "Fix login"`, `git switch main`, `git merge hotfix/login`
4. `git switch hotfix/login`, `git stash pop`
5. `git stash list`

Task 6:
1. `git commit -am A`, `git commit -am B`, `git commit -am C`, `git commit -am D`
2. `git revert [C's ref]`. This is the right choice because it doesn't modify history, which causes issues when other people have cloned your branch.
3. `git commit -am E`, `git reset --soft HEAD~1`
4. `git reset --hard HEAD~2`, `git reflog`, `git reset --hard HEAD@{1}`

Task 7:
1. `git checkout -b feature/checkout`
2. `git switch main`
3. `git switch feature/checkout`, `git rebase main`
4. Edit the file to replace "pick" with "squash" and change the message
5. `git switch main`, git merge feature/checkout`

Task 8:
1. `git checkout -b dev`
2. `git switch main`, `git cherry-pick [second commit's ref]`
3. `git tag -a "v1.0.0" -m "v1.0.0"`
4. `git diff v1.0.0 HEAD`
5. `git tag -l`

Task 9:
1. `git remote add origin ~/server.git`, `git push origin main -u`
2. `git clone ~/server.git teammate`, `git push`
3. `git fetch`, `git diff origin/main main`, `git pull`
4. `git checkout -b my-branch`, `git push origin my-branch`, `git push origin --delete my-branch`

Taks 10:
1. `git stash push -um "WIP payments"`, `git switch main`, `git checkout -b hotfix`, `git switch main`, `git merge hotfix`, `git tag v1.0.1 -m "Fixed critical bug"`
2. `git switch feature/payments`, `git stash pop`, `git rebase main`
3. `git add [conflicting file]`, `git rebase --continue`
4. `git rebase -i`, set everything to squash except one, `git switch main`, `git merge feature/payments`, `git push --tags`
5. `git revert -m 1 [merge commit's ref]`
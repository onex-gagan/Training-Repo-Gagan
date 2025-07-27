# 🧠 Git & GitHub Basics

This document summarizes the essential Git commands and concepts covered during the **Version Control Training** session.

---

## 🔧 Git Setup

```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```
*Set your Git username and email globally (used in commits).*

---

## 📁 Initialize a Repository

```bash
git init
```
*Creates a new Git repository in the current directory.*

---

## 📄 Check File Status

```bash
git status
```
*Shows which files are staged, unstaged, or untracked.*

---

## ➕ Stage Files

```bash
git add <filename>    # Stage a single file
git add .             # Stage all changes
```

---

## ✅ Commit Changes

```bash
git commit -m "Your commit message"
```
*Commits the staged files to the local repository.*

---

## 📜 View Commit History

```bash
git log
```
*Displays the list of commits in the current branch.*

---

## 🔁 Clone a Remote Repository

```bash
git clone <repo-url>
```
*Makes a local copy of a remote repository.*

---

## ⬆️ Push Changes to Remote

```bash
git push origin main
```
*Pushes your local commits to the `main` branch on GitHub.*

---

## ⬇️ Pull Changes from Remote

```bash
git pull origin main
```
*Fetches and merges updates from the remote repository.*

---

## 🌱 Branching

```bash
git branch <branch-name>       # Create a new branch
git checkout <branch-name>     # Switch to an existing branch
git checkout -b <branch-name>  # Create and switch to a new branch
```

---

## 🔀 Merging Branches

```bash
git checkout main
git merge <branch-name>
```
*Merges the specified branch into `main`.*

---

## ❌ Remove Tracked File (Keep Locally)

```bash
git rm --cached <filename>
```
*Untracks a file but does not delete it locally.*

---

## ⏪ Undo Last Commit (Keep Changes)

```bash
git reset --soft HEAD~1
```
*Removes the last commit but retains the file changes in staging.*

---

## 🔗 Connect Local Repo to GitHub

```bash
git remote add origin <repo-url>
```
*Connects your local repo to a remote GitHub repo.*

---

## 📁 .gitignore

Use a `.gitignore` file to exclude files/folders from version control.

**Example `.gitignore`:**
```
*.log
.env
node_modules/
build/
```

---

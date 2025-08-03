````markdown
# 🧠 Linux File Permissions, Ownership & Text File Manipulation using Vim

This document provides a quick reference for two essential topics in Linux:

1. **File Permissions & Ownership**
2. **Text File Manipulation using Vim**

---

## 🔐 File Permissions & Ownership in Ubuntu

Understanding file permissions and ownership is essential for managing access control on a Linux system.

### 🧾 File Permission Groups

Each file has three types of access permissions:

- **User (u)** – The file owner  
- **Group (g)** – Users in the file’s group  
- **Others (o)** – All other users  

Permissions:
- `r` – read
- `w` – write
- `x` – execute

### 🧪 Check File Permissions

```bash
ls -l                 # List files with permission details
stat filename.txt     # Detailed file metadata
````

### 🔧 Changing Ownership

```bash
sudo chown user:group filename
# Example:
sudo chown gagan:devs project.txt
```

### 🔁 Changing Permissions

```bash
chmod u+x script.sh          # Add execute to user
chmod g-w report.txt         # Remove write from group
chmod o=r notes.txt          # Set others to read-only
chmod 755 run.sh             # rwxr-xr-x (user full, group/others read-execute)
```

### 🔢 Numeric Permission Representation

| Permission  | Value |
| ----------- | ----- |
| Read (r)    | 4     |
| Write (w)   | 2     |
| Execute (x) | 1     |

**Examples:**

```bash
chmod 640 file.txt   # rw-r----- (User: rw, Group: r, Others: none)
chmod 777 file.txt   # Full access to all
```

---

## ✅ Summary: File Permissions

* Use `ls -l` to check file permissions.
* Use `chown` to change file owner/group.
* Use `chmod` to set or modify access rights.

---

## 📝 Text File Manipulation Using Vim

`vim` is a powerful command-line text editor used for creating and modifying text files.

### 🚀 Opening and Closing Files

```bash
vim filename.txt         # Open file in vim
```

### 💾 Saving & Exiting

| Command | Description         |
| ------- | ------------------- |
| `:w`    | Save                |
| `:q`    | Quit                |
| `:wq`   | Save and quit       |
| `:q!`   | Quit without saving |

---

### 🧭 Vim Modes

* **Normal Mode**: for navigation and commands (default mode)
* **Insert Mode**: for typing and editing content
* **Command Mode**: for executing commands (use `:` prefix)

### 🔁 Switching Between Modes

| Key   | Action                |
| ----- | --------------------- |
| `i`   | Insert before cursor  |
| `a`   | Append after cursor   |
| `o`   | Open a new line below |
| `Esc` | Return to Normal Mode |

---

### 🧹 Common Vim Commands (Normal Mode)

```bash
dd        # Delete current line
yy        # Copy (yank) current line
p         # Paste below current line
u         # Undo last change
/word     # Search forward for 'word'
n         # Jump to next match
:set nu   # Show line numbers
```

---

## ✅ Summary: Vim Basics

* Press `i`, `a`, or `o` to enter insert mode.
* Use `Esc` to return to normal mode.
* Save with `:w`, quit with `:q`, or do both with `:wq`.

---

## 🎯 Final Notes

* File permissions help secure files from unwanted access or modification.
* `vim` makes quick in-terminal file edits possible — ideal for scripting or config changes.

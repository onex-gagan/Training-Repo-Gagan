````markdown
# 📦 Compression, Archiving, and Shell Scripting in Linux

This note covers essential commands for compressing, archiving, and extracting files in Linux along with an introduction to basic shell scripting. These tools are helpful for packaging files, backups, file sharing, and automating tasks.

---

## 🗜️ 1. Compression and Archiving

### ❓ Difference Between Compression vs Archiving

| Term            | Purpose                                  |
|-----------------|------------------------------------------|
| **Archiving**   | Bundles multiple files into one (`.tar`) |
| **Compression** | Reduces file size (`.gz`, `.zip`, `.xz`) |

> 🔸 A `.tar.gz` file is first **archived**, then **compressed**.  
> 🔸 A `.zip` file is both **archived and compressed** in one step.

---

## 📂 Common Formats & Use Cases

| Format      | Description                                      |
|-------------|--------------------------------------------------|
| `.zip`      | Compressed archive, widely used cross-platform   |
| `.tar`      | Archive only (no compression)                    |
| `.gz`       | Gzip compression (used with `.tar`)              |
| `.tar.gz`   | Tar archive + Gzip compression                   |
| `.tar.xz`   | Tar archive + XZ (higher compression ratio)      |

---

## 🔧 Common Commands

### ✅ Compress (ZIP)

```bash
zip compressed.zip file1.txt file2.txt
zip -r compressed.zip myfolder/
````

### ✅ Decompress (UNZIP)

```bash
unzip compressed.zip
```

---

### ✅ Archive Files (TAR - no compression)

```bash
tar -cf archive.tar file1.txt file2.txt
tar -cf archive.tar myfolder/
```

### ✅ Unarchive .tar File

```bash
tar -xf archive.tar
```

---

### ✅ Archive + Compress (TAR.GZ)

```bash
tar -czf archive.tar.gz myfolder/
```

* `-c` → create archive
* `-z` → compress with gzip
* `-f` → filename

### ✅ Extract .tar.gz

```bash
tar -xzf archive.tar.gz
```

* `-x` → extract
* `-z` → decompress
* `-f` → filename

---

### ✅ Archive + Compress with XZ (`.tar.xz`)

```bash
tar -cJf archive.tar.xz myfolder/
```

* `-J` → use XZ compression

### ✅ Extract .tar.xz

```bash
tar -xJf archive.tar.xz
```

---

## 🔄 Converting Between Formats

### 🔁 Convert `.tar` to `.tar.gz`

```bash
gzip archive.tar     # Produces archive.tar.gz
```

### 🔁 Convert `.tar.gz` to `.tar`

```bash
gunzip archive.tar.gz
```

---

## 🔍 .tar.gz vs .tar.xz

| Feature           | `.tar.gz`         | `.tar.xz`               |
| ----------------- | ----------------- | ----------------------- |
| Speed             | Faster            | Slower                  |
| Compression Ratio | Good              | Better                  |
| Compatibility     | Very common       | Less common             |
| Use Cases         | Backups, web apps | Distributions, packages |

---

## 📁 Summary Table of Flags

| Flag | Meaning                  |
| ---- | ------------------------ |
| `-c` | Create                   |
| `-x` | Extract                  |
| `-z` | Use gzip                 |
| `-J` | Use xz                   |
| `-f` | Filename (always at end) |
| `-v` | Verbose (optional)       |

---

# 🐚 2. Basic Shell Scripting

Shell scripts are simple text files with a series of Linux commands that automate tasks.

---

## 📄 How to Write a Shell Script

1. Create a file:

```bash
touch myscript.sh
```

2. Add the shebang and commands:

```bash
#!/bin/bash

echo "Hello, $USER"
date
```

3. Make it executable:

```bash
chmod +x myscript.sh
```

4. Run it:

```bash
./myscript.sh
```

---

## ✨ Common Shell Commands to Include in Scripts

* `echo` → Print text
* `read` → Take user input
* `if`, `else`, `fi` → Conditional logic
* `for`, `while` loops → Iteration
* `exit` → Exit script
* `touch`, `mkdir`, `rm` → File operations

---

## 🔁 Sample Script: Compress a Folder

```bash
#!/bin/bash

echo "Enter folder name to archive:"
read folder

tar -czf "$folder.tar.gz" "$folder"
echo "Archive created: $folder.tar.gz"
```

---

## 📌 Best Practices

* Always start with `#!/bin/bash`
* Add comments with `#`
* Test scripts before automating
* Use `set -e` to exit on any error

---

🎯 **Recap**

| Task               | Command                       |
| ------------------ | ----------------------------- |
| Zip files          | `zip file.zip file1 file2`    |
| Unzip files        | `unzip file.zip`              |
| Create tar archive | `tar -cf file.tar files/`     |
| Extract tar        | `tar -xf file.tar`            |
| Create tar.gz      | `tar -czf file.tar.gz files/` |
| Extract tar.gz     | `tar -xzf file.tar.gz`        |
| Create tar.xz      | `tar -cJf file.tar.xz files/` |
| Extract tar.xz     | `tar -xJf file.tar.xz`        |
| Run shell script   | `./myscript.sh`               |

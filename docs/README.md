# **BSS Task Manager - User Guide**  
**BSS Task Manager** is a simple **Command Line Interface (CLI) task manager** that allows users to manage their tasks efficiently.  
Users can **add, delete, mark, unmark, and find tasks**, while the application **automatically saves** all changes.

---

## **📌 Quick Start**
1. **Ensure you have Java 17 or later installed** on your computer.  
2. **Download the latest `BSS.jar` file** from [here](#)  
3. **Move the JAR file** to your desired working directory.  
4. **Open a command terminal**, navigate to the folder, and run:
   ```sh
   java -jar BSS.jar


## **1. Adding Tasks**

### **1.1 Adding a Todo Task**
Adds a simple task without a deadline.

```sh
todo DESCRIPTION
```

### **1.2 Adding a Deadline Task**

Adds an event with a deadline.

```sh
event DESCRIPTION /to END
```

### **1.3 Adding an Event Task**

Adds an event with a start and end time.

```sh
event DESCRIPTION /from START /to END
```
## **2. Listing All Tasks**

Displays all tasks currently in the task list.

```sh
list
```
## **3. Marking & Unmarking Tasks**

### **3.1 Marking a Task as done**

Marks a task as completed.

```sh
mark TASK_NUMBER
```
### **3.2 Unmarking a Task**

Marks a task as incomplete.

```sh
unmark TASK_NUMBER
```
## **4. Finding Tasks**

Finds tasks that contain a specific keyword.

```sh
find KEYWORD
```
## **5. Deleting Tasks**

Deletes a specific task from the list.

```sh
delete TASK_NUMBER
```
## **6. Exiting the program**

Ends the session, closes the chatbot.  
Current task list will be automatically stored.

```sh
byeMessage
```

## **❓ FAQs**
**1. How do I quickly reset my task list?**   
Delete the `[JAR file location]/data/duke.txt` file and restart the program on your computer.  

**2. Why is my data missing?**  
Ensure `[JAR file location]/data/duke.txt` exists. If it was accidentally deleted, your data is gone.  

**3.  Can I edit the task descriptions?**   
Sorry but NO, you must delete and re-add the task with new details.


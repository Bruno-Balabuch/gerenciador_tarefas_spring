const apiUrl = 'http://localhost:8080/api/tarefas';

const taskForm = document.getElementById('taskForm');
const taskTableBody = document.getElementById('taskTableBody');

// Carregar tarefas ao iniciar
async function loadTasks() {
    const response = await fetch(apiUrl);
    const tasks = await response.json();

    taskTableBody.innerHTML = '';
    tasks.forEach((task, index) => {
        taskTableBody.innerHTML += `
            <tr>
                <td>${index + 1}</td>
                <td>${task.title}</td>
                <td>${task.description || 'Sem descrição'}</td>
                <td>${task.completed ? '✅ Concluída' : '⏳ Pendente'}</td>
                <td>
                    <button class="btn btn-sm btn-warning" onclick="editTask(${task.id})">Editar</button>
                    <button class="btn btn-sm btn-danger" onclick="deleteTask(${task.id})">Excluir</button>
                </td>
            </tr>
        `;
    });
}

// Adicionar nova tarefa
taskForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;

    await fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, description })
    });

    taskForm.reset();
    loadTasks();
});

// Editar tarefa
async function editTask(id) {
    const response = await fetch(`${apiUrl}/${id}`);
    const task = await response.json();

    document.getElementById('editTaskId').value = task.id;
    document.getElementById('editTitle').value = task.title;
    document.getElementById('editDescription').value = task.description;
    document.getElementById('editCompleted').checked = task.completed;

    const modal = new bootstrap.Modal(document.getElementById('editTaskModal'));
    modal.show();
}

// Salvar edição
document.getElementById('editTaskForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const id = document.getElementById('editTaskId').value;
    const title = document.getElementById('editTitle').value;
    const description = document.getElementById('editDescription').value;
    const completed = document.getElementById('editCompleted').checked;

    await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, description, completed })
    });

    const modal = bootstrap.Modal.getInstance(document.getElementById('editTaskModal'));
    modal.hide();

    loadTasks();
});

// Excluir tarefa
async function deleteTask(id) {
    await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
    loadTasks();
}

// Inicializar
loadTasks();
